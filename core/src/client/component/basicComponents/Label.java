package client.component.basicComponents;

import client.component.Component;

public class Label extends Component
{
    protected String text;

    public Label(String text, int x, int y, int width, int height){
        super(x, y, width, height);
        this.text = text;
    }


    @Override
    protected void init(){

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
}
