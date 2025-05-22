import React from "react";
import "./row-job-item.css";

export const FoundJobsHeader = ({ count = 0 }) => {
  return (
    <div class="browse-job">
      <div class="job-bx-title  clearfix">
        <h5 class="font-weight-700 pull-left text-uppercase">
          {count} Jobs Found
        </h5>
        <div class="float-right">
          <span class="select-title">Sort by freshness</span>
          <select class="custom-btn">
            <option>Last 2 Months</option>
            <option>Last Months</option>
            <option>Last Weeks</option>
            <option>Last 3 Days</option>
          </select>
        </div>
      </div>
    </div>
  );
};
