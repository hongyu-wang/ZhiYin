package client.pages.home;

import client.events.ActionEvent;
import client.pages.State;
import client.singletons.SkinSingleton;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import driver.GameLoop;

/**
 * This is the third home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Home3 extends Home3Shell {
    private TextField searchField;
    public void init() {
        super.init();

        addSearchField();
    }

    private void addSearchField(){
        searchField = new TextField("Search...", SkinSingleton.getInstance());
        searchField.setPosition(26 + 1, 1146);
        searchField.setSize(642, 58);

        stage.addActor(searchField);
    }



    @Override
    public void dispose() {

    }

}
