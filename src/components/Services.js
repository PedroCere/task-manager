import React from 'react';
import ServiceCard from './ServiceCard';
import '../styles/Services.css';
import projectIcon from '../assets/project-icon.png';
import taskIcon from '../assets/task-icon.png';
import commentsIcon from '../assets/comments-icon.png';
import notificationsIcon from '../assets/notifications-icon.png';
import deadlineIcon from '../assets/deadline-icon.png';
import progressIcon from '../assets/progress-icon.png';
import arrowIcon from '../assets/arrow-Icon.png'; 

const servicesData = [
  {
    title: 'Progress Monitoring',
    description: 'Track your progress effortlessly',
    icon: progressIcon,
    bgColor: '#191A23',
    textColor: '#FFFFFF',
    titleBgColor: '#FFFFFF',
    titleTextColor: '#000000',
    arrowIcon: arrowIcon,
    dark: true
  },
  {
    title: 'Task Management',
    description: 'Organize your tasks with ease',
    icon: taskIcon,
    bgColor: '#B9FF66',
    textColor: '#000000',
    titleBgColor: '#FFFFFF',
    titleTextColor: '#000000',
    arrowIcon: arrowIcon,
    dark: false
  },
  {
    title: 'Project Organization',
    description: 'Manage multiple projects effortlessly',
    icon: projectIcon,
    bgColor: '#f3f3f3',
    textColor: '#000000',
    titleBgColor: '#B9FF66',
    titleTextColor: '#000000',
    arrowIcon: arrowIcon,
    dark: false
  },

  {
    title: 'Deadline Tracking',
    description: 'Never miss a deadline',
    icon: deadlineIcon,
    bgColor: '#B9FF66',
    textColor: '#000000',
    titleBgColor: '#FFFFFF',
    titleTextColor: '#000000',
    arrowIcon: arrowIcon,
    dark: false
  },
  {
    title: 'Real-time Notifications',
    description: 'Stay updated with real-time notifications',
    icon: notificationsIcon,
    bgColor: '#f3f3f3',
    textColor: '#000000',
    titleBgColor: '#B9FF66',
    titleTextColor: '#000000',
    arrowIcon: arrowIcon,
    dark: false
  },
  {
    title: 'Comments & Collaboration',
    description: 'Collaborate with your team through comments',
    icon: commentsIcon,
    bgColor: '#191A23',
    textColor: '#FFFFFF',
    titleBgColor: '#FFFFFF',
    titleTextColor: '#000000',
    arrowIcon: arrowIcon,
    dark: true
  },
   
 
  
];

function Services() {
  return (
    <section className="services-section">
      <hr className="services-divider" />
      <div className="services-header">
        <h1 className="services-head">Services</h1>
      </div>
      <div className="services-container">
        {servicesData.map((service, index) => (
          <ServiceCard key={index} {...service} />
        ))}
      </div>
    </section>
  );
}

export default Services;


