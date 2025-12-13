import { useEffect } from 'react';
import { voiceManager } from '../utils/voice';
import './Results.css';

interface ResultsProps {
  score: number;
  total: number;
  onPlayAgain: () => void;
  onBackToCategories: () => void;
}

export default function Results({ score, total, onPlayAgain, onBackToCategories }: ResultsProps) {
  const percentage = Math.round((score / total) * 100);

  useEffect(() => {
    // Give feedback based on score
    const timer = setTimeout(() => {
      if (percentage === 100) {
        voiceManager.speak('Mükemmel Mete! Hepsini doğru yaptın! Süpersin!');
      } else if (percentage >= 80) {
        voiceManager.speak('Bravo Mete! Çok iyi iş çıkardın!');
      } else if (percentage >= 60) {
        voiceManager.speak('Aferin Mete! Güzel gidiyor!');
      } else {
        voiceManager.speak('Gayet iyi Mete! Tekrar deneyelim, daha iyi olacak!');
      }
    }, 500);

    return () => clearTimeout(timer);
  }, [percentage]);

  const getMessage = () => {
    if (percentage === 100) return 'Mükemmelsin! 🏆';
    if (percentage >= 80) return 'Harikasın! 🌟';
    if (percentage >= 60) return 'Çok İyi! 👏';
    return 'Gayet İyi! 💪';
  };

  const getEmoji = () => {
    if (percentage === 100) return '🏆';
    if (percentage >= 80) return '🌟';
    if (percentage >= 60) return '😊';
    return '💪';
  };

  return (
    <div className="results-container">
      <div className="results-content">
        <div className="results-header">
          <h1 className="results-title">
            Tebrikler <span className="name-highlight">Mete!</span>
          </h1>
          <div className="big-emoji">{getEmoji()}</div>
        </div>

        <div className="score-display">
          <div className="score-circle">
            <svg className="circle-svg" viewBox="0 0 200 200">
              <circle
                className="circle-bg"
                cx="100"
                cy="100"
                r="90"
              />
              <circle
                className="circle-progress"
                cx="100"
                cy="100"
                r="90"
                style={{
                  strokeDashoffset: 565 - (565 * percentage) / 100
                }}
              />
            </svg>
            <div className="score-text">
              <div className="percentage">{percentage}%</div>
              <div className="score-fraction">{score}/{total}</div>
            </div>
          </div>
          <h2 className="message">{getMessage()}</h2>
        </div>

        <div className="stars-display">
          {[...Array(5)].map((_, index) => (
            <span
              key={index}
              className={`star ${index < Math.ceil(score / total * 5) ? 'filled' : 'empty'}`}
            >
              ⭐
            </span>
          ))}
        </div>

        <div className="results-actions">
          <button className="action-button primary" onClick={onPlayAgain}>
            <span className="button-icon">🔄</span>
            <span>Tekrar Oyna</span>
          </button>
          <button className="action-button secondary" onClick={onBackToCategories}>
            <span className="button-icon">🎯</span>
            <span>Kategoriler</span>
          </button>
        </div>

        <div className="encouragement">
          <p>Mete için hazırlandı ❤️</p>
        </div>
      </div>
    </div>
  );
}
