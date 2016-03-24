package client.pages.home;


import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;

import static client.singletons.StateManager.M;

/**
 * This is the fourth home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Discovery extends DiscoveryShell {
    private Table table;

    private int numTags;

    private TextField searchField;

    public void init() {
        super.init();

        addSearchField();

        table = new Table();
        table.setBounds(0, 0, 750 * StateManager.M, 1134 * StateManager.M);
        table.top();

        stage.addActor(table);

        numTags = 0;

        addTag("tag1");
        addTag("tag2");
        addTag("tag3");
        addTag("tag4");
        addTag("tag5");
        addTag("tag6");
        addTag("tag7");
        addTag("tag8");
        addTag("tag9");
        addTag("tag10");
        addTag("tag11");
        addTag("tag12");
        addTag("tag13");
        addTag("tag14");
        addTag("tag15");
        addTag("tag16");
        addTag("tag17");
        addTag("tag18");
        addTag("tag19");
        addTag("tag20");
    }

    public void addTag(String tag){
        Label label = new Label(tag, SkinSingleton.getInstance());
        if(numTags++ % 5 == 0){
            table.row().padTop(50 * StateManager.M);
        }
        table.add(label).padLeft(20 * StateManager.M).padRight(20 * StateManager.M);
    }

    @Override
    public void reset() {
        searchField.remove();
        addSearchField();
    }

    private void addSearchField(){
        searchField = new WorkingTextArea("Search...", SkinSingleton.getInstance());
        searchField.setPosition((26 + 1) * M, 1146 * M);
        searchField.setSize((750 - 26*2) * M, 58 * M);
        stage.addActor(searchField);
    }

    @Override
    public void update(float fy){
        super.update(fy);

        searchField.getText();//TODO something
    }

    @Override
    public void dispose() {

    }

}
