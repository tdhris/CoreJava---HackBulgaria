import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicComboBoxUI;

import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.brush.BrushJava;
import syntaxhighlighter.theme.ThemeRDark;


public class QuickCodeInspector {
    private File fileViewed;
    
    public void setFile(File newFile) {
        this.fileViewed = newFile;
    }
    
    public File getFile() {
        return this.fileViewed;
    }
    
    public static void main(String[] args) throws IOException {
        String folder = args[0];
        File[] files = new File(folder).listFiles();
        
        SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushJava());
        SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeRDark());
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setFocusable(true);
        frame.setSize(100, 100);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int arrow_right = 39;
                if (keyCode == arrow_right) {
                    
                }
            }
        });
    }
}
