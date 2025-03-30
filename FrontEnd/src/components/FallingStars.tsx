import { useEffect, useState } from "react";
import { motion } from "framer-motion";
import { nanoid } from "nanoid";
import "./css/FallingStars.css"

interface StarType {
  id: string;
  left: string;
  top: string;
  delay: number;
  duration: number;
  size: string;
}

const generateStars = (count: number): StarType[] => {
  return new Array(count).fill(0).map(() => ({
    id: nanoid(),
    left: Math.random() * 100 + "vw",
    top: -Math.random() * 50 + "vh",
    delay: Math.random() * 1,
    duration: 0.2,
    size: Math.random() * 20 + "px",
  }));
};

export default function FallingStars() {
  const [stars, setStars] = useState<StarType[]>([]);

  useEffect(() => {
    setStars(generateStars(100));
  }, []);

  return (
    <div className="falling-stars-container" style={{ position: "relative", width: "100vw", height: "100vh" }}>
      {stars.map((star) => (
        <motion.div
          key={star.id}
          initial={{ opacity: 1, x: star.left, y: star.top }}
          animate={{
            opacity: 1,
            x: `${parseFloat(star.left) - 60}vw`,
            y: "100vh",
          }}
          transition={{
            duration: star.duration,
            delay: star.delay,
            ease: "linear",
          }}
          className="falling-star"
          style={{
            left: star.left,
            width: star.size,
            height: star.size,
            position: "absolute",
            backgroundColor: "white",
            transform: "rotate(45deg)",
            clipPath: "polygon(50% 0%, 61% 35%, 98% 35%, 68% 57%, 79% 91%, 50% 70%, 21% 91%, 32% 57%, 2% 35%, 39% 35%)",
          }}
        />
      ))}
    </div>
  );
}
