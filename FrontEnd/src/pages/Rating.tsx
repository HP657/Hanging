import React, { useState } from "react";
import StarInput from "../components/StarInput";
import "./css/Rating.css";

const departments = ["스마트소프트웨어학과", "전자공학과", "기계공학과"];

const professors: Record<string, string[]> = {
  "스마트소프트웨어학과": ["이효준", "김철수", "박지영"],
  "전자공학과": ["최강희", "이승엽"],
  "기계공학과": ["홍길동", "이동욱"],
};

const lectures: Record<string, string[]> = {
  "이효준": ["DP", "알고리즘"],
  "김철수": ["운영체제", "네트워크"],
  "박지영": ["소프트웨어공학", "디지털통신"],
};

export default function Rating() {
  const [selectedDepartment, setSelectedDepartment] = useState<string>("");
  const [selectedProfessor, setSelectedProfessor] = useState<string>("");
  const [selectedLecture, setSelectedLecture] = useState<string>("");
  const [rating, setRating] = useState<number>(0);
  const [comment, setComment] = useState<string>("");

  // 교수와 수업의 "직접 입력"에 대한 상태 추가
  const [customProfessor, setCustomProfessor] = useState<string>("");
  const [customLecture, setCustomLecture] = useState<string>("");

  const handleDepartmentChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    const department = e.target.value;
    setSelectedDepartment(department);
    setSelectedProfessor("");
    setSelectedLecture("");   
  };

  const handleProfessorChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    const professor = e.target.value;
    setSelectedProfessor(professor);
    setSelectedLecture(""); 
  };

  const handleLectureChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    const lecture = e.target.value;
    setSelectedLecture(lecture);
  };

  const handleRatingChange = (rating: number) => {
    setRating(rating); 
  };

  const handleCommentChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setComment(e.target.value);
  };

  const handleProfessorInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setCustomProfessor(e.target.value); // '직접 입력' 교수명 관리
  };

  const handleLectureInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setCustomLecture(e.target.value); // '직접 입력' 수업명 관리
  };

  const handleSubmit = () => {
    const professorToSend = selectedProfessor === "직접 입력" ? customProfessor : selectedProfessor;
    const lectureToSend = selectedLecture === "직접 입력" ? customLecture : selectedLecture;

    console.log("평가 제출!");
    console.log({
      department: selectedDepartment,
      professor: professorToSend, // 직접 입력된 값 사용
      lecture: lectureToSend, // 직접 입력된 값 사용
      rating,
      comment,
    });
  };

  return (
    <div className="rating-evaluation-container">
      <h3 className="rating-evaluation-title">강의 평가하기</h3>

      {/* 과 선택 */}
      <div>
        <label className="rating-form-label">과 선택:</label>
        <select className="rating-select-box" value={selectedDepartment} onChange={handleDepartmentChange}>
          <option value="">--과 선택--</option>
          {departments.map((department) => (
            <option key={department} value={department}>
              {department}
            </option>
          ))}
        </select>
      </div>

      {/* 교수 선택 */}
      {selectedDepartment && (
        <div>
          <label className="rating-form-label">교수 선택:</label>
          <select
            className="rating-select-box"
            value={selectedProfessor === "직접 입력" ? "" : selectedProfessor} // 직접 입력일 때 빈값 처리
            onChange={handleProfessorChange}
          >
            <option value="">--교수 선택--</option>
            {professors[selectedDepartment]?.map((professor) => (
              <option key={professor} value={professor}>
                {professor}
              </option>
            ))}
            {/* '직접 입력' 옵션 추가 */}
            <option value="직접 입력">직접 입력</option>
          </select>

          {selectedProfessor === "직접 입력" && (
            <input
              type="text"
              className="rating-input-field"
              value={customProfessor} // "직접 입력"일 때 customProfessor 값을 사용
              onChange={handleProfessorInputChange} // '직접 입력' 시 값 변경
              placeholder="교수 이름을 입력하세요"
            />
          )}
        </div>
      )}

      {/* 수업 선택 */}
      {selectedProfessor && (
        <div>
          <label className="rating-form-label">수업 선택:</label>
          <select
            className="rating-select-box"
            value={selectedLecture === "직접 입력" ? "" : selectedLecture} // 직접 입력일 때 빈값 처리
            onChange={handleLectureChange}
          >
            <option value="">--수업 선택--</option>
            {lectures[selectedProfessor]?.map((lecture) => (
              <option key={lecture} value={lecture}>
                {lecture}
              </option>
            ))}
            {/* '직접 입력' 옵션 추가 */}
            <option value="직접 입력">직접 입력</option>
          </select>

          {selectedLecture === "직접 입력" && (
            <input
              type="text"
              className="rating-input-field"
              value={customLecture} // "직접 입력"일 때 customLecture 값을 사용
              onChange={handleLectureInputChange} // '직접 입력' 시 값 변경
              placeholder="수업 이름을 입력하세요"
            />
          )}
        </div>
      )}

      {/* 평점 선택 */}
      <div>
        <label className="rating-form-label">평점 (0~5):</label>
        <StarInput onRatingChange={handleRatingChange} />
        <span className="rating-display">{rating}</span>
      </div>

      {/* 댓글 입력 */}
      <div>
        <label className="rating-form-label">평가문:</label>
        <input
          type="text"
          className="rating-comment-input"
          value={comment}
          onChange={handleCommentChange}
          placeholder="교수님에 대한 의견을 남겨주세요"
        />
      </div>

      {/* 제출 버튼 */}
      <div>
        <button
          className="rating-submit-button"
          onClick={handleSubmit} // 제출 버튼 클릭 시 데이터 전송
        >
          제출
        </button>
      </div>
    </div>
  );
}
