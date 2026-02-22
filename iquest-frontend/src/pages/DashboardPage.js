import React from 'react';

/**
 * DashboardPage - Main page after login
 * 
 * This is the main page users see after logging in.
 * 
 * Structure:
 * - Header with user info and logout button
 * - DeckList component (shows all decks)
 * - Navigation links
 * 
 * Should check authentication:
 * - If not logged in, redirect to /login
 * - Read auth token from localStorage/context
 */
const DashboardPage = () => {
    return (
        <div>
            <h1>Dashboard</h1>
            {/* <DeckList /> will go here */}
        </div>
    );
};

export default DashboardPage;
