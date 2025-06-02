import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import Login from "./Login";
import Register from "./Register";
import Produits from "./Produits";

function App() {
  const [connecté, setConnecté] = useState(false);

  useEffect(() => {
    // Si un token est présent dans le localStorage, on considère l'utilisateur comme connecté
    const token = localStorage.getItem("token");
    setConnecté(!!token);
  }, []);

  const handleLoginSuccess = () => {
    setConnecté(true);
  };

  return (
    <Router>
      <Routes>
        <Route path="/login" element={<Login onLoginSuccess={handleLoginSuccess} />} />
        <Route path="/register" element={<Register />} />

        {/* Route protégée */}
        <Route
          path="/produits"
          element={connecté ? <Produits /> : <Navigate to="/login" />}
        />

        {/* Rediriger vers /produits si connecté, sinon /login */}
        <Route
          path="/"
          element={<Navigate to={connecté ? "/produits" : "/login"} />}
        />
      </Routes>
    </Router>
  );
}

export default App;
