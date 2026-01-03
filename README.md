#  Costume Rental Application

## Description du Projet
Application complète de gestion de location de costumes, comprenant une application mobile native (Android Java) et un backend robuste (Laravel API).

##  Structure du Dépôt

### 1. `backend/` (Laravel API)
Le serveur backend gérant la logique métier, l'authentification et la base de données.
- **Technologies** : Laravel 10, MySQL, Sanctum Authentication.
- **Setup** :
  ```bash
  cd backend
  composer install
  cp .env.example .env
  php artisan migrate --seed
  php artisan serve
  ```

### 2. `android_app/` (Application Mobile Native)
L'application principale développée en Java natif sous Android Studio.
- **Fonctionnalités** :
  - Authentification (Login/Register)
  - Catalogue de costumes (RecyclerView)
  - Détails et Réservation (Retrofit)
  - Dashboard Admin
- **Compilation** : Ouvrir dans Android Studio et lancer `Run`.

### 3. `mobile_app/` (Version Flutter - POC)
Une preuve de concept (POC) réalisée en Flutter pour comparer les performances avec la version native.

##  Aperçu de l'Interface

##  Aperçu de l'Interface

### Authentification
| Accueil | Accès Admin | Accès Client |
|---------|-------------|--------------|
| ![Accueil](screenshots/page%201.jpeg) | ![Admin Login](screenshots/Admin%20access.jpeg) | ![Client Login](screenshots/Client%20access.jpeg) |

### 👤 Espace Client
| Accueil Client | Réservation | Confirmation |
|----------------|-------------|--------------|
| ![Home](screenshots/home%20client.jpeg) | ![Book](screenshots/book%20now.jpeg) | ![Confirm](screenshots/booking%20confirmation.jpeg) |

### 🛠️ Espace Admin
| Tableau de Bord | Ajouter Costume |
|-----------------|-----------------|
| ![Dashboard](screenshots/Admin%20Dashboard.jpeg) | ![Add](screenshots/add%20new%20costume.jpeg) |

| Voir Costumes | Voir Clients | Voir Réservations |
|---------------|--------------|-------------------|
| ![Costumes](screenshots/View%20costumes.jpeg) | ![Clients](screenshots/view%20clients.jpeg) | ![Reservations](screenshots/view%20reservations.jpeg) |


##  Auteur
- [Saad-Eddine ID HAISSOUN]
- [Saif-Eddine JABELLAH]
- Groupe : [10]

##  Licence
Projet réalisé dans le cadre du module Mobile/Web 2025.
