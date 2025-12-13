import { useEffect } from 'react';
import { voiceManager } from '../utils/voice';
import './WelcomeScreen.css';

interface WelcomeScreenProps {
  onStart: () => void;
}

export default function WelcomeScreen({ onStart }: WelcomeScreenProps) {
  useEffect(() => {
    // Greet Mete when the app loads
    const timer = setTimeout(() => {
      voiceManager.speak('Selam Mete! Hadi birlikte öğrenelim!');
    }, 500);

    return () => clearTimeout(timer);
  }, []);

  const handleStart = () => {
    voiceManager.speak('Harika! Hadi başlayalım Mete!');
    setTimeout(() => {
      onStart();
    }, 300);
  };

  return (
    <div className="welcome-screen">
      <div className="welcome-container">
        <div className="welcome-header">
          <h1 className="welcome-title">
            Hoş Geldin
            <span className="child-name"> Mete! 🎉</span>
          </h1>
          <p className="welcome-subtitle">Eğlenceli Zeka Oyunları</p>
        </div>

        <div className="welcome-features">
          <div className="feature-item">
            <span className="feature-icon">🧠</span>
            <p>Zeka Geliştir</p>
          </div>
          <div className="feature-item">
            <span className="feature-icon">🌍</span>
            <p>İngilizce Öğren</p>
          </div>
          <div className="feature-item">
            <span className="feature-icon">🎮</span>
            <p>Eğlenerek Öğren</p>
          </div>
        </div>

        <button className="start-button" onClick={handleStart}>
          <span className="button-icon">🚀</span>
          <span className="button-text">Başla</span>
        </button>

        <div className="welcome-footer">
          <p className="footer-text">Mete için özel olarak hazırlandı ❤️</p>
        </div>
      </div>
    </div>
  );
}
