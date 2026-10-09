# RandomBarFinder

Application Android qui propose des bars au hasard, autour de toi ou dans une grande ville de France.

Le projet est écrit en Kotlin avec Jetpack Compose, et utilise Google Maps et l'API Google Places.

## Objectifs

- Afficher sur une carte les bars autour de ma position, avec un rayon que je choisis
- Chercher des bars dans une grande ville de France à la place de ma position
- Présenter les résultats sous forme de liste de cartes, avec la photo du bar à gauche, la note et l'adresse
- Ouvrir la carte et l'itinéraire en cliquant sur un bar
- Proposer un bar au hasard
- Préparer un parcours aléatoire : plusieurs bars tirés au hasard et ordonnés pour s'enchaîner, avec ouverture dans Google Maps

## Statut

Projet en cours de développement.

## Prérequis

- Android Studio récent
- Git
- Un téléphone ou un émulateur sous Android 8.0 (API 26) minimum
- Un projet Google Cloud avec ces deux API activées :
    - Maps SDK for Android
    - Places API (New)

## Installation

1. Clone le dépôt et entre dedans :

   ```bash
   git clone https://github.com/floneema69/RandomBarFinder.git
   cd RandomBarFinder
   ```

2. Crée ta clé API dans la Google Cloud Console (APIs et services, puis Identifiants).

3. À la racine du projet, crée un fichier `local.properties` (il est ignoré par git) et ajoute ta clé :

   ```properties
   MAPS_API_KEY=ta_cle_ici
   ```

   Le fichier `local.defaults.properties` sert d'exemple. Il contient une valeur factice que le plugin Secrets Gradle utilise quand `local.properties` n'a pas de clé.

4. Ouvre le dossier dans Android Studio (File > Open), attends la synchronisation Gradle, puis lance l'appli avec le bouton Run.

## Tester sur l'émulateur

La position par défaut de l'émulateur est en Californie. Dans les contrôles étendus (`...`), onglet Location, entre par exemple les coordonnées de Lyon (45.764, 4.8357) et clique sur Set Location. Relance ensuite l'appli.

## Tester sur un vrai téléphone

1. Active le mode développeur : Paramètres, À propos du téléphone, puis appuie 7 fois sur le numéro de build
2. Active le débogage USB dans les options pour les développeurs
3. Branche le téléphone, accepte la demande d'autorisation, puis choisis-le dans la liste des appareils en haut d'Android Studio

## Clé API et coûts

- Ne publie jamais ta vraie clé. Elle reste dans `local.properties`.
- Restreins la clé aux API utilisées et crée un budget d'alerte dans Google Cloud.
- Les requêtes Places sont facturées au-delà du quota gratuit.
- Les appels Places passent par des requêtes HTTP directes, qui n'envoient pas la signature de l'appli. Une clé restreinte aux "Applications Android" sera donc refusée pour ces appels.

## Auteur

Florian Neema, [@floneema69](https://github.com/floneema69)