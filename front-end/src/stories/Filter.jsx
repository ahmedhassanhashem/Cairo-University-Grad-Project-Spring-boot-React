import React from "react";

import "./job-item.css";

export const Filter = ({}) => {
  return (
    <div class="filter-block mb-30">
      <h5 class="medium-heading mb-10">Popular Keyword</h5>
      <div class="form-group">
        <ul class="list-checkbox">
          <li>
            <label class="cb-container">
              <input type="checkbox" />
              <span class="text-small">Software</span>
              <span class="checkmark"></span>
            </label>
            <span class="number-item">24</span>
          </li>
          <li>
            <label class="cb-container">
              <input type="checkbox" />
              <span class="text-small">Developer</span>
              <span class="checkmark"></span>
            </label>
            <span class="number-item">45</span>
          </li>
          <li>
            <label class="cb-container">
              <input type="checkbox" />
              <span class="text-small">Web</span>
              <span class="checkmark"></span>
            </label>
            <span class="number-item">57</span>
          </li>
        </ul>
      </div>
    </div>
  );
};
