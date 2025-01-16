// components/Sidebar.js
import React from 'react';
import { FaHome, FaTasks, FaProjectDiagram, FaChartBar, FaCog, FaEnvelope } from 'react-icons/fa';
import { useTheme } from '../context/ThemeContext'; // Importar el contexto del tema
import '../styles/Sidebar.css';

const Sidebar = () => {
  const { theme, toggleTheme } = useTheme(); // Obtener el tema actual y la función para alternarlo

  return (
    <div className={`sidebar ${theme}`}> {/* Cambiar según el tema */}
      <div className="logo-container">
        <img 
          src={require('../assets/mangly-logo (1).png')} 
          alt="Mangly Logo" 
          className="logo-image" 
        />
      </div>
      <nav className="nav-links">
        <a href="/dashboard" className="active">
          <FaHome className="icon" /> Dashboard
        </a>
        <a href="/analytics">
          <FaChartBar className="icon" /> Analytics
        </a>
        <a href="/messages">
          <FaEnvelope className="icon" /> Messages
        </a>
        <a href="/tasks">
          <FaTasks className="icon" /> Tasks
        </a>
        <a href="/projects">
          <FaProjectDiagram className="icon" /> Projects
        </a>
        <a href="/settings">
          <FaCog className="icon" /> Settings
        </a>
      </nav>
      <div className="theme-switcher">
        <label>
          <input 
            type="checkbox" 
            checked={theme === 'dark'} 
            onChange={toggleTheme} 
          />
          <span className="switch-label">
            {theme === 'dark' ? 'Dark Mode' : 'Light Mode'}
          </span>
        </label>
      </div>
    </div>
  );
};

export default Sidebar;
