package sample;

import java.util.ArrayList;

public class Jeu {
    private int score;
    private Ghost ghost;
    private ArrayList<Obstacle> obstacles;
    private Background background;
    private Background nextBackground;
    private int vitesseDeroulement;
    private int index = 0;
    private int objetsDepasses = 0;

    /**
     * Constructeur du jeu
     */
    public Jeu() {
        this.score = 0;
        this.ghost = new Ghost(320-30,200-30,220,30,"/sample/ghost.png", 500);
        this.obstacles = new ArrayList<Obstacle>();
        this.background = new Background(0);
        this.nextBackground = new Background(640);
        this.vitesseDeroulement = -120;
    }

    /**
     * Ajoute un obstacle aléatoire
     */
    public void ajouterObstacle() {
        int rayon = (int)(Math.random()*((45-10)+1)+10);
        int noImage = (int)(Math.random()*((26-0)+1)+0);
        int y = (int)(Math.random()*((399-0)+1)+0);
        String image = "/sample/obstacles/" + noImage + ".png";
        int type = (int)(Math.random()*3);

        switch (type) {
            case 0: obstacles.add(new Simple(640 + rayon, y, 0, rayon, image)); break;
            case 1: obstacles.add(new Quantique(640 + rayon, y, 0, rayon, image)); break;
            case 2: obstacles.add(new Sinus(640 + rayon, y, 0, rayon, image)); break;
        }

    }

    /**
     * Augmente le score
     */
    public void augmenterScore() {
        this.score += 5;
    }

    /**
     * Accélère la vitesse du jeu
     */
    public void accelerer() {
        this.vitesseDeroulement -= 15;
    }

    /**
     * Vérifie les interactions entre les éléments du jeu
     * @return collision (false) ou pas (true)
     */
    public boolean interactions() {

        for (int i=0; i<index; i++) {
            if (obstacles.get(i).disparaitre()) {
                obstacles.remove(i);
                i--;
                index--;
            }
        }

        for (int i=index; i<obstacles.size(); i++) {
            if (ghost.collisionObstacle(obstacles.get(i))) {
                return false;
            } else if (ghost.depasserObstacle(obstacles.get(i))) {
                index++;
                objetsDepasses++;
                if (objetsDepasses % 2 == 0) {
                    this.accelerer();
                }
                augmenterScore();
            }

        }


        if (background.getX() <= -640) {
            int dx = background.getX() + 640;
            background = nextBackground;
            nextBackground = new Background(640+dx);
        }
        return true;
    }

    /**
     * Bouge les éléments du jeu
     * @param dt l'intervalle de temps depuis le dernier instant
     */
    public void bouger(double dt) {
        ghost.bouger(dt);
        ghost.accelerer(dt);

        for (int i=0; i<obstacles.size(); i++) {
            obstacles.get(i).bouger(dt, vitesseDeroulement);
        }

        background.bouger(dt, vitesseDeroulement);
        nextBackground.bouger(dt, vitesseDeroulement);
    }

    /**
     * getter du ghost
     * @return ghost
     */
    public Ghost getGhost() {
        return ghost;
    }

    /**
     * getter des obstacles
     * @return ArrayList d'obstacles
     */
    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    /**
     * getter du background
     * @return background
     */
    public Background getBackground() {
        return background;
    }

    /**
     * getter du deuxième background
     * @return deuxième background
     */
    public Background getNextBackground() {
        return nextBackground;
    }

    /**
     * getter de la vitesse du jeu
     * @return vitesse du jeu
     */
    public int getVitesseDeroulement() {
        return vitesseDeroulement;
    }

    /**
     * getter du score
     * @return score
     */
    public int getScore() {
        return score;
    }
}