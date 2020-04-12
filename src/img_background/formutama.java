package img_background;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class formutama extends JFrame{
    Image image;
    background panel;
    
    public formutama(){
        super("JFrame");
        initComponents();
    }
    private void initComponents(){
        image = new ImageIcon("img_background/gb.jpg").getImage();
        panel = new background(image);
        add(panel);
        setPreferredSize(new Dimension(image.getWidth(null), image.getHeight(null)));
        pack();
        setVisible(true);
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}