import { useNavigate } from 'react-router-dom'; // react-router-dom을 사용하여 리다이렉션
import "./css/Main.css"; // 검은색 테마 스타일 파일 임포트
import { useEffect } from 'react';
import API from '../api/api';

const Main = () => {
  const navigate = useNavigate(); // 리다이렉션을 위한 hook

  useEffect(() => {
    const fetchData = async () => {
      try {
        const data = await API('', 'GET', null);
        console.log(data); 
      } catch (error) {
        console.error('API 요청 오류:', error);
      }
    };

    fetchData(); // 비동기 함수 호출
  }, []);
  const goToRanking = () => {
    navigate('/rank'); 
  };

  const goToRating = () => {
    navigate('/rating'); 
  };

  const goToReview = () => {
    navigate('/review'); 
  }
  

  return (
    <div className="main-container">
      <img src="/imgs/logo.png" className="main_logo_imgs"alt="인트로 이미지" />
      <button className="main-button" onClick={goToRating}>강의 평가하기</button>
      <br />
      <button className="main-button"onClick={goToReview}>평가문 보기</button>
      <br />
      <button className="main-button" onClick={goToRanking}>랭킹 보기</button>
    </div>
  );
};

export default Main;
