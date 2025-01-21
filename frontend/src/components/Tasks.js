// src/components/Tasks.js
import React from 'react';
import '../styles/Tasks.css';

const tasks = [
  { id: 1, title: 'Finish design for landing page', status: 'In Progress', dueDate: 'Jan 25, 2025' },
  { id: 2, title: 'Prepare meeting notes', status: 'Completed', dueDate: 'Jan 17, 2025' },
  { id: 3, title: 'Implement authentication system', status: 'Pending', dueDate: 'Feb 5, 2025' },
  { id: 4, title: 'Bug fixes for dashboard', status: 'In Progress', dueDate: 'Jan 30, 2025' },
];

const Tasks = () => {
  return (
    <div className="tasks">
      <header className="tasks-header">
        <h1>Your Tasks</h1>
        <button className="add-task-btn">+ Add Task</button>
      </header>
      <table className="tasks-table">
        <thead>
          <tr>
            <th>Task</th>
            <th>Status</th>
            <th>Due Date</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map((task) => (
            <tr key={task.id} className={`status-${task.status.toLowerCase()}`}>
              <td>{task.title}</td>
              <td>{task.status}</td>
              <td>{task.dueDate}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Tasks;
