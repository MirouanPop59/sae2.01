package org.uphf.sae;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class GrdPanel extends Pane {
    private Monde monde;
    private Canvas canvas = new Canvas();

    public GrdPanel(Monde monde) {
        this.monde = monde;
        this.canvas = new Canvas(500,500);
        this.getChildren().add(canvas);
        draw();

    }


    protected void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawGrid(gc);
        drawElements(gc);
    }

    private void drawGrid(GraphicsContext gc) {
        int cellSize = 50;
        gc.setStroke(Color.BLACK);
        for (int i = 0; i <= monde.leMonde.length; i++) {
            gc.strokeLine(i * cellSize, 0, i * cellSize, monde.leMonde.length * cellSize);
            gc.strokeLine(0, i * cellSize, monde.leMonde[0].length * cellSize, i * cellSize);
        }
    }

    private void drawElements(GraphicsContext gc) {
        int cellSize = 50;
        for (int i = 0; i < monde.leMonde.length; i++) {
            for (int j = 0; j < monde.leMonde[i].length; j++) {
                Secteur secteur = monde.leMonde[i][j];
                if (secteur != null) {
                    drawSecteur(gc, secteur, i, j, cellSize);
                }
            }
        }
    }

    private void drawSecteur(GraphicsContext gc, Secteur secteur, int row, int col, int cellSize) {
        int x = col * cellSize;
        int y = row * cellSize;
        // dessin pour les Mines
        if (secteur.visible){
            if (secteur.secteurMine() && !secteur.secteurEau()) {
                for (Mine m : monde.lstMine) {
                    if (secteur.getidBatiement() == m.getIdMine() && m.getTypeMineraiM().equals("NI")) {
                        gc.setFill(Color.GRAY);
                    } else if (secteur.getidBatiement() == m.getIdMine() && m.getTypeMineraiM().equals("OR")) {
                        gc.setFill(Color.YELLOW);
                    }
                }
                gc.fillRect(x, y, cellSize, cellSize);
                gc.setFill(Color.BLACK);
                gc.fillText("M" + secteur.getidBatiement(), x + 10, y + 20);
                // dessin pour les Entrepots
            } else if (secteur.secteurEntrepot() && !secteur.secteurEau()) {
                for (Entrepot e : monde.lstEntrepot) {
                    if (secteur.getidBatiement() == e.getIdEntrepot() && e.getTypeMineraiE().equals("NI")) {
                        gc.setFill(Color.GRAY);
                    } else if (secteur.getidBatiement() == e.getIdEntrepot() && e.getTypeMineraiE().equals("OR")) {
                        gc.setFill(Color.YELLOW);
                    }
                }
                gc.fillRect(x, y, cellSize, cellSize);
                gc.setFill(Color.BLACK);
                gc.fillText("E" + secteur.getidBatiement(), x + 10, y + 20);
                // dessin pour les Robots
            } else if (!secteur.accueilRobot() && !secteur.secteurEau()) {
                for (Robot r : monde.lstRobot) {
                    if (secteur.getidRobot() == r.getIdRobot() && r.getTypeM().equals("NI")) {
                        gc.setFill(Color.GRAY);
                    } else if (secteur.getidRobot() == r.getIdRobot() && r.getTypeM().equals("OR")) {
                        gc.setFill(Color.YELLOW);
                    }
                }
                gc.fillRect(x, y, cellSize, cellSize);
                gc.setFill(Color.BLACK);
                gc.fillText("R" + secteur.getidRobot(), x + 10, y + 40);
            } else if (secteur.secteurEau()) {
                gc.setFill(Color.BLUE);
                gc.fillRect(x, y, cellSize, cellSize);
                gc.setFill(Color.WHITE);
                gc.fillText("Eau", x + 10, y + 40);
            }
        } else{
            gc.setFill(Color.BLACK);
            gc.fillRect(x, y, cellSize, cellSize);
            gc.setFill(Color.WHITE);
            gc.fillText("?", x + 10, y + 40);
        }
    }
}
