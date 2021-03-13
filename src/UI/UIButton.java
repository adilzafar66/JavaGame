package UI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIButton extends UIObject {

    private BufferedImage[] images;
    private ClickListener clickListener;

    public UIButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clickListener) {
        super(x, y, width, height);
        this.images = images;
        this.clickListener = clickListener;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphic) {
        if(hovering){
            graphic.drawImage(images[1], (int) x, (int) y, width, height, null);
        }
        else {
            graphic.drawImage(images[0], (int) x, (int) y, width, height, null);
        }

    }

    @Override
    public void onClick() {
        clickListener.onClick();
    }
}
