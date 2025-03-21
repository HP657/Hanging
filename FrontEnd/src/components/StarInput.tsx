import React, { ChangeEvent, useState } from "react";

const StarInput: React.FC = () => {
  const [starCount, setStarCount] = useState<number>(0); 
  const starColor = (starCount / 5) * 100 + "%"; 
    const [scope, setScope] = useState<string>("");

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    setStarCount(Number(e.target.value));
    setScope(e.target.value)
  };

  return (
    <div>
      <span className="star" style={{ position: "relative", fontSize: "2rem", color: "#ddd", borderRadius: "5px" }}>
        ★★★★★
        <span style={{
          position: "absolute",
          left: 0,
          color: "#FFDB00",
          width: starColor,
          overflow: "hidden",
          pointerEvents: "none",
          borderRadius: "5px", 
        }}>★★★★★</span>
        <input
          type="range"
          onChange={handleChange}
          step="0.1"
          min="0"
          max="5"
          value={starCount} 
          style={{
            width: "100%",
            height: "100%",
            position: "absolute",
            left: 0,
            opacity: 0,
            cursor: "pointer",
            borderRadius: "5px",
          }}
        />
      </span>
      <br />
      {scope}
    </div>
  );
};

export default StarInput;
