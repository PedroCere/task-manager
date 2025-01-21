// src/components/Settings.js
import React, { useState } from 'react';
import '../styles/Settings.css';

const Settings = () => {
  const [theme, setTheme] = useState('Light');
  const [notifications, setNotifications] = useState(true);

  const handleThemeChange = (event) => {
    setTheme(event.target.value);
  };

  const toggleNotifications = () => {
    setNotifications(!notifications);
  };

  return (
    <div className="settings">
      <header className="settings-header">
        <h1>Settings</h1>
      </header>
      <section className="settings-section">
        <h2>Appearance</h2>
        <label className="settings-label">
          Theme:
          <select value={theme} onChange={handleThemeChange}>
            <option value="Light">Light</option>
            <option value="Dark">Dark</option>
          </select>
        </label>
      </section>
      <section className="settings-section">
        <h2>Notifications</h2>
        <label className="settings-label">
          <input
            type="checkbox"
            checked={notifications}
            onChange={toggleNotifications}
          />
          Enable Notifications
        </label>
      </section>
      <section className="settings-section">
        <h2>Account</h2>
        <button className="settings-btn">Manage Account</button>
        <button className="settings-btn danger">Delete Account</button>
      </section>
    </div>
  );
};

export default Settings;
