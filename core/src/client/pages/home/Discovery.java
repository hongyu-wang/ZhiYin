package client.pages.home;


import client.events.executables.internalChanges.serverInteractions.ExecuteUpdate;
import client.events.executables.internalChanges.serverInteractions.ExecuteUpdateTags;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteToTempState;
import client.pageStorage.Pages;
import client.pages.other.TransitionType;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Gesturable;
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
public class Discovery extends DiscoveryShell implements Gesturable{
    private Table table;
    private TextField searchField;

    private float currentWidth;
    private int numTags;

    private ExecuteUpdate update;

    public Discovery(){
        init();
    }

    protected void init() {
        super.init();

        addSearchField();

        table = new Table();
        table.top();
        table.setBounds(0, 0, 750*M, 1134*M);
        stage.addActor(table);

        currentWidth = 0;
        numTags = 0;

        this.update = new ExecuteUpdateTags(this);
    }

    public void addTag(String tagName){
        TextButton tag = new TextButton(tagName, SkinSingleton.getInstance());
        final ExecuteToTempState e = new ExecuteToTempState(new Tagged(this, tagName), TransitionType.FADE_IN);
        tag.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                e.execute();
            }
        });

        if(numTags++ % 3 == 0){
            table.row().padTop(50*M);
        }
        table.add(tag).center().padLeft(20*M).padRight(20*M);

//        addWrapped(tag);

//        table.setDebug(true);
    }

    private void addWrapped(TextButton tag){
        float newWidth = currentWidth + tag.getWidth();// + 40*M;
        if(newWidth >= 750*M){
            table.row().padTop(50*M);
            currentWidth = 0;
        }

        table.add(tag).width(tag.getWidth()).center();//.maxWidth(tag.getWidth());//.padLeft(20*M).padRight(20*M);
        currentWidth = currentWidth + tag.getWidth();// + 40*M;

//        System.out.println("tag width: " + tag.getWidth());
//        System.out.println("current width: " + currentWidth);
    }

    @Override
    public void reset() {
        super.reset();
        searchField.remove();
        addSearchField();
    }


    private void addSearchField(){
        searchField = new WorkingTextArea("Search...", SkinSingleton.getInstance());
        searchField.setPosition(26*M, 1146*M);
        searchField.setSize((750 - 26*2)*M, 58*M);
        stage.addActor(searchField);
    }

    @Override
    public void update(float fy){
        super.update(fy);

        searchField.getText();//TODO something
    }


    @Override
    public void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX) {
        if(gestureXRight && directionMainlyX)
            new ExecuteChangePage(Pages.ARTIST, TransitionType.LEFT_TO_RIGHT).execute();
    }
}
