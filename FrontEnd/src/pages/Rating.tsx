import React, { useEffect, useState } from "react";
import StarInput from "../components/StarInput";
import "./css/Rating.css";
import API from "../api/api";
import { useNavigate } from "react-router-dom";

export default function Rating() {
  const [selectedDepartment, setSelectedDepartment] = useState<string>("");
  const [selectedProfessor, setSelectedProfessor] = useState<string>("");
  const [selectedLecture, setSelectedLecture] = useState<string>("");
  const [rating, setRating] = useState<number>(0);
  const [evaluationContent, setEvaluationContent] = useState<string>("");

  const [departments, setDepartments] = useState<string[]>([]);
  const [professorList, setProfessorList] = useState<string[]>([]);
  const [lectureList, setLectureList] = useState<string[]>([]);
  
  const [customProfessor, setCustomProfessor] = useState<string>("");
  const [customLecture, setCustomLecture] = useState<string>("");
  
  const navigate = useNavigate();

  useEffect(() => {
    async function fetchDepartments() {
      try {
        const response = await API("/api/department", "GET", null);
        console.log(response.data);
        setDepartments(response.data.map((dept: { name: string }) => dept.name));
      } catch (error) {
        console.error("Failed to fetch departments", error);
      }
    }
    fetchDepartments();
  }, []);

  const handleDepartmentChange = async (e: React.ChangeEvent<HTMLSelectElement>) => {
    const department = e.target.value;
    setSelectedDepartment(department);
    setSelectedProfessor("");
    setSelectedLecture("");
    setCustomProfessor("");
    setCustomLecture("");

    if (department) {
      try {
        const response = await API(`/api/professor/by/department?departmentName=${department}`, "GET", null);
        console.log(response.data);
        setProfessorList(response.data.filter((prof: { professorName: any }) => prof.professorName !== null).map((prof: { professorName: string }) => prof.professorName));
      } catch (error) {
        console.error("Failed to fetch professors", error);
        setProfessorList([]);
      }
    } else {
      setProfessorList([]);
    }
  };

  const handleProfessorChange = async (e: React.ChangeEvent<HTMLSelectElement>) => {
    const professor = e.target.value;
    setSelectedProfessor(professor);
    setSelectedLecture("");
    setCustomLecture("");

    if (professor) {
      try {
        const response = await API(`/api/lecture?departmentName=${selectedDepartment}&professorName=${professor}`, "GET", null);
        console.log(response.data);
        setLectureList(response.data);
      } catch (error) {
        console.error("Failed to fetch lectures", error);
        setLectureList([]);
      }
    } else {
      setLectureList([]);
    }
  };

  const handleSubmit = async () => {
    const professorToSend = selectedProfessor === "직접 입력" ? customProfessor : selectedProfessor;
    const lectureToSend = selectedLecture === "직접 입력" ? customLecture : selectedLecture;

    const data = {
      departmentName: selectedDepartment,
      professorName: professorToSend,
      lectureTitle: lectureToSend,
      rating,
      evaluationContent,
    };

    try {
      await API("/api/evaluation", "POST", data);
      navigate("/main");
    } catch (error) {
      console.error("API 요청 오류: ", error);
    }
  };

  return (
    <div className="rating-evaluation-container">
      <h3 className="rating-evaluation-title">강의 평가하기</h3>

      <div>
        <label className="rating-form-label">과 선택:</label>
        <select className="rating-select-box" value={selectedDepartment} onChange={handleDepartmentChange}>
          <option value="">--과 선택--</option>
          {departments.map((department) => (
            <option key={department} value={department}>{department}</option>
          ))}
        </select>
      </div>

      {selectedDepartment && (
        <div>
          <label className="rating-form-label">교수 선택:</label>
          <select className="rating-select-box" value={selectedProfessor} onChange={handleProfessorChange}>
            <option value="">--교수 선택--</option>
            {professorList.map((professor) => (
              <option key={professor} value={professor}>{professor}</option>
            ))}
            <option value="직접 입력">직접 입력</option>
          </select>
          {selectedProfessor === "직접 입력" && <input type="text" className="rating-input-field" value={customProfessor} onChange={(e) => setCustomProfessor(e.target.value)} placeholder="교수 이름을 입력하세요" />}
        </div>
      )}

      {selectedProfessor && (
        <div>
          <label className="rating-form-label">수업 선택:</label>
          <select className="rating-select-box" value={selectedLecture} onChange={(e) => setSelectedLecture(e.target.value)}>
            <option value="">--수업 선택--</option>
            {lectureList.map((lecture) => (
              <option key={lecture} value={lecture}>{lecture}</option>
            ))}
            <option value="직접 입력">직접 입력</option>
          </select>
          {selectedLecture === "직접 입력" && <input type="text" className="rating-input-field" value={customLecture} onChange={(e) => setCustomLecture(e.target.value)} placeholder="수업 이름을 입력하세요" />}
        </div>
      )}

      <div>
        <label className="rating-form-label">평점 (0~5):</label>
        <StarInput onRatingChange={setRating} />
        <span className="rating-display">{rating}</span>
      </div>

      <div>
        <label className="rating-form-label">평가문:</label>
        <input type="text" className="rating-comment-input" value={evaluationContent} onChange={(e) => setEvaluationContent(e.target.value)} placeholder="교수님에 대한 의견을 남겨주세요" />
      </div>

      <div>
        <button className="rating-submit-button" onClick={handleSubmit}>제출</button>
      </div>
    </div>
  );
}
