import React, { useEffect, useMemo } from "react";
import {
  Routes,
  Route,
  BrowserRouter,
  useNavigate,
  useLocation,
} from "react-router-dom";
import jwtDecode from "jwt-decode";

import "./App.css";
import "bootstrap/dist/js/bootstrap.bundle.js";
import "bootstrap/dist/css/bootstrap.min.css";
import { HomePage } from "./Pages/Home";
import { Navbar } from "./stories/Navbar";
import { CompanyProfile } from "./Pages/CompanyProfile";
import { UserProfile } from "./Pages/UserProfile";
import { Footer } from "./stories/Footer";
import { JobDetails } from "./stories/JobDetails";
import { JobsListings } from "./stories/JobsListings";
import { Signup } from "./Pages/UserSignup";
import { SignIn } from "./Pages/SignIn";
import { CompanySignUp } from "./Pages/CompanySignUp";
import { ToastProvider } from "react-toast-notifications";
import { getUser } from "./utils";

const Router = () => {
  const user = getUser();

  return (
    <Routes>
      <Route path="/" element={<HomePage />}></Route>
      <Route path="/sign-in" element={<SignIn />}></Route>
      <Route path="/sign-up" element={<Signup />}></Route>
      <Route path="/company-sign-up" element={<CompanySignUp />}></Route>
      <Route path="/company-profile" element={<CompanyProfile />} />
      <Route path="/profile" element={<UserProfile />} />
      <Route path="/job-details" element={<JobDetails />} />
      <Route path="/jobs-listing" element={<JobsListings />} />
      <Route
        path="*"
        element={
          <div
            style={{ height: "400px" }}
            className="d-flex justify-content-center align-items-center"
          >
            <h1 style={{ fontSize: "80px" }}>404 Not found!</h1>
          </div>
        }
      />
    </Routes>
  );
};

function App() {
  return (
    <div style={{ width: "100%" }}>
      <BrowserRouter>
        <div>
          <Navbar />
        </div>
        <ToastProvider>
          <div>
            <Router />
          </div>
        </ToastProvider>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
