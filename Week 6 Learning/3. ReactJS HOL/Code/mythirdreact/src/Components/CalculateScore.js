import React from "react";
import "../Stylesheets/mystyle.css";

function CalculateScore({ name, school, total, goal }) {
  const average = total / goal;

  return (
    <div className="score-card">
      <h2>Student Score Report</h2>
      <p>
        <strong>Name:</strong> {name}
      </p>
      <p>
        <strong>School:</strong> {school}
      </p>
      <p>
        <strong>Total Marks:</strong> {total}
      </p>
      <p>
        <strong>Subjects:</strong> {goal}
      </p>
      <p>
        <strong>Average Score:</strong> {average.toFixed(2)}
      </p>
    </div>
  );
}

export default CalculateScore;
