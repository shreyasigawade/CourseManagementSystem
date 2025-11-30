import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import { fetchAllInstructors } from "../services/InstructorService";
import { addCourse } from "../services/CourseService";

function CourseAdd() {
    const navigate = useNavigate();
    const [allInstructors, setAllInstructors] = useState([]);
    const [errors, setErrors] = useState({});
    const [formData, setFormData] = useState({
        courseName: '',
        location: '',
        courseFee: 0,
        durationInWeeks: 0,
        level: '',
        instructorId: '' // Initialize to an empty string
    });

    useEffect(() => {
        fetchAllInstructors()
            .then(response => response.json())
            .then(data => {
                setAllInstructors(data);
            })
            .catch(error => console.error(error));
    }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    console.log('Name:', name);
    console.log('Value:', value);
    setFormData({ ...formData, [name]: value });
    console.log('FormData:', formData);
}


    const handleSubmit = (e) => {
        e.preventDefault();

        let validationErrors = {};
        if (!formData.courseName.trim()) {
            validationErrors.courseName = 'Course Name is required!';
        }
        if (!formData.location.trim()) {
            validationErrors.location = 'Location is required!';
        }
        if (formData.courseFee <= 0) {
            validationErrors.courseFee = 'Course Fee should be greater than 0!';
        }
        if (formData.durationInWeeks <= 0) {
            validationErrors.durationInWeeks = 'Duration should be greater than 0!';
        }
        if (!formData.level.trim()) {
            validationErrors.level = 'Level is required!';
        }
        if (!formData.instructorId ) {
            validationErrors.instructorId = 'Instructor is required!';
        }

        setErrors(validationErrors);

        if (Object.keys(validationErrors).length === 0 && formData.instructorId) {
            addCourse(formData)
                .then(() => navigate('/course-list'))
                .catch(error => console.error(error));
        }
    }

    const instructorsOptions = allInstructors.map(instructor =>
        <option key={instructor.instructorId} value={instructor.instructorId}>{instructor.instructorName}</option>
    );

    return (
        <div className="container">
            <h2>Add New Course</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="courseName" className="form-label">Course Name:</label>
                    <input type="text" className="form-control" id="courseName" name="courseName" value={formData.courseName} onChange={handleChange} />
                    {errors.courseName && <div className="text-danger">{errors.courseName}</div>}
                </div>
                <div className="mb-3">
                    <label htmlFor="location" className="form-label">Location:</label>
                    <input type="text" className="form-control" id="location" name="location" value={formData.location} onChange={handleChange} />
                    {errors.location && <div className="text-danger">{errors.location}</div>}
                </div>
                <div className="mb-3">
                    <label htmlFor="courseFee" className="form-label">Course Fee:</label>
                    <input type="number" className="form-control" id="courseFee" name="courseFee" value={formData.courseFee} onChange={handleChange} />
                    {errors.courseFee && <div className="text-danger">{errors.courseFee}</div>}
                </div>
                <div className="mb-3">
                    <label htmlFor="durationInWeeks" className="form-label">Duration in Weeks:</label>
                    <input type="number" className="form-control" id="durationInWeeks" name="durationInWeeks" value={formData.durationInWeeks} onChange={handleChange} />
                    {errors.durationInWeeks && <div className="text-danger">{errors.durationInWeeks}</div>}
                </div>
                <div className="mb-3">
                    <label htmlFor="level" className="form-label">Level:</label>
                    <input type="text" className="form-control" id="level" name="level" value={formData.level} onChange={handleChange} />
                    {errors.level && <div className="text-danger">{errors.level}</div>}
                </div>
                <div className="mb-3">
                    <label htmlFor="instructorId" className="form-label">Instructor:</label>
                    <select className="form-control" id="instructorId" name="instructorId" value={formData.instructorId} onChange={handleChange}>
                        <option value="">--Select Instructor--</option>
                        {instructorsOptions}
                    </select>
                    {errors.instructorId && <div className="text-danger">{errors.instructorId}</div>}
                </div>
                <button type="submit" className="btn btn-primary">Add Course</button>
            </form>
        </div>
    );
}

export default CourseAdd;