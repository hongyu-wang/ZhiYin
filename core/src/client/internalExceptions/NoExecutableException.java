package client.internalExceptions;


/**
 * This exception is called when the given Performable doesn't have the required exception.
 */
public class NoExecutableException extends Exception{
    public NoExecutableException(){
        super("The given pressable has no executable");
    }

}
