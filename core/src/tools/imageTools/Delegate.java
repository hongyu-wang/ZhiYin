package tools.imageTools;

import client.singletons.StateManager;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import org.robovm.apple.uikit.*;

/**
 * Created by Kevin on 4/2/2016.
 */
class Delegate extends UINavigationControllerDelegateAdapter implements UIImagePickerControllerDelegate{
    @Override
    public void didFinishPickingMedia(UIImagePickerController uiImagePickerController, UIImagePickerControllerEditingInfo uiImagePickerControllerEditingInfo) {
        UIImage image = uiImagePickerControllerEditingInfo.getOriginalImage();

        assert(image != null);
        byte[] bytes = image.toPNGData().getBytes();
        //Pixmap temp = new Pixmap(bytes,0,bytes.length);
        //Texture draw = new Texture(temp);
        //temp.dispose();
        //Image im = new Image(draw);
        //im.setBounds(0,0,100,100);
        //StateManager.getInstance().currentState.getStage().addActor(im);
        //Controller.getInstance().closeCameraRoll();
        System.out.println("finished picking media");
    }

    @Override
    public void didCancel(UIImagePickerController uiImagePickerController) {
        Controller.getInstance().closeCameraRoll();
        System.out.println("canceled");
    }
}
