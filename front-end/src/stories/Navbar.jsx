import React from "react";
import "./navbar.css";
import "./animate.css";
import "bootstrap/dist/js/bootstrap.bundle.js";
import "bootstrap/dist/css/bootstrap.min.css";
import { Link, NavLink, useLocation } from "react-router-dom";
import Image from "./assets/brand-3.png";

import { getUser } from "../utils";
import {
  Nav,
  Navbar as BootstrapNavBar,
  Container,
  Offcanvas,
} from "react-bootstrap";

export const Navbar = () => {
  const location = useLocation();
  const user = getUser();

  const { name, role } = user;

  const token = localStorage.getItem("token");

  const UserNav = () => {
    return (
      <>
        <Nav.Link className="mr-3" active={location.pathname === "/"}>
          <Link to="/">Home</Link>
        </Nav.Link>
        <Nav.Link
          className="mr-3"
          active={location.pathname === "/jobs-listing"}
        >
          <Link to="/jobs-listing">Jobs Listing</Link>
        </Nav.Link>
        {/* <Nav.Link
          className="mr-3"
          active={location.pathname === "/job-details"}
        >
          <Link to="/job-details">Job Details</Link>
        </Nav.Link> */}
        <Nav.Link className="mr-3" active={location.pathname === "/profile"}>
          <Link to="profile">{name} Profile</Link>
        </Nav.Link>
        <Nav.Link className="mr-3">
          <Link
            className="btn btn-danger d-flex justify-content-center align-items-center"
            to="/sign-in"
            onClick={() => {
              localStorage.clear();
            }}
          >
            Logout
          </Link>
        </Nav.Link>
      </>
    );
  };

  const CompanyNav = () => {
    return (
      <>
        <Nav.Link className="mr-3" active={location.pathname === "/"}>
          <Link to="/">Home</Link>
        </Nav.Link>
        <Nav.Link
          className="mr-3"
          active={location.pathname === "/company-profile"}
        >
          <Link to="/company-profile">{name} Profile</Link>
        </Nav.Link>
        {/* <Nav.Link
          className="mr-3"
          active={location.pathname === "/jobs-listing"}
        >
          <Link to="/jobs-listing">Jobs Listing</Link>
        </Nav.Link> */}
        {/* <Nav.Link
          className="mr-3"
          active={location.pathname === "/job-details"}
        >
          <Link to="/job-details">Job Details</Link>
        </Nav.Link> */}
        <Nav.Link className="mr-3">
          <Link
            className="btn btn-danger d-flex justify-content-center align-items-center"
            to="/sign-in"
            onClick={() => {
              localStorage.clear();
            }}
          >
            Logout
          </Link>
        </Nav.Link>
      </>
    );
  };

  return (
    <BootstrapNavBar
      bg="light"
      collapseOnSelect
      expand="md"
      className="mb-2 py-3"
      style={{
        boxShadow: "0 0 10px #0018801a",
      }}
    >
      <Container>
        <BootstrapNavBar.Brand href="#">
          <image
            src={Image}
            width="30"
            height="30"
            className="d-inline-block align-top"
          />
        </BootstrapNavBar.Brand>
        <BootstrapNavBar.Toggle
          aria-controls={`offcanvasNavbar-expand`}
          style={{
            height: "40px",
            width: "40px",
            color: "gray",
            border: "2px solid gray",
            borderRadius: "5px",
          }}
        >
          <i
            class="fa fa-bars"
            style={{
              fontSize: "30px",
            }}
            aria-hidden="true"
          ></i>
        </BootstrapNavBar.Toggle>
        <BootstrapNavBar.Offcanvas
          id={`offcanvasNavbar-expand`}
          aria-labelledby={`offcanvasNavbarLabel-expand`}
          placement="end"
        >
          <Offcanvas.Header closeButton>
            <Offcanvas.Title id={`offcanvasNavbarLabel-expand`}>
              Offcanvas
            </Offcanvas.Title>
          </Offcanvas.Header>
          <Offcanvas.Body>
            <Nav className="justify-content-end flex-grow-1 pe-3">
              {role === "SEEKER" ? (
                <UserNav />
              ) : role === "COMPANY" ? (
                <CompanyNav />
              ) : (
                <>
                  <NavLink
                    to="/sign-in"
                    className="btn mr-1 d-flex justify-content-center align-items-center"
                    style={{
                      color: "#6c757d",
                      backgroundColor: "transparent",
                      backgroundImage: "none",
                      borderColor: "#6c757d",
                    }}
                  >
                    Sign In
                  </NavLink>
                  <NavLink
                    to="/sign-up"
                    className="btn btn-primary d-flex justify-content-center align-items-center"
                  >
                    Sign up
                  </NavLink>
                </>
              )}
            </Nav>
          </Offcanvas.Body>
        </BootstrapNavBar.Offcanvas>
      </Container>
    </BootstrapNavBar>
  );
};

// <div
//   class="header p-0"
//   style={{
//     borderBottom: "2px solid #0275d8",
//   }}
// >
//   <div class="container">
//     <div class="main-header">
//       <div class="header-left">
//         <div class="header-logo">
//           <a class="d-flex" href="#/">
//             <h1>interna</h1>
//           </a>
//         </div>
//       </div>
//       <div class="header-nav">
//         <nav class="nav-main-menu">
//           <ul class="main-menu">
//             <li>
//               <Link
//                 class={classNames("", {
//                   active: location.pathname === "/",
//                 })}
//                 to="/"
//               >
//                 Home
//               </Link>
//             </li>
//             {/* <li class="has-children">
//               <a href="#">Find a Job</a>
//               <ul class="sub-menu">
//                 <li>
//                   <a href="#">Jobs Grid</a>
//                 </li>
//                 <li>
//                   <a href="#/">Jobs List</a>
//                 </li>
//                 <li>
//                   <a href="#/">Jobs Details</a>
//                 </li>
//                 <li>
//                   <a href="#/">Jobs Details 2 </a>
//                 </li>
//               </ul>
//             </li> */}
//             {/* <li class="has-children">
//               <a href="#/">Recruiters</a>
//               <ul class="sub-menu">
//                 <li>
//                   <a href="#/">Recruiters</a>
//                 </li>
//                 <li>
//                   <a href="#/">Company Details</a>
//                 </li>
//               </ul>
//             </li> */}
//             {/* <li class="has-children">
//               <a href="#/">Candidates</a>
//               <ul class="sub-menu">
//                 <li>
//                   <a href="#">Candidates Grid</a>
//                 </li>
//                 <li>
//                   <a href="#">Candidate Details</a>
//                 </li>
//                 <li>
//                   <a href="#">Candidate Profile</a>
//                 </li>
//               </ul>
//             </li> */}
//             {/* <li class="has-children">
//               <a href="#">Pages</a>
//               <ul class="sub-menu">
//                 <li>
//                   <a href="#">About Us</a>
//                 </li>
//                 <li>
//                   <a href="#">Pricing Plan</a>
//                 </li>
//                 <li>
//                   <a href="#">Contact Us</a>
//                 </li>
//                 <li>
//                   <a href="#">Register</a>
//                 </li>
//                 <li>
//                   <a href="#">Signin</a>
//                 </li>
//                 <li>
//                   <a href="#">Reset Password</a>
//                 </li>
//                 <li>
//                   <a href="#">Content Protected</a>
//                 </li>
//               </ul>
//             </li> */}
//             {/* <li>
//               <a href="#">Contact</a>
//             </li> */}
//             <li>
//               <Link
//                 class={classNames("", {
//                   active: location.pathname === "/company-profile",
//                 })}
//                 to="/company-profile"
//               >
//                 Company
//               </Link>
//             </li>
//             <li>
//               <Link
//                 class={classNames("", {
//                   active: location.pathname === "/jobs-listing",
//                 })}
//                 to="/jobs-listing"
//               >
//                 Jobs Listing
//               </Link>
//             </li>
//             <li>
//               <Link
//                 class={classNames("", {
//                   active: location.pathname === "/job-details",
//                 })}
//                 to="/job-details"
//               >
//                 Job Details
//               </Link>
//             </li>
//             <li>
//               <Link
//                 class={classNames("", {
//                   active: location.pathname === "profile",
//                 })}
//                 to="/profile"
//               >
//                 User
//               </Link>
//             </li>
//           </ul>
//         </nav>
//         <div class="burger-icon burger-icon-white ">
//           <span class="burger-icon-top"></span>
//           <span class="burger-icon-mid"></span>
//           <span class="burger-icon-bottom"></span>
//         </div>
//       </div>
//       <div class="header-right">
//         <div class="block-signin">
//           <a class="text-link-bd-btom hover-up" href="#">
//             Register
//           </a>
//           <a class="btn btn-default btn-shadow ml-40 hover-up" href="#">
//             Sign in
//           </a>
//         </div>
//       </div>
//     </div>
//   </div>
// </div>;
