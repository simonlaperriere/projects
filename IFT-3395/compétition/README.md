#Competition 1

This project was conducted as part of the Fundamentals of machine learning (IFT-3395) class. We took part in a Kaggle competition based on text classification, with the ultimate goal of designing a machine learning algorithm that can automatically sort abstracts from scientific papers of the arXiv dataset. The code given in the file `competition.py` gives an implementation of a Naïve Bayes classifier using Bag of Words features, which allowed us to score an accuracy rate of ~76% on the test data.

Authors: Simon-Olivier Laperrière and Sophie Perreault
N.B.: The data contained in the `test.csv` and `train.csv` files were sampled from the [arXiv database](https://arxiv.org/).

##Usage

In order to work, the file `competition.py` needs to be placed in the same directory as `test.csv` and `train.csv`. To run the program, once in its parent directory, call the command:
```
python competition.py
```
