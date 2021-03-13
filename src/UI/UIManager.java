package UI;

import main.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {
    private Handler handler;
    private ArrayList<UIObject> uiObjects;

    public UIManager(Handler handler){

        this.handler = handler;
        uiObjects = new ArrayList<UIObject>();
    }

    public void update(){
        for(UIObject O: uiObjects){
            O.update();
        }

    }

    public void render(Graphics graphic){
        for(UIObject O: uiObjects){
            O.render(graphic);
        }

    }

    public void onMouseMove(MouseEvent e){
        for(UIObject O: uiObjects){
            O.onMouseMove(e);
        }

    }

    public void onMouseRelease(MouseEvent e){
        for(UIObject O: uiObjects){
            O.onMouseRelease(e);
        }

    }

    public void addUIObject(UIObject uiObject){
        uiObjects.add(uiObject);
    }

    public void removeUIObject(UIObject uiObject){
        uiObjects.remove(uiObject);
    }


}
