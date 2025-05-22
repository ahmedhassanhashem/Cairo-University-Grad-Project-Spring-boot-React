import React from "react";
import "../Pages/home.css";
import { NewsLetter } from "./NewsLetter";
export const Footer = () => {
  return (
    <div class="footer-area footer-bg footer-padding">
      <div class="container">
        <div className="row">
          <div className="col-12">
            <NewsLetter />
          </div>
        </div>
        <div class="row d-flex justify-content-between">
          <div class="col-xl-4 col-lg-4 col-md-4 col-sm-6">
            <div class="single-footer-caption mb-50">
              <div class="single-footer-caption mb-30">
                <div class="footer-tittle">
                  <h4>About Us</h4>
                  <div class="footer-pera">
                    <p>
                      Sorem spsum dolor sit amsectetur adipisclit, seddo eiusmod
                      tempor incididunt ut laborea.
                    </p>
                  </div>
                </div>
              </div>
            </div>
            <div class="footer-logo mb-20">
              <a href="index.html">
                <h1 style={{ color: "#fff" }}>LOGO</h1>
              </a>
            </div>
          </div>
          <div class="col-xl-4 col-lg-4 col-md-4 col-sm-5">
            <div class="single-footer-caption mb-50">
              <div class="footer-tittle">
                <h4>Contact Info</h4>
                <ul style={{ paddingLeft: "0" }}>
                  <li>
                    <p>Address :Your address goes here, your demo address.</p>
                  </li>
                  <li>
                    <a href="#">Phone : +123 123456</a>
                  </li>
                  <li>
                    <a href="#">Email : info@mail.com</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
          <div class="col-xl-4 col-lg-4 col-md-4 col-sm-5">
            <div class="single-footer-caption mb-50">
              <div class="footer-tittle">
                <h4>Important Link</h4>
                <ul style={{ paddingLeft: "0" }}>
                  <li>
                    <a href="#"> View Project</a>
                  </li>
                  <li>
                    <a href="#">Contact Us</a>
                  </li>
                  <li>
                    <a href="#">Testimonial</a>
                  </li>
                  <li>
                    <a href="#">Proparties</a>
                  </li>
                  <li>
                    <a href="#">Support</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="row footer-wejed justify-content-between">
          <div class="col-xl-4 col-lg-4 col-md-4 col-sm-5">
            <div class="footer-tittle-bottom">
              <span>5000+</span>
              <p>Talented Hunter</p>
            </div>
          </div>
          <div class="col-xl-4 col-lg-4 col-md-4 col-sm-5">
            <div class="footer-tittle-bottom">
              <span>451</span>
              <p>Talented Hunter</p>
            </div>
          </div>
          <div class="col-xl-4 col-lg-4 col-md-4 col-sm-5">
            <div class="footer-tittle-bottom">
              <span>568</span>
              <p>Talented Hunter</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
