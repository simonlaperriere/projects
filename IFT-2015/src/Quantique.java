package sample;

public class Quantique extends Obstacle {
    private double temps;
    private double tempsPrecedent; // pour traiter la condition pause

    /**
     * Constructeur d'obstacle quantique
     * @param x position en x
     * @param y position en y
     * @param vy vitesse en y
     * @param rayon rayon de l'obstacle
     * @param image lien de l'image
     */
    public Quantique(int x, int y, int vy, int rayon, String image) {
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
        this.temps += dt;
        teleportation();
    }

    /**
     * Téléporte l'obstacle quantique dépendamment du temps
     */
    public void teleportation(){
        if ((int)(temps*10) % 2 == 0 && temps != tempsPrecedent) {
            int dx = (int)(Math.random()*((59-0)+1)+0) - 30;
            int dy = (int)(Math.random()*((59-0)+1)+0) - 30;
            this.x += dx;
            this.y += dy;
            tempsPrecedent = temps;
        }
    }
}
