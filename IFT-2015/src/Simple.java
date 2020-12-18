package sample;

public class Simple extends Obstacle {

    /**
     * Constructeur d'obstacle simple
     * @param x position en x
     * @param y position en y
     * @param vy vitesse en y
     * @param rayon rayon de l'obstacle
     * @param image lien de l'image
     */
    public Simple(int x, int y, int vy, int rayon, String image) {
        super(x, y, vy, rayon, image);
    }

    /**
     * Fait bouger l'obstacle
     * @param dt l'intervalle de temps depuis le dernier instant
     * @param vitesseDeroulement la vitesse du jeu
     */
    @Override
    public void bouger(double dt, int vitesseDeroulement) {
        this.x += (int)(vitesseDeroulement * dt);
    }

}
