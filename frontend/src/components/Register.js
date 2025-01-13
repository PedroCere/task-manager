import React from 'react';
import '../styles/Register.css';

const Register = () => {
  return (
    <div className="register-container">
      <div className="register-form">
        <h1>Register</h1>
        <p>Create a new account</p>
        <form>
          <input type="email" placeholder="Email" />
          <input type="text" placeholder="Username" />
          <input type="password" placeholder="Password" />
          <input type="password" placeholder="Confirm Password" />
          <button type="submit">Create Account</button>
        </form>
        <p>Already have an account? <a href="/login">Log in</a></p>
      </div>
    </div>
  );
};

export default Register;
