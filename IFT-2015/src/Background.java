package sample;

public class Background {
    private int x;
    private String image = "/sample/bg.png";

    public Background(int x) {
        this.x = x;
    }

    public void bouger(double dt, int vitesseDeroulement) {
        this.x += (int)(vitesseDeroulement * dt);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getImage() {
        return image;
    }
}
