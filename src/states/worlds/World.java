package states.worlds;

import entities.EntityManager;
import entities.moving.Fly;
import entities.moving.Slug;
import entities.moving.Player;
import entities.stationary.Box;
import main.Handler;
import tiles.TileDir;
import tiles.Tiles;
import utils.Utils;

import java.awt.*;

public class World {
    private Handler handler;
    private int width, height;
    private int[][] tiles;
    private int spawnX, spawnY;

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 0, 0));
        loadWorld(path);
        entityManager.getPlayer().setX(spawnX * 66 + 20);
        entityManager.getPlayer().setY((spawnY * 92) + 16);

        for(int i = 1; i < 11; i++){
            entityManager.addEntity(new Slug(handler, 600 * i,356, 50, 28));
        }
        for(int i = 3; i < 8; i++){
            entityManager.addEntity(new Box(handler, 0,50*i -16, 50, 50));
        }
        entityManager.addEntity(new Box(handler, 200,50*7 - 16, 50, 50));

        for(int i = 1; i < 5; i++){
            entityManager.addEntity(new Fly(handler, 800* i,300*(float)Math.pow(0.8,i), 40, 20));
        }
    }

    public void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for(int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x+y * width) + 4]);
            }
        }
    }

    public Tiles getTile(int x, int y){
        Tiles t = TileDir.tiles[tiles[x][y]];
        if(t == null){
            return TileDir.grassTile;
        }
        return t;
    }

    public void update(){
        entityManager.update();

    }

    public void render(Graphics graphic){

        int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Tiles.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tiles.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Tiles.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getCamera().getyOffset() + handler.getHeight()) / Tiles.TILEHEIGHT + 1);

        int xPos, yPos;

        for(int y = yStart; y < yEnd; y++){
            for (int x = xStart; x < xEnd; x++){

                xPos = (int) (x * Tiles.TILEWIDTH - handler.getCamera().getxOffset());
                yPos = (int) (y * Tiles.TILEHEIGHT - handler.getCamera().getyOffset());

                getTile(x,y).render(graphic, xPos, yPos);
            }
        }
        entityManager.render(graphic);
    }

    public int getSpawnX() {
        return spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }
}
