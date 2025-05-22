import React, { useState, useEffect } from "react";

import "./user-side-bar.css";
import "./boxicons.min.css";
import "./icons.css";
import axios from "axios";
import { companyInfoFactory } from "../utils";
import { useToasts } from "react-toast-notifications";

export const CompanyProfileEdit = ({
  user,
  onProfilePictureChange,
  imageRef,
}) => {
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
    baseURL: "https://interna-platform.uc.r.appspot.com/api/gateway/company",
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
    const infoToSave = companyInfoFactory(userInfo.info, imageRef, user);
    toggleIsSaving(true);
    axiosInstance({
      method: "POST",
      url: "",
      data: infoToSave,
    })
      .then(() => {
        toggleIsSaving(false);
      })
      .catch(() => {
        axiosInstance({
          method: "PUT",
          url: "/update",
          data: infoToSave,
        })
          .then(() => {
            addToast("Info saved Successfully !", {
              appearance: "success",
              autoDismiss: true,
            });
            toggleIsSaving(false);
          })
          .catch((error) => {
            console.log(error);

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
    <div class="job-bx submit-resume mb-5">
      <div class="job-bx-title clearfix">
        <h5 class="font-weight-700 pull-left text-uppercase">
          Company Profile
        </h5>
        <a
          class="site-button right-arrow button-sm float-right"
          href="https://job-board.dexignzone.com/react/demo/company-profile"
        >
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
        <form id="form-company" onSubmit={handleSubmit}>
          <div class="row m-b30">
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Company Name</label>
                <input
                  required
                  type="text"
                  name="companyName"
                  class="form-control"
                  placeholder="Enter Company Name"
                  value={userInfo?.info?.companyName}
                  onChange={(e) => handleFieldsChange("companyName", e)}
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
                  disabled
                  class="form-control"
                  placeholder="info@gmail.com"
                  value={userInfo?.info?.email}
                  onChange={(e) => handleFieldsChange("email", e)}
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Founded Date </label>
                <input
                  required
                  type="date"
                  name="foundedDate"
                  class="form-control"
                  placeholder="17/12/2018"
                  value={userInfo?.info?.foundedDate}
                  onChange={(e) => handleFieldsChange("foundedDate", e)}
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Industry</label>
                <select
                  required
                  name="industry"
                  class="custom-select custom-select"
                  value={userInfo?.info?.industry}
                  onChange={(e) => handleFieldsChange("industry", e)}
                >
                  <option>Web Designer</option>
                  <option>Web Developer1</option>
                </select>
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Governate</label>
                <select
                  required
                  name="city"
                  value={userInfo?.info?.city?.id}
                  onChange={(e) => handleFieldsChange("city", e)}
                  className="custom-select"
                >
                  <option value={1}>Cairo</option>
                  <option value={2}>Giza</option>
                  <option value={3}>Alex</option>
                </select>
              </div>
            </div>
            <div class="col-lg-12 col-md-12">
              <div class="form-group">
                <label>Description:</label>
                <textarea
                  required
                  name="description"
                  class="form-control"
                  value={userInfo?.info?.description}
                  onChange={(e) => handleFieldsChange("description", e)}
                ></textarea>
              </div>
            </div>
          </div>
          <div class="job-bx-title clearfix">
            <h5 class="font-weight-700 pull-left text-uppercase">
              Contact Information
            </h5>
          </div>

          <div class="row m-b30">
            {/* <div class="col-lg-6 col-md-6">
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
            </div> */}
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Zip</label>
                <input
                  required
                  type="text"
                  name="zip"
                  class="form-control"
                  placeholder="504030"
                  value={userInfo?.info?.zip}
                  onChange={(e) => handleFieldsChange("zip", e)}
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Address</label>
                <input
                  required
                  type="text"
                  name="address"
                  class="form-control"
                  placeholder="Zamalek"
                  value={userInfo?.info?.address}
                  onChange={(e) => handleFieldsChange("address", e)}
                />
              </div>
            </div>
            <div class="job-bx-title clearfix">
              <h5 class="font-weight-700 pull-left text-uppercase">
                Social link
              </h5>
            </div>
            <div class="row">
              <div class="col-lg-6 col-md-6">
                <div class="form-group">
                  <label>Facebook</label>
                  <input
                    required
                    type="text"
                    name="facebook"
                    class="form-control"
                    placeholder="https://www.facebook.com/"
                    value={userInfo?.info?.links?.facebook}
                    onChange={(e) => handleFieldsChange("facebook", e)}
                  />
                </div>
              </div>
              <div class="col-lg-6 col-md-6">
                <div class="form-group">
                  <label>Twitter</label>
                  <input
                    required
                    type="text"
                    name="twitter"
                    class="form-control"
                    placeholder="https://www.twitter.com/"
                    value={userInfo?.info?.links?.twitter}
                    onChange={(e) => handleFieldsChange("twitter", e)}
                  />
                </div>
              </div>
              <div class="col-lg-6 col-md-6">
                <div class="form-group">
                  <label>Linkedin</label>
                  <input
                    required
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
