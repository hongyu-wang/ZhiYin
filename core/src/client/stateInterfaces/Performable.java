package client.stateInterfaces;

/**
 * This interface will MARK all classes that can perform events.
 *
 * Examples of this as of now would be buttons.
 *
 * The only method would be the getter for the relevant executable within the performable.
 *
 *
 *
 * Created by Hongyu Wang on 3/7/2016.
 */
public interface Performable {

    Executable getExecutable();

}
