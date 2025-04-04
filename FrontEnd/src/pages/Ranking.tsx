import { useEffect, useState } from "react";
import "./css/Ranking.css";
import API from "../api/api";
import GoBack from "../components/goBack";

interface RankItem {
  id: number;
  department: string;
  professorName: string;
  averageScore: number;
}

// 학과 리스트 (정적 데이터)
const departments = [
  { id: 1, name: "전기전자공학과" },
  { id: 2, name: "스마트전기전자공학과" },
  { id: 3, name: "기계공학과" },
  { id: 4, name: "스마트기계공학과" },
  { id: 5, name: "스마트소프트웨어학과" },
];

export default function Ranking() {
  const [isDepartment, setIsDepartment] = useState(true); 
  const [overallRanking, setOverallRanking] = useState<RankItem[]>([]);
  const [departmentRankings, setDepartmentRankings] = useState<{ [key: string]: RankItem[] }>({});

  useEffect(() => {
    async function fetchRankingData() {
      try {
        const response = await API("/api/evaluation/all/professor/ranking", "GET", null);
        if (response?.data) {
          // 점수순 정렬 후 ID 부여
          const sortedData: RankItem[] = response.data
            .sort((a: RankItem, b: RankItem) => b.averageScore - a.averageScore)
            .map((item: RankItem, index: number) => ({
              ...item,
              id: index + 1, // 1위부터 ID 부여
            }));
          setOverallRanking(sortedData);

          // 학과별로 데이터 분류
          const departmentMap: { [key: string]: RankItem[] } = {};
          departments.forEach((dept) => (departmentMap[dept.name] = []));

          sortedData.forEach((item: RankItem) => {
            if (departmentMap[item.department]) {
              departmentMap[item.department].push(item);
            }
          });

          setDepartmentRankings(departmentMap);
        }
      } catch (error) {
        console.error("Error fetching ranking data:", error);
      }
    }

    fetchRankingData();
  }, []);

  return (
    <div className="ranking-container">
      <GoBack />
      <h1 className="ranking-title">🏆 랭킹</h1>
      <div className="ranking-tabs">
        <button className={isDepartment ? "active" : ""} onClick={() => setIsDepartment(true)}>
          학과별 랭킹
        </button>
        <button className={!isDepartment ? "active" : ""} onClick={() => setIsDepartment(false)}>
          전체 랭킹
        </button>
      </div>  

      {/* 전체 랭킹 */}
      {!isDepartment && (
        <ul className="ranking-list">
          {overallRanking.length > 0 ? (
            overallRanking.map((rank) => (
              <li key={rank.id} className="ranking-item">
                <span className="ranking-rank">{rank.id}위</span>
                <span className="ranking-name">{rank.professorName}</span>
                <span className="ranking-score">{rank.averageScore.toFixed(1)}점</span>
              </li>
            ))
          ) : (
            <p className="no-data">데이터가 없습니다.</p>
          )}
        </ul>
      )}

      {/* 학과별 랭킹 */}
      {isDepartment &&
        departments.map((dept) => {
          const rankingData = departmentRankings[dept.name] || [];
          return (
            <div key={dept.id} className="department-section">
              <h2 className="department-title">{dept.name}</h2>
              <ul className="ranking-list">
                {rankingData.length > 0 ? (
                  rankingData.slice(0, 5).map((rank) => (
                    <li key={rank.id} className="ranking-item">
                      <span className="ranking-rank">{rank.id}위</span>
                      <span className="ranking-name">{rank.professorName}</span>
                      <span className="ranking-score">{rank.averageScore.toFixed(1)}점</span>
                    </li>
                  ))
                ) : (
                  <p className="no-data">데이터가 없습니다.</p>
                )}
              </ul>
            </div>
          );
        })}
    </div>
  );
}
