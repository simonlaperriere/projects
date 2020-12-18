package sample;

public class Sinus extends Obstacle {
    private double OMEGA = Math.PI;
    private int AMPLITUDE = 25;
    private double initialY;
    private double totalDt;

    /**
     * Constructeur d'obstacle sinus
     * @param x position en x
     * @param y position en y
     * @param vy vitesse en y
     * @param rayon rayon de l'obstacle
     * @param image lien de l'image
     */
    public Sinus(double x, double y, int vy, int rayon, String image) {
        super(x, y, vy, rayon, image);
        initialY = y;
    }

    /**
     * Fait bouger l'obstacle
     * @param dt l'intervalle de temps depuis le dernier instant
     * @param vitesseDeroulement la vitesse du jeu
     */
    @Override
    public void bouger(double dt, int vitesseDeroulement) {
        totalDt += dt;
        this.x += (int)(vitesseDeroulement * dt);
        this.y = initialY + Math.sin(totalDt * OMEGA)*AMPLITUDE;
    }

}
