import React from 'react';
import { NavLink } from 'react-router-dom';
import { FaHome, FaTasks, FaProjectDiagram, FaChartBar, FaCog, FaEnvelope } from 'react-icons/fa';
import { useTheme } from '../context/ThemeContext'; // Importar el contexto del tema
import '../styles/Sidebar.css';

const Sidebar = () => {
  const { theme, toggleTheme } = useTheme(); // Obtener el tema actual y la función para alternarlo

  return (
    <div className={`sidebar ${theme}`}> {/* Cambiar según el tema */}
      {/* Logo */}
      <div className="logo-container">
        <img 
          src={require('../assets/mangly-logo (1).png')} 
          alt="Mangly Logo" 
          className="logo-image" 
        />
      </div>

      {/* Navegación */}
      <nav className="nav-links">
        <NavLink to="/dashboard" activeClassName="active">
          <FaHome className="icon" /> Dashboard
        </NavLink>
        <NavLink to="/analytics" activeClassName="active">
          <FaChartBar className="icon" /> Analytics
        </NavLink>
        <NavLink to="/messages" activeClassName="active">
          <FaEnvelope className="icon" /> Messages
        </NavLink>
        <NavLink to="/tasks" activeClassName="active">
          <FaTasks className="icon" /> Tasks
        </NavLink>
        <NavLink to="/projects" activeClassName="active">
          <FaProjectDiagram className="icon" /> Projects
        </NavLink>
        <NavLink to="/settings" activeClassName="active">
          <FaCog className="icon" /> Settings
        </NavLink>
      </nav>

      {/* Selector de tema */}
      <div className="theme-switcher">
        <label>
          <input 
            type="checkbox" 
            checked={theme === 'light'} 
            onChange={toggleTheme} 
          />
          <span className="switch-label">
            {theme === 'light' ? 'Light Mode' : 'Dark Mode'}
          </span>
        </label>
      </div>
    </div>
  );
};

export default Sidebar;
