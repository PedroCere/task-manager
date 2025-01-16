// components/TaskSections.js
import React from 'react';
import TaskCard from './TaskCard';
import '../styles/TaskSections.css';
import User1 from '../assets/user-1.png';
import User2 from '../assets/user-2.png';
import User3 from '../assets/user-3.png';
import User4 from '../assets/user-4.png';
import User5 from '../assets/user-5.png';

const TaskSections = () => {
  const tasks = {
    todo: [
      {
        label: 'High',
        labelColor: '#f28b82',
        title: 'Brainstorming',
        description: 'Brainstorming brings team members’ diverse experience into play.',
        avatars: [
          User1,
          User2,
          User3,
        ],
        comments: 12,
        files: 3,
      },
      {
        label: 'High',
        labelColor: '#f28b82',
        title: 'Research',
        description: 'User research helps you to create an optimal product for users.',
        avatars: [
          User4,
          User5,
        ],
        comments: 10,
        files: 0,
      },
    ],
    progress: [
      {
        label: 'On Progress',
        labelColor: '#fbbc04',
        title: 'Moodboard',
        description: 'Moodboard helps you collect the most basic inspirations.',
        avatars: [
          User2,
          User5,
        ],
        comments: 8,
        files: 2,
      },
    ],
    done: [
      {
        label: 'Completed',
        labelColor: '#34a853',
        title: 'Mobile App Design',
        description: 'Design the mobile app for our e-commerce platform.',
        avatars: [
          User5,
          User1,
          User4,
        ],
        comments: 15,
        files: 5,
      },
    ],
  };

  return (
    <div className="task-sections">
      <div className="task-section">
        <h3 className="section-title">To Do</h3>
        {tasks.todo.map((task, index) => (
          <TaskCard key={index} {...task} />
        ))}
      </div>
      <div className="task-section">
        <h3 className="section-title">On Progress</h3>
        {tasks.progress.map((task, index) => (
          <TaskCard key={index} {...task} />
        ))}
      </div>
      <div className="task-section">
        <h3 className="section-title">Done</h3>
        {tasks.done.map((task, index) => (
          <TaskCard key={index} {...task} />
        ))}
      </div>
    </div>
  );
};

export default TaskSections;
