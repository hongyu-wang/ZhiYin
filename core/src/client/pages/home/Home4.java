package client.pages.home;


import client.singletons.SkinSingleton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

/**
 * This is the fourth home diary page as given in the
 * art assets folder.
 *
 * Created by Hongyu Wang on 3/9/2016.
 */
public class Home4 extends Home4Shell {
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
    public void update(float fy){
        super.update(fy);

        searchField.getText();//TODO something
    }

    @Override
    public void dispose() {

    }

}
