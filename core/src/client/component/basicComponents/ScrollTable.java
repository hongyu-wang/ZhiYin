package client.component.basicComponents;

import client.singletons.StateManager;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * This is the primary ScrollTable class.
 * This class will just encapsulate all code required without
 *
 *
 * Created by Hongyu Wang on 3/14/2016.
 */
public class ScrollTable {
    /**
     * This is the table
     * that contains all widgets.
     */
    private Table table;

    /**
     * This is the scrollPane that contains the primary table.
     *
     */
    private ScrollPane scrollPane;


    /**
     * This is the primary constructor for ScrollTable
     *
     */
    public ScrollTable() {
        init();
        scrollPane.setBounds(0, 117 * StateManager.M, 750 * StateManager.M, 1100 * StateManager.M);
    }


    public ScrollTable(int x, int y, int width, int height){
        this();
        scrollPane.setBounds(x*StateManager.M, y * StateManager.M, width * StateManager.M, height * StateManager.M);
    }

    /**
     * This sets up the local variables.
     */
    private void init(){
        table = new Table();
        scrollPane = new ScrollPane(table);

    }


    /**
     * This returns the scrollPane that should be added to the stage.
     * @return The scrollPane
     */
    public ScrollPane getPane(){
        return scrollPane;
    }


    /**
     * This adds a given widget into the scrollPane.
     * @param widget The widget to be added.
     */
    public void addToPane(Actor widget){
        table.add(widget);
        table.row();
    }
}
