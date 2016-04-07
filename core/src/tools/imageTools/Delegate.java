package tools.imageTools;

import client.pageStorage.Pages;
import client.pages.musicDiary.Diary2;
import client.pages.other.MyProfile;
import client.singletons.StateManager;
import client.tools.ImageParser;
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
        if(StateManager.getInstance().getCurrentState() == Pages.MYPROFILE.getStateReference())
            ((MyProfile)Pages.MYPROFILE.getStateReference()).attemptSetUpImage();
        if(StateManager.getInstance().getCurrentState() instanceof Diary2){
            ((Diary2)StateManager.getInstance().getCurrentState()).attemptSetUpImage();
        }
    }

    @Override
    public void didCancel(UIImagePickerController uiImagePickerController) {

        ImageParser.setUpImage(null, true);
        Controller.getInstance().closeCameraRoll();
        System.out.println("canceled");
    }
}
