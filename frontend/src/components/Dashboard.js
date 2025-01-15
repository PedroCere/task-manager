import React from 'react';
import Sidebar from './Sidebar';
import DashboardHeader from './DashboardHeader';
import ContentArea from './ContentArea';
import '../styles/Dashboard.css'; // Para estilos adicionales

const Dashboard = () => {
  return (
    <div className="dashboard">
      <Sidebar />
      <div className="main-content">
        <DashboardHeader />
        <ContentArea />
      </div>
    </div>
  );
};

export default Dashboard;
