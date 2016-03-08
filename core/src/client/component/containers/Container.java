package client.component.containers;

import client.component.Component;
import client.components.Component;
import tools.ServiceList;

public class Container extends Component
{
    protected ServiceList<Component> components = new ServiceList<>();


    public Container(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        init();
    }

    public void init(){

    }

    public void addComponent(Component component){
        this.components.add(component);
    }

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
