import { useState } from "react";
import axios from "axios";

function Login({ onLoginSuccess }) {
  const [email, setEmail] = useState("");
  const [motDePasse, setMotDePasse] = useState("");

  const handleLogin = async () => {
    try {
      const response = await axios.post("http://localhost:8081/auth/login", {
        email,
        motDePasse,
      });

      const token = response.data.token;
      localStorage.setItem("token", token); // ✅ Stockage
      onLoginSuccess(); // Redirige ou recharge les données
    } catch (error) {
      alert("Échec de la connexion");
    }
  };

  return (
    <div style={{ padding: "2rem" }}>
      <h2>🔐 Connexion</h2>
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <br />
      <input
        type="password"
        placeholder="Mot de passe"
        value={motDePasse}
        onChange={(e) => setMotDePasse(e.target.value)}
      />
      <br />
      <button onClick={handleLogin}>Se connecter</button>
    </div>
  );
}

export default Login;
