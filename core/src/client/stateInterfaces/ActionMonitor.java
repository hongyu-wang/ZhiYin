package client.stateInterfaces;

import client.events.ActionEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the ActionMonitor interface. An ActionMonitor will be able
 * to deal with and handle ActionEvents.
 *
 * Created by Hongyu Wang on 3/7/2016.
 */
public interface ActionMonitor {

    /**
     * This is the actionPerformed
     * @param e
     */
    void actionPerformed(ActionEvent e);


}
