// components/StatsSection.js
import React from 'react';
import '../styles/StatsSection.css';
import { FaThumbsUp, FaFolderOpen, FaTasks } from 'react-icons/fa';

const StatsSection = () => {
  return (
    <div className="stats-section">
      <div className="stats-card">
        <FaThumbsUp className="icon" />
        <h3>Weekly Activity</h3>
        <p>85% of tasks completed</p>
        <div className="progress-bar">
          <div className="progress" style={{ width: '85%' }}></div>
        </div>
      </div>
      <div className="stats-card">
        <FaFolderOpen className="icon" />
        <h3>Projects Worked</h3>
        <p>12 Active Projects</p>
      </div>
      <div className="stats-card">
        <FaTasks className="icon" />
        <h3>Tasks Completed</h3>
        <p>57 Tasks Completed</p>
      </div>
    </div>
  );
};

export default StatsSection;
