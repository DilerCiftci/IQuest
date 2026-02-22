import React from 'react';

/**
 * CardList Component - Displays all cards in a deck
 * 
 * This component will:
 * 
 * 1. Receive deckId from URL params (useParams hook)
 * 
 * 2. Fetch cards from API:
 *    - GET /api/cards/decks/:deckId
 * 
 * 3. Display each card:
 *    - Show question and answer
 *    - Edit button (opens form)
 *    - Delete button
 * 
 * 4. "Add New Card" button/form:
 *    - Input for question
 *    - Input for answer
 *    - POST /api/cards/decks/:deckId
 * 
 * 5. "Start Quiz" button -> navigate to /quiz/:deckId
 */
const CardList = () => {
    return (
        <div>
            <h2>Card List</h2>
            {/* Display cards here */}
        </div>
    );
};

export default CardList;
