import React, { Component } from "react";

class Counter extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
    };
    this.handleWelcome = this.handleWelcome.bind(this);
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 }, () => {
      this.sayHello();
    });
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  sayHello = () => {
    console.log("Hello! Count updated.");
  };

  handleWelcome(message) {
    alert(`Say ${message}`);
  }

  handleClick = (event) => {
    alert("I was clicked");
    console.log("Synthetic Event:", event);
  };

  render() {
    return (
      <div style={{ marginBottom: "40px" }}>
        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.increment}>Increment</button>{" "}
        <button onClick={this.decrement}>Decrement</button>{" "}
        <button onClick={() => this.handleWelcome("Welcome")}>
          Say Welcome
        </button>{" "}
        <button onClick={this.handleClick}>OnPress</button>
      </div>
    );
  }
}

export default Counter;
