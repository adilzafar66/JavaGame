package entities.moving;

import graphics.Animations;
import graphics.Assets;
import main.Handler;

import java.awt.*;

public class Slug extends Creature{

    private Animations animMove;


    public Slug(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        animMove = new Animations(150, Assets.Slug);
    }

    public void getInput(){
        xMove = -1;
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
