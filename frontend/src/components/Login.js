import React from 'react';
import '../styles/Login.css';

const Login = () => {
  return (
    <div className="login-container">
      <div className="login-form">
        <h1>Login</h1>
        <p>Enter your account details</p>
        <form>
          <input type="text" placeholder="Username" />
          <input type="password" placeholder="Password" />
          <button type="submit">Login</button>
        </form>
        <p>Don’t have an account? <a href="/register">Sign up</a></p>
      </div>
    </div>
  );
};

export default Login;
