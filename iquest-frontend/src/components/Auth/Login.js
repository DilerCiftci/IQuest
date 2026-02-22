import React from 'react';

/**
 * Login Component - User login form
 * 
 * TODO: Implement this component with:
 * 
 * 1. State for username and password:
 *    const [username, setUsername] = useState('');
 *    const [password, setPassword] = useState('');
 * 
 * 2. Login form with input fields
 * 
 * 3. Submit handler that:
 *    - Sends POST request to /api/users/login
 *    - With Basic Auth header: btoa(`${username}:${password}`)
 *    - Saves credentials to localStorage/context
 *    - Redirects to /dashboard on success
 * 
 * 4. Error handling for invalid credentials
 */
const Login = () => {
  return (
    <div>
      <h1>Login</h1>
      {/* Add form here */}
    </div>
  );
};

export default Login;
