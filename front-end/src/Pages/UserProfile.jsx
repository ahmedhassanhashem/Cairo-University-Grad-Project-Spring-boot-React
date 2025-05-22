import React, { useRef, useState } from "react";

import { UserSideBar } from "../stories/UserSideBar";
import { UserProfileEdit } from "../stories/UserProfileEdit";
import { ChangePassword } from "../stories/ChangePassword";
import { Cv } from "../stories/Cv";
import { useLocation } from "react-router-dom";
import { EditCv } from "../stories/EditCv";
import { AppliedJobs } from "../stories/AppliedJobs";
import ProfilePicture from "../stories/assets/profile.jpg";
import { getUser } from "../utils";

const profileMappings = (profilePicture, setprofilePicture, imageRef) => {
  const user = getUser();
  return {
    profile: (
      <UserProfileEdit
        profilePicture={profilePicture}
        user={user}
        imageRef={imageRef}
        onProfilePictureChange={setprofilePicture}
      />
    ),
    "my-resume": <Cv user={user} />,
    "edit-resume": <EditCv />,
    "applied-jobs": <AppliedJobs />,
    "change-password": <ChangePassword />,
  };
};

export const UserProfile = () => {
  const [activeTab, setActiveTab] = useState("profile");
  const [profilePicture, setprofilePicture] = useState(ProfilePicture);
  const imageRef = useRef(null);

  const user = getUser();
  const tabs = [
    {
      name: "Profile",
      icon: "fa fa-user-o",
      handler: () => setActiveTab("profile"),
      active: activeTab === "profile",
    },
    {
      name: "My Resume",
      icon: "fa fa-file-text-o",
      handler: () => setActiveTab("my-resume"),
      active: activeTab === "my-resume",
    },
    {
      name: "Applied jobs",
      icon: "fa fa-briefcase",
      handler: () => setActiveTab("applied-jobs"),
      active: activeTab === "applied-jobs",
    },
    {
      name: "Change Password",
      icon: "fa fa-key",
      handler: () => setActiveTab("change-password"),
      active: activeTab === "change-password",
    },
  ];
  return (
    <div className="container pb-5">
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
            profileMappings(profilePicture, setprofilePicture, imageRef)[
              activeTab
            ]
          }
        </div>
      </div>
    </div>
  );
};
