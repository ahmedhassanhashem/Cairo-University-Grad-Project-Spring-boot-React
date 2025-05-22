import React, { useEffect } from "react";
import "./home.css";
import { ProcessStepperExplanation } from "../stories/ProcessStepperExplanation";
import BlueBackgroundImage from "../assets/how-applybg.png";
import Logo from "../stories/assets/brand-3.png";
import Logo2 from "../stories/assets/circle.png";

import { CategoryItem } from "../stories/CategoryItem";

import { JobItem } from "../stories/JobItem";
import { Navigate } from "react-router-dom";

export const HomePage = () => {
  const authenticated = localStorage.getItem("authenticated");

  if (authenticated !== "true") {
    return <Navigate replace to="/sign-in" />;
  }

  return (
    <div>
      <div className="slider-area">
        <div className="slider-active">
          <div
            className="single-slider slider-height d-flex align-items-center"
            style={{
              backgroundImage:
                "url(https://images.unsplash.com/photo-1529400971008-f566de0e6dfc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8.png)",
              backgroundAttachment: "fixed",
              width: "100%",
            }}
          >
            <div className="container">
              <div className="row">
                <div className="col-xl-6 col-lg-9 col-md-10">
                  <div className="hero__caption">
                    <h1>Find the most exciting jobs</h1>
                  </div>
                </div>
              </div>
              <div className="row">
                <div className="col-xl-8">
                  <form action="#" className="search-box">
                    <div className="input-form">
                      <input type="text" placeholder="Job Tittle or keyword" />
                    </div>
                    <div className="select-form">
                      <div className="select-items">
                        <select
                          name="select"
                          id="select1"
                          className="nice-select"
                        >
                          <option value="">Location BD</option>
                          <option value="">Location US</option>
                          <option value="">Location UK</option>
                          <option value="">Location PK</option>
                        </select>
                      </div>
                    </div>
                    <div className="search-form">
                      <a href="#">Find job</a>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div
        className="apply-process-area apply-bg pt-150 pb-150"
        style={{
          backgroundImage: `url(${BlueBackgroundImage})`,
        }}
      >
        <div className="container">
          <div className="row">
            <div className="col-lg-12">
              <div className="section-tittle white-text text-center">
                <span>Apply process</span>
                <h2> How it works</h2>
              </div>
            </div>
          </div>
          <ProcessStepperExplanation />
        </div>
      </div>
      <div className="our-services section-pad-t30">
        <div className="container">
          <div className="row">
            <div className="col-lg-12">
              <div className="section-tittle text-center">
                <span>FEATURED TOURS Packages</span>
                <h2>Browse Top Categories </h2>
              </div>
            </div>
          </div>
          <div className="row d-flex justify-contnet-center">
            <div className="col-xl-3 col-lg-3 col-md-4 col-sm-6">
              <CategoryItem />
            </div>
            <div className="col-xl-3 col-lg-3 col-md-4 col-sm-6">
              <CategoryItem />
            </div>
            <div className="col-xl-3 col-lg-3 col-md-4 col-sm-6">
              <CategoryItem />
            </div>
            <div className="col-xl-3 col-lg-3 col-md-4 col-sm-6">
              <CategoryItem />
            </div>
            <div className="col-xl-3 col-lg-3 col-md-4 col-sm-6">
              <CategoryItem />
            </div>
            <div className="col-xl-3 col-lg-3 col-md-4 col-sm-6">
              <CategoryItem />
            </div>
            <div className="col-xl-3 col-lg-3 col-md-4 col-sm-6">
              <CategoryItem />
            </div>
            <div className="col-xl-3 col-lg-3 col-md-4 col-sm-6">
              <CategoryItem />
            </div>
          </div>
          <div className="row">
            <div className="col-lg-12">
              <div className="browse-btn2 text-center mt-50">
                <a href="job_listing.html" className="border-btn2">
                  Browse All Sectors
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div
        className="online-cv cv-bg section-overly pt-90 pb-120"
        style={{
          backgroundImage:
            "url(https://images.unsplash.com/photo-1517245386807-bb43f82c33c4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8.png)",
          backgroundAttachment: "fixed",
        }}
      >
        <div className="container">
          <div className="row justify-content-center">
            <div className="col-xl-10">
              <div className="cv-caption text-center">
                <p className="pera1">FEATURED TOURS Packages</p>
                <p className="pera2">
                  {" "}
                  Make a Difference with Your Online Resume!
                </p>
                <a href="#" className="border-btn2 border-btn4">
                  Create And Download Your Resume
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <section className="featured-job-area feature-padding">
        <div className="container">
          <div className="row">
            <div className="col-lg-12">
              <div className="section-tittle text-center">
                <span>Recent Job</span>
                <h2>Featured Jobs</h2>
              </div>
            </div>
          </div>
          <div className="row justify-content-center">
            <div className="col-lg-4 col-md-6 p-2">
              <JobItem />
            </div>
            <div className="col-lg-4 col-md-6 p-2">
              <JobItem />
            </div>
            <div className="col-lg-4 col-md-6 p-2">
              <JobItem />
            </div>
            <div className="col-lg-4 col-md-6 p-2">
              <JobItem />
            </div>
            <div className="col-lg-4 col-md-6 p-2">
              <JobItem />
            </div>
            <div className="col-lg-4 col-md-6 p-2">
              <JobItem />
            </div>
          </div>
        </div>
      </section>
    </div>
  );
};
