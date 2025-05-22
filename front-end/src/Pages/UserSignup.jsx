import React, { useState } from "react";
import axios from "axios";
import { useToasts } from "react-toast-notifications";

import "./sign-up.css";
import { any, isEmpty, values } from "ramda";
import { Link, useNavigate } from "react-router-dom";

export const Signup = () => {
  const [signupInfo, setSignupInfo] = useState({
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    confirmedPassword: "",
  });

  const { addToast } = useToasts();
  const navigate = useNavigate();

  const [loading, toggleLoading] = useState(false);
  const handleFieldsChange = (field, e) => {
    setSignupInfo({ ...signupInfo, [field]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (any(isEmpty, values(signupInfo))) {
      addToast("Please fill all empty fields", {
        appearance: "error",
        autoDismiss: true,
      });
    } else {
      toggleLoading(true);
      axios
        .post(
          "https://interna-platform.uc.r.appspot.com/api/gateway/user/register",
          {
            name: `${signupInfo.firstName} ${signupInfo.lastName}`,
            email: signupInfo.email,
            password: signupInfo.password,
            role: {
              id: 101,
            },
          }
        )
        .then((response) => {
          addToast(
            "Signed Up Succcessfully, You will be redirected to the Sign in page in a moment",
            { appearance: "success", autoDismiss: true }
          );
          toggleLoading(false);
          setTimeout(() => navigate("/sign-in"), 2000);
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
                          <h3>Sign Up</h3>
                          <p className="m-0 p-0">
                            Sign Up to join our amazing community!
                          </p>

                          <input
                            type="text"
                            className="form-control form-group"
                            placeholder="First Name"
                            onChange={(e) => handleFieldsChange("firstName", e)}
                          />
                          <input
                            type="text"
                            className="form-control form-group"
                            placeholder="Last Name"
                            onChange={(e) => handleFieldsChange("lastName", e)}
                          />
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
                          <input
                            type="password"
                            className="form-control form-group"
                            placeholder="password"
                            style={{ display: "inline-block" }}
                            onChange={(e) =>
                              handleFieldsChange("confirmedPassword", e)
                            }
                          />
                          <button className="contact_form_submit">
                            {loading ? (
                              <div
                                class="spinner-grow
                              ..30......."
                                role="status"
                              >
                                <span class="sr-only">Loading...</span>
                              </div>
                            ) : (
                              "Sign Up"
                            )}
                          </button>
                        </div>
                      </form>
                    </div>
                    <div className="text-right w-100">
                      <p>
                        {" "}
                        You are a company that's looking for good calibers ?{" "}
                        <Link to="/company-sign-up">Click Here</Link>
                      </p>
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
