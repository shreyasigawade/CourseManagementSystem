import { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import { deleteCourse, fetchAllCourses } from "../services/CourseService";

function CourseList(){
    const navigate = useNavigate();

    let [allCourses, setAllCourses] = useState([]);

    useEffect(() => {
        loadCourses();    
    }, []);

    const loadCourses = () => {
        fetchAllCourses()
            .then(response=>response.json())
            .then(data=>{
                console.log(data);
                setAllCourses(data);
            })
            .catch(error=>console.log(error));
    }

    const removeCourse = (courseId) => {
        deleteCourse(courseId)
            .then(response=>{
                fetchAllCourses()
                    .then(response=>response.json())
                    .then(data=>{
                        setAllCourses(data);
                    })
                    .catch(error=>console.log(error));
            })
            .catch(error=>console.log(error));
    }
    

    const viewCourse = (courseId)=> {
        navigate('/course-view/'+courseId);
    }

    const editCourse = (courseId)=> {
        navigate('/course-edit/'+courseId);
    }
    
    const handleAddCourse = () => {
        navigate('/course-add');
    }

    const allCoursesDisplay = allCourses.map((eachCourse, index) => 
        <tr key={index}>
            <td>{eachCourse.courseId}</td>
            <td>{eachCourse.courseName}</td>
            <td>{eachCourse.location}</td>
            <td>Rs. {eachCourse.courseFee}</td>
            <td>{eachCourse.instructor.name}</td>
          
            <td>{eachCourse.durationInWeeks}</td>
            <td>{eachCourse.courseLevel}</td>
            
            <td>
                <button type="button" className="btn btn-warning" onClick={()=>viewCourse(eachCourse.courseId)}>View</button>
            </td>
            <td>
                <button type="button" className="btn btn-primary" onClick={()=>editCourse(eachCourse.courseId)}>Edit</button>
            </td>
            <td>
                <button type="button" className="btn btn-danger" onClick={()=>removeCourse(eachCourse.courseId)}>Remove</button>
            </td>
        </tr>
    );

    return (
        <div className="container m-5">
            <h1>LIST OF COURSES</h1>
            <button type="button" className="btn btn-success" onClick={handleAddCourse}>ADD NEW COURSE</button>
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
                    {allCoursesDisplay}
                </tbody>
            </table>
        </div>
    );
}
export default CourseList;