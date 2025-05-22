import React from "react";
import PropTypes from "prop-types";
import { BookmarkDash } from "react-bootstrap-icons";
import IconImage from "./assets/account-finance.svg";
import "./category-item.css";
import { propTypes } from "react-bootstrap/esm/Image";
import { Link } from "react-router-dom";

const colorsMapping = {
  primary: "#2D72D2",
  success: "#238551",
  danger: "#CD4246",
  warning: "#C87619",
};
export const CategoryItem = ({
  intent,
  icon,
  header,
  discription,
  count,
  number,
  onClick,
}) => {
  return (
    <div
      style={{
        width: "100%",
        margin: "15px",
      }}
      onClick={onClick}
    >
      <Link
        to="/jobs-listing"
        onClick={() => {
          window.scrollTo(0, 0);
        }}
      >
        <div className={`${intent} jobs__single-category`}>
          <div className="category__top">
            <div className="icon">
              <img src={icon} alt="" />
            </div>
            <div className="category__number">
              <h6>{`0${number}`}</h6>
            </div>
          </div>
          <div className="category__content">
            <h5>
              <a href="#">{header}</a>
            </h5>
            <p>
              {discription}: <span>{count}</span>
            </p>
          </div>
        </div>
      </Link>
    </div>
  );
};

CategoryItem.propTypes = {
  intent: PropTypes.oneOf(["primary", "danger", "success", "warning"]),
  icon: PropTypes.node,
  header: PropTypes.string,
  discription: PropTypes.string,
  count: PropTypes.number,
  number: PropTypes.number,
  onClick: PropTypes.func,
};

CategoryItem.defaultProps = {
  intent: "primary",
  icon: IconImage,
  header: "Some header here",
  discription: "Small discription",
  count: 20,
  number: 6,
  onClick: () => {},
};
