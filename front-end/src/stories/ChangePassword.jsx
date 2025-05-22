import React, { useState } from "react";

import "./user-side-bar.css";
import "./boxicons.min.css";
import "./icons.css";
import { Button } from "react-bootstrap";
import { getPasswordPattren, getUser } from "../utils";
import axios from "axios";

export const ChangePassword = () => {
  const [password, setPassword] = useState({
    new: "",
    confirmedNew: "",
    old: "",
  });

  const user = getUser();
  const [passwordError, setPasswordErrors] = useState({
    missmatchedPasswords: false,
    wrongOldPassword: {
      message: "",
      haveError: false,
    },
  });

  const token = localStorage.getItem("token");

  const axiosInstance = axios.create({
    baseURL:
      "https://interna-platform.uc.r.appspot.com/api/gateway/user/password/change",
    headers: { Authorization: `Bearer ${token}` },
  });

  const handleUpdatePassword = (e) => {
    e.preventDefault();
    setPasswordErrors({
      missmatchedPasswords: false,
      wrongOldPassword: {
        message: "",
        haveError: false,
      },
    });
    if (password?.new !== password?.confirmedNew) {
      setPasswordErrors({ ...passwordError, missmatchedPasswords: true });
      return;
    }
    axiosInstance({
      method: "PUT",
      url: "",
      data: {
        userId: user?.jti,
        currentPassword: password.old,
        newPassword: password.new,
      },
    })
      .then(console.log)
      .catch((error) => {
        setPasswordErrors({
          ...passwordError,
          wrongOldPassword: {
            message: error.response.data.message,
            haveError: true,
          },
        });
      });
  };
  return (
    <div class="job-bx submit-resume mb-5">
      <div class="job-bx-title clearfix">
        <h5 class="font-weight-700 pull-left text-uppercase">
          CHANGE PASSWORD
        </h5>
        <a
          class="site-button right-arrow button-sm float-right"
          href="https://job-board.dexignzone.com/react/demo/company-profile"
        >
          Back
        </a>
      </div>
      <p style={{ color: "black", fontSize: "10px", display: "block" }}>
        * Password should be made of minimum eight characters, at least one
        uppercase letter, one lowercase letter, one number and one special
        character:
      </p>
      {passwordError?.missmatchedPasswords && (
        <p style={{ color: "red", fontSize: "10px", display: "block" }}>
          * Passwords are not the same
        </p>
      )}
      {passwordError?.wrongOldPassword?.haveError && (
        <p style={{ color: "red", fontSize: "10px", display: "block" }}>
          * {passwordError?.wrongOldPassword?.message}
        </p>
      )}
      <form onSubmit={handleUpdatePassword}>
        <div class="row m-b30">
          <div class="col-sm-12">
            <div class="form-group">
              <label>Old Password</label>
              <input
                type="password"
                class="form-control"
                value={password.old}
                pattern={getPasswordPattren()}
                onChange={(e) =>
                  setPassword({ ...password, old: e.target.value })
                }
                placeholder="Enter your old password"
              />
            </div>
          </div>
          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>New password</label>
              <input
                type="password"
                class="form-control"
                pattern={getPasswordPattren()}
                value={password.new}
                onChange={(e) =>
                  setPassword({ ...password, new: e.target.value })
                }
                placeholder="New Password"
              />
            </div>
          </div>
          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Confirm New Password</label>
              <input
                type="password"
                class="form-control"
                pattern={getPasswordPattren()}
                value={password.confirmedNew}
                onChange={(e) =>
                  setPassword({ ...password, confirmedNew: e.target.value })
                }
                placeholder="Confirm New Password"
              />
            </div>
          </div>
        </div>

        <Button variant="primary" type="submit" className="w-100">
          Change Password
        </Button>
      </form>
    </div>
  );
};
