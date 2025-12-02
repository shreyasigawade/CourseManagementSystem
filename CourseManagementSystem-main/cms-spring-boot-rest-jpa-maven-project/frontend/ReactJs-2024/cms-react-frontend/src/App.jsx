import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./components/Home";
import CourseList from "./components/CourseList";
import CourseView from "./components/CourseView";
import CourseEdit from "./components/CourseEdit";
import CourseAdd from "./components/CourseAdd";
import Register from "./components/Register";
import Login from "./components/Login";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/course-list" element={<CourseList />} />
        <Route path="/course-view/:courseId" element={<CourseView />} />
        <Route path="/course-edit/:courseId" element={<CourseEdit />} />
        <Route path="/course-add" element={<CourseAdd />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </Router>
  );
}

export default App;
