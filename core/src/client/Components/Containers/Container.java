package client.Components.Containers;

import client.Components.Component;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tools.ServiceList;

public abstract class Container extends Component
{
    protected ServiceList<Component> components = new ServiceList<>();

    public Container(){

    }

    public Container(SpriteBatch batch, double x, double y, double width, double height){
        this.batch = batch;
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

}
