const baseUrl ="https://localhost:8080/v1/api/courses";

export const fetchAllCourses = () =>{
    return fetch(baseUrl);

}

export const fetchACourse = (courseId) =>{
    
    return fetch(baseUrl +"/"+ courseId )

}

export const addCourse = (newCourse) =>{
    
}
export const updateCourse = (updateCourse) =>{

}
export const deleteCourse = (courseId) =>{

}