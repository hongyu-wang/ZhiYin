package client.pages;

import client.component.basicComponents.Button;
import client.events.ActionEvent;
import client.events.executables.internalChanges.updatePageExecutables.ExecuteChangePage;
import client.internalExceptions.NoExecutableException;
import client.pageStorage.Pages;
import client.pages.other.TransitionType;
import client.pages.pageInternal.inputController.InputController;
import client.singletons.MainBatch;
import client.stateInterfaces.*;
import client.tools.Constants;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import tools.utilities.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the superclass of all States.
 *
 * All pages should extend this.
 */
public abstract class State implements Updatable, Drawable, Disposable, ActionMonitor, Constants {

    private static List<State> everything = new ArrayList<>();
    protected ArrayList<Disposable> disposables;

    protected Stage stage;
    private InputController inputController;
    protected TransitionType transitionType;

    protected Texture tx;

    @Override
    public void update(float dt) {
        stage.act(dt);
    }


    /**
     * This is the serviceList will store all components
     * inside the given state.
     */
    private List<Actor> components;

    /**
     * This method will initialize all values as required within state
     */
    protected void init(){
        disposables = new ArrayList<>();
        everything.add(this);
        components = Utils.newList();
        inputController = new InputController();
        stage = new Stage();
        transitionType = TransitionType.NONE;
    }

    /**
     * This method will add a component to the components.
     *
     * This will also add all Performables to the performable list in the static
     * input controller.
     * @param c the component to be added
     */
    public void add(Actor c){
        if (c instanceof Performable)
            inputController.add((Performable) c);
        components.add(c);
    }

    /**
     * NO ONE ELSE EVER USE THIS METHOD PLSPSLSPLSLSLPSPLSPLPSPLSSPLSPLSLPSL
     * THIS METHOD IS CALLED. ULTIMATE
     * Mom's SPAGETTHI.
     * NEVER EVER EVER EVER EVER EVER USE THIS!!!!!!!!!!!!!!!!!!!!!!
     * OK? never ever ever ever ever ever everever ever everever ever everever ever everever ever everever ever ever
     * ever ever ever
     * ever ever ever
     * ever ever ever
     * ever ever ever
     * ever ever ever
     * ever ever ever
     * ever ever ever
     * ever ever ever
     * ever ever ever
     * ever ever ever
     * Use this fucking method.
     * @param c thing.
     */
    @Deprecated
    public void remove(Performable c){
        components.remove(c);
        inputController.remove(c);
    }

    /**
     * Create and add the buttons for the bottom bar.
     */
    protected void setBottomBar(){
        Button homeButton = new Button(this);
        homeButton.setBounds(0, 0, 210, 117);
        homeButton.setExecutable(new ExecuteChangePage(Pages.HOME, TransitionType.FADE_IN));
        add(homeButton);

        Button diaryButton = new Button(this);
        diaryButton.setBounds(210, 0, 180, 117);
        diaryButton.setExecutable(new ExecuteChangePage(Pages.DIARY1, TransitionType.FADE_IN));
        add(diaryButton);

        Button friendsButton = new Button(this);
        friendsButton.setBounds(390, 0, 160, 117);
        friendsButton.setExecutable(new ExecuteChangePage(Pages.FRIENDS1, TransitionType.FADE_IN));
        add(friendsButton);

        Button toolsButton = new Button(this);
        toolsButton.setBounds(550, 0, 200, 117);
        toolsButton.setExecutable(new ExecuteChangePage(Pages.MYPROFILE, TransitionType.FADE_IN));
        add(toolsButton);
    }

    protected Table createImage(String imagePath, Executable e, int x, int y, int width, int height ){

        Image image = new Image(tx = new Texture(imagePath + "1.0" + ".png"));
        disposables.add(tx);

        image.setSize(image.getWidth() * M, image.getHeight() * M);


        Stack s = new Stack();
        s.add(new Image(tx = new Texture("Home/BlackBG@1.0.png")));
        disposables.add(tx);

        Table t = new Table();
        t.add(image).width(image.getWidth()).height(image.getHeight());
        s.add(t);

        final Executable executable = e;
        s.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                executable.execute();
            }
        });

        Table table = new Table();
        table.add(s);
        table.setBounds(x * M, y * M, width * M, height * M);

        return table;
    }

    protected void addImage(String imagePath, Executable e, int x, int y, int width, int height){
        Table t = createImage(imagePath, e, x, y, width, height);
        stage.addActor(t);
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
        for (Actor actor : components) {
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

    public void reset(){


    }


    public InputController getInputController(){
        return inputController;
    }



    public Stage getStage() {
        return stage;
    }

    public String toString(){
        return this.getClass().getName();
    }

    public TransitionType getTransitionType(){
        return transitionType;
    }

    public static List<State> getEverything() {
        return everything;
    }

    @Override
    public void dispose() {
        for (Disposable i : disposables){
            i.dispose();
        }
    }
}

