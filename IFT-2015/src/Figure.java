package sample;

public abstract class Figure {
    protected double x;
    protected double y;
    protected double vy;
    protected int rayon;
    protected String image;

    /**
     * Constructeur de figure
     * @param x position en x
     * @param y position en y
     * @param vy vitesse en y
     * @param rayon rayon de la figure
     * @param image lien de l'image
     */
    public Figure(double x, double y, double vy, int rayon, String image) {
        this.x = x;
        this.y = y;
        this.vy = vy;
        this.rayon = rayon;
        this.image = image;
    }

    /**
     * setter de la position en x
     * @param x la nouvelle position en x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getter de la position en x
     * @return la position en x
     */
    public double getX() {
        return x;
    }

    /**
     * setter de la position en y
     * @param y la nouvelle position en y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * getter de la position en y
     * @return la position en y
     */
    public double getY() {
        return y;
    }

    /**
     * setter de la vitesse en y
     * @param vy la nouvelle vitesse en y
     */
    public void setVy(int vy) {
        this.vy = vy;
    }

    /**
     * getter de la vitesse en y
     * @return la vitesse en y
     */
    public double getVy() {
        return vy;
    }

    /**
     * getter du rayon
     * @return le rayon
     */
    public int getRayon() {
        return rayon;
    }

    /**
     * getter du lien de l'image
     * @return le lien de l'image
     */
    public String getImage() {
        return image;
    }
}
