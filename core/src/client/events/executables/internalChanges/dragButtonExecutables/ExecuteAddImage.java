package client.events.executables.internalChanges.dragButtonExecutables;

import client.stateInterfaces.Executable;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


/**
 * Created by Hongyu Wang on 3/24/2016.
 */
public class ExecuteAddImage implements Executable {
    private Stage stage;
    private Image image;
    public ExecuteAddImage(Stage stage, Image image){
        this.stage = stage;
        this.image = image;
    }

    @Override
    public void execute() {
        stage.addActor(image);
    }
}
