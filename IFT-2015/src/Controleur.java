package sample;

import java.util.ArrayList;

public class Controleur {
    private FlappyGhost vue;
    private Jeu jeu;

    /**
     * Constructeur du controleur
     * @param vue l'instance vue de l'affichage du jeu
     */
    public Controleur(FlappyGhost vue) {
        this.vue = vue;
        this.jeu = new Jeu();
    }

    /**
     * Fait sauter le fantôme
     */
    public void sauter() {
        jeu.getGhost().sauter();
    }

    /**
     * Appel d'affichage (vue) des éléments du jeu après interactions et mouvements
     * @param dt l'intervalle de temps depuis le dernier instant
     */
    public void affichage(double dt) {
        jeu.bouger(dt);

        Ghost ghost = jeu.getGhost();
        ArrayList<Obstacle> obstacles = jeu.getObstacles();
        Background background = jeu.getBackground();
        Background nextBackground = jeu.getNextBackground();


        if (!jeu.interactions() && !this.vue.getIsDebug()) {
            jeu = new Jeu();
        }

        vue.affichageBackground(background.getX(), background.getImage());
        vue.affichageBackground(nextBackground.getX(), nextBackground.getImage());

        for (int i=0; i<obstacles.size(); i++) {
            if (ghost.collisionObstacle(obstacles.get(i))) {
                vue.affichageObstacle(obstacles.get(i).getRayon(), obstacles.get(i).getX(),
                        obstacles.get(i).getY(), obstacles.get(i).getImage(), true);
            } else {
                vue.affichageObstacle(obstacles.get(i).getRayon(), obstacles.get(i).getX(),
                        obstacles.get(i).getY(), obstacles.get(i).getImage(), false);
            }
        }
        vue.affichageGhost(ghost.getRayon(), ghost.getX(), ghost.getY(), ghost.getImage());

        vue.affichageScore(jeu.getScore());
    }

    /**
     * Ajoute un obstacle au jeu
     */
    public void ajouterObstacle() {
        jeu.ajouterObstacle();
    }



}
