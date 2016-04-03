//package tools.imageTools;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
//import org.robovm.apple.uikit.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Kevin on 4/2/2016.
// *
// * dont read my comments
// */
//public class Controller {
//
//    private static UIImagePickerController UIPC;
//
//    private static Controller controller = new Controller();
//
//    private Controller() {
//        UIPC = new UIImagePickerController();
//        if (UIPC.isSourceTypeAvailable((UIImagePickerControllerSourceType.PhotoLibrary)))
//            UIPC.setSourceType(UIImagePickerControllerSourceType.PhotoLibrary);
//        List<String> s = new ArrayList<>();
//        s.add("kUTTypeImage");
//        UIPC.setMediaTypes(s);
//        UIPC.setAllowsEditing(true);
//        UIPC.getView().setBounds(UIScreen.getMainScreen().getBounds());
//        UIPC.getView().setFrame(UIScreen.getMainScreen().getBounds());
//        UIPC.setDelegate(new Delegate());
//        UIPC.setMediaTypes(UIPC.getAvailableMediaTypes(UIImagePickerControllerSourceType.PhotoLibrary).subList(0, 1));
//        System.out.println(UIPC.getAvailableMediaTypes(UIImagePickerControllerSourceType.PhotoLibrary).subList(0, 1));
//    }
//
//    public static Controller getInstance(){
//        System.out.println(UIScreen.getMainScreen().getBounds());
//        return controller;
//    }
//
//    public static void testOpen(){ //THIS MIGHT DO THE THING
//
//        UIViewController test = ((IOSApplication) Gdx.app).getUIViewController(); //??????
//        test.addChildViewController(UIPC);
//        test.getView().setBounds(UIScreen.getMainScreen().getBounds());
//        test.setModalPresentationStyle(UIModalPresentationStyle.Popover);
//        test.getView().addSubview(UIPC.getView());
//    }
//}
