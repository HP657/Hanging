import React, { ChangeEvent, useState } from "react";
import "./css/StarInput.css"; 

interface StarInputProps {
  onRatingChange: (rating: number) => void; 
}

export default function StarInput({ onRatingChange }: StarInputProps) {
  const [starCount, setStarCount] = useState<number>(0); 
  const starColor = (starCount / 5) * 100 + "%"; 

  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    const newRating = Number(e.target.value);
    setStarCount(newRating);
    onRatingChange(newRating);
  };

  return (
    <div>
      <span className="star">
        ★★★★★
        <span
          style={{
            width: starColor,
          }}
        >
          ★★★★★
        </span>
        <input
          type="range"
          onChange={handleChange}
          step="0.1"
          min="0"
          max="5"
          value={starCount} 
        />
      </span>
    </div>
  );
};
