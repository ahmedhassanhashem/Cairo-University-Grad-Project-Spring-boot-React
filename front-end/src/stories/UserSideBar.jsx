import React, { useRef, useState } from "react";
import ProfilePicture from "./assets/profile.jpg";

import "./user-side-bar.css";
import "./boxicons.min.css";
import "./icons.css";
import { Link } from "react-router-dom";
import classNames from "classnames";
import { type } from "ramda";

export const UserSideBar = ({
  user,
  profilePicture,
  onProfilePictureChange,
  imageRef,
  tabs = [],
}) => {
  const { name = "" } = user;

  console.log({ profilePicture });
  return (
    // <div class="col-xl-3 col-lg-4 m-b30">
    <div class="sticky-top mb-5">
      <div class="candidate-info company-info">
        <div class="candidate-detail text-center">
          <div class="canditate-des">
            <a href="#" className="d-block h-100 w-100">
              <img
                className="d-block h-100 w-100"
                alt="userProfile"
                src={
                  type(profilePicture) === "String"
                    ? profilePicture
                    : URL.createObjectURL(profilePicture)
                }
                ref={imageRef}
              />
            </a>
            <div
              class="upload-link"
              title="update"
              data-toggle="tooltip"
              data-placement="right"
            >
              <input
                type="file"
                name="filepond"
                accept="image/png, image/jpeg"
                class="update-flie filepond"
                onChange={(e) => onProfilePictureChange(e.target.files[0])}
              />
              <i class="fa fa-pencil"></i>
            </div>
          </div>
          <div class="candidate-title">
            <h4 class="m-b5">
              <a href="#">{name}</a>
            </h4>
          </div>
        </div>
        <ul>
          {tabs.map((tab) => {
            const { name, icon, handler, active } = tab;
            return (
              <li>
                <a
                  className={classNames({
                    active: active,
                  })}
                  style={{
                    pointerEvents: active && "none",
                  }}
                  href=""
                  onClick={(e) => {
                    e.preventDefault();
                    handler();
                  }}
                >
                  <i class={icon} aria-hidden="true"></i>
                  <span>{name}</span>
                </a>
              </li>
            );
          })}
        </ul>
      </div>
    </div>
    // </div>
  );
};
