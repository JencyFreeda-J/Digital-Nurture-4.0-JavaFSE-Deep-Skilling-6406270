import React from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function ContentList({ selected }) {
  const books = [
    { id: 1, title: "React in Depth", author: "Sam Smith" },
    { id: 2, title: "JS Mastery", author: "Lily Joe" },
  ];

  const blogs = [
    { id: 1, title: "JSX Explained", writer: "Alex" },
    { id: 2, title: "React LifeCycle", writer: "Nina" },
  ];

  const courses = [
    { id: 1, course: "React Bootcamp", instructor: "Elon" },
    { id: 2, course: "Advanced Hooks", instructor: "Ada" },
  ];

  if (selected === "books") {
    return (
      <ul>
        {books.map((b) => (
          <BookDetails key={b.id} {...b} />
        ))}
      </ul>
    );
  }

  if (selected === "blogs") {
    return (
      <ul>
        {blogs.map((b) => (
          <BlogDetails key={b.id} {...b} />
        ))}
      </ul>
    );
  }

  if (selected === "courses") {
    return (
      <ul>
        {courses.map((c) => (
          <CourseDetails key={c.id} {...c} />
        ))}
      </ul>
    );
  }

  return <p>Please select a category.</p>;
}

export default ContentList;
