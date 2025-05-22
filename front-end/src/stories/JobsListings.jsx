import React from "react";
import "./job-item.css";

import { Filter } from "./Filter";
import { AppliedJobs } from "./AppliedJobs";

export const JobsListings = () => {
  return (
    <>
      <section class="section-box-2 my-3">
        <div class="container">
          <div class="banner-hero banner-single banner-single-bg">
            <div class="block-banner text-center">
              <h3 class="wow animate__animated animate__fadeInUp">
                <span class="color-brand-2">22 Jobs</span> Available Now
              </h3>
              <div
                class="font-sm color-text-paragraph-2 mt-10 wow animate__animated animate__fadeInUp"
                data-wow-delay=".1s"
              >
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Vero
                repellendus magni, <br class="d-none d-xl-block" />
                atque delectus molestias quis?
              </div>
            </div>
          </div>
        </div>
      </section>
      <section className="container">
        <div className="row">
          <div className="col-md-4 pr-4">
            <Filter />
            <Filter />
            <Filter />
            <Filter />
          </div>
          <div className="col-md-8">
            <AppliedJobs />
          </div>
        </div>
      </section>
    </>
  );
};
