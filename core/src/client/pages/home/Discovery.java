package client.pages.home;


import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdateTags;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.singletons.SkinSingleton;
import client.singletons.StateManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

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

    private ExecuteUpdate update;

    public Discovery(){
        init();
    }

    protected void init() {
        super.init();

        addSearchField();

        table = new Table();
        table.setBounds(50, 0, 650 * StateManager.M, 1134 * StateManager.M);
        table.top();

        stage.addActor(table);

        numTags = 0;

        this.update = new ExecuteUpdateTags(this);
    }

    public void addTag(String tagName){
//        Label tag = new Label(tag, SkinSingleton.getInstance());
        TextButton tag = new TextButton(tagName, SkinSingleton.getInstance());
        final ExecuteToTempState e = new ExecuteToTempState(new Tagged(this, tagName));
        tag.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

//        if(numTags++ % 5 == 0){
//            table.row().padTop(50 * StateManager.M);
//        }
        table.setDebug(true);
        table.add(tag).padLeft(20 * StateManager.M).padRight(20 * StateManager.M);

        table.layout();
    }

    @Override
    public void reset() {
        super.reset();
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
