import "./css/Review.css";

export default function Review() {
    const data = [
        {
            department: "스마트소프트웨어학과",
            professorName: "12351",
            lectureTitle: "78465",
            score: 3.7,
            evaluationComment: "98465"
        },
        {
            department: "스마트소프트웨어학과",
            professorName: "12351",
            lectureTitle: "78465",
            score: 3.4,
            evaluationComment: "89465"
        }
    ];

    return (
        <div className="review-container">
            <h1 className="review-header">최신 강의 평가</h1>
            {data.map((review, index) => (
                <div key={index} className="review-card">
                    <h3 className="review-title">{review.lectureTitle}</h3>
                    <p className="review-text">학과: {review.department}</p>
                    <p className="review-text">교수: {review.professorName}</p>
                    <p className="review-text">평점: {review.score}</p>
                    <p className="review-comment">평가: {review.evaluationComment}</p>
                </div>
            ))}
        </div>
    );
}

