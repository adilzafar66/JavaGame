package entities.moving;

import graphics.Animations;
import graphics.Assets;
import main.Handler;

import java.awt.*;

public class Fly extends Creature {

    private Animations animMove;

    public Fly(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        animMove = new Animations(100, Assets.Fly);
    }

    public void getInput(){
        xMove = -3;
    }

    @Override
    public void update() {
        getInput();
        move();
        animMove.update();

    }

    @Override
    public void render(Graphics graphic) {
        float xPos = x - handler.getCamera().getxOffset();
        float yPos = y - handler.getCamera().getyOffset();
        graphic.drawImage(animMove.getCurrentFrame(), (int)xPos, (int)yPos, width,height,null);
    }
}
