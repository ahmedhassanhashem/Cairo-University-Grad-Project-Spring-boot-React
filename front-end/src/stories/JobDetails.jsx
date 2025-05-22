import React from "react";
import "./job-item.css";
import CompanyLogo from "../stories/assets/brand-3.png";
import { Button } from "react-bootstrap";
export const JobDetails = () => {
  return (
    <section class="section-box mt-50">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-12 col-sm-12 col-12">
            <div class="box-border-single">
              <div class="row mt-10">
                <div class="col-lg-8 col-md-12">
                  <h3>Full Stack developer</h3>
                  <div class="mt-0 mb-15">
                    <span class="card-briefcase">Fulltime</span>
                    <span class="card-time">1 hour ago</span>
                  </div>
                </div>
                <div class="col-lg-4 col-md-12 text-lg-end">
                  <Button
                    size="lg"
                    variant="primary"
                    type="submit"
                    className="mr-15"
                  >
                    Apply now
                  </Button>
                </div>
              </div>
              <div class="border-bottom pt-10 pb-10"></div>
              <div class="job-overview">
                <h5 class="border-bottom pb-15 mb-30">Overview</h5>
                <div class="row">
                  <div class="col-md-6 d-flex">
                    <div class="sidebar-icon-item">
                      <span class="text-description industry-icon mb-10">
                        Industry
                      </span>
                      <strong class="small-heading">
                        Mechanical / Auto / Automotive, Civil / Construction
                      </strong>
                    </div>
                  </div>
                  <div class="col-md-6 d-flex mt-sm-15">
                    <div class="sidebar-icon-item"></div>
                    <div class="sidebar-text-info ml-10">
                      <span class="text-description joblevel-icon mb-10">
                        Job level
                      </span>
                      <strong class="small-heading" style={{ color: "black" }}>
                        Experienced (Non - Manager)
                      </strong>
                    </div>
                  </div>
                </div>
                <div class="row mt-25">
                  <div class="col-md-6 d-flex">
                    <div class="sidebar-text-info ml-10">
                      <span class="text-description experience-icon mb-10">
                        Experience
                      </span>
                      <strong class="small-heading">1 - 2 years</strong>
                    </div>
                  </div>
                  <div class="col-md-6 d-flex mt-sm-15">
                    <div class="sidebar-text-info ml-10">
                      <span class="text-description mb-10">Location</span>
                      <strong class="small-heading">Giza, Egypt</strong>
                    </div>
                  </div>
                </div>
                <div class="row mt-25">
                  <div class="col-md-6 d-flex mt-sm-15">
                    <div class="sidebar-text-info ml-10">
                      <span class="text-description jobtype-icon mb-10">
                        Job type
                      </span>
                      <strong class="small-heading">Full time</strong>
                    </div>
                  </div>
                  <div class="col-md-6 d-flex mt-sm-15">
                    <div class="sidebar-text-info ml-10">
                      <span class="text-description mb-10">Deadline</span>
                      <strong class="small-heading">10/08/2022</strong>
                    </div>
                  </div>
                </div>
                <div class="row mt-25">
                  {/* <div class="col-md-6 d-flex mt-sm-15">
                    <div class="sidebar-text-info ml-10">
                      <span class="text-description jobtype-icon mb-10">
                        Updated
                      </span>
                      <strong class="small-heading">10/07/2022</strong>
                    </div>
                  </div> */}
                </div>
              </div>
              <div class="content-single">
                <h4>Welcome to Company Team</h4>
                <p>
                  The Company Design team has a vision to establish a trusted
                  platform that enables productive and healthy enterprises in a
                  world of digital and remote everything, constantly changing
                  work patterns and norms, and the need for organizational
                  resiliency.
                </p>
                <p>
                  The ideal candidate will have strong creative skills and a
                  portfolio of work which demonstrates their passion for
                  illustrative design and typography. This candidate will have
                  experiences in working with numerous different design
                  platforms such as digital and print forms.
                </p>
                <h4>Essential Knowledge, Skills, and Experience</h4>
                <ul>
                  <li>
                    A portfolio demonstrating well thought through and polished
                    end to end customer journeys
                  </li>
                  <li>
                    5+ years of industry experience in interactive design and /
                    or visual design
                  </li>
                  <li>Excellent interpersonal skills</li>
                  <li>
                    Aware of trends inmobile, communications, and collaboration
                  </li>
                  <li>
                    Ability to create highly polished design prototypes,
                    mockups, and other communication artifacts
                  </li>
                  <li>
                    The ability to scope and estimate efforts accurately and
                    prioritize tasks and goals independently
                  </li>
                  <li>History of impacting shipping products with your work</li>
                  <li>
                    A Bachelor's Degree in Design (or related field) or
                    equivalent professional experience
                  </li>
                  <li>
                    Proficiency in a variety of design tools such as Figma,
                    Photoshop, Illustrator, and Sketch
                  </li>
                </ul>
                <h4>Preferred Experience</h4>
                <ul>
                  <li>
                    Designing user experiences for enterprise software /
                    services
                  </li>
                  <li>
                    Creating and applying established design principles and
                    interaction patterns
                  </li>
                  <li>
                    Aligning or influencing design thinking with teams working
                    in other geographies
                  </li>
                </ul>
                {/* <h4>Product Designer</h4> */}
                {/* <p>
                  <strong>Product knowledge:</strong> Deeply understand the
                  technology and features of the product area to which you are
                  assigned.
                </p>
                <p>
                  <strong>Research:</strong> Provide human and business impact
                  and insights for products.
                </p>
                <p>
                  <strong>Deliverables:</strong> Create deliverables for your
                  product area (for example competitive analyses, user flows,
                  low fidelity wireframes, high fidelity mockups, prototypes,
                  etc.) that solve real user problems through the user
                  experience.
                </p>
                <p>
                  <strong>Communication:</strong> Communicate the results of UX
                  activities within your product area to the design team
                  department, cross-functional partners within your product
                  area, and other interested Superformula team members using
                  clear language that simplifies complexity.
                </p> */}
              </div>
              <div class="author-single">
                <span>( Company Name )</span>
              </div>
              <div class="single-apply-jobs">
                <div class="row align-items-center">
                  <div class="col-md-5">
                    <Button variant="primary" type="submit" className="mr-15">
                      Apply now
                    </Button>
                    <Button
                      variant="outline-secondary"
                      type="submit"
                      className="mr-15"
                    >
                      Save Job
                    </Button>
                  </div>
                  <div class="col-md-7 text-lg-end social-share"></div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-md-12 col-sm-12 col-12 pl-40 pl-lg-15 mt-lg-30">
            <div class="sidebar-border">
              <div class="sidebar-heading">
                <div class="avatar-sidebar">
                  <figure>
                    <img alt="Logo" src={CompanyLogo} />
                  </figure>
                  <div class="sidebar-info pt-1">
                    <span class="sidebar-company">( Company Name )</span>
                    <span class="card-location">Zaamalek, Giza, Egypt</span>
                  </div>
                </div>
              </div>
              <div class="sidebar-list-job">
                <ul class="ul-disc">
                  <li>205 Share3 abo el feda, zamalek, giza</li>
                  <li>Phone: (123) 456 7890</li>
                  <li>Email: contact@mail.com</li>
                  <li>
                    <a
                      href="#"
                      style={{
                        color: "#0275d8",
                      }}
                      ref={(node) => {
                        if (node) {
                          node.style.setProperty(
                            "text-decoration",
                            "underline",
                            "important"
                          );
                        }
                      }}
                    >
                      02 Open Jobs
                    </a>
                  </li>
                </ul>
              </div>
            </div>
            <div class="sidebar-border">
              <h6 class="f-18">Tags</h6>
              <div class="sidebar-list-job">
                <button class="btn btn-grey-small bg-14 mb-10 mr-2">
                  Digital
                </button>
                <button class="btn btn-grey-small bg-14 mb-10 mr-2">
                  Marketing
                </button>
                <button class="btn btn-grey-small bg-14 mb-10 mr-2">
                  Conten Writer
                </button>
                <button class="btn btn-grey-small bg-14 mb-10 mr-2">
                  Sketch
                </button>
                <button class="btn btn-grey-small bg-14 mb-10 mr-2">App</button>
                <button class="btn btn-grey-small bg-14 mb-10 mr-2">PSD</button>
                <button class="btn btn-grey-small bg-14 mb-10 mr-2">
                  Laravel
                </button>
                <button class="btn btn-grey-small bg-14 mb-10 mr-2">
                  React JS
                </button>
                <button class="btn btn-grey-small bg-14 mb-10 mr-2">
                  HTML
                </button>
                <button class="btn btn-grey-small bg-14 mb-10 mr-2">
                  Finance
                </button>
                <button class="btn btn-grey-small bg-14 mb-10 mr-2">
                  Manager
                </button>
                <button class="btn btn-grey-small bg-14 mb-10 mr-2">
                  Business
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
