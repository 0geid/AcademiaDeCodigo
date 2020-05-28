package org.academiadecodigo.rhashtafaris.mapeditor.Positioning;

import org.academiadecodigo.rhashtafaris.mapeditor.GameObjects.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;

public abstract class LogicPosition {
    private int col;
    private int row;
    private Color color;
    private Grid grid;


    public LogicPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
        show();
    }

    public abstract void show();

    public abstract void hide();

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setColor(Color color) {
        this.color = color;
        show();
    }

    public void moveInDirection(GridDirection direction, int distance) {

        switch (direction) {

            case RIGHT:
                moveRight(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
        }
    }

    private void moveUp(int dist) {

        int maxRowsUp = dist < getRow() ? dist : getRow();
        setPos(getCol(), getRow() - maxRowsUp);
    }


    private void moveDown(int dist) {

        int maxRowsDown = dist > grid.getROWS()*grid.getCELL_SIZE() - (getRow() + 1) ? grid.getROWS()*grid.getCELL_SIZE() - (getRow() + 1) : dist;
        setPos(getCol(), getRow() + maxRowsDown);
    }


    private void moveLeft(int dist) {

        int maxRowsLeft = dist < getCol() ? dist : getCol();
        setPos(getCol() - maxRowsLeft, getRow());
    }

    private void moveRight(int dist) {

        int maxRowsRight = dist > getGrid().getCOLS()*grid.getCELL_SIZE() - (getCol() + 1) ? getGrid().getCOLS()*grid.getCELL_SIZE() - (getCol() + 1) : dist;
        setPos(getCol() + maxRowsRight, getRow());
    }
}