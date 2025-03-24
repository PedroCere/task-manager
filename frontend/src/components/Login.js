import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { loginUser } from '../api'; 
import '../styles/Login.css';
import loginImage from '../assets/login-img.png';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    setError('');

    try {
      await loginUser(username, password);
      navigate('/dashboard'); // Redirige al dashboard si el login es exitoso
    } catch (err) {
      setError('Invalid username or password');
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
            type="text"
            placeholder="Username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
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
        {/* Blobs */}
        <svg className="blob blob-1" viewBox="0 0 600 600">
          <path
            d="M300,100Q380,150,400,250Q420,350,320,400Q220,450,120,350Q20,250,120,150Q220,50,300,100Z"
            fill="#B9FF66"
          />
        </svg>
        <svg className="blob blob-2" viewBox="0 0 600 600">
          <path
            d="M300,200Q400,250,450,350Q500,450,400,500Q300,550,200,500Q100,450,150,350Q200,250,300,200Z"
            fill="#B9FF66"
          />
        </svg>
        <svg className="blob blob-3" viewBox="0 0 700 600">
          <path
            d="M300,50Q400,100,450,200Q500,300,400,400Q300,500,200,400Q100,300,200,200Q300,100,300,50Z"
            fill="#B9FF66"
          />
        </svg>
        <svg className="blob blob-4" viewBox="0 40 450 450">
          <path
            d="M400,300Q500,400,450,500Q400,600,250,550Q100,500,50,400Q0,300,100,200Q200,100,400,300Z"
            fill="#B9FF66"
          />
        </svg>
      </div>
    </div>
  );
};

export default Login;
