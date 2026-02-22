/**
 * API Service - Handles all HTTP requests to the backend
 * 
 * This file centralizes API calls so you can:
 * - Reuse the same functions across components
 * - Change API URLs in one place
 * - Handle authentication in one place
 * 
 * Backend base URL: http://localhost:8080/api
 */

/**
 * Fetch data from an API endpoint
 * 
 * @param {string} endpoint - The API endpoint (e.g., 'decks' or 'cards/5')
 * @returns {Promise} - The response data as JSON
 * 
 * Example usage:
 *   const decks = await fetchData('decks');
 *   const cards = await fetchData('cards/decks/5');
 */
export const fetchData = async (endpoint) => {
    try {
        // Send GET request to the backend
        const response = await fetch(`/api/${endpoint}`);

        // Convert response to JavaScript object
        const data = await response.json();
        return data;
    } catch (error) {
        // Log error and re-throw it
        console.error('Error fetching data:', error);
        throw error;
    }
};

// TODO: Add more API functions here:
// - register(username, password)
// - login(username, password)
// - createDeck(name)
// - updateDeck(id, name)
// - deleteDeck(id)
// - createCard(deckId, question, answer)
// - etc.
