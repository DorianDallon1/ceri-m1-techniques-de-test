# UCE Génie Logiciel Avancé : Techniques de tests

## Nom et Prénom
Dallon Dorian

## Groupe
M1 Alternant ILSEN

## Badges

![CircleCI](https://circleci.com/gh/DorianDallon1/ceri-m1-techniques-de-test.svg?style=svg)  
[![codecov](https://codecov.io/github/DorianDallon1/ceri-m1-techniques-de-test/graph/badge.svg?token=C49PKWXVLO)](https://codecov.io/github/DorianDallon1/ceri-m1-techniques-de-test)

![Checkstyle](https://img.shields.io/badge/code--style-checkstyle-brightgreen)
[![Javadoc](https://img.shields.io/badge/Javadoc-100%25-brightgreen)](https://doriandallon1.github.io/ceri-m1-techniques-de-test)

## Documentation

La documentation Javadoc est disponible ici :  
[Voir la Javadoc](https://doriandallon1.github.io/ceri-m1-techniques-de-test)

## TP 6 rapport

J'ai ajouté le code de la team rocket à la place de mon ancien code PokemonFactory, dans ce code aquali n'est pas ajouté à la liste des pokémon dans index2map.
J'ai donc du le supprimer du test original pour qu'il passe le test. Ensuite le 2e test initial était en cas d'index invalide mais le cas n'étais pas gérer par la team rocket.
J'ai donc modifier la ligne correspondant pour que le test passe.
J'ai aussi du ajouter un test en cas d'index négatif.


## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
