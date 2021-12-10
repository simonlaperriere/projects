# Projet final de structures intrinsèques des données

Ce projet a été réalisé dans le cadre du cours d’introduction aux structures intrinsèques des données (MAT-2795). Notre objectif était de démystifier des chants de baleine en utilisant des techniques d’apprentissage de variétés et de réduction de dimensions, nous permettant de regrouper des enregistrements sonores selon leur degré de similarité. Plus spécifiquement, trois algorithmes ont été appliquées sur les spectrogrammes issus des enregistrements recueillis, soient *PCA*, *Isomap* et *t-SNE*. Les données traitées ont aussi éte représentées de façon graphique afin d'illustrer les résultats. Finalement, les résultats issus des différentes techniques ont été comparés afin de déterminer la technique la plus adéquate pour regrouper les enregistrements.

Auteurs: Simon-Olivier Laperrière, Shophika Vaithyanathasarma et Noémie Chenail

## Données

Les enregistrements utilisés proviennent du site internet du [New Bedford Marine Museum](https://whoicf2.whoi.edu/science/B/whalesounds/index.cfm). Ceux-ci proviennent d’une soixantaine d’espèces différentes et totalisent plus de 15000 enregistrements réalisés entre 1940 et 2000 à différents endroits dans le monde par William Watkins et ses collaborateurs.

## Répertoire

Le fichier `projet.ipynb` contient le code utilisé pour effectuer le pré-traitement des fichiers audios et leur conversion en spectrogrammes, l'application des techniques d'apprentissages de variéte et de réduction de dimension ainsi que la production des graphiques.

Le fichier `rapport.pdf` contient notre rapport final.
