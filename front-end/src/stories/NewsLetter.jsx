import React from "react";
import "./job-item.css";
import LeftImage from "./assets/newsletter-left.png";
import RightImage from "./assets/newsletter-right.png";
import { Button } from "react-bootstrap";
export const NewsLetter = () => {
  return (
    <section class="section-box mb-150">
      <div class="container">
        <div class="box-newsletter">
          <div class="row">
            <div class="col-xl-3 col-12 text-center d-none d-xl-block">
              <img src={LeftImage} alt="joxBox" />
            </div>
            <div class="col-lg-12 col-xl-6 col-12">
              <h2 class="text-md-newsletter text-center">
                New Things Will Always
                <br /> Update Regularly
              </h2>
              <div class="box-form-newsletter mt-40">
                <form class="form-newsletter">
                  <input
                    class="input-newsletter"
                    type="text"
                    placeholder="Enter your email here"
                  />
                  <Button variant="primary">Subscribe</Button>
                </form>
              </div>
            </div>
            <div class="col-xl-3 col-12 text-center d-none d-xl-block">
              <img src={RightImage} alt="joxBox" />
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};
