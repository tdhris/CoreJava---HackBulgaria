import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.nitido.utils.toaster.Toaster;

/**
 * Blah Blah The Greatest Documentation Ever
 * @author Tania
 * 
 *
 */

public class TakeABreak {
    public static void main(String[] args) {
        Toaster toaster = new Toaster();
        int icon_width = 200;
        int icon_height = 50;
        toaster.setToasterWidth(icon_width);
        toaster.setToasterHeight(icon_height);
        ImageIcon  icon = new ImageIcon();
        Color border_color = new Color(255, 0, 0);
        Color message_color = new Color(255, 255, 255);
        toaster.setBorderColor(border_color);
        Image background = new BufferedImage(icon_width, icon_height, BufferedImage.TYPE_3BYTE_BGR);
        toaster.setBackgroundImage(background);
        toaster.setMessageColor(message_color);
        int timer = Integer.parseInt(JOptionPane.showInputDialog("Enter the timer value:", 5));
        //swing -> ""
        toaster.showToaster(icon, "Take a Break!");
        toaster.setStep(timer);
    }
}
