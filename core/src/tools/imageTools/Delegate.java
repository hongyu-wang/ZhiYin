package tools.imageTools;

import client.pageStorage.Pages;
import client.pages.other.MyProfile;
import client.singletons.StateManager;
import client.tools.ImageParser;
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

        Controller.getInstance().closeCameraRoll();
        ImageParser.setUpImage(bytes, false);
        System.out.println("finished picking media");
        ((MyProfile)Pages.MYPROFILE.getStateReference()).attemptSetUpImage();
    }

    @Override
    public void didCancel(UIImagePickerController uiImagePickerController) {

        ImageParser.setUpImage(null, true);
        Controller.getInstance().closeCameraRoll();
        System.out.println("canceled");
    }
}
