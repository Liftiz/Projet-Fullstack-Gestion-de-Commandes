import { useEffect, useState } from "react";
import axios from "axios";

function Produits() {
  const [produits, setProduits] = useState([]);
  const [nom, setNom] = useState("");
  const [prix, setPrix] = useState("");

  // Récupérer tous les produits
  useEffect(() => {
    axios.get("http://localhost:8081/produits")
      .then(res => setProduits(res.data))
      .catch(err => console.error(err));
  }, []);

  const ajouterProduit = () => {
    axios.post("http://localhost:8081/produits", {
      nom: nom,
      prix: parseFloat(prix)
    }).then(() => {
      setNom("");
      setPrix("");
      window.location.reload(); // Recharge la page pour rafraîchir la liste
    });
  };

  return (
    <div style={{ padding: "2rem" }}>
      <h2>📦 Produits</h2>
      <ul>
        {produits.map((p, i) => (
          <li key={i}>{p.nom} – {p.prix} €</li>
        ))}
      </ul>

      <h3>➕ Ajouter un produit</h3>
      <input
        type="text"
        placeholder="Nom du produit"
        value={nom}
        onChange={(e) => setNom(e.target.value)}
      />
      <input
        type="number"
        placeholder="Prix"
        value={prix}
        onChange={(e) => setPrix(e.target.value)}
      />
      <button onClick={ajouterProduit}>Ajouter</button>
    </div>
  );
}

export default Produits;
