import axios from "axios";

// Création d'une instance personnalisée
const instance = axios.create({
  baseURL: "http://localhost:8081",
});

// Intercepteur : ajoute le token à chaque requête
instance.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default instance;
