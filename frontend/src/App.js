// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Routes, useLocation } from 'react-router-dom';
import Header from './Header';
import Hero from './components/Hero';
import Services from './components/Services';
import JoinNowSection from './components/JoinNowSection';
import Footer from './components/Footer';
import Register from './components/Register';
import Login from './components/Login';
import './App.css';
import Dashboard from './components/Dashboard';
import { ThemeProvider } from './context/ThemeContext'; // Importar el contexto

function AppContent() {
  const location = useLocation();
  const hideHeader = location.pathname === '/dashboard' || location.pathname === '/register' || location.pathname === '/login';
  const hideDashBoard = location.pathname === '/' || location.pathname === '/register' || location.pathname === '/login'|| location.pathname === '/dashboard';

  return (
    <>
      {!hideHeader && <Header />}
      {!hideDashBoard && <Dashboard />}
      <ThemeProvider>
      <Routes>
        <Route 
          path="/" 
          element={
            <>
              <Hero />
              <Services />
              <JoinNowSection />
              <Footer />
            </>
          } 
          />
          <Route 
          path="/dashboard" 
          element={
            <>
              <Dashboard />
            </>
          } 
        />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
      </Routes>
      </ThemeProvider>
    </>
  );
}

function App() {
  return (
    <Router>
      <AppContent />
    </Router>
  );
}

export default App;
