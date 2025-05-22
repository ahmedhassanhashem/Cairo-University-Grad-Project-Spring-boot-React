import { map } from "ramda";
import React, { useEffect, useState } from "react";
import { RowJobItem } from "./RowJobItem";
import { FoundJobsHeader } from "./FoundJobsHeader";
import { getUser } from "../utils";
import { useToasts } from "react-toast-notifications";
import axios from "axios";

export const ManageJobs = ({ activeTab }) => {
  const jobs = [{}, {}, {}, {}];
  const user = getUser();
  const [companyJobsInfo, setCompanyJobsInfo] = useState([]);

  const [loadingInfo, setLoadingInfo] = useState(false);

  const token = localStorage.getItem("token");
  const axiosInstance = axios.create({
    baseURL:
      "https://interna-platform.uc.r.appspot.com/api/gateway/job/company",
    headers: { Authorization: `Bearer ${token}` },
  });

  const getCompanyJobs = () => {
    setLoadingInfo(true);
    axiosInstance({
      method: "GET",
      url: `/${user.jti}`,
    })
      .then(({ data }) => {
        setLoadingInfo(false);
        setCompanyJobsInfo(data.data);
      })
      .catch(() => {
        setLoadingInfo(false);
        setCompanyJobsInfo([]);
      });
  };

  return (
    <div className="mb-5">
      <FoundJobsHeader count={companyJobsInfo.length} />
      {companyJobsInfo.length === 0 && !loadingInfo ? (
        <div
          style={{ height: "400px" }}
          className="w-100 d-flex justify-content-center align-items-center"
        >
          <button onClick={getCompanyJobs} className="btn btn-primary">
            Load All Posted jobs
          </button>
        </div>
      ) : (
        <>
          {loadingInfo ? (
            <div className="text-center">
              <div class="spinner-grow text-primary" role="status">
                <span class="sr-only">Loading...</span>
              </div>
            </div>
          ) : (
            <>
              {map((job) => {
                return (
                  <div key={job.id} className="mb-3">
                    <RowJobItem job={job} isCompany />
                  </div>
                );
              }, companyJobsInfo)}
            </>
          )}
        </>
      )}
    </div>
  );
};
