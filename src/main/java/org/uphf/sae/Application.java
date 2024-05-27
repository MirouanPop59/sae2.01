package org.uphf.sae;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    private static final int LIGNE = 10;
    private static final int COLONNE = 10;
    private int[][] grille = new int[LIGNE][COLONNE]; // La grille en Java

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        initializeGrille();

        HelloManager ctr = new HelloManager();
        Group root = new Group();
        Stage stg = new Stage();
        VBox vbox = new VBox();
        HBox hBox = new HBox();
        Rectangle rect = new Rectangle(600, 500);
        Rectangle rect2 = new Rectangle(740, 150);
        Button btnQuitter = new Button("Quitter");
        Button btnRecolter = new Button("Récolter");
        Button btnDeposer = new Button("Déposer");
        Button btnCommencer = new Button("Commencer");

        btnQuitter.setOnAction(ctr);

        Rectangle haut = new Rectangle(40, 40);
        Rotate rot = new Rotate();
        rot.setAngle(45);
        haut.getTransforms().addAll(rot);
        haut.setLayoutX(660);
        haut.setLayoutY(310);
        haut.setFill(Color.rgb(218, 189, 255));

        Rectangle bas = new Rectangle(40, 40);
        rot.setAngle(45);
        bas.getTransforms().addAll(rot);
        bas.setLayoutX(660);
        bas.setLayoutY(375);
        bas.setFill(Color.rgb(218, 189, 255));

        Rectangle droite = new Rectangle(40, 40);
        rot.setAngle(45);
        droite.setFill(Color.BLUE);
        droite.getTransforms().addAll(rot);
        droite.setLayoutX(692);
        droite.setLayoutY(342.5);
        droite.setFill(Color.rgb(218, 189, 255));

        Rectangle gauche = new Rectangle(40, 40);
        rot.setAngle(45);
        gauche.getTransforms().addAll(rot);
        gauche.setLayoutX(628);
        gauche.setLayoutY(342.5);
        gauche.setFill(Color.rgb(218, 189, 255));

        vbox.setSpacing(20);
        btnQuitter.setMinWidth(100);
        btnQuitter.setMinHeight(30);
        btnRecolter.setMinWidth(100);
        btnRecolter.setMinHeight(30);
        btnDeposer.setMinWidth(100);
        btnDeposer.setMinHeight(30);
        btnCommencer.setMinWidth(100);
        btnCommencer.setMinHeight(30);

        Pane p = new Pane();
        for (int i = 0; i < LIGNE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                Rectangle r = new Rectangle(45, 45);
                r.setLayoutX(60 + j * 48);  // Calcul de la position X
                r.setLayoutY(10 + i * 48);  // Calcul de la position Y
                if (grille[i][j] == 1) {
                    r.setFill(Color.BLUE);
                } else {
                    r.setFill(Color.GREEN);
                }
                root.getChildren().add(r);
            }
        }

        btnCommencer.setOnAction(ctr);

        hBox.getChildren().addAll(rect, vbox);
        vbox.getChildren().addAll(btnQuitter, btnRecolter, btnDeposer, btnCommencer);
        root.getChildren().addAll(rect2, vbox, droite, haut, bas, gauche);
        rect2.setLayoutY(510);
        rect2.setLayoutX(20);
        rect.setFill(Color.LIGHTGRAY);
        rect.setLayoutX(20);
        rect2.setFill(Color.LIGHTGRAY);
        vbox.setLayoutX(610);
        vbox.setLayoutY(100);

        Scene scene = new Scene(root, 780, 700);
        stage.setTitle("ROBOT MINEUR");
        stage.setScene(scene);
        stage.show();
    }

    private void initializeGrille() {
        for (int i = 0; i < LIGNE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                grille[4][9] = 1;
            }
        }
    }
}