package img_background;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class background extends JPanel{
    Image image;
    
    public background(Image image){
        this.image = image;
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, null);
    }
    
}