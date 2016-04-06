package client.singletons;

/**
 *
 * Created by Hongyu Wang on 4/6/2016.
 */
public interface Gesturable {


    /**
     * This is the primary handle gesture function for the state
     * This will allow us to do cool animation things!! yayy.
     *
     * @param gestureX This will be true iff they swiped right
     * @param gestureY This will be true iff they swiped up
     * @param direction This will be true iff they swiped horizontally more than vertically
     */
    void handleGesture(boolean gestureX, boolean gestureY, boolean direction);
}
