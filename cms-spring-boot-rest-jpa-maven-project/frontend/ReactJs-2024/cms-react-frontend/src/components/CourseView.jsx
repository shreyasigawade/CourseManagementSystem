import { useParams } from 'react-router-dom';
import { fetchACourse } from '../services/CourseService';
import { useState, useEffect } from 'react';

function CourseView() {
    let [fetchedCourse, setFetchedCourse] = useState(null);

    // Extract the route parameter - courseId
    const { courseId } = useParams();

    // Consume the endpoint to fetch a course by passing the course id using useEffect
    useEffect(() => {
        fetchACourse(courseId)
            .then(response => response.json())
            .then(data => {
                console.log(data);
                // Store the fetched course in a state variable
                setFetchedCourse(data);
            })
            .catch(error => console.log(error));
    }, [courseId]);

    // Display the state variable in JSX
    return (
        <>
            {fetchedCourse && 
            <div className="container m-5">
                <div className="row">
                    <div className="col-3"></div>
                    <div className="col-6">
                        <div className="card">
                            <div className="card-header bg-warning text-white"> <h2>COURSE INFORMATION</h2></div>
                            <div className="card-title p-2">COURSE NAME: {fetchedCourse.courseName}</div>
                            <div className="card-text p-2">LOCATION: {fetchedCourse.location}</div>
                            <div className="card-text p-2">COURSE FEE: Rs. {fetchedCourse.courseFee}</div>
                            <div className="card-text p-2">DURATION IN WEEKS: {fetchedCourse.durationInWeeks}</div>
                            <div className="card-text p-2">COURSE LEVEL: {fetchedCourse.courseLevel}</div>
                            <div className="card-text p-2">INSTRUCTOR: {fetchedCourse.instructor.instructorName}</div>
                        </div>
                    </div>
                    <div className="col-3"></div>
                </div>
            </div>}
        </>
    );
}

export default CourseView;