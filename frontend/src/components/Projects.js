// src/components/Projects.js
import React from 'react';
import '../styles/Projects.css';

const projects = [
  { id: 1, name: 'Redesign Company Website', manager: 'John Doe', dueDate: 'March 1, 2025', status: 'At Risk', progress: 50 },
  { id: 2, name: 'Mobile App Development', manager: 'Jane Smith', dueDate: 'April 15, 2025', status: 'Completed', progress: 100 },
  { id: 3, name: 'Marketing Campaign Launch', manager: 'Mark Brown', dueDate: 'Feb 10, 2025', status: 'Delayed', progress: 70 },
];

const Projects = () => {
  return (
    <div className="projects">
      <header className="projects-header">
        <h1>Projects Overview</h1>
        <button className="add-project-btn">+ New Project</button>
      </header>
      <table className="projects-table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Manager</th>
            <th>Due Date</th>
            <th>Status</th>
            <th>Progress</th>
          </tr>
        </thead>
        <tbody>
          {projects.map((project) => (
            <tr key={project.id} className={`status-${project.status.toLowerCase().replace(' ', '-')}`}>
              <td>{project.name}</td>
              <td>{project.manager}</td>
              <td>{project.dueDate}</td>
              <td className={`status-label`}>{project.status}</td>
              <td>
                <div className="progress-bar">
                  <div className="progress" style={{ width: `${project.progress}%` }}></div>
                </div>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Projects;
