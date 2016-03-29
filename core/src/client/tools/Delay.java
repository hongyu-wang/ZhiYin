package client.tools;

/**
 *
 * Created by Hongyu Wang on 3/29/2016.
 */
public class Delay {

    private int currentValue;
    private final int resetValue;

    public Delay(int resetValue){
        this.resetValue = resetValue;
        currentValue = resetValue;
    }

    public boolean isCompleted(){
        return currentValue == 0;
    }

    public void tick(){
        if (!isCompleted())
            currentValue --;
    }

    public void reset(){
        currentValue = resetValue;
    }
}
