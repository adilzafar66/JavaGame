package input;

import UI.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean LeftClick, RightClick;
    private int mouseX, mouseY;

    private UIManager uiManager;

    public void setUIManager(UIManager uiManager){
        this.uiManager = uiManager;
    }

    public MouseManager(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
            LeftClick = true;
        else if(e.getButton()==MouseEvent.BUTTON2)
            RightClick = true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1)
            LeftClick = false;
        else if(e.getButton()==MouseEvent.BUTTON2)
            RightClick = false;

        if(uiManager != null){
            uiManager.onMouseRelease(e);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if(uiManager != null){
            uiManager.onMouseMove(e);
        }

    }

    public boolean isLeftClick() {
        return LeftClick;
    }

    public boolean isRightClick() {
        return RightClick;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }
}
