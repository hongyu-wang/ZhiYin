package client.stateInterfaces;

/**
 *
 * Created by Hongyu Wang on 4/6/2016.
 */
public interface Gesturable {


    /**
     * This is the primary handle gesture function for the state
     * This will allow us to do cool animation things!! yayy.
     *
     * @param gestureXRight This will be true iff they swiped right
     * @param gestureYUp This will be true iff they swiped up
     * @param directionMainlyX This will be true iff they swiped horizontally more than vertically
     */
    void handleGesture(boolean gestureXRight, boolean gestureYUp, boolean directionMainlyX);
}
