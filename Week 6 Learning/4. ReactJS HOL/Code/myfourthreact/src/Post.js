import React from "react";

class Post extends React.Component {
  render() {
    const { title, body } = this.props;
    return (
      <div
        style={{
          marginBottom: "20px",
          padding: "10px",
          borderBottom: "1px solid #ccc",
        }}
      >
        <h3>{title}</h3>
        <p>{body}</p>
      </div>
    );
  }
}

export default Post;
