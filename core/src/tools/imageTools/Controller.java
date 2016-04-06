package tools.imageTools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import org.robovm.apple.foundation.NSErrorException;
import org.robovm.apple.foundation.NSException;
import org.robovm.apple.uikit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 4/2/2016.
 *
 * dont read my comments
 */
public class Controller {

    private static UIImagePickerController UIPC;

    private static Controller controller = new Controller();

    private static UIViewController uivc;
    private static UIView uw;

    private boolean cancelled = false;

    private Controller() {
        initWithCameraRoll();

    }

    private static void initWithCameraRoll(){
        if(UIPC!=null)
            UIPC.dispose();
        UIPC = new UIImagePickerController();
        if (UIPC.isSourceTypeAvailable((UIImagePickerControllerSourceType.PhotoLibrary)))
            UIPC.setSourceType(UIImagePickerControllerSourceType.PhotoLibrary);

        UIPC.setAllowsEditing(true);
        UIPC.getView().setBounds(UIScreen.getMainScreen().getBounds());
        UIPC.getView().setFrame(UIScreen.getMainScreen().getBounds());
        UIPC.setDelegate(new Delegate());
        UIPC.setMediaTypes(UIImagePickerController.getAvailableMediaTypes(UIImagePickerControllerSourceType.PhotoLibrary));

    }

    private static void initWithCamera(){
        if(UIPC!=null)
            UIPC.dispose();
        UIPC = new UIImagePickerController();
        if (UIPC.isSourceTypeAvailable((UIImagePickerControllerSourceType.Camera)))
            UIPC.setSourceType(UIImagePickerControllerSourceType.Camera);
        UIPC.setAllowsEditing(true);
        UIPC.getView().setBounds(UIScreen.getMainScreen().getBounds());
        UIPC.getView().setFrame(UIScreen.getMainScreen().getBounds());
        UIPC.setDelegate(new Delegate());
        UIPC.setMediaTypes(UIImagePickerController.getAvailableMediaTypes(UIImagePickerControllerSourceType.Camera));
    }

    public static Controller getInstance(){
        System.out.println(UIScreen.getMainScreen().getBounds());
        return controller;
    }

    public static void openCameraRoll(){ //THIS MIGHT DO THE THING
        initWithCameraRoll();
        UIViewController test = ((IOSApplication) Gdx.app).getUIViewController(); //??????
        uivc = test.getPresentingViewController();
        uw = test.getView();
        assert(uw!=null);
        test.presentViewController(UIPC, true, null);

    }

    public static void openCamera(){
        initWithCamera();
        UIViewController test = ((IOSApplication) Gdx.app).getUIViewController(); //??????
        uivc = test.getPresentingViewController();
        uw = test.getView();
        assert(uw!=null);
        test.presentViewController(UIPC, true, null);
    }

    public static void closeCameraRoll(){
        UIViewController test = ((IOSApplication) Gdx.app).getUIViewController();

        test.dismissViewController(true, null);
        test.getView().removeFromSuperview();

    }
}
