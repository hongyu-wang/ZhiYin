package client.component.basicComponents;

import client.singletons.SkinSingleton;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.ui.WorkingTextArea;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 *
 * Created by Hongyu Wang on 3/21/2016.
 */
public class CommentWindow {
    private Window window;
    private WorkingTextArea wta;
    private TextButton cancelButton;
    private TextButton saveButton;
    private String textAreaMessage;
    public CommentWindow(){
        init();



    }

    private void init(){
        initializeButton();
        initializeWindow();
    }
    private void initializeWindow(){
        window = new Window("Comment", SkinSingleton.getInstance());
        window.setBounds(0, 300, wta.getPrefWidth() + 200, wta.getPrefHeight() + 50 + saveButton.getPrefHeight());
        window.add(wta).minWidth(window.getWidth()-20);
        window.row();
        Table table = new Table();
        table.add(saveButton).minWidth(window.getWidth()/2);
        table.add(cancelButton).minWidth(window.getWidth()/2);
        window.add(table);
    }



    private void initializeButton(){
        cancelButton = new TextButton("Cancel", SkinSingleton.getInstance());
        cancelButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                window.remove();
            }
        });
        saveButton = new TextButton("Save", SkinSingleton.getInstance());
        saveButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println(textAreaMessage = wta.getText());
                window.remove();
            }
        });

    }

    public Window getWindow(){
        return window;
    }


}
