import { useState, useEffect } from "react";
import { useNavigate, useParams } from 'react-router-dom';
import { fetchAllInstructors } from "../services/InstructorService";
import { fetchACourse, updateCourse } from "../services/CourseService";

function CourseEdit() {
    let navigate = useNavigate();
    let { courseId } = useParams();
    let [allInstructors, setAllInstructors] = useState([]);
    let [errors, setErrors] = useState({});
    let [formCourseData, setFormCourseData] = useState({
        courseId: 0,
        courseName: '',
        location: '',
        courseFee: 0,
        durationInWeeks: 0,
        level: '',
        instructor: null
    });

  useEffect(() => {
      fetchAllInstructors()
          .then((data) => {
              setAllInstructors(data); // data is already JSON
              return fetchACourse(courseId);
          })
          .then((data) => {
              console.log(data);
              setFormCourseData(data);
          })
          .catch((error) => console.error(error));
  }, [courseId]);


    const handleChange = (e) => {
        const { name, value } = e.target;

        if (name === "instructor") {
            const selectedInstructor = allInstructors.find(i => i.instructorId.toString() === value);
            setFormCourseData({ ...formCourseData, instructor: selectedInstructor || null });
        } else {
            setFormCourseData({ ...formCourseData, [name]: value });
        }
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        // Validate the form data
        let validationErrors = {};
        if (!formCourseData.courseName) validationErrors.courseName = 'Course Name is Required!';
        if (!formCourseData.location) validationErrors.location = 'Location is Required!';
        if (!formCourseData.courseFee) validationErrors.courseFee = 'Course Fee is Required!';
        if (!formCourseData.durationInWeeks) validationErrors.durationInWeeks = 'Duration in Weeks is Required!';
        if (!formCourseData.level) validationErrors.level = 'Level is Required!';
        if (!formCourseData.instructor) validationErrors.instructor = 'Instructor is Required!';

        setErrors(validationErrors);

        if (Object.keys(validationErrors).length === 0) {
            console.log(formCourseData);
            updateCourse(formCourseData)
                .then(() => navigate('/course-list'))
                .catch((error) => console.error(error));
        }
    }

    const allInstructorsDisplay = allInstructors.map((instructor, index) =>
        <option key={index} value={instructor.instructorId}>{instructor.instructorName}</option>
    );

    return (
        <div className="container m-5">
            <div className="row m-5">
                <div className="col-3"></div>
                <div className="col-6">
                    <div className="card">
                        <form onSubmit={handleSubmit}>
                            <div className="card-header bg-primary text-white">
                                <h2>EDIT COURSE</h2>
                            </div>
                            <div className="card-body">
                                <div className="mb-3 mt-3">
                                    <label htmlFor="courseName" className="form-label">Course Name:*</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="courseName"
                                        name="courseName"
                                        value={formCourseData.courseName}
                                        onChange={handleChange}
                                    />
                                    {errors.courseName && <div className="text-danger small">{errors.courseName}</div>}
                                </div>
                                <div className="mb-3 mt-3">
                                    <label htmlFor="location">Location:*</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="location"
                                        name="location"
                                        value={formCourseData.location}
                                        onChange={handleChange}
                                    />
                                    {errors.location && <div className="text-danger small">{errors.location}</div>}
                                </div>
                                <div className="mb-3 mt-3">
                                    <label htmlFor="courseFee">Course Fee:*</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="courseFee"
                                        name="courseFee"
                                        value={formCourseData.courseFee}
                                        onChange={handleChange}
                                    />
                                    {errors.courseFee && <div className="text-danger small">{errors.courseFee}</div>}
                                </div>
                                <div className="mb-3 mt-3">
                                    <label htmlFor="durationInWeeks" className="form-label">Duration in Weeks:*</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="durationInWeeks"
                                        name="durationInWeeks"
                                        value={formCourseData.durationInWeeks}
                                        onChange={handleChange}
                                    />
                                    {errors.durationInWeeks && <div className="text-danger small">{errors.durationInWeeks}</div>}
                                </div>
                                <div className="mb-3 mt-3">
                                    <label htmlFor="level" className="form-label">Level:*</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        id="level"
                                        name="level"
                                        value={formCourseData.level}
                                        onChange={handleChange}
                                    />
                                    {errors.level && <div className="text-danger small">{errors.level}</div>}
                                </div>
                                <div className="mb-3 mt-3">
                                    <label htmlFor="instructor" className="form-label">Instructor:*</label>
                                    <select
                                        id="instructor"
                                        className="form-select"
                                        name="instructor"
                                        value={formCourseData.instructor?.instructorId || ""}
                                        onChange={handleChange}
                                    >
                                        <option value="">--select--</option>
                                        {allInstructorsDisplay}
                                    </select>
                                    {errors.instructor && <div className="text-danger small">{errors.instructor}</div>}
                                </div>
                            </div>
                            <div className="card-footer bg-primary">
                                <button type="submit" className="btn btn-primary bg-white text-primary mx-5">UPDATE</button>
                                <button type="reset" className="btn btn-primary bg-white text-success mx-5">CLEAR</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div className="col-3"></div>
            </div>
        </div>
    );
}

export default CourseEdit;
