import React, { Component } from "react";
import Post from "./Post";

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      hasError: false,
    };
  }

  componentDidMount() {
    this.loadPosts();
  }

  loadPosts = () => {
    fetch("https://jsonplaceholder.typicode.com/posts")
      .then((response) => response.json())
      .then((data) => this.setState({ posts: data }))
      .catch((error) => {
        console.error("Fetch error:", error);
        this.setState({ hasError: true });
      });
  };

  componentDidCatch(error, info) {
    alert("An error occurred while displaying posts.");
    console.error("Error caught in componentDidCatch:", error, info);
  }

  render() {
    const { posts, hasError } = this.state;
    if (hasError) {
      return (
        <h2 style={{ color: "red" }}>
          Something went wrong while loading posts.
        </h2>
      );
    }

    return (
      <div style={{ padding: "20px" }}>
        <h1>Blog Posts</h1>
        {posts.map((post) => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}

export default Posts;
