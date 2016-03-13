package client.pages;

import client.component.Component;
import client.component.basicComponents.Button;
import client.events.ActionEvent;
import client.inputController.InputController;
import client.internalExceptions.NoExecutableException;
import client.stateInterfaces.*;
import tools.utilities.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This is the superclass of all States.
 *
 * All pages should extend this.
 */
public abstract class State implements Updatable, Drawable, Disposable, ActionMonitor {
    public static final String SHELLINPUT = "shell";
    public static final String MOVEABLEINPUT = "moveable";


    /**
     * This is the primary constructor of state.
     * No parameters should ever get passed into this constructor.
     */
    public State(){
        init();
    }



    private Map<String, InputController> controllers;



    /**
     * This is the serviceList will store all components
     * inside the given state.
     */
    private List<Component> components;

    /**
     * This method will initialize all values as required within state
     */
    public void init(){
        components = Utils.<Component>newList();
        controllers = Utils.newMap();
        controllers.put(SHELLINPUT, new InputController());
        controllers.put(MOVEABLEINPUT, new InputController());
    }

    /**
     * This method will add a component to the components.
     *
     * This will also add all Performables to the performable list in the static
     * input controller.
     * @param c the component to be added
     */
    public void add(Component c){
        if (c instanceof Pressable)
            controllers.get(SHELLINPUT).add((Pressable) c);
        components.add(c);
    }

    /**
     * This will return a deep copy of the stored component list
     * @return A deep copy of the components.
     */
    public List<Component> getComponents(){

        List<Component> deepCopy = Utils.newList();
        deepCopy.addAll(components.stream().collect(Collectors.toList()));

        return deepCopy;
    }



    /**
     * This method will draw everything.
     */
    public void draw(){
        components.forEach(client.component.Component::draw);
    }



    @Override
    public void actionPerformed(ActionEvent e){
        try {
            e.getSource().getExecutable().execute();
        } catch (NoExecutableException ex){
            System.out.println(ex.getMessage());
        }
    }

    public InputController getInputController(String FIXEDINPUT){
        return controllers.get(FIXEDINPUT);
    }

    protected void getInformationFromServer(){

    }

}

