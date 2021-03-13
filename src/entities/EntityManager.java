package entities;

import entities.moving.Player;
import main.Handler;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);

    }

    public void update(){
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).update();
        }
    }

    public void render(Graphics graphic){
        for(Entity e: entities){
            e.render(graphic);
        }

    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    //Getters and Setters

    public Handler getHandler() {
        return handler;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
