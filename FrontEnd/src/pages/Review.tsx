import { useEffect, useState } from "react";
import "./css/Review.css";
import API from "../api/api";
import GoBack from "../components/goBack";

interface ReviewItem {
    department: string;
    professorName: string;
    lectureTitle: string;
    score: number;
    evaluationComment: string;
    evaluationTimestamp: string;
}

export default function Review() {
    const [data, setData] = useState<ReviewItem[]>([]);
    const [loading, setLoading] = useState(true);
    const [searchQuery, setSearchQuery] = useState("");

    useEffect(() => {
        async function fetchData() {
            try {
                const response = await API("/api/evaluation/all/professor/review", "GET", null);
                setData(response.data);
            } catch (error) {
                console.error("데이터를 불러오는 중 오류 발생:", error);
            } finally {
                setLoading(false);
            }
        }
        fetchData();
    }, []);

    const formatTimestamp = (timestamp: string) => {
        const date = new Date(timestamp);
        const options: Intl.DateTimeFormatOptions = {
            year: 'numeric',
            month: 'long',
            day: 'numeric',
            hour: 'numeric',
            minute: 'numeric',
            second: 'numeric',
            hour12: true,
        };
        return date.toLocaleString('ko-KR', options); 
    };

    const filteredData = data.filter((review) => {
        const lowerQuery = searchQuery.toLowerCase();
        return (
            review.professorName.toLowerCase().includes(lowerQuery) ||
            review.lectureTitle.toLowerCase().includes(lowerQuery)
        );
    });

    return (
        <div className="review-container">
            <GoBack />
            <h1 className="review-header">최신 강의 평가</h1>

            <input
                type="text"
                placeholder="교수명 또는 강의명을 입력하세요..."
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
                className="search-input"
            />

            {loading ? (
                <p className="loading-text">불러오는 중...</p>
            ) : filteredData.length === 0 ? (
                <p className="no-review-text">검색 결과가 없습니다.</p>
            ) : (
                filteredData.map((review, index) => (
                    <div key={index} className="review-card">
                        <h3 className="review-title">
                            {review.lectureTitle}
                            <span className="review-time">{formatTimestamp(review.evaluationTimestamp)}</span>
                        </h3>
                        <p className="review-text">학과: {review.department}</p>
                        <p className="review-text">교수: {review.professorName}</p>
                        <p className="review-text">평점: {review.score}</p>
                        <p className="review-comment">평가: {review.evaluationComment}</p>
                    </div>
                ))
            )}
        </div>
    );
}
