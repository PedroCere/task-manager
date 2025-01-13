
import React from 'react';
import Header from './Header';
import Hero from './components/Hero';
import Services from './components/Services';
import JoinNowSection from './components/JoinNowSection';
import Footer from './components/Footer';
import './App.css';

function App() {
  return (
    <div className="App">
      <Header />
      <Hero />
      <Services />
      <JoinNowSection/>
      <Footer/>
    </div>      
  );
}

export default App;


