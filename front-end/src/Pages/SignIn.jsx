import React, { useState } from "react";
import axios from "axios";

import "./sign-up.css";
import { any, isEmpty, values } from "ramda";
import { useNavigate } from "react-router-dom";
import { useToasts } from "react-toast-notifications";

export const SignIn = () => {
  const [signInInfo, setSignInInfo] = useState({
    email: "",
    password: "",
  });
  const [loading, toggleLoading] = useState(false);
  const navigate = useNavigate();
  const { addToast } = useToasts();
  const handleFieldsChange = (field, e) => {
    setSignInInfo({ ...signInInfo, [field]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (any(isEmpty, values(signInInfo))) {
      addToast("Write a valid email and password!", {
        appearance: "success",
        autoDismiss: true,
      });
    } else {
      toggleLoading(true);
      axios
        .post(
          "https://interna-platform.uc.r.appspot.com/api/gateway/auth/login",
          {
            email: signInInfo.email,
            password: signInInfo.password,
          }
        )
        .then(({ data }) => {
          addToast("Logged In!", {
            appearance: "success",
            autoDismiss: true,
          });

          localStorage.setItem("token", data.data.access_token);
          localStorage.setItem("refresh_token", data.data.refresh_token);
          localStorage.setItem("authenticated", true);
          toggleLoading(false);
          navigate("/");
        })
        .catch(() => {
          toggleLoading(false);
          addToast("Wrong Email Or password !", {
            appearance: "error",
            autoDismiss: true,
          });
        });
    }
  };

  return (
    <>
      <section
        className="contact_us h-100"
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <div className="contact_inner">
                <div className="row">
                  <div className="col-md-10">
                    <div className="contact_form_inner">
                      <form onSubmit={handleSubmit}>
                        <div className="sign_up_field">
                          <h3>Sign in</h3>
                          <p className="m-0 p-0">We missed you!</p>

                          <input
                            type="email"
                            className="form-control form-group"
                            placeholder="Email"
                            onChange={(e) => handleFieldsChange("email", e)}
                          />
                          <input
                            type="password"
                            className="form-control form-group"
                            placeholder="password"
                            onChange={(e) => handleFieldsChange("password", e)}
                          />

                          <button
                            disabled={loading}
                            className="contact_form_submit"
                          >
                            {loading ? (
                              <div
                                class="spinner-grow
                              ..30......."
                                role="status"
                              >
                                <span class="sr-only">Loading...</span>
                              </div>
                            ) : (
                              "Sign In"
                            )}
                          </button>
                        </div>
                      </form>
                    </div>
                  </div>
                  <div className="col-md-2">
                    <div className="right_conatct_social_icon d-flex align-items-end"></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
};
