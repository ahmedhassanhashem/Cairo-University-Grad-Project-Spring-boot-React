import React from "react";
import PropTypes from "prop-types";

import "./job-item.css";

import Image from "./assets/brand-3.png";
import { Link } from "react-router-dom";
import { Button } from "react-bootstrap";
export const JobItem = ({ companyInfo, jobInfo, onClick }) => {
  const { name, location, image } = companyInfo;
  const { jobName, employmentType, postedAt, description, skills } = jobInfo;

  return (
    <div
      style={{
        width: "100%",
      }}
    >
      <div class="card-grid-2 hover-up">
        <div class="card-grid-2-image-left">
          <span class="flash"></span>
          <div class="image-box">
            <img src={image} style={{ height: "50px" }} alt="Logo" />
          </div>
          <div class="right-info">
            <a class="name-job" href="#">
              {name}
            </a>
            <span class="location-small">{location}</span>
          </div>
        </div>
        <div class="card-block-info">
          <h6>
            <a
              href="#"
              style={{
                color: "#000",
              }}
            >
              {jobName}
            </a>
          </h6>
          <div class="mt-2">
            <span class="card-briefcase">{employmentType}</span>
            <span class="card-time">
              <span>{postedAt}</span>
            </span>
          </div>
          <p class="font-sm color-text-paragraph mt-15">{description}</p>
          <div class="mt-30">
            {skills.map((skill) => {
              return (
                <a class="btn btn-grey-small mr-2 mb-3" href="#">
                  {skill}
                </a>
              );
            })}
          </div>
          <div class="card-2-bottom mt-30">
            <div class="row">
              <div class="col-lg-6 col-6"></div>
              <div class="col-lg-6 col-6 text-end">
                <Button variant="primary">
                  <Link
                    to="/job-details"
                    onClick={(e) => {
                      window.scrollTo(0, 0);
                    }}
                  >
                    Apply now
                  </Link>
                </Button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

JobItem.propTypes = {
  companyInfo: {
    name: PropTypes.string,
    location: PropTypes.string,
    image: PropTypes.node,
  },
  jobInfo: {
    jobName: PropTypes.string,
    employmentType: PropTypes.string,
    postedAt: PropTypes.string,
    description: PropTypes.string,
    skills: PropTypes.array,
  },

  onClick: PropTypes.func,
};

JobItem.defaultProps = {
  companyInfo: {
    name: "Company A",
    location: "Cairo Giza",
    image: Image,
  },
  jobInfo: {
    jobName: "Frontend developer",
    employmentType: "Full Time",
    postedAt: "2020",
    description: "Some text here that is tooo loooooong",
    skills: ["HTML", "CSS", "Javascript"],
  },
  onClick: () => {},
};
