package entities.stationary;

import graphics.Assets;
import main.Handler;

import java.awt.*;

public class Box extends Object {
    public Box(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphic) {
        float xPos = x - handler.getCamera().getxOffset();
        float yPos = y - handler.getCamera().getyOffset();
        graphic.drawImage(Assets.box, (int)xPos, (int)yPos, width,height,null);
    }
}
