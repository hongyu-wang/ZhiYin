package client.Components.Containers;

import client.Components.Component;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import tools.ServiceList;

import java.util.List;

public abstract class Container extends Component
{
    protected List<Component> components = new ServiceList<>();

    public Container(){

    }

    public Container(SpriteBatch batch, double x, double y, double width, double height){
        init(batch, x, y, width, height);
    }

    public void init(SpriteBatch batch, double x, double y, double width, double height){
        this.batch = batch;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void addComponent(Component component){
        this.components.add(component);
    }

    public void clear(){
        components.clear();
    }

}
