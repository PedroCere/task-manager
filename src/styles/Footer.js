import '../styles/Footer.css';
import ManglyLogo from '../assets/logo-mangly-blanco.png';
import TwitterLogo from '../assets/twitter-icon.png';
import FacebookLogo from '../assets/facebook-icon.png';

const Footer = () => {
    return (
      <footer className="footer">
        <div className="footer-container">
          <div className="footer-left">
            <div className="footer-logo">
              <img src={ManglyLogo} alt="Mangly Logo" />
            </div>
            <div className="footer-contact">
              <button className="contact-button">Contact Us</button>
              <p>
                Email: info@mangly.com<br />
                Phone: +1 234 567 890<br />
                Address: 123 Mangly St, City, Country
              </p>
            </div>
          </div>
  
          <div className="footer-links">
            <a href="#about-us">About us</a>
            <a href="#services">Services</a>
            <a href="#use-cases">Use Cases</a>
            <a href="#pricing">Pricing</a>
            <a href="#blog">Blog</a>
          </div>
  
          <div className="footer-right">
            <div className="footer-social">
              <img src={FacebookLogo} alt="Facebook" className="social-icon" />
              <img src={TwitterLogo} alt="Twitter" className="social-icon" />
            </div>
            <div className="footer-subscribe">
              <div className="subscribe-container">
                <input
                  type="email"
                  placeholder="Enter your email"
                  className="subscribe-input"
                />
                <button className="subscribe-button">Subscribe to News</button>
              </div>
            </div>
          </div>
        </div>
  
        <div className="footer-bottom">
          <span>© 2025 Mangly. All Rights Reserved.</span>
          <a href="#privacy-policy">Privacy Policy</a>
        </div>
      </footer>
    );
  };

  export default Footer;
  