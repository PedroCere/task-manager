import React from 'react';
import '../styles/DashboardHeader.css' // Para estilos adicionales

const DashboardHeader = () => {
  return (
    <header className="dashboard-header">
      <div>Logo</div>
      <nav>
        <ul className="nav-links">
          <li><a href="#inicio">Inicio</a></li>
          <li><a href="#usuarios">Usuarios</a></li>
          <li><a href="#ajustes">Ajustes</a></li>
        </ul>
      </nav>
      <div>
        <span>Usuario</span>
        <button className="logout-button">Cerrar sesión</button>
      </div>
    </header>
  );
};

export default DashboardHeader;
