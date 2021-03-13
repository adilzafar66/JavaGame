package states;

import background.MainBackground;
import entities.moving.Slug;
import entities.moving.Player;
import main.Handler;
import states.worlds.World;

import java.awt.*;

public class GameState extends State {

    private World world;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler,"Resources/Worlds/world1.txt");
        handler.setWorld(world);

    }
    @Override
    public void update() {
        world.update();

    }

    @Override
    public void render(Graphics graphic) {
        MainBackground.render(graphic);
        world.render(graphic);

    }
}
