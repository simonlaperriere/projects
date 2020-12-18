// Par Simon-Olivier Laperrière et Sophie Perreault
package sample;

import com.sun.prism.shader.DrawCircle_Color_Loader;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FlappyGhost extends Application {
    private Controleur controleur;
    private Text score = new Text("Score: " + 0);
    private GraphicsContext context;
    private boolean isPaused = false;
    private boolean isDebug = false;

    /**
     * Fonction principale de l'interface graphique JavaFX
     * @param primaryStage la fenêtre du jeu
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.controleur = new Controleur(this);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 640, 440);


        Canvas canva = new Canvas();
        canva.setWidth(640);
        canva.setHeight(400);

        Platform.runLater(() -> {
            canva.requestFocus();
        });

        scene.setOnMouseClicked((event) -> {
            canva.requestFocus();
        });

        this.context = canva.getGraphicsContext2D();
        AnimationTimer timer = new AnimationTimer() {

            private long startTime = 0;
            double temps = 0;
            int dernierSec = 0;

            @Override
            public void handle(long now) {
                if (startTime == 0) {
                    startTime = now;
                    return;
                }

               if (!isPaused){
                   double dt = (now - startTime)*1e-9;
                    Platform.runLater(() -> {
                        context.clearRect(0,0,640,400);
                        controleur.affichage(dt);
                    });
                   temps += dt;

                   if((int)(temps)-dernierSec == 3){
                        dernierSec = (int) temps;
                        controleur.ajouterObstacle();
                    }
               } else {
                   double dt = (now - startTime)*1e-9;
                   Platform.runLater(() -> {
                       context.clearRect(0,0,640,400);
                       controleur.affichage(0);
                   });
               }

               startTime = now;

            }
        };
        timer.start();

        HBox barre = new HBox();

        Button pause = new Button("Pause");

        pause.setOnAction((event) -> {
            if (isPaused) {
                isPaused = false;
            } else {
                isPaused = true;
            }
        });

        Separator separator1 = new Separator();
        separator1.setOrientation(Orientation.VERTICAL);

        CheckBox debug = new CheckBox("Mode debug");
        debug.setOnAction((event) -> {
            if (debug.isSelected()) {
                isDebug = true;
            } else {
                isDebug = false;
            }
        });

        Separator separator2 = new Separator();
        separator2.setOrientation(Orientation.VERTICAL);

        barre.getChildren().add(pause);
        barre.getChildren().add(separator1);
        barre.getChildren().add(debug);
        barre.getChildren().add(separator2);
        barre.getChildren().add(score);
        barre.setAlignment(Pos.CENTER);

        scene.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.SPACE) { //Space, sauter
                this.controleur.sauter();
            } else if (event.getCode() == KeyCode.ESCAPE) { //Esc, quitter le jeu
                Platform.exit();
            }
        });

        root.setTop(canva);
        root.setBottom(barre);

        primaryStage.setTitle("Flappy Ghost");
        primaryStage.getIcons().add(new Image("sample/ghost.png"));
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Affichage du fantôme
     * @param rayon rayon du fantôme
     * @param x position en x
     * @param y position en y
     * @param image lien de l'image
     */
    public void affichageGhost(int rayon, double x, double y, String image) {
        this.context.setFill(Color.BLACK);
        if (isDebug) {
            this.context.fillOval(x,y,rayon*2,rayon*2);

        } else {
            Image ghost = new Image(image, rayon*2, rayon*2, true, true);
            this.context.drawImage(ghost, x, y);
        }
    }

    /**
     * Affichage d'un obstacle
     * @param rayon rayon de l'obstacle
     * @param x position en x
     * @param y position en y
     * @param image lien de l'image
     * @param collision collision (true) ou non (false)
     */
    public void affichageObstacle(int rayon, double x, double y, String image, boolean collision) {
        if (collision) {
            this.context.setFill(Color.RED);
        } else {
            this.context.setFill(Color.YELLOW);
        }

        if (isDebug) {
            this.context.fillOval(x, y, rayon*2, rayon*2);
        } else {
            Image obstacle = new Image(image, rayon*2, rayon*2, true, true);
            this.context.drawImage(obstacle, x, y);
        }
    }

    /**
     * Affichage du background
     * @param x position en x
     * @param image lien de l'image
     */
    public void affichageBackground(int x, String image) {
        Image background = new Image(image);
        this.context.drawImage(background,x,0);
    }

    /**
     * Affichage du score
     * @param score score actuel
     */
    public void affichageScore(int score) {
        this.score.setText("Score: " + score);
    }

    /**
     * getter du mode debug
     * @return mode debug (true) ou non (false)
     */
    public boolean getIsDebug() {
        return isDebug;
    }

    /**
     * Fonction main du jeu
     */
    public static void main(String[] args) {
        launch(args);
    }
}
