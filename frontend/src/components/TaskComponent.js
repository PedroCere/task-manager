import React from 'react';
import '../styles/TaskCard.css';

const TaskCard = ({ title, status, onClick }) => {
  return (
    <div className="task-card" onClick={onClick}>
      <h4>{title}</h4>
      <p>Status: {status}</p>
    </div>
  );
};

export default TaskCard;
