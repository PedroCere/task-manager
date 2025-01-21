// src/components/Analytics.js
import React from 'react';
import '../styles/Analytics.css'; // Archivo de estilos específico para Analytics

const Analytics = () => {
  return (
    <div className="analytics">
      <header className="analytics-header">
        <h1>Your Progress</h1>
        <div className="analytics-graphic">
          {/* Gráfico decorativo */}
          <span className="circle"></span>
          <span className="star"></span>
          <span className="spiral"></span>
        </div>
      </header>

      {/* Sección de métricas */}
      <section className="analytics-metrics">
        <div className="metric-card">
          <div className="metric-icon projects"></div>
          <div className="metric-details">
            <h3>Projects</h3>
            <p>
              <strong>95</strong> / 100
            </p>
            <span className="metric-change decrease">10% decrease from last month</span>
          </div>
        </div>
        <div className="metric-card">
          <div className="metric-icon time"></div>
          <div className="metric-details">
            <h3>Time spent</h3>
            <p>
              <strong>1022</strong> / 1300 Hrs
            </p>
            <span className="metric-change increase">8% increase from last month</span>
          </div>
        </div>
        <div className="metric-card">
          <div className="metric-icon resources"></div>
          <div className="metric-details">
            <h3>Resources</h3>
            <p>
              <strong>101</strong> / 120
            </p>
            <span className="metric-change increase">2% increase from last month</span>
          </div>
        </div>
      </section>

      {/* Resumen de proyectos */}
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
            <tr>
              <td>Nissa Web Development</td>
              <td>Mathew Kennedy</td>
              <td>May 2, 2027</td>
              <td className="status completed">Completed</td>
              <td className="progress">100%</td>
            </tr>
            <tr>
              <td>Destacable API</td>
              <td>Richard Ramos</td>
              <td>June 22, 2025</td>
              <td className="status delayed">Delayed</td>
              <td className="progress">70%</td>
            </tr>
            <tr>
              <td>Mega APP for pros</td>
              <td>Enrique Iglesias</td>
              <td>March 1, 2028</td>
              <td className="status at-risk">At Risk</td>
              <td className="progress">50%</td>
            </tr>
            <tr>
              <td>Incredible Application</td>
              <td>Matias Loco</td>
              <td>July 12, 2025</td>
              <td className="status completed">Completed</td>
              <td className="progress">100%</td>
            </tr>
            <tr>
              <td>NASA Project</td>
              <td>Sandro Castro</td>
              <td>April 2, 2028</td>
              <td className="status delayed">Delayed</td>
              <td className="progress">74%</td>
            </tr>
          </tbody>
        </table>
      </section>
    </div>
  );
};

export default Analytics;
