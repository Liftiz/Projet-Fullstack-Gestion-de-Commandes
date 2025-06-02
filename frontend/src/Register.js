import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Register() {
  const [email, setEmail] = useState("");
  const [motDePasse, setMotDePasse] = useState("");
  const navigate = useNavigate();

  const handleRegister = () => {
    axios.post("http://localhost:8081/auth/register", {
      email,
      motDePasse,
    })
    .then(() => {
      alert("Inscription réussie !");
      navigate("/login");
    })
    .catch((err) => {
      console.error(err);
      alert("Erreur lors de l'inscription");
    });
  };

  return (
    <div style={{ padding: "2rem" }}>
      <h2>📝 Créer un compte</h2>
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      /><br /><br />
      <input
        type="password"
        placeholder="Mot de passe"
        value={motDePasse}
        onChange={(e) => setMotDePasse(e.target.value)}
      /><br /><br />
      <button onClick={handleRegister}>S'inscrire</button>
    </div>
  );
}

export default Register;
