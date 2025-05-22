import React from "react";
import Image from "./assets/job-apply.svg";
import "./process-stepper-explanation.css";
import "bootstrap/dist/css/bootstrap.min.css";

export const ProcessStepperExplanation = ({}) => {
  return (
    <div className="home1-work-process mb-120">
      <div className="container-fluid">
        <div className="row g-lg-4 gy-5 justify-content-center">
          <div className="col-xl-3 col-lg-4 col-sm-6">
            <div className="single-work-process one text-center">
              <div className="icon">
                <img src={Image} alt="" />
              </div>
              <div className="work-content">
                <h5>
                  <a href="#">Account Create</a>
                </h5>
                <p>To create your account be confident &amp; safely.</p>
              </div>
            </div>
          </div>
          <div className="col-xl-3 col-lg-4 col-sm-6">
            <div className="single-work-process two text-center">
              <div className="icon">
                <img src={Image} alt="" />
              </div>
              <div className="work-content">
                <h5>
                  <a href="#">Create Resume</a>
                </h5>
                <p>To create your account be confident &amp; safely.</p>
              </div>
            </div>
          </div>
          <div className="col-xl-3 col-lg-4 col-sm-6">
            <div className="single-work-process one text-center">
              <div className="icon">
                <img src={Image} alt="" />
              </div>
              <div className="work-content">
                <h5>
                  <a href="#">Find Jobs</a>
                </h5>
                <p>To create your account be confident &amp; safely.</p>
              </div>
            </div>
          </div>
          <div className="col-xl-3 col-lg-4 col-sm-6">
            <div className="single-work-process two text-center">
              <div className="icon">
                <img src={Image} alt="" />
              </div>
              <div className="work-content">
                <h5>
                  <a href="#">Apply Jobs</a>
                </h5>
                <p>To create your account be confident &amp; safely.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
