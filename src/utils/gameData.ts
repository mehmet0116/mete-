import type { GameCategory, Question } from '../types';

export const categories: GameCategory[] = [
  { id: 'animals', name: 'Hayvanlar', nameEn: 'Animals', icon: '🦁', color: '#FF6B6B' },
  { id: 'numbers', name: 'Sayılar', nameEn: 'Numbers', icon: '🔢', color: '#4ECDC4' },
  { id: 'shapes', name: 'Şekiller', nameEn: 'Shapes', icon: '⭐', color: '#95E1D3' },
  { id: 'colors', name: 'Renkler', nameEn: 'Colors', icon: '🎨', color: '#F38181' },
  { id: 'letters', name: 'Harfler', nameEn: 'Letters', icon: '📝', color: '#AA96DA' },
  { id: 'fruits', name: 'Meyveler', nameEn: 'Fruits', icon: '🍎', color: '#FCBAD3' },
];

export const questions: Question[] = [
  // Animals - Pattern Recognition
  {
    id: 'animal-1',
    type: 'pattern',
    category: 'animals',
    question: 'Mete, hangi hayvan sırada gelecek?',
    questionEn: 'Which animal comes next?',
    items: ['🦁', '🐘', '🦁', '🐘', '🦁'],
    options: ['🐘', '🦁', '🦒', '🐯'],
    correctAnswer: 0,
    voice: 'Aslan, fil, aslan, fil, aslan... Sonra ne gelir Mete?'
  },
  {
    id: 'animal-2',
    type: 'pattern',
    category: 'animals',
    question: 'Desenin devamını bul!',
    questionEn: 'Complete the pattern!',
    items: ['🐶', '🐱', '🐶', '🐱'],
    options: ['🐶', '🐱', '🐭', '🐰'],
    correctAnswer: 0,
    voice: 'Köpek, kedi, köpek, kedi... Sırada ne var?'
  },
  {
    id: 'animal-3',
    type: 'quiz',
    category: 'animals',
    question: 'Cat İngilizce ne demek?',
    questionEn: 'What does Cat mean in Turkish?',
    options: ['🐱 Kedi', '🐶 Köpek', '🐭 Fare', '🐰 Tavşan'],
    correctAnswer: 0,
    voice: 'Cat İngilizce ne demek Mete?'
  },
  {
    id: 'animal-4',
    type: 'quiz',
    category: 'animals',
    question: 'Dog İngilizce ne demek?',
    questionEn: 'What does Dog mean in Turkish?',
    options: ['🐱 Kedi', '🐶 Köpek', '🐭 Fare', '🐰 Tavşan'],
    correctAnswer: 1,
    voice: 'Dog İngilizce ne demek?'
  },
  
  // Numbers - Counting
  {
    id: 'number-1',
    type: 'counting',
    category: 'numbers',
    question: 'Kaç tane yıldız var Mete?',
    questionEn: 'How many stars are there?',
    items: ['⭐', '⭐', '⭐', '⭐', '⭐'],
    options: ['3', '4', '5', '6'],
    correctAnswer: 2,
    voice: 'Kaç tane yıldız var? Sayalım Mete!'
  },
  {
    id: 'number-2',
    type: 'pattern',
    category: 'numbers',
    question: 'Hangi sayı gelecek?',
    questionEn: 'Which number comes next?',
    items: ['1', '2', '3', '4'],
    options: ['5', '6', '3', '1'],
    correctAnswer: 0,
    voice: 'Bir, iki, üç, dört... Sonra hangi sayı gelir Mete?'
  },
  {
    id: 'number-3',
    type: 'quiz',
    category: 'numbers',
    question: 'Five İngilizce kaç demek?',
    questionEn: 'What number is Five?',
    options: ['3', '4', '5', '6'],
    correctAnswer: 2,
    voice: 'Five İngilizce kaç demek?'
  },
  
  // Shapes
  {
    id: 'shape-1',
    type: 'pattern',
    category: 'shapes',
    question: 'Hangi şekil sırada gelecek?',
    questionEn: 'Which shape comes next?',
    items: ['⭐', '⬛', '⭐', '⬛', '⭐'],
    options: ['⬛', '⭐', '🔵', '🔺'],
    correctAnswer: 0,
    voice: 'Yıldız, kare, yıldız, kare, yıldız... Ne gelir Mete?'
  },
  {
    id: 'shape-2',
    type: 'quiz',
    category: 'shapes',
    question: 'Circle İngilizce ne demek?',
    questionEn: 'What shape is Circle?',
    options: ['⭐ Yıldız', '⬛ Kare', '🔵 Daire', '🔺 Üçgen'],
    correctAnswer: 2,
    voice: 'Circle İngilizce ne demek?'
  },
  {
    id: 'shape-3',
    type: 'quiz',
    category: 'shapes',
    question: 'Star İngilizce ne demek?',
    questionEn: 'What shape is Star?',
    options: ['⭐ Yıldız', '⬛ Kare', '🔵 Daire', '🔺 Üçgen'],
    correctAnswer: 0,
    voice: 'Star İngilizce ne demek Mete?'
  },
  
  // Colors
  {
    id: 'color-1',
    type: 'pattern',
    category: 'colors',
    question: 'Hangi renk gelecek?',
    questionEn: 'Which color comes next?',
    items: ['🔴', '🔵', '🔴', '🔵', '🔴'],
    options: ['🔵', '🔴', '🟢', '🟡'],
    correctAnswer: 0,
    voice: 'Kırmızı, mavi, kırmızı, mavi, kırmızı... Ne gelir?'
  },
  {
    id: 'color-2',
    type: 'quiz',
    category: 'colors',
    question: 'Red İngilizce ne demek?',
    questionEn: 'What is Red in Turkish?',
    options: ['🔴 Kırmızı', '🔵 Mavi', '🟢 Yeşil', '🟡 Sarı'],
    correctAnswer: 0,
    voice: 'Red İngilizce ne renk demek?'
  },
  {
    id: 'color-3',
    type: 'quiz',
    category: 'colors',
    question: 'Blue İngilizce ne demek?',
    questionEn: 'What is Blue in Turkish?',
    options: ['🔴 Kırmızı', '🔵 Mavi', '🟢 Yeşil', '🟡 Sarı'],
    correctAnswer: 1,
    voice: 'Blue İngilizce ne renk demek Mete?'
  },
  
  // Letters
  {
    id: 'letter-1',
    type: 'pattern',
    category: 'letters',
    question: 'Hangi harf gelecek?',
    questionEn: 'Which letter comes next?',
    items: ['A', 'B', 'C', 'D'],
    options: ['E', 'F', 'G', 'A'],
    correctAnswer: 0,
    voice: 'A, B, C, D... Hangi harf gelir Mete?'
  },
  {
    id: 'letter-2',
    type: 'quiz',
    category: 'letters',
    question: 'Apple İngilizcede hangi harfle başlar?',
    questionEn: 'What letter does Apple start with?',
    options: ['A', 'B', 'C', 'D'],
    correctAnswer: 0,
    voice: 'Apple hangi harfle başlar?'
  },
  {
    id: 'letter-3',
    type: 'pattern',
    category: 'letters',
    question: 'Alfabede X\'ten sonra ne gelir?',
    questionEn: 'What comes after X in the alphabet?',
    items: ['W', 'X'],
    options: ['Y', 'Z', 'V', 'T'],
    correctAnswer: 0,
    voice: 'W, X... Sonra hangi harf gelir Mete?'
  },
  
  // Fruits
  {
    id: 'fruit-1',
    type: 'pattern',
    category: 'fruits',
    question: 'Hangi meyve gelecek?',
    questionEn: 'Which fruit comes next?',
    items: ['🍎', '🍌', '🍎', '🍌', '🍎'],
    options: ['🍌', '🍎', '🍊', '🍇'],
    correctAnswer: 0,
    voice: 'Elma, muz, elma, muz, elma... Ne gelir?'
  },
  {
    id: 'fruit-2',
    type: 'quiz',
    category: 'fruits',
    question: 'Apple İngilizce ne demek?',
    questionEn: 'What is Apple in Turkish?',
    options: ['🍎 Elma', '🍌 Muz', '🍊 Portakal', '🍇 Üzüm'],
    correctAnswer: 0,
    voice: 'Apple İngilizce ne demek Mete?'
  },
  {
    id: 'fruit-3',
    type: 'quiz',
    category: 'fruits',
    question: 'Banana İngilizce ne demek?',
    questionEn: 'What is Banana in Turkish?',
    options: ['🍎 Elma', '🍌 Muz', '🍊 Portakal', '🍇 Üzüm'],
    correctAnswer: 1,
    voice: 'Banana İngilizce ne demek?'
  },
];
