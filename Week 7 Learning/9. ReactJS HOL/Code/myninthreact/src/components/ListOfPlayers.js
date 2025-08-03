import React from "react";

const ListOfPlayers = () => {
  const players = [
    { name: "Virat", score: 95 },
    { name: "Rohit", score: 88 },
    { name: "Rahul", score: 65 },
    { name: "Gill", score: 78 },
    { name: "Pant", score: 45 },
    { name: "Hardik", score: 70 },
    { name: "Jadeja", score: 84 },
    { name: "Shami", score: 55 },
    { name: "Bumrah", score: 91 },
    { name: "Kuldeep", score: 60 },
    { name: "Surya", score: 89 },
  ];

  const filteredPlayers = players.filter((player) => player.score < 70);

  return (
    <div style={{ padding: "20px" }}>
      <h2>All Players</h2>
      <ul>
        {players.map((player, idx) => (
          <li key={idx}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>

      <h2>Players with score below 70</h2>
      <ul>
        {filteredPlayers.map((player, idx) => (
          <li key={idx}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListOfPlayers;
