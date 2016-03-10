package client.pageManager;

import client.pages.State;

/**
 * This is the enum storing all possible page states across all the pages.
 * When a new State is created, then you should utilize this Enum.
 *
 * Created by Hongyu Wang on 3/7/2016.
 */
public enum Pages {
    /**
     * Here should be placed state objects as a classname. Note, className needs
     * to include all subpackages within package.
     *
     * TODO add all required paths.
     */
    DIARY1(""),
    DIARY2(""),
    DIARY3(""),
    FRIENDS1(""),
    FRIENDS2(""),
    FRIENDS3(""),
    FRIENDS4(""),
    HOME1(""),
    HOME2(""),
    HOME3(""),
    HOME4(""),
    NOWPLAYING(""),
    PROFILE("Main");

    /**
     * This attribute denotes the current className of the given enum
     */
    private final String CLASS_NAME;


    /**
     * This variable stores the given state Reference to the classname.
     */
    private State state_reference;



    Pages(String class_name){
        String preamble = "pages.";
        CLASS_NAME = preamble + class_name;

        initializeState();

    }

    /**
     * This method will initialize a state reference from the given name.
     *
     */
    private void initializeState(){
        try {
            state_reference = (State) Class.forName(CLASS_NAME).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return CLASS_NAME;
    }

    /**
     * This method returns the given state reference
     * associated with the given Enum. Essentially makes this enum
     * into a HashTable with the Enum name as a key and the value as the state.
     *
     */
    public State getStateReference() {
        return this.state_reference;
    }
}
