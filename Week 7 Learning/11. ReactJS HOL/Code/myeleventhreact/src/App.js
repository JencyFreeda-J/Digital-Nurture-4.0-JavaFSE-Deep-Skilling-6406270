import React from "react";
import Counter from "./components/Counter";
import CurrencyConverter from "./components/CurrencyConverter";

function App() {
  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h1>React Event Handling Examples</h1>
      <Counter />
      <CurrencyConverter />
    </div>
  );
}

export default App;
