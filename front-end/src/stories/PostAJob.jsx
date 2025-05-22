import React, { useState } from "react";

import "./user-side-bar.css";
import "./boxicons.min.css";
import "./icons.css";
import { Button } from "react-bootstrap";
import { getUser } from "../utils";
import { useToasts } from "react-toast-notifications";
import axios from "axios";

export const PostAJob = () => {
  const user = getUser();

  const [jobInfo, setJobInfo] = useState({});

  const [isSaving, toggleIsSaving] = useState(false);

  const { addToast } = useToasts();

  const token = localStorage.getItem("token");

  const axiosInstance = axios.create({
    baseURL: "https://interna-platform.uc.r.appspot.com/api/gateway/job",
    headers: { Authorization: `Bearer ${token}` },
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    const infoToSave = {
      company: {
        id: user.jti,
      },
      ...jobInfo,
    };

    toggleIsSaving(true);
    axiosInstance({
      method: "POST",
      url: "",
      data: infoToSave,
    })
      .then(() => {
        toggleIsSaving(false);
        addToast("Job Posted Successfully !", {
          appearance: "success",
          autoDismiss: true,
        });
      })
      .catch(() => {
        addToast(
          "Somthing went wrong while submiting your job! please try again later",
          {
            appearance: "error",
            autoDismiss: true,
          }
        );
        toggleIsSaving(false);
      });
  };

  const handleFieldsChange = (field, e) => {
    setJobInfo({
      ...jobInfo,
      [field]: e.target.value,
    });
  };
  return (
    <div class="job-bx submit-resume mb-5">
      <div class="job-bx-title clearfix">
        <h5 class="font-weight-700 pull-left text-uppercase">POST A JOB</h5>
        <a class="site-button right-arrow button-sm float-right" href="#">
          Back
        </a>
      </div>
      <form onSubmit={handleSubmit}>
        <div class="row m-b30">
          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Job Title</label>
              <input
                required
                type="text"
                name="position"
                class="form-control"
                placeholder="Enter Job Title"
                value={jobInfo.title}
                onChange={(e) => handleFieldsChange("position", e)}
              />
            </div>
          </div>
          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Job Level</label>
              <select
                required
                name="jobLevel"
                value={jobInfo.jobLevel}
                onChange={(e) => handleFieldsChange("jobLevel", e)}
                class="custom-select custom-select"
              >
                <option value="Intern">Intern</option>
                <option value="Entry level">Entry level</option>
                <option value="Experienced">Experienced</option>
              </select>
            </div>
          </div>
          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Job Type</label>
              <select
                required
                name="jobType"
                value={jobInfo.jobType}
                onChange={(e) => handleFieldsChange("jobType", e)}
                class="custom-select custom-select"
              >
                <option value="Full time">Full time</option>
                <option value="Part time">Part time</option>
              </select>
            </div>
          </div>
          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Experience</label>
              <select
                required
                name="experience"
                value={jobInfo.experience}
                onChange={(e) => handleFieldsChange("experience", e)}
                class="custom-select custom-select"
              >
                <option value={1}>1 Year</option>
                <option value={2}>2 Years</option>
              </select>
            </div>
          </div>
          {/* <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Region</label>
              <select class="custom-select custom-select">
                <option value={1}>Cairo</option>
                <option>Giza</option>
                <option>Alexandria</option>
              </select>
            </div>
          </div> */}
          {/* <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Location</label>
              <input type="text" class="form-control" placeholder="London" />
            </div>
          </div> */}
          <div class="col-lg-12 col-md-12">
            <div class="form-group">
              <label>Description:</label>
              <textarea
                required
                name="description"
                value={jobInfo.description}
                onChange={(e) => handleFieldsChange("description", e)}
                class="form-control"
              ></textarea>
            </div>
          </div>
          <div class="col-lg-12 col-md-12">
            <div class="form-group">
              <label>Requirements:</label>
              <textarea
                required
                name="requirements"
                value={jobInfo.requirements}
                onChange={(e) => handleFieldsChange("requirements", e)}
                class="form-control"
              ></textarea>
            </div>
          </div>

          <div class="col-lg-12 col-md-12">
            <div class="form-group">
              <label>Deadline</label>
              <input
                type="date"
                required
                class="form-control"
                name="deadLine"
                placeholder="2020-05-05"
                value={jobInfo.deadLine}
                onChange={(e) => handleFieldsChange("deadLine", e)}
              />
            </div>
          </div>
        </div>
        <Button
          variant="primary"
          disabled={isSaving}
          type="submit"
          className="w-100"
        >
          {isSaving ? (
            <div
              class="spinner-grow
                              ..30......."
              role="status"
            >
              <span class="sr-only">Loading...</span>
            </div>
          ) : (
            "Post"
          )}
        </Button>
      </form>
    </div>
  );
};
