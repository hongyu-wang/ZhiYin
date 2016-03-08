package client.component.containers;

import client.component.Component;
import tools.ServiceList;

/**
 * This is the container class for components.
 * This class has an add, a clear, a dispose method.
 */
public abstract class Container extends Component
{
    /**
     * This is the primary component array of the Container.
     */
    protected ServiceList<Component> components = new ServiceList<>();


    public Container(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    @Override
    public void dispose() {
        for (Component comp : components){
            comp.dispose();
        }
    }

    @Override
    public void draw() {
        for (Component comp : components){
            comp.draw();
        }
    }

    @Override
    public void update(float dt) {
        for (Component comp : components){
            comp.update(dt);
        }
    }
}
