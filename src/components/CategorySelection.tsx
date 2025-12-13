import type { GameCategory } from '../types';
import { voiceManager } from '../utils/voice';
import './CategorySelection.css';

interface CategorySelectionProps {
  categories: GameCategory[];
  onSelectCategory: (categoryId: string) => void;
}

export default function CategorySelection({ categories, onSelectCategory }: CategorySelectionProps) {
  const handleCategoryClick = (category: GameCategory) => {
    voiceManager.speak(`${category.name} seçtik Mete! Harika seçim!`);
    setTimeout(() => {
      onSelectCategory(category.id);
    }, 300);
  };

  return (
    <div className="category-selection">
      <div className="category-header">
        <h2 className="category-title">
          <span className="title-highlight">Mete</span>, Bir Kategori Seç! 🎯
        </h2>
        <p className="category-subtitle">Hangi konuda oynamak istersin?</p>
      </div>

      <div className="categories-grid">
        {categories.map((category, index) => (
          <button
            key={category.id}
            className="category-card"
            style={{
              backgroundColor: category.color,
              animationDelay: `${index * 0.1}s`
            }}
            onClick={() => handleCategoryClick(category)}
          >
            <div className="category-icon">{category.icon}</div>
            <div className="category-info">
              <h3 className="category-name">{category.name}</h3>
              <p className="category-name-en">{category.nameEn}</p>
            </div>
          </button>
        ))}
      </div>
    </div>
  );
}
