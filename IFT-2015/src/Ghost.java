package sample;

public class Ghost extends Figure {
    private int ay;

    /**
     * Constructeur de ghost
     * @param x position en x
     * @param y position en y
     * @param vy vitesse en y
     * @param rayon rayon de la figure
     * @param image lien de l'image
     * @param ay l'accélération en y
     */
    public Ghost(double x, double y, double vy, int rayon, String image, int ay) {
        super(x, y, vy, rayon, image);
        this.ay = ay;
    }

    /**
     * Calcule la distance (élevée à la 2) entre le ghost et un obstacle
     * @param x position en x d'un obstacle
     * @param y position en y d'un obstacle
     * @return la distance entre le ghost et l'obstacle
     */
    public double distance(double x, double y) {
        return (this.x-x)*(this.x-x) + (this.y-y)*(this.y-y);
    }

    /**
     * Vérifie si une collision a lieu entre le ghost et un obstacle
     * @param obstacle un obstacle du jeu
     * @return true s'il y a une collision, false sinon
     */
    public boolean collisionObstacle(Obstacle obstacle) {
        if (distance(obstacle.getX(),obstacle.getY()) <
                (this.rayon + obstacle.getRayon())*(this.rayon + obstacle.getRayon())) {
            return true;
        }
        return false;
    }

    /**
     * Vérifie si le ghost dépasse un obstacle
     * @param obstacle un obstacle du jeu
     * @return true si le ghost a dépassé l'obstacle, false sinon
     */
    public boolean depasserObstacle(Obstacle obstacle) {
        if (obstacle.getX() < this.x - this.rayon) {
            return true;
        }
        return false;
    }
    /**
     * Fait sauter le ghost
     */
    public void sauter() {
        this.vy = -300;
    }

    /**
     * Fait bouger le ghost
     * @param dt l'intervalle de temps depuis le dernier instant
     */
    public void bouger(double dt) {
        double y = this.y + this.vy * dt;

        if (y >= 400 - this.rayon*2) {
            this.y = 400 - this.rayon*2 - 1;
            this.vy = -this.vy;

        } else if (y < 0) {
            this.y = 1;
            this.vy = -this.vy;

        } else {
            this.y = y;
        }

    }

    /**
     * Fait accélerer le ghost
     * @param dt l'intervalle de temps depuis le dernier instant
     */
    public void accelerer(double dt) {
        double vy = this.vy + this.ay * dt;
        if (vy > 300) {
            this.vy = 300;
        } else if (vy < -300) {
            this.vy = -300;
        } else {
            this.vy = vy;
        }
    }

}
