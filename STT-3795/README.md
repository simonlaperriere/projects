# Projet final de sciences des données

Ce projet a été réalisé dans le cadre du cours de fondements théoriques en sciences des données (STT-3795). Notre objectif était de mesurer le degré de polarisation des tweets datant de la dernière campagne présidentielle en les classifiant selon une échelle de négativisme-positivisme (*Twitter sentiment analysis*). Différentes méthodes de classification ont été utilisées pour analyser les données: classificateur de Bayes naïf, machine a vecteurs de support (*SVM*), arbres de décision et réseau de neurones. Pour chacune de ces méthodes, différents paramètres ont été optimisés afin d'atteindre une efficacité maximale. Finalement, les différentes méthodes ont été comparées pour déteminer laquelle offrait le meilleur taux de précision pour cette tâche.

Auteurs: Simon-Olivier Laperrière, Juliette Beaulieu-Lépine, Laurent Alsène-Racicot

## Données

Les tweets utilisés pour entraîner les algorithmes proviennent de la banque de données [sentiment140](https://www.kaggle.com/kazanova/sentiment140). Celle-ci contient 1.6 millions de tweets étiquetés en fonction de leur degré de polarisation. Afin de réduire la taille immense de cet ensemble de données, nous avons conservé 100 000 sélectionnés de façon aléatoire.

Les tweets utilisés pour tester les modèles entraînés proviennet quant à eux du compte Twitter de huit démocrates et huit républicains que nous avons sélectionnés. Pour chacun d'eux, nous avons recueilli au plus 200 tweets datant de la semaine en cours (limite imposée par l'API de Twitter).

## Répertoire

Le fichier `projet.ipynb` contient le code utilisé pour effectuer le pré-traitement des tweets, l'entraînement et le test des algorithmes de classification ainsi que la production des graphiques.

Le fichier `rapport.pdf` contient notre rapport final.
