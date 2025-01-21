// src/components/Dashboard.js
import React from 'react';
import StatsSection from './StatsSection';
import TaskSections from './TaskSections';
import '../styles/Dashboard.css';
import { useTheme } from '../context/ThemeContext';

const Dashboard = () => {
  const { theme } = useTheme();

  return (
    <div className={`dashboard-content ${theme}`}>
      <StatsSection />
      <TaskSections />
    </div>
  );
};

export default Dashboard;
