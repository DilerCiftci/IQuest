/**
 * App.js - Main React Component (Entry Point)
 * 
 * This is the root component of your React application.
 * 
 * TODO: Replace the default template with:
 * - React Router for navigation (HomePage, DashboardPage, etc.)
 * - Authentication context/state
 * - Routes for /login, /dashboard, /decks/:id, /quiz/:id
 * 
 * Example structure:
 * <Router>
 *   <Routes>
 *     <Route path="/" element={<HomePage />} />
 *     <Route path="/dashboard" element={<DashboardPage />} />
 *     <Route path="/decks/:id" element={<DeckPage />} />
 *     <Route path="/quiz/:id" element={<QuizPage />} />
 *   </Routes>
 * </Router>
 */

import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
