# Boutique Stock — Java

Application web locale de démonstration pour gérer les ventes en espèces, le stock, les articles, les comptes et les historiques.

## Démarrage

Double-cliquez sur `run.bat`, puis ouvrez `http://localhost:8080`.

Comptes de démonstration :

- Manager : `manager` / `manager123`
- Caissier : `caissier` / `caissier123`

Pour la démonstration de récupération de mot de passe, utilisez le lien « Mot de passe oublié ? » :

- manager : code de récupération `manager-secure`
- caissier : code de récupération `caissier-secure`

En production, ces codes doivent être remplacés par une vérification par e-mail, SMS ou une question de sécurité stockée de manière chiffrée.

## Déploiement sur Render

1. Créez un dépôt GitHub et importez tous les fichiers de ce dossier.
2. Sur Render, choisissez **New > Web Service**, connectez ce dépôt puis choisissez **Java**.
3. Utilisez `javac App.java` comme commande de build et `java App` comme commande de démarrage.
4. Après le déploiement, Render fournit une adresse `https://...onrender.com` : elle est utilisable sur tous les téléphones.

Le programme utilise automatiquement la variable `PORT` fournie par Render.

Les données sont volontairement enregistrées dans le navigateur pour cette maquette. Pour la version de production, il faudra une base de données et une authentification sécurisée côté serveur.
