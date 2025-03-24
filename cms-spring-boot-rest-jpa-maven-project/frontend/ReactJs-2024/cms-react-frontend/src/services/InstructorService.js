const baseUrl = "https://localhost:8080/v1/api/instructors";

export const fetchAllInstructors = () => {
    return fetch(baseUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch instructors');
            }
            return response.json();
        })
        .catch(error => {
            console.error('Error fetching instructors:', error);
            throw error; // Re-throw the error to be handled by the caller
        });
};
