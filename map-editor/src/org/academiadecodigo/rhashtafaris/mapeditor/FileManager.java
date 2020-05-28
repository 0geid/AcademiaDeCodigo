package org.academiadecodigo.rhashtafaris.mapeditor;

import org.academiadecodigo.rhashtafaris.mapeditor.GameObjects.Grid;
import org.academiadecodigo.rhashtafaris.mapeditor.Positioning.GraphicPosition;

import java.io.*;
import java.util.Arrays;

public class FileManager implements Serializable {

    private Grid grid;

    File file = new File("/home/bob/academiadecodigo/repo1/map-editor/src/org/academiadecodigo/rhashtafaris/mapeditor/saveGrid.dat");

    public FileManager(Grid grid) {
        this.grid = grid;
    }

    public void save() {

        try {

            FileOutputStream fo = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fo);

            out.writeObject(grid.getDrawArray());

            fo.close();
            out.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void load() {

        GraphicPosition[][] array = grid.getDrawArray();

        try {

            System.out.println(Arrays.deepToString(array));

            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fi);

            while (in.read() != -1) {

                array = (GraphicPosition[][]) in.readObject();
            }

            grid.setDrawArray(array);

            System.out.println(Arrays.deepToString(array));

            fi.close();
            in.close();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
