package client.stateInterfaces;

import com.badlogic.gdx.math.Matrix4;

/**
 * This is the scrollable interface.
 * This interface will be resultant from all Scrolling objects.
 *
 *
 * Created by Hongyu Wang on 3/5/2016.
 */
public interface Scrollable {
   void drawScrolled();

   Matrix4 getCamera();
}
