import React from "react";
import "./css/EasterEgg.css";

const EasterEggPage = () => {
  const teamName = "팀 이스터에그";
  const members = [
    { name: "이승현", role: "팀장" },
    { name: "박건희", role: "프론트엔드" },
    { name: "이효준", role: "백엔드" },
    { name: "김진성", role: "디자이너" },
    { name: "김태윤", role: "기획자" },
    { name: "박도진", role: "데브옵스" },
    { name: "박지영", role: "QA" }
  ];

  return (
    <div className="easter-egg-container">
      <h1 className="easter-egg-title">🎉 You found the Easter Egg! 🎉</h1>
      <h2 className="easter-egg-teamname">{teamName}</h2>
      <ul className="easter-egg-members">
        {members.map((member, index) => (
          <li key={index} className="easter-egg-member">{member.name} - {member.role}</li>
        ))}
      </ul>
    </div>
  );
};

export default EasterEggPage;