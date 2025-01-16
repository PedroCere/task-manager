// components/TaskCard.js
import React from 'react';
import '../styles/TaskCard.css';

const TaskCard = ({ title }) => {
  return (
    <div className="task-card">
      <h4>{title}</h4>
    </div>
  );
};

export default TaskCard;
