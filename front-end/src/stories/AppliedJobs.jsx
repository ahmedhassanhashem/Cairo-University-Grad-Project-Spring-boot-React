import { map } from "ramda";
import React from "react";
import { RowJobItem } from "./RowJobItem";
import { FoundJobsHeader } from "./FoundJobsHeader";

export const AppliedJobs = () => {
  const jobs = [{}];
  return (
    <>
      <FoundJobsHeader />
      {map((job) => {
        return (
          <div className="mb-3">
            <RowJobItem job={job} />
          </div>
        );
      }, jobs)}
    </>
  );
};
