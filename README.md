# Projet Technologie Web

[![forthebadge](http://forthebadge.com/images/badges/built-with-love.svg)](http://forthebadge.com)

RoseMarket Application
On se propose de réaliser une application web J2EE, en respectant au mieux l'architecture MVC (DAO, JSP).
On utilise la base de données « comptoirs » fournie sur Moodle.
Schéma de la base de données : les clients passent des commandes, les commandes référencent des produits, les produits appartiennent a des catégories. 
L'application est destinée à deux catégories d'utilisateurs : Les clients et l'administrateur.

## Pour commencer

* Le client doit pouvoir s'authentifier pour accéder à ses différents paramètres. Pour se connecter il utilise son « contact » en tant qu’identifiant et son « code » en tant que mot de passe. Exemple de login/password : 
———————————————                                                             
  Elizabeth Lincoln / BOTTM      
  Hanna Moos / BLAUS       
  Antonio Moreno / ANTON      
  Aria Cruz / FAMIA      
———————————————

Une fois authentifié, l'application doit permettre au client l'édition de ses commandes à l’aide d’un caddie. Une des prochaines modifications de l'application sera d'ajouter la possibilité de supprimer, modifier la quantité d'un élement du panier.
Il doit pouvoir également voir l’historique de ses commandes et pouvoir modifier ses informations personnelles via l’onglet « Mon Compte »

* L'administrateur s'authentifie en utilisant un login / password prédéfini (admin/mdp). 
Une fois authentifié, l'administrateur a accès à une série de tableaux de bord graphiques qui lui permettent de visualiser des statistiques sur les commandes saisies :                             
--Visualiser les chiffres d'affaire par catégorie d'article.                                       
--Visualiser les chiffres d'affaire par zone géographique.                               
--Visualiser les chiffres d'affaire par client.
Une des prochaines modifications de l'application sera de pouvoir choisir la période (date de début / date de fin) sur laquelle doit porter la statistique.
Pour l'affichage des graphiques, nous avons utilisé la charte graphique GoogleChart en JavaScript.


## Démarrage

Vous pouvez cloner le projet sur l'IDE et le lancer.


## Auteurs

Projet réalisé par : 
* **Marisol CANAVY** _alias_ [@MarisolCanavy](https://github.com/MarisolCanavy)
* **Marie NOURRISSON** _alias_ [@Marienrs](https://github.com/Marienrs)
* **Emma SALVAN** _alias_ [@EmmaSalvan](https://github.com/EmmaSalvan)


Nous nous sommes réparties les tâches. Marisol a travaillé sur la partie login et administrateur. Marie et Emma se sont occupés de la partie commandes client. Enfin, nous avons travaillé en coopération sur la partie édition du profil client.
Afin d’améliorer l’esthétique de notre application, Marisol a ajouté des pages CSS, réalisées avec un framework personnalisé.

Merci d'avoir pris le temps de visiter notre Application Web RoseMarket.



