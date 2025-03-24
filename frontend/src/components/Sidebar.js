// src/components/Sidebar.js
import React from 'react';
import { FaHome, FaChartBar, FaEnvelope, FaTasks, FaProjectDiagram, FaCog } from 'react-icons/fa';
import { NavLink } from 'react-router-dom';
import { useTheme } from '../context/ThemeContext';
import ManglyLogo from '../assets/mangly-logo (1).png';
import '../styles/Sidebar.css';

const Sidebar = () => {
  const { theme, toggleTheme } = useTheme();

  return (
    <div className={`sidebar ${theme}`}>
      <div className="logo-container">
        <img src={require('../assets/mangly-logo (1).png')} alt="Mangly Logo" className="logo-image" />
      </div>
      <nav className="nav-links">
        <NavLink to="/dashboard">
          <FaHome className="icon" /> Dashboard
        </NavLink>
        <NavLink to="/analytics">
          <FaChartBar className="icon" /> Analytics
        </NavLink>
        <NavLink to="/messages">
          <FaEnvelope className="icon" /> Messages
        </NavLink>
        <NavLink to="/tasks">
          <FaTasks className="icon" /> Tasks
        </NavLink>
        <NavLink to="/projects">
          <FaProjectDiagram className="icon" /> Projects
        </NavLink>
        <NavLink to="/settings">
          <FaCog className="icon" /> Settings
        </NavLink>
      </nav>
      <div className="theme-switcher">
        <label>
          <input type="checkbox" onChange={toggleTheme} />
          {theme === 'light' ? 'Light Mode' : 'Dark Mode'}
        </label>
      </div>
    </div>
  );
};

export default Sidebar;
