export interface GameCategory {
  id: string;
  name: string;
  nameEn: string;
  icon: string;
  color: string;
}

export interface Question {
  id: string;
  type: 'pattern' | 'matching' | 'counting' | 'memory' | 'quiz';
  category: string;
  question: string;
  questionEn: string;
  options: string[];
  correctAnswer: number;
  items?: string[];
  voice?: string;
}

export interface GameState {
  currentCategory: string | null;
  currentQuestion: number;
  score: number;
  questionsAnswered: number;
  correctAnswers: number;
}
