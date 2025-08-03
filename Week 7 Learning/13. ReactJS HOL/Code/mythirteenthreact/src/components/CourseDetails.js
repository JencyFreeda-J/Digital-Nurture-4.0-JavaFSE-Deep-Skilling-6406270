import React from "react";

const CourseDetails = ({ course, instructor }) => (
  <li>
    <strong>Course:</strong> {course} - {instructor}
  </li>
);

export default CourseDetails;
