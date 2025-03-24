import React, { useEffect, useState } from 'react';
import '../styles/ContentArea.css'; // For additional styles

const ContentArea = () => {
  const [activityData, setActivityData] = useState([]);

  useEffect(() => {
    // Simulate fetching dynamic content
    const fetchData = async () => {
      const data = await fetch('/api/activity'); // Replace with actual API endpoint
      const json = await data.json();
      setActivityData(json);
    };

    fetchData();
  }, []);

  return (
    <div className="content-area">
      <h2>Weekly Activity</h2>
      <ul>
        {activityData.map((activity, index) => (
          <li key={index}>{activity.description}</li>
        ))}
      </ul>
    </div>
  );
};

export default ContentArea;
