import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Intro from "./pages/Intro";
import Rating from "./pages/Rating";
import Ranking from "./pages/Ranking";
import Main from "./pages/Main";

export default function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Intro />} />
        <Route path="/main" element={<Main />} />
        <Route path="/rating" element={<Rating />} />
        <Route path="/rank" element={<Ranking />} />
      </Routes>
    </Router>
  );
}
