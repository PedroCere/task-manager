import JoinNow from '../assets/JoinNow.png';
import React from 'react';
import '../styles/JoinNow.css';
import { Link } from 'react-router-dom'; // Import Link for routing

const JoinNowSection = () => {
    return (
      <section className="join-now-section">
        <div className="join-now-container">
          <div className="join-now-content">
            <h2 className="join-now-title">Let’s make things happen</h2>
            <p className="join-now-paragraph">
              Take control of your tasks and projects with Mangly. Join us today and transform the way you work!
            </p>
            <Link to="/register" className="join-now-button">Join Now</Link> {/* Updated to use Link */}
          </div>
          <div className="join-now-image-container">
            <img 
              src={JoinNow} 
              alt="Join Now" 
              className="join-now-image"
            />
          </div>
        </div>
      </section>
    )
}

export default JoinNowSection;
