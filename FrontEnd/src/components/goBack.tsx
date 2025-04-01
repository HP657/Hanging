import { useNavigate } from "react-router-dom";

export default function GoBack() { 
    const navigate = useNavigate();
    return (
        <img 
            src="/imgs/back.png" 
            alt="goBack" 
            onClick={() => navigate("/main")}
            style={{
                position: "absolute",
                top: "20px", 
                left: "20px", 
                backgroundColor: "white", 
                filter: "invert(100%)", 
                width: "25px",
                cursor: "pointer",
                zIndex: 9999 
            }}
        /> 
    );
}
