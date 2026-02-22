import React from 'react';

/**
 * DeckList Component - Displays all of user's decks
 * 
 * TODO: Implement this component with:
 * 
 * 1. State for decks:
 *    const [decks, setDecks] = useState([]);
 * 
 * 2. useEffect to fetch decks on component mount:
 *    - GET /api/decks (with auth header)
 *    - Set decks in state
 * 
 * 3. Display decks as cards/list:
 *    - Show deck name
 *    - "View Cards" button -> navigate to /decks/:id
 *    - "Start Quiz" button -> navigate to /quiz/:id
 *    - "Delete" button
 * 
 * 4. "Create New Deck" button/form
 */
const DeckList = () => {
    return (
        <div>
            <h2>Deck List</h2>
            {/* Add deck cards here */}
        </div>
    );
};

export default DeckList;
