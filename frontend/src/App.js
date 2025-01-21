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
import Analytics from './components/Analytics';
import Projects from './components/Projects';import Tasks from './components/Tasks';
import Messages from './components/Messages';
import Settings from './components/Settings';
import LayoutWithSidebar from './components/LayoutWithSidebar';
import { ThemeProvider } from './context/ThemeContext';

function AppContent() {
  const location = useLocation();
  const hideHeader =
    location.pathname === '/dashboard' ||
    location.pathname === '/register' ||
    location.pathname === '/login' ||
    location.pathname === '/analytics' ||
    location.pathname === '/projects' ||
    location.pathname === '/tasks' ||
    location.pathname === '/messages' ||
    location.pathname === '/settings';



  return (
    <>
      {!hideHeader && <Header />}
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
              <LayoutWithSidebar>
                <Dashboard />
              </LayoutWithSidebar>
            }
          />
          <Route
            path="/analytics"
            element={
              <LayoutWithSidebar>
                <Analytics />
              </LayoutWithSidebar>
            }
          />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route path="/tasks" element={<LayoutWithSidebar>
                <Tasks />
              </LayoutWithSidebar>} />
          <Route path="/projects" element={<LayoutWithSidebar>
                <Projects />
              </LayoutWithSidebar>} /><Route path="/tasks" element={<LayoutWithSidebar>
                <Tasks />
              </LayoutWithSidebar>} />
          <Route path="/messages" element={<LayoutWithSidebar>
                <Messages />
              </LayoutWithSidebar>} />
          <Route path="/settings" element={<LayoutWithSidebar>
                <Settings />
              </LayoutWithSidebar>} />    
              
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
