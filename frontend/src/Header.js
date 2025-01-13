// src/components/Header.js
import React from 'react';
import './styles/Header.css';
import logo from './assets/mangly-logo (1).png'; 

const Header = () => {
  return (
    <header className="header">
      <div className="logo">
      <img src={logo} alt="Mangly Logo" className="logo-img" />
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
      <button className="register-button">Register/Log in</button>
    </header>
  );
};

export default Header;
