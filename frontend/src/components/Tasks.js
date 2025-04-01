import React, { useState, useEffect } from 'react';
import '../styles/Tasks.css';

const API_URL = 'http://localhost:8082/task'; // Cambia esto según tu configuración

const Tasks = () => {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState({ title: '', status: 'Pending', dueDate: '' });
  const [editingTask, setEditingTask] = useState(null);

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    const response = await fetch(API_URL);
    const data = await response.json();
    setTasks(data);
  };

  const handleCreateTask = async () => {
    await fetch(API_URL, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(newTask),
    });
    fetchTasks();
    setNewTask({ title: '', status: 'Pending', dueDate: '' });
  };

  const handleDeleteTask = async (id) => {
    await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
    fetchTasks();
  };

  const handleUpdateTask = async () => {
    await fetch(`${API_URL}/${editingTask.id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(editingTask),
    });
    fetchTasks();
    setEditingTask(null);
  };

  return (
    <div className="tasks">
      <header className="tasks-header">
        <h1>Your Tasks</h1>
        <div>
          <input
            type="text"
            placeholder="Task Title"
            value={newTask.title}
            onChange={(e) => setNewTask({ ...newTask, title: e.target.value })}
          />
          <input
            type="date"
            value={newTask.dueDate}
            onChange={(e) => setNewTask({ ...newTask, dueDate: e.target.value })}
          />
          <button onClick={handleCreateTask}>+ Add Task</button>
        </div>
      </header>

      <table className="tasks-table">
        <thead>
          <tr>
            <th>Task</th>
            <th>Status</th>
            <th>Due Date</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map((task) => (
            <tr key={task.id}>
              <td>{task.title}</td>
              <td>{task.status}</td>
              <td>{task.dueDate}</td>
              <td>
                <button onClick={() => setEditingTask(task)}>Edit</button>
                <button onClick={() => handleDeleteTask(task.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {editingTask && (
        <div className="edit-task">
          <h2>Edit Task</h2>
          <input
            type="text"
            value={editingTask.title}
            onChange={(e) => setEditingTask({ ...editingTask, title: e.target.value })}
          />
          <input
            type="date"
            value={editingTask.dueDate}
            onChange={(e) => setEditingTask({ ...editingTask, dueDate: e.target.value })}
          />
          <button onClick={handleUpdateTask}>Save</button>
          <button onClick={() => setEditingTask(null)}>Cancel</button>
        </div>
      )}
    </div>
  );
};

export default Tasks;

