import React from 'react';
import '../styles/Sidebar.css'; // Para estilos adicionales
import { FaHome, FaUsers, FaCog } from 'react-icons/fa'; // Importamos íconos

function Sidebar() {
  return (
    <div className="sidebar">
      <ul>
        <li>
          <a href="/">
            <FaHome className="icon" /> Inicio
          </a>
        </li>
        <li>
          <a href="/users">
            <FaUsers className="icon" /> Usuarios
          </a>
        </li>
        <li>
          <a href="/settings">
            <FaCog className="icon" /> Ajustes
          </a>
        </li>
      </ul>
    </div>
  );
}

export default Sidebar;