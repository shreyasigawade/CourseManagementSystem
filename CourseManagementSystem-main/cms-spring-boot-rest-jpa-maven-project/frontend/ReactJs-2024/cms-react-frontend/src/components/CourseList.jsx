import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import { deleteCourse, fetchAllCourses } from "../services/CourseService";

function CourseList() {
    const navigate = useNavigate();
    const [allCourses, setAllCourses] = useState([]);

    // Load all courses from backend
    useEffect(() => {
        loadCourses();
    }, []);

    const loadCourses = () => {
        fetchAllCourses()
            .then(data => {
                console.log("Fetched courses:", data);
                setAllCourses(Array.isArray(data) ? data : data.courses);
            })
            .catch(error => console.log("Error fetching courses:", error));
    };


const removeCourse = (courseId) => {
    deleteCourse(courseId)
        .then(() => loadCourses())  // refresh the list after successful delete
        .catch(error => alert("Failed to delete: " + error.message)); // show error to user
};

    // Navigation handlers
    const viewCourse = (courseId) => navigate('/course-view/' + courseId);
    const editCourse = (courseId) => navigate('/course-edit/' + courseId);
    const handleAddCourse = () => navigate('/course-add');

    // Render courses
    const allCoursesDisplay = allCourses.map((eachCourse, index) =>
        <tr key={index}>
            <td>{eachCourse.courseId}</td>
            <td>{eachCourse.courseName}</td>
            <td>{eachCourse.location}</td>
            <td>Rs. {eachCourse.courseFee}</td>
            <td>{eachCourse.instructor ? eachCourse.instructor.instructorName : "N/A"}</td>
            <td>{eachCourse.durationInWeeks}</td>
            <td>{eachCourse.level || "N/A"}</td>
            <td>
                <button
                    type="button"
                    className="btn btn-warning"
                    onClick={() => viewCourse(eachCourse.courseId)}
                >
                    View
                </button>
            </td>
            <td>
                <button
                    type="button"
                    className="btn btn-primary"
                    onClick={() => editCourse(eachCourse.courseId)}
                >
                    Edit
                </button>
            </td>
            <td>
                <button
                    type="button"
                    className="btn btn-danger"
                    onClick={() => removeCourse(eachCourse.courseId)}
                >
                    Remove
                </button>
            </td>
        </tr>
    );

    return (
        <div className="container m-5">
            <h1>LIST OF COURSES</h1>
            <button
                type="button"
                className="btn btn-success mb-3"
                onClick={handleAddCourse}
            >
                ADD NEW COURSE
            </button>

            <table className="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>COURSE NAME</th>
                        <th>LOCATION</th>
                        <th>FEE</th>
                        <th>INSTRUCTOR</th>
                        <th>DURATION</th>
                        <th>LEVEL</th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {allCoursesDisplay.length > 0 ? allCoursesDisplay : (
                        <tr>
                            <td colSpan="10" className="text-center">No courses found</td>
                        </tr>
                    )}
                </tbody>
            </table>
        </div>
    );
}

export default CourseList;
