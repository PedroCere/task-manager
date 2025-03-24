// src/components/Dashboard.js
import React from 'react';
import { useTheme } from '../context/ThemeContext'; // Usar el contexto del tema
import '../styles/Dashboard.css';

const Dashboard = () => {
  const { theme } = useTheme(); // Obtener el tema actual

  const kpis = [
    { id: 1, title: 'Projects', value: '95 / 100', trend: '-10%', color: 'orange', description: '10% decrease from last month' },
    { id: 2, title: 'Time spent', value: '1022 / 1300 Hrs', trend: '+8%', color: 'blue', description: '8% increase from last month' },
    { id: 3, title: 'Resources', value: '101 / 120', trend: '+2%', color: 'green', description: '2% increase from last month' },
  ];

  const projects = [
    { name: 'Nissa Web Development', manager: 'Mathew Kennedy', dueDate: 'May 2, 2027', status: 'Completed', progress: 100 },
    { name: 'Destacable API', manager: 'Richard Ramos', dueDate: 'June 22, 2025', status: 'Delayed', progress: 70 },
    { name: 'Mega APP for Pros', manager: 'Enrique Iglesias', dueDate: 'March 1, 2028', status: 'At Risk', progress: 50 },
    { name: 'Incredible Application', manager: 'Matias Loco', dueDate: 'July 12, 2025', status: 'Completed', progress: 100 },
    { name: 'NASA Project', manager: 'Sandro Castro', dueDate: 'April 2, 2028', status: 'Delayed', progress: 74 },
  ];

  return (
    <div className={`dashboard ${theme}`}> {/* Clase dinámica según el tema */}
      {/* KPIs Section */}
      <section className="kpis">
        {kpis.map((kpi) => (
          <div key={kpi.id} className={`kpi-card ${kpi.color}`}>
            <h3>{kpi.title}</h3>
            <p className="kpi-value">{kpi.value}</p>
            <p className={`kpi-trend ${kpi.trend.startsWith('+') ? 'positive' : 'negative'}`}>{kpi.trend}</p>
            <p className="kpi-description">{kpi.description}</p>
          </div>
        ))}
      </section>

      {/* Project Summary */}
      <section className="project-summary">
        <h2>Project Summary</h2>
        <table className="project-table">
          <thead>
            <tr>
              <th>Name</th>
              <th>Project Manager</th>
              <th>Due Date</th>
              <th>Status</th>
              <th>Progress</th>
            </tr>
          </thead>
          <tbody>
            {projects.map((project, index) => (
              <tr key={index}>
                <td>{project.name}</td>
                <td>{project.manager}</td>
                <td>{project.dueDate}</td>
                <td>
                  <span className={`status ${project.status.toLowerCase()}`}>{project.status}</span>
                </td>
                <td>
                  <div className="progress-bar">
                    <div className="progress" style={{ width: `${project.progress}%` }}></div>
                  </div>
                  <span>{project.progress}%</span>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </section>
    </div>
  );
};

export default Dashboard;
