package org.academiadecodigo.rhashtafaris.mapeditor.Positioning;

import org.academiadecodigo.rhashtafaris.mapeditor.GameObjects.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.Serializable;


public class GraphicPosition extends LogicPosition implements Serializable{

    private transient Rectangle rectangle;
    private Grid grid;
    private boolean isFilled;

    public GraphicPosition(int col, int row, Grid grid) {
        super(col, row, grid);
        this.grid = grid;
        this.rectangle = new Rectangle(col, row, grid.getCELL_SIZE(), grid.getCELL_SIZE());
    }

    @Override
    public void show() {
        this.rectangle.fill();
        this.isFilled = true;
    }

    @Override
    public void hide() {
        this.rectangle.draw();
        this.isFilled = false;
    }

    @Override
    public void moveInDirection(GridDirection direction, int distance) {

        int initialCol = super.getCol();
        int initialRow = super.getRow();

        super.moveInDirection(direction, distance);

        this.rectangle.translate(grid.getCELL_SIZE() * (super.getCol() - initialCol), grid.getCELL_SIZE() * (super.getRow() - initialRow));
    }

    @Override
    public void setColor(Color color) {
        rectangle.setColor(color);
        super.setColor(color);
    }

    public boolean getIsFilled() {
        return isFilled;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void verifyIsFilled() {

        while(true) {

            if (isFilled = true) {
                this.rectangle.fill();
            }
        }
    }

    public void setFilledTrue() {
        isFilled = true;
    }

    public void setFilledFalse() {
        isFilled = false;
    }
}
