import React, { useState } from "react";
import ContentList from "./ContentList";

function MainPage() {
  const [selected, setSelected] = useState("books");
  const [showExtra] = useState(true);

  return (
    <div>
      <h2>Conditional Rendering Example</h2>

      {/* Selection buttons */}
      <div>
        <button onClick={() => setSelected("books")}>Books</button>
        <button onClick={() => setSelected("blogs")}>Blogs</button>
        <button onClick={() => setSelected("courses")}>Courses</button>
      </div>

      <hr />

      {/* Conditional rendering via component with props */}
      <ContentList selected={selected} />

      {/* Ternary rendering */}
      <p>
        {selected === "books" ? "You are viewing books." : "Not viewing books."}
      </p>

      {/* Logical && rendering */}
      {showExtra && <p>This is extra content shown using logical &&.</p>}

      {/* Element variable rendering */}
      {(() => {
        if (selected === "blogs") return <p>Viewing blog list.</p>;
        if (selected === "courses") return <p>Viewing course list.</p>;
        return null;
      })()}
    </div>
  );
}

export default MainPage;
