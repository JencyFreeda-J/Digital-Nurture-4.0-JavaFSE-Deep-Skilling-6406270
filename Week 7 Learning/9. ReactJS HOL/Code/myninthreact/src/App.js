import React from "react";
import ListOfPlayers from "./components/ListOfPlayers";
import IndianPlayers from "./components/IndianPlayers";

function App() {
  const flag = false;

  return (
    <div className="App">{flag ? <ListOfPlayers /> : <IndianPlayers />}</div>
  );
}

export default App;
