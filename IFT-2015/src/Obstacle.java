package sample;

public abstract class Obstacle extends Figure {

    /**
     * Constructeur d'obstacle
     * @param x position en x
     * @param y position en y
     * @param vy vitesse en y
     * @param rayon rayon de l'obstacle
     * @param image lien de l'image
     */
    public Obstacle(double x, double y, double vy, int rayon, String image) {
        super(x, y, vy, rayon, image);
    }

    /**
     * Verifie si un obstacle dépasse l'écran de jeu
     * @return true si l'obstacle dépasse, false sinon
     */
    public boolean disparaitre() {
        if (this.x < -this.rayon) {
            return true;
        }
        return false;
    }

    /**
     * Fait bouger l'obstacle
     * @param dt l'intervalle de temps depuis le dernier instant
     * @param vitesseDeroulement la vitesse du jeu
     */
    public abstract void bouger(double dt, int vitesseDeroulement);

}
