import React from "react";

const OfficeSpace = () => {
  const heading = <h1>Office Space Rental Listing</h1>;

  const imageURL = process.env.PUBLIC_URL + "/Office-Space.png";

  <img
    src={imageURL}
    alt="Office Space"
    style={{ width: "100%", maxWidth: "400px", marginBottom: "20px" }}
  />;

  const offices = [
    {
      name: "Indiranagar Office",
      rent: 55000,
      address: "12th Main Rd, Bangalore",
    },
    {
      name: "Whitefield Workspace",
      rent: 68000,
      address: "ITPL Road, Bangalore",
    },
    {
      name: "HSR Layout Hub",
      rent: 62000,
      address: "Sector 2, Bangalore",
    },
    {
      name: "Koramangala Spot",
      rent: 48000,
      address: "5th Block, Bangalore",
    },
  ];

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      {heading}
      <img
        src={imageURL}
        alt="Office Space"
        style={{ width: "100%", maxWidth: "400px", marginBottom: "20px" }}
      />
      <h2>Available Spaces</h2>
      {offices.map((office, index) => (
        <div
          key={index}
          style={{
            marginBottom: "15px",
            borderBottom: "1px solid #ccc",
            paddingBottom: "10px",
          }}
        >
          <h3>{office.name}</h3>
          <p>
            <strong>Rent:</strong>{" "}
            <span style={{ color: office.rent > 60000 ? "green" : "red" }}>
              ₹{office.rent.toLocaleString()}
            </span>
          </p>
          <p>
            <strong>Address:</strong> {office.address}
          </p>
        </div>
      ))}
    </div>
  );
};

export default OfficeSpace;
