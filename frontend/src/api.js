import axios from 'axios';

const API_URL = 'http://localhost:8081/auth';

const api = axios.create({
  baseURL: API_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// ✅ Login: Envía credenciales y guarda el token en localStorage
export const loginUser = async (email, password) => {
  try {
    const response = await api.post('/login', { email, password });
    const { token } = response.data;
    localStorage.setItem('token', token);
    return response.data;
  } catch (error) {
    console.error('Login error:', error.response?.data || error.message);
    throw error;
  }
};

// ✅ Registro: Envía datos para crear una cuenta
export const registerUser = async (userData) => {
  try {
    const response = await api.post('/register', userData);
    return response.data;
  } catch (error) {
    console.error('Registration error:', error.response?.data || error.message);
    throw error;
  }
};

// ✅ Valida si el token JWT sigue siendo válido
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

// ✅ Logout: Borra el token y cierra sesión
export const logoutUser = () => {
  localStorage.removeItem('token');
};

export default api;
