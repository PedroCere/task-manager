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

function AppContent() {
  const location = useLocation();
  const hideHeader = location.pathname === '/dashboard' || location.pathname === '/register' || location.pathname === '/login';

  return (
    <>
      {!hideHeader && <Header />}
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
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
      </Routes>
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
