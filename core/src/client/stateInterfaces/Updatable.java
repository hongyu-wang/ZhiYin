package client.stateInterfaces;

/**
 * This interface designated an object that can be updated. This interface has one method update
 * Created by Hongyu Wang on 3/2/2016.
 */
public interface Updatable {

    /**
     * This is the update method used in all client classes.
     * @param dt The rate of change of updating
     */
    void update(float dt);
}
