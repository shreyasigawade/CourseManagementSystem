import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import './index.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import CourseList from './components/CourseList.jsx';
import CourseAdd from './components/CourseAdd.jsx';
import CourseView from './components/CourseView.jsx';
import CourseEdit from './components/CourseEdit.jsx';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <Router>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/course-list" element={<CourseList />} />
        <Route path="/course-view/:courseId" element={<CourseView />} />
        <Route path="/course-add" element={<CourseAdd />} />
        <Route path="/course-edit/:courseId" element={<CourseEdit />} />
      </Routes>
    </Router>
  </React.StrictMode>
);

