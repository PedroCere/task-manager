// src/components/Dashboard.js
import React from 'react';
import Sidebar from './Sidebar';
import DashboardHeader from './DashboardHeader';
import StatsSection from './StatsSection';
import TaskSections from './TaskSections';
import '../styles/Dashboard.css';
import { useTheme } from '../context/ThemeContext'; // Importar el contexto del tema

const Dashboard = () => {
  const { theme } = useTheme(); // Obtener el tema actual (light o dark)

  return (
    <div className={`dashboard ${theme}`}> {/* Cambiar la clase dinámicamente */}
      <Sidebar />
      <div className="main-content">
        <DashboardHeader />
        <div className="dashboard-content">
          <StatsSection />
          <TaskSections />
        </div>
      </div>
    </div>
  );
};

export default Dashboard;
