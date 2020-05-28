package org.academiadecodigo.rhashtafaris.mapeditor.GameObjects;

import org.academiadecodigo.rhashtafaris.mapeditor.FileManager;
import org.academiadecodigo.rhashtafaris.mapeditor.Positioning.GraphicPosition;
import org.academiadecodigo.rhashtafaris.mapeditor.Positioning.GridDirection;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor implements KeyboardHandler {

    private Grid grid;
    private GraphicPosition graphicPosition;

    public Cursor(Grid grid) {
        this.grid = grid;
        cursorInit();
        keyboardInit();
    }

    private void cursorInit() {

        this.graphicPosition = new GraphicPosition(grid.getPADDING(), grid.getPADDING(), grid);
        this.graphicPosition.setColor(Color.GREEN);
    }

    private void drawCell() {

        if (!(grid.getDrawArray()[(this.graphicPosition.getCol() - grid.getPADDING())][(this.graphicPosition.getRow() - grid.getPADDING())].getIsFilled())) {

            grid.getDrawArray()[(this.graphicPosition.getCol() - grid.getPADDING())][(this.graphicPosition.getRow() - grid.getPADDING())].show();
            return;
        }

        grid.getDrawArray()[(this.graphicPosition.getCol() - grid.getPADDING())][(this.graphicPosition.getRow() - grid.getPADDING())].hide();
    }

    private void move(GridDirection direction) {

            switch (direction) {
                case RIGHT:
                    if (!(this.graphicPosition.getCol() +1 == grid.getCOLS()+grid.getPADDING())) {
                        graphicPosition.moveInDirection(GridDirection.RIGHT, 1);
                    }
                    break;
                case LEFT:
                    if (!(this.graphicPosition.getCol() == grid.getPADDING())) {
                        graphicPosition.moveInDirection(GridDirection.LEFT, 1);
                    }
                    break;
                case UP:
                    if (!(this.graphicPosition.getRow() == grid.getPADDING())) {
                        graphicPosition.moveInDirection(GridDirection.UP, 1);
                    }
                    break;
                case DOWN:
                    if (!(this.graphicPosition.getRow()+1 == grid.getROWS()+grid.getPADDING())) {
                        graphicPosition.moveInDirection(GridDirection.DOWN, 1);
                    }
                    break;
            }

    }

    public GraphicPosition getGraphicPosition() {
        return graphicPosition;
    }

    private void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent sPressed = new KeyboardEvent();
        sPressed.setKey(KeyboardEvent.KEY_S);
        sPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent lPressed = new KeyboardEvent();
        lPressed.setKey(KeyboardEvent.KEY_L);
        lPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(upPressed);
        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(spacePressed);
        keyboard.addEventListener(sPressed);
        keyboard.addEventListener(lPressed);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                this.move(GridDirection.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                this.move(GridDirection.LEFT);
                break;
            case KeyboardEvent.KEY_UP:
                this.move(GridDirection.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                this.move(GridDirection.DOWN);
                break;
            case KeyboardEvent.KEY_SPACE:
                drawCell();
                break;
            case KeyboardEvent.KEY_S:
                grid.getFileManager().save();
                break;
            case KeyboardEvent.KEY_L:
                grid.getFileManager().load();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        //nothing
    }
}
