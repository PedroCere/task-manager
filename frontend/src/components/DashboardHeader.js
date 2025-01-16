// components/DashboardHeader.js
import React from 'react';
import '../styles/DashboardHeader.css';
import PedroUser from '../assets/pedro-user.png';

const DashboardHeader = () => {
  const today = new Date().toLocaleDateString('en-US', {
    weekday: 'long', year: 'numeric', month: 'long', day: 'numeric'
  });

  return (
    <header className="dashboard-header">
      <div className="header-left">
        <h2>Today</h2>
        <p>{today}</p>
      </div>
      <div className="header-right">
        <img
          src={PedroUser}
          alt="User Avatar"
          className="user-avatar"
        />
        <span className="user-name">Mohamed Salah</span>
      </div>
    </header>
  );
};

export default DashboardHeader;
