package graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static int width = 32, height = 32;
    public static BufferedImage grass, grassMid, sky, rock, gravel, sand, dirt, cloud,cloud2, cloud3, box;
    public static BufferedImage[] player_forward;
    public static BufferedImage[] player_backward;
    public static BufferedImage player_jump;
    public static BufferedImage player_stand;
    public static BufferedImage player_duck;
    public static BufferedImage[] Slug, Fly;
    public static String path;
    public static BufferedImage BG;

    public static void init(){
        BG = ImageLoader.loadImage("/bg.png");
        SpriteSheet sheet = new SpriteSheet(graphics.ImageLoader.loadImage("/textures/bg2.png"));
        grass = ImageLoader.loadImage("/Tiles/grass.png");
        box = ImageLoader.loadImage("/Tiles/box.png");
        grassMid = ImageLoader.loadImage("/Tiles/grassMid.png");
        cloud = ImageLoader.loadImage("/Items/cloud1.png");
        cloud2 = ImageLoader.loadImage("/Items/cloud2.png");
        cloud3 = ImageLoader.loadImage("/Items/cloud3.png");
        sky = ImageLoader.loadImage("/bg.png");
        dirt = ImageLoader.loadImage("/grassCenter.png");
        gravel = sheet.crop(2*width, 0, width, height);
        sand = sheet.crop(3*width, 0 , width, height);
        player_forward = new BufferedImage[11];
        player_backward = new BufferedImage[11];
        player_jump = ImageLoader.loadImage("/Player/p1_jump.png");
        player_stand = ImageLoader.loadImage("/Player/p1_stand.png");
        player_duck = ImageLoader.loadImage("/Player/p1_duck.png");
        for (int x = 1; x < 12; x++){
            path = "/Player/p1_walk" + x + ".png";
            player_forward[x-1] = ImageLoader.loadImage(path);
            player_backward[11-x] = ImageLoader.loadImage(path);
        }

        Slug = new BufferedImage[2];
        for (int x = 1; x < 3; x++){
            path = "/Enemies/slimeWalk"+ x +".png";
            Slug[x-1] = ImageLoader.loadImage(path);
        }
        Fly = new BufferedImage[2];
        for (int x = 1; x < 3; x++){
            path = "/Enemies/flyFly"+ x +".png";
            Fly[x-1] = ImageLoader.loadImage(path);
        }

    }
}