import React from "react";

const BlogDetails = ({ title, writer }) => (
  <li>
    <strong>Blog:</strong> {title} by {writer}
  </li>
);

export default BlogDetails;
