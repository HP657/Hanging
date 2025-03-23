// src/components/Main.tsx

import { useNavigate } from 'react-router-dom'; // react-router-dom을 사용하여 리다이렉션
import "./css/Main.css"; // 검은색 테마 스타일 파일 임포트

const Main = () => {
  const navigate = useNavigate(); // 리다이렉션을 위한 hook

  const goToRanking = () => {
    navigate('/rank'); // /ranking 경로로 리다이렉션
  };

  const goToReview = () => {
    navigate('/rating'); // /review 경로로 리다이렉션
  };

  return (
    <div className="main-container">
      <img src="/imgs/logo.png" className="main_logo_imgs"alt="인트로 이미지" />
      <button onClick={goToReview}>강의 평가하기</button>
      <br />
      <button onClick={goToRanking}>랭킹 보기</button>
    </div>
  );
};

export default Main;
