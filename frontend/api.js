import axios from 'axios';

const API_URL = 'http://localhost:8080/auth'; // Base URL del servicio de autenticación

const api = axios.create({
  baseURL: API_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// 🔹 Función para hacer login
export const loginUser = async (email, password) => {
  try {
    const response = await api.post('/login', { email, password });
    const { token } = response.data; // Extraemos el token de la respuesta
    localStorage.setItem('token', token); // Guardamos el token en localStorage
    return response.data;
  } catch (error) {
    console.error('Login error:', error.response?.data || error.message);
    throw error;
  }
};

// 🔹 Función para registrar un nuevo usuario
export const registerUser = async (userData) => {
  try {
    const response = await api.post('/register', userData);
    return response.data;
  } catch (error) {
    console.error('Registration error:', error.response?.data || error.message);
    throw error;
  }
};

// 🔹 Función para validar el token JWT
export const validateToken = async () => {
  const token = localStorage.getItem('token');
  if (!token) return null;

  try {
    const response = await api.get(`/validate?token=${token}`);
    return response.data;
  } catch (error) {
    console.error('Token validation error:', error.response?.data || error.message);
    return null;
  }
};

// 🔹 Función para cerrar sesión
export const logoutUser = () => {
  localStorage.removeItem('token'); // Eliminamos el token
};

export default api;
