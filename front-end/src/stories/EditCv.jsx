import React from "react";

import "./user-side-bar.css";
import "./boxicons.min.css";
import "./icons.css";

export const EditCv = () => {
  return (
    <div class="job-bx submit-resume">
      <div class="job-bx-title clearfix">
        <h5 class="font-weight-700 pull-left text-uppercase">Basic Info</h5>
        <a class="site-button right-arrow button-sm float-right" href="#">
          Back
        </a>
      </div>
      <form>
        <div class="row m-b30">
          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Name</label>
              <input
                type="text"
                class="form-control"
                placeholder="Enter Full Name"
              />
            </div>
          </div>
          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Your Email</label>
              <input
                type="email"
                class="form-control"
                placeholder="info@gmail.com"
              />
            </div>
          </div>
          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Job title</label>
              <input
                type="text"
                class="form-control"
                placeholder="web Developer"
              />
            </div>
          </div>
          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Date Of Birth</label>
              <input type="text" class="form-control" placeholder="1/1/1900" />
            </div>
          </div>

          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Governate</label>
              <input type="email" class="form-control" placeholder="Cairo" />
            </div>
          </div>
          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Adress</label>
              <input type="email" class="form-control" placeholder="Zamalek" />
            </div>
          </div>
          <div class="col-lg-6 col-md-6">
            <div class="form-group">
              <label>Phone</label>
              <input
                type="text"
                class="form-control"
                placeholder="+1 123 456 7890"
              />
            </div>
          </div>
        </div>

        <div class="row m-b30">
          <div class="job-bx-title clearfix">
            <h5 class="font-weight-700 pull-left text-uppercase">
              PROFESSIONAL SECTION
            </h5>
          </div>
          <div class="row">
            <div class="col-lg-12 col-md-12">
              <div class="form-group">
                <label>Summary</label>
                <textarea
                  class="form-control"
                  placeholder="Write a summary about yourself"
                ></textarea>
              </div>
            </div>
          </div>
        </div>

        <div class="row m-b30">
          <div class="job-bx-title clearfix">
            <h5 class="font-weight-700 pull-left text-uppercase">Education</h5>
          </div>
          <div class="row">
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Education Level</label>
                <input
                  type="text"
                  class="form-control"
                  placeholder="Graduation / College Student"
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Degree</label>
                <input
                  type="text"
                  class="form-control"
                  placeholder="Bachelor's Degree"
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>University</label>
                <input
                  type="text"
                  class="form-control"
                  placeholder="Cairo University"
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Faculty</label>
                <input
                  type="text"
                  class="form-control"
                  placeholder="Faculty Of Computers And Artificial Intelligence"
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Major</label>
                <input
                  type="text"
                  class="form-control"
                  placeholder="Computer Science"
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Start Data</label>
                <input
                  type="text"
                  class="form-control"
                  placeholder="Enter start data"
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>Graduation Data</label>
                <input
                  type="text"
                  class="form-control"
                  placeholder="Expected Graduation Date"
                />
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="form-group">
                <label>GPA</label>
                <input type="text" class="form-control" placeholder="3.5" />
              </div>
            </div>
            <div class="col-lg-12 col-md-12">
              <div class="form-group">
                <label>GPA</label>
                <section
                  id="textarea"
                  class="form-control"
                  contenteditable="true"
                  style={{
                    height: "auto",
                  }}
                >
                  <ul
                    className="mx-4"
                    style={{
                      listStyle: "circle",
                    }}
                  >
                    <li>List item here</li>
                    <li>List item here</li>
                    <li>List item here</li>
                    <li>List item here</li>
                  </ul>
                </section>
              </div>
            </div>
          </div>
        </div>
        <div className="row">
          <button type="submit" class="site-button m-b30">
            Update
          </button>
        </div>
      </form>
    </div>
  );
};
