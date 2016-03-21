package client.pages;

import client.component.basicComponents.Button;
import client.events.ActionEvent;
import client.events.executables.internalChanges.ExecuteChangePage;
import client.pages.pageInternal.inputController.InputController;
import client.events.executables.internalChanges.TestExecutable;
import client.internalExceptions.NoExecutableException;
import client.pageStorage.Pages;
import client.singletons.MainBatch;
import client.stateInterfaces.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import tools.utilities.Utils;

import java.util.List;
import java.util.Map;

/**
 * This is the superclass of all States.
 *
 * All pages should extend this.
 */
public abstract class State implements Updatable, Drawable, Disposable, ActionMonitor {
    public static final String SHELLINPUT = "shell";
    public static final String MOVEABLEINPUT = "moveable";
    protected Stage stage;

    /**
     * This is the primary constructor of state.
     * No parameters should ever get passed into this constructor.
     */
    public State(){
        init();
    }

    @Override
    public void update(float dt) {
        stage.act();
    }


    /**
     * This clears the stage of all actors. The main purpose of this
     * is for the input multiplexer to work properly.
     */
    public void clearStage(){
        stage.clear();
    }

    private Map<String, InputController> controllers;



    /**
     * This is the serviceList will store all components
     * inside the given state.
     */
    private List<Actor> components;

    /**
     * This method will initialize all values as required within state
     */
    public void init(){
        components = Utils.newList();
        controllers = Utils.newMap();
        controllers.put(SHELLINPUT, new InputController());
        controllers.put(MOVEABLEINPUT, new InputController());
        stage = new Stage();

    }

    /**
     * This method will add a component to the components.
     *
     * This will also add all Performables to the performable list in the static
     * input controller.
     * @param c the component to be added
     */
    public void add(Actor c){
        if (c instanceof Pressable)
            controllers.get(SHELLINPUT).add((Pressable) c);
        components.add(c);
    }

    /**
     * Create and add the buttons for the bottom bar.
     */
    protected void setBottomBar(){
        // 59 + 117 + 55 + 117 + 55 + 117 + 55 + 117 + 58

        Button homeButton = new Button(this);
        homeButton.setBounds((59) + 1, 0, 117, 117);
        homeButton.setExecutable(new ExecuteChangePage(Pages.HOME1));
        add(homeButton);

        Button diaryButton = new Button(this);
        diaryButton.setBounds((59 + 117 + 55) + 1, 0, 117, 117);
        diaryButton.setExecutable(new ExecuteChangePage(Pages.DIARY1));
        add(diaryButton);

        Button friendsButton = new Button(this);
        friendsButton.setBounds((59 + 117*2 + 55*2) + 1, 0, 117, 117);
        friendsButton.setExecutable(new ExecuteChangePage(Pages.FRIENDS1));
        add(friendsButton);

        Button toolsButton = new Button(this);
        toolsButton.setBounds((59 + 117*3 + 55*3) + 1, 0, 117, 117);
        toolsButton.setExecutable(new TestExecutable("tools"));
        add(toolsButton);
    }

    /**
     * This will return a deep copy of the stored component list
     * @return A deep copy of the components.
     */
    public List<Actor> getComponents(){

        List<Actor> deepCopy = Utils.newList();
        for (Actor i : components){
            deepCopy.add(i);
        }

        return deepCopy;
    }



    /**
     * This method will draw everything.
     */
    public void draw(){
        if (stage.getActors().size != 0) {
            stage.draw();
        }
        for (Actor actor : components){
            actor.draw(MainBatch.getInstance(), 1);
        }
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



    public Stage getStage() {
        return stage;
    }



}

