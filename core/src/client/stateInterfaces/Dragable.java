package client.stateInterfaces;

import client.internalExceptions.NoExecutableException;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public interface Dragable extends Performable{


    void drag() throws NoExecutableException;

    void release() throws NoExecutableException;




    void setDragExecutable(Executable e);

    void setReleaseExecutable(Executable e);
}
