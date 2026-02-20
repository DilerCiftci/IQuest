// API service file for handling HTTP requests
// Add your API calls here

export const fetchData = async (endpoint) => {
    try {
        const response = await fetch(`/api/${endpoint}`);
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
};
