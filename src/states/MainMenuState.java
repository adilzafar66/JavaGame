package states;

import UI.ClickListener;
import UI.UIButton;
import UI.UIManager;
import graphics.Assets;
import main.Game;
import main.Handler;
import states.State;
import states.worlds.World;

import java.awt.*;

public class MainMenuState extends State {

    private World world;
    private Font headFont;
    private UIManager uiManager;


    public MainMenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);
        uiManager.addUIObject(new UIButton(200, 200, 70, 80, Assets.player_backward, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                CurrentState.SetState(handler.getGame().getGameState());
            }
        }));

    }

    @Override
    public void update() {
        if(handler.getMouseManager().isLeftClick()){
            CurrentState.SetState(handler.getGame().getGameState());
        }

        uiManager.update();

    }

    @Override
    public void render(Graphics graphic) {
        graphic.drawImage(Assets.BG,0,0,256,256,null);
        graphic.drawImage(Assets.BG, 0,256,256,256,null);
        graphic.drawImage(Assets.BG, 256,0,256,256,null);
        graphic.drawImage(Assets.BG, 256,256,256,256,null);
        headFont = new Font("arial",Font.BOLD,50);
        graphic.setFont(headFont);
        graphic.drawString("SlugDay", handler.getGame().getWidth()/2-100, 100);
        uiManager.render(graphic);

    }
}
