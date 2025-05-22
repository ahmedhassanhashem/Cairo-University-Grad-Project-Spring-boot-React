import React, { useEffect, useState } from "react";

import "./user-side-bar.css";
import "./boxicons.min.css";
import "./icons.css";
import axios from "axios";
import { userInfoFactory } from "../utils";
import { useToasts } from "react-toast-notifications";

export const UserProfileEdit = ({ user, onProfilePictureChange, imageRef }) => {
  const [userInfo, setuserInfo] = useState({
    foundInfo: false,
    tries: 0,
    info: { email: user?.sub },
  });

  const [loadingInfo, setLoadingInfo] = useState(false);
  const [isSaving, toggleIsSaving] = useState(false);

  const { addToast } = useToasts();

  const token = localStorage.getItem("token");

  const axiosInstance = axios.create({
    baseURL: "https://interna-platform.uc.r.appspot.com/api/gateway/seeker",
    headers: { Authorization: `Bearer ${token}` },
  });

  useEffect(() => {
    window.addEventListener("load", () => {
      if (!userInfo.foundInfo && userInfo.tries === 0) {
        setLoadingInfo(true);
        axiosInstance({
          method: "GET",
          url: `/${user.jti}`,
        })
          .then(({ data }) => {
            onProfilePictureChange(data.data.profile);
            setLoadingInfo(false);
            setuserInfo(() => {
              return {
                foundInfo: true,
                tries: 1,
                info: data.data,
              };
            });
          })
          .catch(() => {
            setLoadingInfo(false);
            setuserInfo({ ...userInfo, tries: 1 });
          });
      }
    });
    return () => {
      window.removeEventListener("load", () => {
        if (!userInfo.foundInfo && userInfo.tries === 0) {
          setLoadingInfo(true);
          axiosInstance({
            method: "GET",
            url: `/${user.jti}`,
          })
            .then(({ data }) => {
              setLoadingInfo(false);
              setuserInfo(() => {
                return {
                  foundInfo: true,
                  tries: 1,
                  info: data.data,
                };
              });
            })
            .catch(() => {
              setLoadingInfo(false);
              setuserInfo({ ...userInfo, tries: 1 });
            });
        }
      });
    };
  }, [userInfo, {}]);

  const handleSubmit = (e) => {
    e.preventDefault();
    const infoToSave = userInfoFactory(userInfo.info, imageRef, user);
    toggleIsSaving(true);
    axiosInstance({
      method: "POST",
      url: "",
      data: infoToSave,
    })
      .then(() => {
        toggleIsSaving(false);
        addToast("Info saved Successfully !", {
          appearance: "success",
          autoDismiss: true,
        });
      })
      .catch(() => {
        axiosInstance({
          method: "PUT",
          url: `/update`,
          data: infoToSave,
        })
          .then(() => {
            addToast("Info saved Successfully !", {
              appearance: "success",
              autoDismiss: true,
            });
            toggleIsSaving(false);
          })
          .catch(() => {
            addToast(
              "Unexpected error happened while saving! Please try again after filling all fields",
              {
                appearance: "error",
                autoDismiss: true,
              }
            );
            toggleIsSaving(false);
          });
      });
  };

  const handleFieldsChange = (field, e) => {
    setuserInfo({
      ...userInfo,
      info: { ...userInfo.info, [field]: e.target.value },
    });
  };

  return (
    <div class="job-bx submit-resume">
      <div class="job-bx-title clearfix">
        <h5 class="font-weight-700 pull-left text-uppercase">Profile</h5>
        <a class="site-button right-arrow button-sm float-right" href="#">
          Back
        </a>
      </div>
      {loadingInfo ? (
        <div className="text-center">
          <div class="spinner-grow text-primary" role="status">
            <span class="sr-only">Loading...</span>
          </div>
        </div>
      ) : (
        <form id="form" onSubmit={handleSubmit}>
          <div class="row m-b30">
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Name</label>
                <input
                  required
                  type="text"
                  name="seekerName"
                  class="form-control"
                  placeholder="Enter Name"
                  value={userInfo?.info?.seekerName}
                  onChange={(e) => handleFieldsChange("seekerName", e)}
                />
              </div>
            </div>

            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Date Of Birth</label>
                <input
                  type="date"
                  required
                  class="form-control"
                  name="dateOfBirth"
                  placeholder="2020-05-05"
                  value={userInfo?.info.dateOfBirth}
                  onChange={(e) => handleFieldsChange("dateOfBirth", e)}
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Your Email</label>
                <input
                  required
                  type="email"
                  name="email"
                  class="form-control"
                  disabled
                  placeholder="info@gmail.com"
                  value={userInfo?.info.email}
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Governate</label>
                <select
                  required
                  name="city"
                  value={userInfo?.info?.city?.name}
                  onChange={(e) => handleFieldsChange("city", e)}
                  className="custom-select"
                >
                  <option value={1}>Cairo</option>
                  <option value={2}>Giza</option>
                  <option value={3}>Alex</option>
                </select>
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Adress</label>
                <input
                  required
                  type="text"
                  value={userInfo?.info?.address}
                  onChange={(e) => handleFieldsChange("address", e)}
                  class="form-control"
                  placeholder="Zamalek"
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Job title</label>
                <input
                  required
                  type="text"
                  name="position"
                  class="form-control"
                  placeholder="developer"
                  value={userInfo?.info?.position}
                  onChange={(e) => handleFieldsChange("position", e)}
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Phone</label>
                <input
                  required
                  type="tel"
                  name="mobileNumber"
                  class="form-control"
                  placeholder="+1 123 456 7890"
                  value={userInfo?.info?.mobileNumber}
                  onChange={(e) => handleFieldsChange("mobileNumber", e)}
                />
              </div>
            </div>
            <div class="col-lg-12">
              <div class="form-group">
                <label>Summary</label>
                <textarea
                  required
                  type="text"
                  name="summary"
                  class="form-control"
                  placeholder="Summary about yourself"
                  value={userInfo?.info?.summary}
                  onChange={(e) => handleFieldsChange("summary", e)}
                />
              </div>
            </div>
          </div>

          <div class="row m-b30">
            <div class="job-bx-title clearfix">
              <h5 class="font-weight-700 pull-left text-uppercase">
                professional social network
              </h5>
            </div>
            <div class="row">
              <div class="col-lg-6 col-md-6">
                <div class="form-group">
                  <label>Linkedin</label>
                  <input
                    type="text"
                    name="linkedin"
                    class="form-control"
                    placeholder="https://www.linkedin.com/"
                    value={userInfo?.info?.links?.linkedin}
                    onChange={(e) => handleFieldsChange("linkedin", e)}
                  />
                </div>
              </div>
            </div>
            <button type="submit" disabled={isSaving} class="site-button m-b30">
              {isSaving ? (
                <div
                  class="spinner-grow
                              ..30......."
                  role="status"
                >
                  <span class="sr-only">Loading...</span>
                </div>
              ) : (
                "Update Info"
              )}
            </button>
          </div>
        </form>
      )}
    </div>
  );
};
