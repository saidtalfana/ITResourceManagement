Description du Projet
Ce projet est une application de gestion des équipements informatiques, des pannes et des tickets de support. Il permet aux administrateurs IT de gérer les équipements, les pannes, et les tickets de support. Les utilisateurs peuvent signaler des pannes et suivre l'état de leurs tickets. Les techniciens peuvent traiter les tickets qui leur sont attribués.

User Stories
Gestion des Équipements Informatiques
En tant qu'administrateur IT, je veux pouvoir ajouter de nouveaux équipements informatiques au système afin de suivre leur état et leur utilisation.
En tant qu'administrateur IT, je veux pouvoir modifier les informations des équipements existants pour maintenir des données à jour.
En tant qu'administrateur IT, je veux pouvoir supprimer des équipements obsolètes ou hors service pour garder le système organisé.
En tant qu'administrateur IT, je veux pouvoir voir une liste de tous les équipements avec leur état actuel pour une gestion efficace.
Gestion et Suivi des Pannes
En tant qu'administrateur IT, je veux pouvoir faire la gestion (ajouter, modifier, supprimer) des pannes.
En tant qu'administrateur IT, je veux pouvoir consulter l'historique des pannes pour chaque équipement afin d'identifier les équipements problématiques.
Gestion des Tickets de Support
En tant qu'utilisateur, je veux pouvoir créer un ticket de support pour signaler une panne afin de recevoir de l'aide.
En tant qu'administrateur IT, je veux pouvoir attribuer les tickets de support aux techniciens disponibles pour une résolution rapide.
En tant que technicien IT, je veux pouvoir voir les tickets qui me sont attribués pour les traiter efficacement.
En tant qu'utilisateur, je veux pouvoir suivre l'état de mon ticket de support pour savoir quand mon problème sera résolu.
Bonus
En tant qu'administrateur IT, je veux recevoir des notifications pour les tickets en attente afin de ne pas manquer de demandes importantes.
En tant qu'administrateur IT, je veux pouvoir voir des statistiques sur les pannes pour identifier les tendances et les problèmes récurrents.
En tant qu'administrateur IT, je veux pouvoir générer des rapports sur l'état des équipements pour une meilleure gestion.
En tant qu'administrateur IT, je veux pouvoir générer des rapports sur les performances du service de support pour améliorer l'efficacité.
Fonctionnement
Historique des Pannes : Conserve un enregistrement détaillé de toutes les pannes passées pour chaque équipement. Chaque entrée est liée à un équipement pour suivre les problèmes et réparations.
Tickets de Support : Créés par les utilisateurs lorsqu'ils rencontrent des problèmes avec les équipements. Chaque ticket est lié à un utilisateur spécifique pour suivre les demandes et maintenir une communication efficace.
Attribution des Tickets : Une fois un ticket créé, il est attribué à un technicien pour résolution. Cela permet de suivre quel technicien est responsable et d’évaluer les performances en fonction des tickets résolus.
Technologies Utilisées
Backend : Spring Boot, Spring Data JPA, Spring Security
Frontend : Angular 16
Base de données : PostgreSQL / MySQL
Test unitaire : JUnit
Conteneurisation : Docker
Installation et Exécution﻿# ITResourceManagement
