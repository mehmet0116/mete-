import { useState } from 'react';
import WelcomeScreen from './components/WelcomeScreen';
import CategorySelection from './components/CategorySelection';
import Game from './components/Game';
import Results from './components/Results';
import { categories, questions } from './utils/gameData';
import './App.css';

type GameScreen = 'welcome' | 'categories' | 'game' | 'results';

function App() {
  const [currentScreen, setCurrentScreen] = useState<GameScreen>('welcome');
  const [selectedCategory, setSelectedCategory] = useState<string | null>(null);
  const [finalScore, setFinalScore] = useState({ score: 0, total: 0 });

  const handleStart = () => {
    setCurrentScreen('categories');
  };

  const handleSelectCategory = (categoryId: string) => {
    setSelectedCategory(categoryId);
    setCurrentScreen('game');
  };

  const handleGameFinish = (score: number, total: number) => {
    setFinalScore({ score, total });
    setCurrentScreen('results');
  };

  const handlePlayAgain = () => {
    setCurrentScreen('game');
  };

  const handleBackToCategories = () => {
    setSelectedCategory(null);
    setCurrentScreen('categories');
  };

  const handleBackFromGame = () => {
    setSelectedCategory(null);
    setCurrentScreen('categories');
  };

  const getCategoryQuestions = () => {
    if (!selectedCategory) return [];
    return questions.filter(q => q.category === selectedCategory);
  };

  const getCategoryName = () => {
    if (!selectedCategory) return '';
    const category = categories.find(c => c.id === selectedCategory);
    return category?.name || '';
  };

  return (
    <div className="app">
      {currentScreen === 'welcome' && (
        <WelcomeScreen onStart={handleStart} />
      )}

      {currentScreen === 'categories' && (
        <CategorySelection
          categories={categories}
          onSelectCategory={handleSelectCategory}
        />
      )}

      {currentScreen === 'game' && (
        <Game
          questions={getCategoryQuestions()}
          categoryName={getCategoryName()}
          onFinish={handleGameFinish}
          onBack={handleBackFromGame}
        />
      )}

      {currentScreen === 'results' && (
        <Results
          score={finalScore.score}
          total={finalScore.total}
          onPlayAgain={handlePlayAgain}
          onBackToCategories={handleBackToCategories}
        />
      )}
    </div>
  );
}

export default App;
