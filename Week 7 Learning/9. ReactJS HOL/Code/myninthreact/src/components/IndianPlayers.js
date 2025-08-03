import React from "react";

const IndianPlayers = () => {
  const oddTeam = ["Virat", "Rahul", "Pant", "Jadeja", "Shami"];
  const evenTeam = ["Rohit", "Gill", "Hardik", "Bumrah", "Kuldeep"];

  const [virat, rahul, pant, jadeja, shami] = oddTeam;
  const [rohit, gill, hardik, bumrah, kuldeep] = evenTeam;

  const t20Players = ["Virat", "Rohit", "Gill", "Pant", "Hardik"];
  const ranjiPlayers = ["Shreyas", "Pujara", "Saha", "Siraj"];

  const mergedPlayers = [...t20Players, ...ranjiPlayers];

  return (
    <div style={{ padding: "20px" }}>
      <h2>Odd Team Players</h2>
      <ul>
        <li>{virat}</li>
        <li>{rahul}</li>
        <li>{pant}</li>
        <li>{jadeja}</li>
        <li>{shami}</li>
      </ul>

      <h2>Even Team Players</h2>
      <ul>
        <li>{rohit}</li>
        <li>{gill}</li>
        <li>{hardik}</li>
        <li>{bumrah}</li>
        <li>{kuldeep}</li>
      </ul>

      <h2>Merged Players (T20 + Ranji)</h2>
      <ul>
        {mergedPlayers.map((player, idx) => (
          <li key={idx}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
