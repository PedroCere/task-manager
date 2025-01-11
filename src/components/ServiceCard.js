import React from 'react';
import '../styles/ServiceCard.css';

function ServiceCard({ title, description, icon, bgColor, textColor, titleBgColor, titleTextColor }) {
    return (
      <div className="service-card" style={{ backgroundColor: bgColor, color: textColor }}>
        <div className="service-card-header">
          <h3 style={{ backgroundColor: titleBgColor, color: titleTextColor }}>{title}</h3>
          <img className="service-icon" src={icon} alt={`${title} icon`} />
        </div>
        <div className="service-card-body">
          <p className="service-description">
            <img src="/assets/arrow-Icon.png" alt="arrow" className="arrow-Icon" />
            {description}
          </p>
        </div>
      </div>
    );
  }
  
  export default ServiceCard;

