import { useState, useEffect } from 'react';
import type { Question } from '../types';
import { voiceManager } from '../utils/voice';
import './Game.css';

interface GameProps {
  questions: Question[];
  categoryName: string;
  onFinish: (score: number, total: number) => void;
  onBack: () => void;
}

export default function Game({ questions, categoryName, onFinish, onBack }: GameProps) {
  const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
  const [score, setScore] = useState(0);
  const [selectedAnswer, setSelectedAnswer] = useState<number | null>(null);
  const [showFeedback, setShowFeedback] = useState(false);

  const currentQuestion = questions[currentQuestionIndex];

  useEffect(() => {
    // Read the question when it loads
    if (currentQuestion && currentQuestion.voice) {
      const timer = setTimeout(() => {
        voiceManager.speak(currentQuestion.voice!);
      }, 500);
      return () => clearTimeout(timer);
    }
  }, [currentQuestionIndex, currentQuestion]);

  const handleAnswerClick = (answerIndex: number) => {
    if (selectedAnswer !== null) return; // Already answered

    setSelectedAnswer(answerIndex);
    setShowFeedback(true);

    const isCorrect = answerIndex === currentQuestion.correctAnswer;

    if (isCorrect) {
      setScore(score + 1);
      const praises = [
        'Bravo Mete! Çok iyi!',
        'Aferin Mete! Harikasın!',
        'Süpersin Mete!',
        'Mükemmel Mete!',
        'Tebrikler Mete!'
      ];
      // Select random praise on user action
      // eslint-disable-next-line react-hooks/purity
      const randomIndex = Math.floor(Math.random() * praises.length);
      const randomPraise = praises[randomIndex];
      voiceManager.speak(randomPraise);
    } else {
      voiceManager.speak('Tekrar dene Mete, sen yapabilirsin!');
    }

    // Move to next question after 2 seconds
    setTimeout(() => {
      if (currentQuestionIndex < questions.length - 1) {
        setCurrentQuestionIndex(currentQuestionIndex + 1);
        setSelectedAnswer(null);
        setShowFeedback(false);
      } else {
        // Game finished
        onFinish(score + (isCorrect ? 1 : 0), questions.length);
      }
    }, 2000);
  };

  const progress = ((currentQuestionIndex + 1) / questions.length) * 100;

  return (
    <div className="game-container">
      <div className="game-header">
        <button className="back-button" onClick={onBack}>
          ← Geri
        </button>
        <div className="progress-info">
          <h3 className="category-badge">{categoryName}</h3>
          <p className="question-counter">
            Soru {currentQuestionIndex + 1} / {questions.length}
          </p>
        </div>
        <div className="score-badge">
          <span className="score-icon">⭐</span>
          <span className="score-text">{score}</span>
        </div>
      </div>

      <div className="progress-bar">
        <div className="progress-fill" style={{ width: `${progress}%` }} />
      </div>

      <div className="game-content">
        <div className="question-section">
          <h2 className="question-text">
            <span className="mete-highlight">Mete,</span> {currentQuestion.question}
          </h2>
          {currentQuestion.questionEn && (
            <p className="question-english">{currentQuestion.questionEn}</p>
          )}
        </div>

        {currentQuestion.items && currentQuestion.items.length > 0 && (
          <div className="pattern-display">
            {currentQuestion.items.map((item, index) => (
              <div key={index} className="pattern-item">
                {item}
              </div>
            ))}
            <div className="pattern-item pattern-question">?</div>
          </div>
        )}

        <div className="answers-grid">
          {currentQuestion.options.map((option, index) => {
            const isSelected = selectedAnswer === index;
            const isCorrect = index === currentQuestion.correctAnswer;
            const showCorrect = showFeedback && isCorrect;
            const showWrong = showFeedback && isSelected && !isCorrect;

            return (
              <button
                key={index}
                className={`answer-button ${showCorrect ? 'correct' : ''} ${showWrong ? 'wrong' : ''}`}
                onClick={() => handleAnswerClick(index)}
                disabled={selectedAnswer !== null}
              >
                <span className="answer-content">{option}</span>
                {showCorrect && <span className="feedback-icon">✓</span>}
                {showWrong && <span className="feedback-icon">✗</span>}
              </button>
            );
          })}
        </div>
      </div>
    </div>
  );
}
