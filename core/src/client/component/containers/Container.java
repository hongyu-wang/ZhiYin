package client.component.containers;

import client.component.Component;
import client.singletons.MainBatch;
import tools.utilities.Utils;

import java.util.List;

/**
 * This is the container class for components.
 * This class has an add, a clear, a dispose method.
 */
public abstract class Container extends Component
{
    /**
     * This is the primary component array of the Container.
     */
    protected List<Component> components = Utils.<Component>newList();


    public Container(int x, int y, int width, int height){
        setBounds(x, y, width, height);
        init();
    }

    @Override
    protected void init(){

    }

    /**
     * This is the addComponent method. This will add a component
     * into the container
     * @param component the component to be added.
     */
    public void addComponent(Component component){
        this.components.add(component);
    }

    /**
     * This is the clear method. This will clear all components
     * out of the container.
     */
    public void clear(){
        components.clear();
    }



    public void draw() {
        for (Component comp : components){
            comp.draw(MainBatch.getInstance(), 0);
        }
    }

    @Override
    public void update(float dt) {
        for (Component comp : components){
            comp.update(dt);
        }
    }
}
