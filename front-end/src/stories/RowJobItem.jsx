import React from "react";
import "./boxicons.min.css";
import "./icons.css";
import "./row-job-item.css";
import { Button } from "react-bootstrap";
import moment from "moment";

export const RowJobItem = ({ isCompany = false, job }) => {
  const creationDate = moment
    .utc(job.createdDate)
    .local()
    .startOf("seconds")
    .fromNow();

  return (
    <div className="post-job-bx browse-job">
      <div class="post-bx" style={{ width: "100%" }}>
        <div class="job-post-info m-a0">
          <h4>
            <a href="#">{job.position}</a>
          </h4>
          <p>{job.description}</p>
          {isCompany ? (
            <div class="job-time m-t15 m-b10">
              <Button
                variant="success"
                type="submit"
                className="mr-1 "
                size="sm"
              >
                (0) Applications
              </Button>
              <Button
                variant="primary"
                type="submit"
                className="mr-1"
                size="sm"
              >
                Active
              </Button>
            </div>
          ) : (
            <ul>
              <li>
                <a href="#">Company 1</a>
              </li>
              <li>
                <i class="fa fa-map-marker"></i> Giza, Egypt
              </li>
            </ul>
          )}

          <div class="job-time m-t15 m-b10">
            <a class="mr-1" href="#">
              <span>HTML</span>
            </a>
            <a class="mr-1" href="#">
              <span>CSS</span>
            </a>
            <a class="mr-1" href="#">
              <span>Javascript</span>
            </a>
            <a class="mr-1" href="#">
              <span>GIT</span>
            </a>
          </div>
          <div class="posted-info clearfix">
            <p class="m-tb0 text-primary float-left">
              <span class="text-black m-r10">Posted:</span> {creationDate}
            </p>
            {isCompany && (
              <>
                <Button
                  variant="primary"
                  type="submit"
                  className="float-right ml-2"
                  size="sm"
                >
                  View
                </Button>
                <Button
                  variant="danger"
                  type="submit"
                  className="float-right ml-2"
                  size="sm"
                >
                  Delete
                </Button>
              </>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};
