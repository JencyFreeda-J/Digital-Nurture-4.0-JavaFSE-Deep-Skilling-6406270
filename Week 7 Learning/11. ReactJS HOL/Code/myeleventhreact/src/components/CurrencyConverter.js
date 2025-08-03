import React, { useState } from "react";

function CurrencyConverter() {
  const [rupees, setRupees] = useState("");
  const [euros, setEuros] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const conversionRate = 0.011; // 1 INR ≈ 0.011 EUR
    const result = parseFloat(rupees) * conversionRate;
    setEuros(result.toFixed(2));
  };

  return (
    <div>
      <h2>Currency Converter (INR to EUR)</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          value={rupees}
          onChange={(e) => setRupees(e.target.value)}
          placeholder="Enter amount in INR"
          required
        />
        <button type="submit">Convert</button>
      </form>
      {euros && <p>€ {euros} Euros</p>}
    </div>
  );
}

export default CurrencyConverter;
