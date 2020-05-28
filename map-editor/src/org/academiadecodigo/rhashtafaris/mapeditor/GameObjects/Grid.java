package org.academiadecodigo.rhashtafaris.mapeditor.GameObjects;

import org.academiadecodigo.rhashtafaris.mapeditor.FileManager;
import org.academiadecodigo.rhashtafaris.mapeditor.Positioning.GraphicPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.Serializable;

public class Grid implements Serializable{

    private final int COLS = 20;
    private final int ROWS = 20;
    private final int CELL_SIZE = 20;
    private final int PADDING = 10;

    private GraphicPosition[][] drawArray;
    private FileManager fileManager;

    public Grid() {
        new Cursor(this);
        this.drawArray = new GraphicPosition[COLS][ROWS];
        this.fileManager = new FileManager(this);
        gridInit();
        arrayInit();
    }

    public void gridInit() {

        Rectangle cells;

        for (int i = PADDING; i <= (COLS * CELL_SIZE); i += CELL_SIZE) {

            for (int p = PADDING; p <= (ROWS * CELL_SIZE); p += CELL_SIZE) {

                cells = new Rectangle(i, p, CELL_SIZE, CELL_SIZE);
                cells.setColor(Color.BLACK);
                cells.draw();
            }
        }
    }

    public void arrayInit() {

        for (int i=0; i < COLS; i++) {

            for (int p=0; p< ROWS; p++) {

                drawArray[i][p] = new GraphicPosition((i*CELL_SIZE)+PADDING, (p*CELL_SIZE)+PADDING, this);
            }
        }
    }

    public int getCOLS() {
        return COLS;
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCELL_SIZE() {
        return CELL_SIZE;
    }

    public int getPADDING() {
        return PADDING;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public GraphicPosition[][] getDrawArray() {
        return drawArray;
    }

    public void setDrawArray(GraphicPosition[][] array) {
        this.drawArray = array;
    }
}