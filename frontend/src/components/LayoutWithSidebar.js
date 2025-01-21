// src/components/LayoutWithSidebar.js
import React from 'react';
import Sidebar from './Sidebar';
import DashboardHeader from './DashboardHeader';
import '../styles/LayoutWithSidebar.css';

const LayoutWithSidebar = ({ children }) => {
  return (
    <div className="layout-with-sidebar">
      <Sidebar />
      <div className="main-content">
        <DashboardHeader />
        <div className="content">{children}</div>
      </div>
    </div>
  );
};

export default LayoutWithSidebar;