package entities.moving;

import graphics.Animations;
import graphics.Assets;
import main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {


    private Animations animForward;
    private Animations animBackward;
    private boolean flag = false;
    private float k = 0;
    private float temp = 0;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_WIDTH,Creature.DEFAULT_HEIGHT);
        animForward = new Animations(50,Assets.player_forward);
        animBackward = new Animations(50, Assets.player_backward);
    }



    private void getInput(){
        xMove = 0;
        yMove = 0;

        //Up (Up Arrow ASCII = 38)
        if(handler.getKeyManager().getKey()[32] || flag){

            if(!checkEntityCollisions(0f,4) && !checkEntityCollisions(0f,-4)){
                yMove = -10 + (float)2 * k;
                k = k + (float)0.25;
            }
            else {
                if(k <= 5){
                    k = (float)10.25 - k;
                }
                handler.getKeyManager().keys[32] = false;
                flag = true;
            }

            if (k >= 10 + 0.25) {
                flag = false;
                handler.getKeyManager().keys[32] = false;
                k = 0;
            }

        }

//        if(handler.getKeyManager().getKey()[40]){
//            yMove = 3;
//        }

        //Left (Left Arrow ASCII = 37)
        if(handler.getKeyManager().getKey()[37]){
            xMove = -3;
        }

        //Right (Right Arrow ASCII = 38)
        if(handler.getKeyManager().getKey()[39]){
            xMove = 3;
        }

//        System.out.println(handler.getKeyManager().getKey()[32]);
//        if(y < 285 && !checkEntityCollisions(0f, yMove) && !handler.getKeyManager().getKey()[32]){
//             yMove = (float)Math.pow((z),2);
//
//             if(yMove + y > 292){
//
//                 y = 292;
//             }
//
//             z += 0.25;
//
//        }

    }

    @Override
    public void update() {
        getInput();
        move();
        handler.getCamera().centerOnEntity(this);
        animForward.update();
        animBackward.update();
    }

    @Override
    public void render(Graphics graphic) {

        int xPos = (int) (x - handler.getCamera().getxOffset());
        int yPos = (int) (y - handler.getCamera().getyOffset());
        if (getCurrentAnimFrame()==Assets.player_duck){
            graphic.drawImage(getCurrentAnimFrame(),xPos,yPos + (Creature.DEFAULT_HEIGHT - 71),69, 71, null);

        }
        else{
            graphic.drawImage(getCurrentAnimFrame(),xPos,yPos,Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT, null);
        }
    }

    private BufferedImage getCurrentAnimFrame(){
        if(handler.getKeyManager().getKey()[32]){
            return Assets.player_jump;

        }
        else if(handler.getKeyManager().getKey()[37]){
            return animBackward.getCurrentFrame();
        }
        else if(handler.getKeyManager().getKey()[39]){
            return animForward.getCurrentFrame();
        }
        else if(handler.getKeyManager().getKey()[40]){
            return Assets.player_duck;
        }
        else{
            return Assets.player_stand;
        }
    }



}
