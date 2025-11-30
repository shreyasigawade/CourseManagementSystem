import { useParams } from 'react-router-dom';
import { fetchACourse } from '../services/CourseService';
import { useState, useEffect } from 'react';

function CourseView() {
    let [fetchedCourse, setFetchedCourse] = useState(null);
    const { courseId } = useParams();

    useEffect(() => {
        fetchACourse(courseId)
            .then(data => {
                console.log("Fetched course:", data);
                setFetchedCourse(data);
            })
            .catch(error => console.log("Error fetching course:", error));
    }, [courseId]);

    return (
        <>
            {fetchedCourse &&
            <div className="container m-5">
                <div className="row">
                    <div className="col-3"></div>
                    <div className="col-6">
                        <div className="card">
                            <div className="card-header bg-warning text-white">
                                <h2>COURSE INFORMATION</h2>
                            </div>
                            <div className="card-title p-2">
                                <strong>COURSE NAME:</strong> {fetchedCourse.courseName}
                            </div>
                            <div className="card-text p-2">
                                <strong>LOCATION:</strong> {fetchedCourse.location}
                            </div>
                            <div className="card-text p-2">
                                <strong>COURSE FEE:</strong> Rs. {fetchedCourse.courseFee}
                            </div>
                            <div className="card-text p-2">
                                <strong>DURATION IN WEEKS:</strong> {fetchedCourse.durationInWeeks}
                            </div>
                            <div className="card-text p-2">
                                <strong>COURSE LEVEL:</strong> {fetchedCourse.level}
                            </div>
                            <div className="card-text p-2">
                                <strong>INSTRUCTOR:</strong> {fetchedCourse.instructor?.instructorName || "N/A"}
                            </div>
                        </div>
                    </div>
                    <div className="col-3"></div>
                </div>
            </div>}
        </>
    );
}

export default CourseView;
