package tiles;

import graphics.Assets;

import java.awt.*;

public class CloudTile extends Tiles {
    public CloudTile(int tileId) {
        super(Assets.cloud, tileId);
    }


    public void render(Graphics graphic, int x, int y){
        graphic.drawImage(texture, x, y, 128, 71, null);
    }

}
