// src/components/Messages.js
import React from 'react';
import '../styles/Messages.css';

const messages = [
  { id: 1, sender: 'John Doe', subject: 'Meeting Reminder', date: 'Jan 20, 2025', unread: true },
  { id: 2, sender: 'Jane Smith', subject: 'Project Update', date: 'Jan 18, 2025', unread: false },
  { id: 3, sender: 'HR Department', subject: 'Policy Changes', date: 'Jan 17, 2025', unread: true },
  { id: 4, sender: 'Client A', subject: 'Feedback on Proposal', date: 'Jan 15, 2025', unread: false },
];

const Messages = () => {
  return (
    <div className="messages">
      <header className="messages-header">
        <h1>Messages</h1>
      </header>
      <ul className="messages-list">
        {messages.map((message) => (
          <li key={message.id} className={`message-item ${message.unread ? 'unread' : ''}`}>
            <div className="message-info">
              <span className="message-sender">{message.sender}</span>
              <span className="message-subject">{message.subject}</span>
            </div>
            <span className="message-date">{message.date}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Messages;
