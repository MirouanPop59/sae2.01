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
    private Button btnQuitter;
    private Button btnRecolter;
    private Button btnDeposer;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        initializeGrille();

        ButtonEventHandler ctr = new ButtonEventHandler();
        Group root = new Group();
        VBox vbox = new VBox();
        HBox hBox = new HBox();
        Rectangle rect = new Rectangle(600, 500);
        Rectangle rect2 = new Rectangle(740, 150);
        Button btnQuitter = new Button("Quitter");

        Button btnRecolter = new Button("Récolter");

        Button btnDeposer = new Button("Déposer");

        btnQuitter.setOnAction(ctr);

        Button btnHaut = new Button("Haut");
        Button btnBas = new Button("Bas");
        Button btnDroite = new Button("Droite");
        Button btnGauche = new Button("Gauche");

        vbox.setSpacing(20);
        btnQuitter.setMinWidth(100);
        btnQuitter.setMinHeight(30);
        btnRecolter.setMinWidth(100);
        btnRecolter.setMinHeight(30);
        btnDeposer.setMinWidth(100);
        btnDeposer.setMinHeight(30);
        btnHaut.setMinWidth(100);
        btnHaut.setMinHeight(30);
        btnBas.setMinWidth(100);
        btnBas.setMinHeight(30);
        btnDroite.setMinWidth(100);
        btnDroite.setMinHeight(30);
        btnGauche.setMinWidth(100);
        btnGauche.setMinHeight(30);



        // Création du GrdPanelFX et ajout à la scène
        Monde monde = new Monde(); // Assuming Monde is a class you have
        GrdPanel grdPanelFX = new GrdPanel(monde);
        grdPanelFX.setLayoutX(20); // Positionner le GrdPanelFX
        grdPanelFX.setLayoutY(20);



        hBox.getChildren().addAll(rect, vbox);
        vbox.getChildren().addAll(btnQuitter, btnRecolter, btnDeposer, btnHaut, btnBas, btnDroite, btnGauche);
        root.getChildren().addAll(rect2, vbox, grdPanelFX);
        rect2.setLayoutY(530);
        rect2.setLayoutX(20);
        rect.setFill(Color.LIGHTGRAY);
        rect.setLayoutX(20);
        rect2.setFill(Color.LIGHTGRAY);
        vbox.setLayoutX(630);
        vbox.setLayoutY(100);

        Scene scene = new Scene(root, 780, 700);
        stage.setTitle("ROBOT MINEUR");
        stage.setScene(scene);
        stage.show();
    }

    private void initializeGrille() {
        for (int i = 0; i < LIGNE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                grille[i][j] = (i == 4 && j == 9) ? 1 : 0;
            }
        }
    }
}