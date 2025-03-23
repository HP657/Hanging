import { useState } from "react";
import "./css/Ranking.css";

interface RankItem {
  id: number;
  name: string;
  score: number;
}

const departmentRanking: RankItem[] = [
  { id: 1, name: "Alice", score: 1500 },
  { id: 2, name: "Bob", score: 1450 },
  { id: 3, name: "Charlie", score: 1400 },
];

const overallRanking: RankItem[] = [
  { id: 1, name: "Alice", score: 1500 },
  { id: 2, name: "Bob", score: 1450 },
  { id: 3, name: "Charlie", score: 1400 },
  { id: 4, name: "David", score: 1350 },
  { id: 5, name: "Eve", score: 1300 },
];

export default function Ranking() {
  const [isDepartment, setIsDepartment] = useState(true);
  const rankingData = isDepartment ? departmentRanking : overallRanking;

  return (
    <div className="ranking-container">
      <h1 className="ranking-title">🏆 랭킹</h1>
      <div className="ranking-tabs">
        <button
          className={isDepartment ? "active" : ""}
          onClick={() => setIsDepartment(true)}
        >
          학과별 랭킹
        </button>
        <button
          className={!isDepartment ? "active" : ""}
          onClick={() => setIsDepartment(false)}
        >
          전체 랭킹
        </button>
      </div>
      <ul className="ranking-list">
        {rankingData.map((rank) => (
          <li key={rank.id} className="ranking-item">
            <span className="ranking-rank">{rank.id}위</span>
            <span className="ranking-name">{rank.name}</span>
            <span className="ranking-score">{rank.score}점</span>
          </li>
        ))}
      </ul>
    </div>
  );
}
