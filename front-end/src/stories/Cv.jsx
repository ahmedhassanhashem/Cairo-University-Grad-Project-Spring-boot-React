import React, { useEffect, useState } from "react";
import "./cv.css";
import jsPDF from "jspdf";
import html2canvas from "html2canvas";
import { dropLast, isEmpty, type } from "ramda";

import PhoneIcon from "./assets/phone-5.svg";
import EnvlopeIcon from "./assets/envlop-5.svg";
import UserImage from "./assets/resume-author.png";
import axios from "axios";

export const Cv = ({ user }) => {
  const { jti } = user;
  const [userInfo, setuserInfo] = useState({
    foundInfo: false,
    tries: 0,
    info: "",
  });

  const [cvLoading, toggleCvIsLoading] = useState(false);

  const token = localStorage.getItem("token");

  const axiosInstance = axios.create({
    baseURL: "https://interna-platform.uc.r.appspot.com/api/gateway/seeker/cv",
    headers: { Authorization: `Bearer ${token}` },
  });

  const exportToPdf = () => {
    console.log("clicked");
    let elem = document.getElementById("report");

    elem.scrollIntoView();
    html2canvas(elem).then((canvas) => {
      const img = canvas.toDataURL("image/png", 1);

      var imgWidth = 210;
      var pageHeight = 450;
      var imgHeight = (canvas.height * imgWidth) / canvas.width;
      var heightLeft = imgHeight;

      const pdf = new jsPDF("p", "mm", "a4");
      var position = 0;

      pdf.addImage(img, "PNG", 0, 0, imgWidth, imgHeight, 100);
      heightLeft -= pageHeight;

      while (heightLeft >= 0) {
        position = heightLeft - imgHeight;
        pdf.addPage();
        pdf.addImage(img, "PNG", 0, 0, imgWidth, imgHeight);
        heightLeft -= pageHeight;
      }

      //pdf.addImage(img, 'PNG', 0, 0)
      pdf.save("export.pdf");
    });
  };

  const defaultExperience = (idx) => (
    <div class="educational-qualification mb-30">
      <div
        class="education-dt"
        style={{
          maxWidth: "100%",
          overflow: "hidden",
        }}
      >
        <h6 contentEditable="true">
          Company Name ( <span>0{idx + 1}.</span>
          <span contentEditable="true">April, 2021- May, 2022</span> )
        </h6>
        <p class="position">
          <span>Position:</span> <span contentEditable="true">Position</span>({" "}
          <span contentEditable="true">Full-Time</span>)
          <span contentEditable="true"></span>
        </p>
        <div class="responsibility">
          <h6>Responsibility:</h6>
          <section
            id="textarea"
            class="form-control w-100"
            contenteditable="true"
            style={{
              height: "auto",
              width: "100%",
              border: "none",
            }}
          >
            <ul>
              <li>Start Writing your job responsibilities</li>
            </ul>
          </section>
        </div>
      </div>
    </div>
  );

  const [professionalExperience, setProfessinalExperience] = useState([
    defaultExperience(0),
  ]);
  const defaultSkill = <li className="col-md-4">List item here</li>;
  const [skills, setSkills] = useState([defaultSkill]);

  const [uploadedImage, setUploadedImage] = useState(UserImage);

  const getCV = (function () {
    var executed = false;
    return function () {
      if (!executed) {
        executed = true;
        if (!userInfo.foundInfo && userInfo.tries === 0) {
          axiosInstance({
            method: "GET",
            url: `/${user.jti}`,
          })
            .then(({ data }) => {
              setuserInfo(() => {
                return {
                  foundInfo: true,
                  tries: 1,
                  info: data.data,
                };
              });
            })
            .catch(() => {
              setuserInfo({ ...userInfo, tries: 1 });
            });
        }
      }
    };
  })();

  getCV();

  useEffect(() => {
    document.getElementById("download").addEventListener("click", handleSaveCV);
  });

  const handleSaveCV = (e) => {
    e.preventDefault();
    exportToPdf();
    axiosInstance({
      method: "POST",
      url: "",
      data: {
        id: jti,
        cv: document.getElementById("report").innerHTML,
      },
    })
      .then(console.log)
      .catch((error) => {
        axiosInstance({
          method: "PUT",
          url: `/update`,
          data: {
            id: jti,
            cv: document.getElementById("report").innerHTML,
          },
        })
          .then(console.log)
          .catch(console.log);
      });
  };

  console.log(uploadedImage);
  return (
    <div class="dashboard-area mb-120">
      <span style={{ color: "black" }}>
        * click on any section info to edit and add yours. Edit is happening
        inline
      </span>
      <div class="container">
        <div class="row justify-content-center g-lg-4 gy-5 mb-90">
          <div class="col-lg-12">
            {userInfo.foundInfo ? (
              <div
                class="resume-area"
                id="report"
                dangerouslySetInnerHTML={{
                  __html: userInfo.info.cv,
                }}
              ></div>
            ) : (
              <div class="resume-area" id="report">
                <div class="edit-resume-btn">
                  <a
                    href="#"
                    id="download"
                    onClick={handleSaveCV}
                    data-html2canvas-ignore="true"
                  >
                    <i
                      class="fa fa-arrow-circle-down mr-2"
                      aria-hidden="true"
                    ></i>
                    Download Resume
                  </a>
                </div>
                <div class="row g-4 mb-40">
                  <div class="col-lg-6">
                    <div class="author-area">
                      <div class="name-degination">
                        <h4 contenteditable="true">Add Your Name Here</h4>
                        <span contenteditable="true">Job Title</span>
                      </div>
                    </div>
                  </div>
                  <div class="col-lg-6">
                    <div class="contact-area">
                      <h4>Contact Info</h4>
                      <ul>
                        <li>
                          Phone:{" "}
                          <span contenteditable="true">+20123 456 789 </span>
                          <a href="#">
                            <span>
                              <img src={PhoneIcon} alt="" />
                            </span>
                          </a>
                        </li>
                        <li>
                          Email:
                          <span contenteditable="true">info@example.com </span>
                          <a href="#">
                            <span>
                              <img src={EnvlopeIcon} alt="" />
                            </span>
                          </a>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
                <div class="col-lg-12">
                  <div class="single-information-area">
                    <div class="section-title">
                      <h6>Summary</h6>
                      <div class="dash"></div>
                    </div>
                    <div class="description">
                      <p contentEditable="true" style={{ color: "black" }}>
                        Write Summary About yourself here
                      </p>
                    </div>
                  </div>
                </div>
                <div class="col-lg-12">
                  <div class="single-information-area">
                    <div class="section-title">
                      <h6>Educational Qualification</h6>
                      <div class="dash"></div>
                    </div>
                    <div class="educational-qualification mb-30">
                      <div class="passing-year">
                        <p contentEditable="true">
                          <span>01.</span>April, 2016- May, 2020
                        </p>
                        <span></span>
                      </div>
                      <div class="education-dt">
                        <h6 contentEditable="true">College Name</h6>
                        <ul>
                          <li>
                            <span>Education Level:</span>{" "}
                            <span contentEditable="true">Graduation</span>
                          </li>
                          <li>
                            <span>My Major:</span>{" "}
                            <span contentEditable="true">Your Major</span>
                          </li>
                          <li>
                            <span>Result/GPA:</span>{" "}
                            <span contentEditable="true">your GPA</span>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-lg-12">
                  <div class="single-information-area">
                    <div class="section-title professional-information">
                      <h6>Professionals Information</h6>
                      <button
                        style={{ backgroundColor: "transparent" }}
                        className="mr-3 add-experience"
                        onClick={() => {
                          setProfessinalExperience([
                            ...professionalExperience,
                            defaultExperience(professionalExperience.length),
                          ]);
                        }}
                      >
                        <i
                          class="fa fa-plus-circle"
                          aria-hidden="true"
                          style={{ color: "#0275d8" }}
                        ></i>
                      </button>

                      <button
                        style={{ backgroundColor: "transparent" }}
                        className="mr-3 add-experience"
                        onClick={() => {
                          if (professionalExperience.length === 1) {
                            setProfessinalExperience([]);
                            return;
                          }
                          setProfessinalExperience(
                            dropLast(1, professionalExperience)
                          );
                        }}
                      >
                        <i
                          class="fa fa-minus-circle"
                          aria-hidden="true"
                          style={{ color: "#0275d8" }}
                        ></i>
                      </button>
                      <div class="dash"></div>
                    </div>
                    {professionalExperience.map((job) => {
                      return job;
                    })}
                  </div>
                </div>
                <div class="col-lg-12">
                  <div class="single-information-area">
                    <div class="section-title skills-section">
                      <h6>Special Skills</h6>
                      <button
                        style={{ backgroundColor: "transparent" }}
                        className="mr-3 add-skill"
                        onClick={() => {
                          setSkills([...skills, defaultSkill]);
                        }}
                      >
                        <i
                          class="fa fa-plus-circle"
                          aria-hidden="true"
                          style={{ color: "#0275d8" }}
                        ></i>
                      </button>

                      <button
                        style={{ backgroundColor: "transparent" }}
                        className="mr-3 add-skill"
                        onClick={() => {
                          console.log({ skills });
                          if (skills.length === 1) {
                            setSkills([]);
                            return;
                          }
                          setSkills(dropLast(1, skills));
                        }}
                      >
                        <i
                          class="fa fa-minus-circle"
                          aria-hidden="true"
                          style={{ color: "#0275d8" }}
                        ></i>
                      </button>
                      <div class="dash"></div>
                    </div>
                    <section
                      id="textarea"
                      class="form-control w-100 tag-area"
                      contenteditable="true"
                      style={{
                        height: "auto",
                        width: "100%",
                        border: "none",
                      }}
                    >
                      <ul className="row">
                        {skills.map((job) => {
                          return job;
                        })}
                      </ul>
                    </section>
                  </div>
                </div>
              </div>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};
