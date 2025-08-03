import React from "react";

const BookDetails = ({ title, author }) => (
  <li>
    <strong>Book:</strong> {title} - {author}
  </li>
);

export default BookDetails;
