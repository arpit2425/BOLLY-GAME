import java.applet.*;
import java.awt.*;
import java.net.*;
import java.io.IOException.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.applet.AudioClip;
     import java.awt.event.ItemListener;
     import java.awt.event.ItemEvent;
     import java.awt.event.ActionListener;
     import java.awt.event.ActionEvent;
     import java.awt.FlowLayout;
     import javax.swing.JApplet;
         import javax.swing.JButton;
    import javax.swing.JComboBox;


public class BackgroundAplet extends JApplet implements ActionListener
 {
     Image backGround;
String s="BOLLYWOOD";
     public void init() {
         JLabel secretb;
secretb =new JLabel();
          // set the size of the applet to the size of the background image.
          // Resizing the applet may cause distortion of the image.
          setSize(300, 300);
          secretb.setFont(new Font("CHILLER", Font.BOLD, 48));
           secretb.setText(s);
con.add(secretb);
          // Set the image name to the background you want. Assumes the image 
          // is in the same directory as the class file is
          backGround = getImage(getCodeBase(), "BHjUyMQCEAAK5Vl.jpg");
          BackGroundPanel bgp = new BackGroundPanel();
          bgp.setLayout(new FlowLayout());
          bgp.setBackGroundImage(backGround);

          // Add the components you want in the Applet to the Panel
          bgp.add(new Button("Button 1"));
          bgp.add(new TextField("isn't this cool?"));
          bgp.add(new Button("Useless Button 2"));

          // set the layout of the applet to Border Layout
          setLayout(new BorderLayout());

          // now adding the panel, adds to the center
          // (by default in Border Layout) of the applet
          add(bgp);
     }
}

class BackGroundPanel extends Panel {
     Image backGround;

     BackGroundPanel() {
          super();
     }

     public void paint(Graphics g) {

          // get the size of this panel (which is the size of the applet),
          // and draw the image
          g.drawImage(getBackGroundImage(), 0, 0,
              (int)getBounds().getWidth(), (int)getBounds().getHeight(), this);
     }

     public void setBackGroundImage(Image backGround) {
          this.backGround = backGround;    
     }

     private Image getBackGroundImage() {
          return backGround;    
     }
}