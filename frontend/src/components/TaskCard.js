// components/TaskCard.js
import React from 'react';
import { FaComment, FaPaperclip } from 'react-icons/fa';
import '../styles/TaskCard.css';

const TaskCard = ({ label, labelColor, title, description, avatars, comments, files }) => {
  return (
    <div className="task-card">
      <div className="task-card-header">
        <span className="task-label" style={{ backgroundColor: labelColor }}>
          {label}
        </span>
      </div>
      <div className="task-card-body">
        <h4 className="task-title">{title}</h4>
        <p className="task-description">{description}</p>
      </div>
      <div className="task-card-footer">
        <div className="avatars">
          {avatars.map((avatar, index) => (
            <img
              key={index}
              src={avatar}
              alt="User Avatar"
              className="avatar"
            />
          ))}
        </div>
        <div className="task-meta">
          <span className="task-comments">
            <FaComment /> {comments} comments
          </span>
          <span className="task-files">
            <FaPaperclip /> {files} files
          </span>
        </div>
      </div>
    </div>
  );
};

export default TaskCard;
