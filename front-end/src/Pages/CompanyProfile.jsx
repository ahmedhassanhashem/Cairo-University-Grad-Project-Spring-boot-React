import React, { useRef, useState } from "react";

import { UserSideBar } from "../stories/UserSideBar";
import { CompanyProfileEdit } from "../stories/CompanyProfileEdit";
import { ChangePassword } from "../stories/ChangePassword";
import { PostAJob } from "../stories/PostAJob";
import { useLocation } from "react-router-dom";
import { ManageJobs } from "../stories/ManageJobs";
import ProfilePicture from "../stories/assets/profile.jpg";
import { getUser } from "../utils";

const profileMappings = (
  user,
  profilePicture,
  setprofilePicture,
  imageRef,
  activeTab
) => {
  return {
    profile: (
      <CompanyProfileEdit
        user={user}
        profilePicture={profilePicture}
        imageRef={imageRef}
        onProfilePictureChange={setprofilePicture}
      />
    ),
    "post-a-job": <PostAJob />,
    "manage-jobs": <ManageJobs activeTab={activeTab} />,
    "change-password": <ChangePassword />,
  };
};

export const CompanyProfile = () => {
  const [activeTab, setActiveTab] = useState("profile");
  const [profilePicture, setprofilePicture] = useState(ProfilePicture);
  const imageRef = useRef(null);
  const user = getUser();

  const tabs = [
    {
      name: "Company Profile",
      icon: "fa fa-user-o",
      handler: () => setActiveTab("profile"),
      active: activeTab === "profile",
    },
    {
      name: "Post A Job",
      icon: "fa fa-file-text-o",
      handler: () => setActiveTab("post-a-job"),
      active: activeTab === "post-a-job",
    },
    {
      name: "Manage jobs",
      icon: "fa fa-briefcase",
      handler: () => setActiveTab("manage-jobs"),
      active: activeTab === "manage-jobs",
    },
    {
      name: "Change Password",
      icon: "fa fa-key",
      handler: () => setActiveTab("change-password"),
      active: activeTab === "change-password",
    },
  ];
  return (
    <div className="container">
      <div className="row">
        <div className="col-lg-3 col-md-4 col-sm-12">
          <UserSideBar
            user={{
              name: user.name,
            }}
            tabs={tabs}
            profilePicture={profilePicture}
            onProfilePictureChange={setprofilePicture}
            imageRef={imageRef}
          />
        </div>

        <div className="col-lg-9 col-md-8 col-sm-12">
          {
            profileMappings(
              user,
              profilePicture,
              setprofilePicture,
              imageRef,
              activeTab
            )[activeTab]
          }
        </div>
      </div>
    </div>
  );
};
