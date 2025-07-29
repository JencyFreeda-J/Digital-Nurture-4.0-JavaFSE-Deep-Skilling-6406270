import React from "react";
import CohortDetails from "./Components/CohortDetails";

function App() {
  const cohorts = [
    {
      name: "React Bootcamp",
      status: "Ongoing",
      startDate: "2025-06-01",
      endDate: "2025-08-01",
    },
    {
      name: "Java Sprint",
      status: "Completed",
      startDate: "2025-03-01",
      endDate: "2025-05-01",
    },
  ];

  return (
    <div style={{ padding: "20px" }}>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
