// src/components/Hero.js
import React from 'react';
import '../styles/Hero.css';
import ProgressBar from './ProgressBar';

const Hero = () => {
  return (
    <section className="hero">
      <div className="hero-content">
        <h1>All your tasks in one place.</h1>
        <p>
        Organize, prioritize, and achieve your goals effortlessly. Stop worrying about what you need to do and start enjoying the feeling of productivity. Take charge of your day with Mangly
        </p>
        <button className="try-now">Try Now</button>
      </div>
      <div className="progress-bars">
        <ProgressBar progress={30} />
        <ProgressBar progress={80} />
        <ProgressBar progress={60} />
      </div>
    </section>
  );
};

export default Hero;
