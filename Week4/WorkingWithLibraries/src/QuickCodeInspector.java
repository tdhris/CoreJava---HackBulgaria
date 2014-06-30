
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

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
        SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushJava());
        SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeRDark());
        highlighter.setContent(new File(args[0]));
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setFocusable(true);
        frame.pack();
        frame.setVisible(true);
        frame.setContentPane(highlighter);
      
    }
}