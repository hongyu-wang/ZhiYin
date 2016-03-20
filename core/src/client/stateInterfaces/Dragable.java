package client.stateInterfaces;

/**
 * Created by Hongyu Wang on 3/20/2016.
 */
public interface Dragable extends Performable{


    void drag();

    void release();




    void setDragExecutable(Executable e);

    void setReleaseExecutable(Executable e);
}