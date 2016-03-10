package client.component.basicComponents;

import client.component.Component;
import client.events.ActionEvent;
import client.stateInterfaces.ActionMonitor;
import client.stateInterfaces.Performable;

/**
 * This is a button component. All new buttons should extend this button. This button component
 * will have its own specific textures.
 */
public class Button extends Component implements Performable {

    private ActionMonitor monitor;

    /**
     * The primary constructor for button.
     */
    public Button(ActionMonitor monitor){
        super();
        this.monitor = monitor;
    }

    @Override
    protected void init() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void draw() {

    }

    @Override
    public void update(float dt) {

    }

    /**
     * This is the press method. What this method will do is it will send
     * a new ActionEvent to the actionListener.
     */
    private void pressed() {
        monitor.actionPerformed(new ActionEvent(this));
    }
}
