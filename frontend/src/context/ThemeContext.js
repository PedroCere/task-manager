// src/context/ThemeContext.js
import React, { createContext, useState, useContext } from 'react';

// Crear el contexto
const ThemeContext = createContext();

// Proveedor del contexto
export const ThemeProvider = ({ children }) => {
  const [theme, setTheme] = useState('light'); // Por defecto es modo claro

  // Función para alternar entre temas
  const toggleTheme = () => {
    setTheme((prevTheme) => (prevTheme === 'light' ? 'dark' : 'light'));
  };

  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      {children}
    </ThemeContext.Provider>
  );
};

// Hook para usar el contexto más fácilmente
export const useTheme = () => useContext(ThemeContext);
