import React from "react";
import "./css/EasterEgg.css";

const EasterEggPage = () => {
  const teamName = "팀 이스터에그";
  const members = [
    { name: "이승현", role: "팀장 및 총괄" },
    { name: "박건희", role: "디자인" },
    { name: "이효준", role: "시제품 개발" },
    { name: "김진성", role: "발표 및 PPT" },
    { name: "김태윤", role: "PPT 제작" },
    { name: "박도진", role: "설문조사" },
    { name: "박지영", role: "자료조사" }
  ];

  return (
    <div className="easter-egg-container">
      <h1 className="easter-egg-title">🎉 절 찾으셨군요! 🎉</h1>
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