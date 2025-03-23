import { useEffect, useState } from "react";
import FallingStars from "../components/FallingStars";
import { useNavigate } from "react-router-dom";
import "./css/Intro.css"

export default function Intro() {
  
  useEffect(() => {
    fetch("https://api64.ipify.org?format=json")
      .then((res) => res.json())
      .then((data) => console.log("클라이언트 IP 주소:", data.ip))
      .catch((err) => console.error("IP 가져오기 실패:", err));
  }, []);
  
  const [showStars, setShowStars] = useState(true); 
  const [showButton, setShowButton] = useState(false); 
  const navigate = useNavigate();
  useEffect(() => {
    setTimeout(() => setShowStars(false), 2000); 
    setTimeout(() => setShowButton(true), 2000); 
  }, []);

  return (
    <div className="intro-container">
      {showStars && <FallingStars />}
      {showButton && (
        <>
        <img src="/imgs/logo.png" className="logo_imgs" alt="인트로 이미지"/>
        <button className="intro-enter-button" onClick={() => navigate("/main")}>
          들어가기
        </button>
        </>
      )}
    </div>
  );
}
