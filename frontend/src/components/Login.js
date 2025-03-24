import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { loginUser } from '../api'; // Importamos la función de login
import '../styles/Login.css';
import loginImage from '../assets/login-img.png';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    setError('');

    try {
      const userData = await loginUser(email, password);
      console.log('Login Successful:', userData);
      navigate('/dashboard'); // Redirigir al dashboard después del login
    } catch (err) {
      setError('Invalid email or password');
    }
  };

  return (
    <div className="container">
      <div className="left-section">
        <h2>Login</h2>
        <p>Enter your account details</p>
        {error && <p className="error-message">{error}</p>}
        <form onSubmit={handleLogin}>
          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          <div className="forgot-password">
            <a href="/forgot-password">Forgot Password?</a>
          </div>
          <button type="submit">Login</button>
        </form>
        <p>
          Don’t have an account? <a href="/register">Sign up</a>
        </p>
      </div>
      <div className="right-section">
        <h1>Welcome to Mangly</h1>
        <p>Login to access your account</p>
        <img src={loginImage} alt="Login Illustration" className="login-illustration" />
      </div>
    </div>
  );
};

export default Login;
