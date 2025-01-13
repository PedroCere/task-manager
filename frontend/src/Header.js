// src/components/Header.js
import React from 'react';
import { Link } from 'react-router-dom';
import './styles/Header.css';
import logo from './assets/mangly-logo (1).png'; 

const Header = () => {
  return (
    <header className="header">
      <div className="logo">
        <Link to="/">
          <img src={logo} alt="Mangly Logo" className="logo-img" />
        </Link>
      </div>
      <nav className="nav">
        <ul>
          <li>Services</li>
          <li>About us</li>
          <li>Use Cases</li>
          <li>Pricing</li>
          <li>Blog</li>
        </ul>
      </nav>
      <div>
        <Link to="/register" className="register-button">Register</Link>
        <Link to="/login" className="login-button">Log in</Link>
      </div>
    </header>
  );
};

export default Header;
