package tools.imageTools;

import org.robovm.apple.uikit.UIImagePickerController;
import org.robovm.apple.uikit.UIImagePickerControllerDelegate;
import org.robovm.apple.uikit.UIImagePickerControllerEditingInfo;
import org.robovm.apple.uikit.UINavigationControllerDelegateAdapter;

/**
 * Created by Kevin on 4/2/2016.
 */
class Delegate extends UINavigationControllerDelegateAdapter implements UIImagePickerControllerDelegate{
    @Override
    public void didFinishPickingMedia(UIImagePickerController uiImagePickerController, UIImagePickerControllerEditingInfo uiImagePickerControllerEditingInfo) {
        System.out.println("finished picking media");
    }

    @Override
    public void didCancel(UIImagePickerController uiImagePickerController) {
        System.out.println("canceled");
    }
}
