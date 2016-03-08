package client.stateInterfaces;

/**
 * This is the interface that all disposable methods should inherit from.
 *
 * Created by Hongyu Wang on 3/2/2016.
 */
public interface Disposable {

    /**
     * This is the dispose method. All disposables should be disposed after use.
     */
    void dispose();
}
