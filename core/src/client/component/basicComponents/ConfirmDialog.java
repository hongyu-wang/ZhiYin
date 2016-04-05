package client.component.basicComponents;

import client.events.executables.internalChanges.ExecutableMultiplexer;
import client.events.executables.internalChanges.TestExecutable;
import client.singletons.SkinSingleton;
import client.stateInterfaces.Executable;
import client.tools.Constants;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by JimGuo on 4/5/16.
 */
public class ConfirmDialog implements Constants{
    private Window window;
    private TextButton [] buttons;
    private String title;

    public ConfirmDialog(String title, String [] options){


        this.title = title;

        buttons = new TextButton[options.length];
        int cnt = 0;
        for (String option : options){
            buttons[cnt] = new TextButton(option, SkinSingleton.getInstance());
            cnt++;
        }

        initWindow();


    }



    private void initWindow(){
        window = new Window("Confirm", SkinSingleton.getInstance());
        Label label = new Label(title, SkinSingleton.getInstance());

        window.setWidth(600*M);
        window.setHeight(400*M);

        label.setWidth(window.getWidth()-200*M);
        label.setWrap(true);

        window.add(label).minWidth(window.getWidth()-100*M).padBottom(100*M);
        window.row();

        Table table = new Table();
        window.row();
        for (TextButton button : buttons){
            table.add(button);

        }
        window.add(table).bottom();
        window.setX(WIDTH*M/2 - window.getWidth()/2);
        window.setY(HEIGHT*M/2 + window.getHeight()/2);
        window.layout();
    }


    /**
     *
     * @param executables
     * @throws IllegalArgumentException If there are too many executables
     */
    public void setUpExecutables(Executable [] executables){
        if (executables.length > buttons.length)
            throw new IllegalArgumentException();

        int difference = buttons.length - executables.length;

        int cnt = 0;
        for (Executable ex : executables){
            buttons[cnt].addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    ex.execute();
                    window.remove();
                }

            });
            cnt ++;
        }

        for (int i = 0; i < difference; i ++){
            buttons[cnt].addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    new TestExecutable("Extra executable").execute();
                    window.remove();
                }

            });
        }

    }

    public Window getWindow(){
        return window;
    }

}
