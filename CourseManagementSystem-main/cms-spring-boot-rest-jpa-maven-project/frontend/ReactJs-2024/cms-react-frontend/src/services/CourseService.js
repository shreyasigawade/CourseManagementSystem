// src/services/CourseService.js

const baseUrl = "http://localhost:8080/v1/api/courses"; // backend URL

// Fetch all courses
export const fetchAllCourses = () => {
    return fetch(baseUrl)
        .then(response => {
            if (!response.ok) throw new Error("Failed to fetch courses");
            return response.json();
        });
}

// Fetch single course by ID
export const fetchACourse = (courseId) => {
    return fetch(`${baseUrl}/${courseId}`)
        .then(response => {
            if (!response.ok) throw new Error("Failed to fetch course");
            return response.json();
        });
}

// Add new course
export const addCourse = (newCourse) => {
    return fetch(baseUrl, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newCourse)
    })
    .then(response => {
        if (!response.ok) throw new Error("Failed to add course");
        return response.json();
    })
    .catch(error => {
        console.error("Error adding course:", error);
        throw error;
    });
}

// Update existing course
export const updateCourse = (updateCourse) => {
    return fetch(`${baseUrl}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(updateCourse)
    })
    .then(response => {
        if (!response.ok) throw new Error("Failed to update course");
        return response.json();
    });
}

// Delete course
export const deleteCourse = (courseId) => {
    return fetch(`${baseUrl}/${courseId}`, { method: "DELETE" })
        .then(response => {
            if (!response.ok) throw new Error("Failed to delete course");
            return response;
        });
};
