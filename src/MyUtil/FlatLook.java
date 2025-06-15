
package MyUtil;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.UIManager;

public class FlatLook {
    
    public static String theam = "light";
    
    public static void setup(String theam){
        
        if("light".equals(theam)){
            FlatMacLightLaf.setup();
            ColorTheme.panel = ColorTheme.light;
            ColorTheme.Textcolor = new Color(0,0,0);
        } else {
            FlatMacDarkLaf.setup();
            ColorTheme.panel = ColorTheme.dark;
            ColorTheme.Textcolor = new Color(255,255,255);
        }
//        com.formdev.flatlaf.FlatDarculaLaf.setup();
//        com.formdev.flatlaf.FlatDarkLaf.setup();
//        com.formdev.flatlaf.FlatLightLaf.setup();
//        com.formdev.flatlaf.FlatIntelliJLaf.setup();
        
        
        UIManager.put("Button.arc", 16);
        UIManager.put("TextComponent.arc", 16);
        UIManager.put( "Component.arc", 16 );
        UIManager.put( "CheckBox.arc", 16 );
        UIManager.put( "ProgressBar.arc", 16 );
        UIManager.put( "ScrollBar.showButtons", true );
        UIManager.put( "Component.arrowType", "triangle" );
        
        UIManager.put( "Component.borderWidth", 1.2 );
        UIManager.put( "Component.borderColor", ColorTheme.btn );
        UIManager.put( "ComboBox.selectionBackground", ColorTheme.btn );
        UIManager.put( "ComboBox.buttonBackground", ColorTheme.btn );
        UIManager.put( "Component.focusWidth",0 );
        UIManager.put( "Component.innerFocusWidth",2);
        
        UIManager.put( "ScrollBar.thumbArc", 999 );
        UIManager.put( "ScrollBar.thumbInsets", new Insets( 2, 2, 2, 2 ) );
        
        UIManager.put("Panel.background", ColorTheme.panel);
        UIManager.put("ToggleButton.selectedBackground", ColorTheme.btn);
        UIManager.put("ToggleButton.selectedForeground", ColorTheme.light);
        
        
        UIManager.put("TableHeader.background", ColorTheme.btn);
        UIManager.put("TableHeader.foreground", ColorTheme.light);
        UIManager.put("Table.selectionBackground", new java.awt.Color(204, 204,204));
        UIManager.put("Table.selectionForeground", new java.awt.Color(51, 51, 51));
        UIManager.put("TableHeader.fontsize", 14);
        UIManager.put("TableHeader.font", new Font("Segoe UI bold", 0, 12));
        UIManager.put("MenuBar.selectionForeground",	ColorTheme.light);
        
        System.setProperty( "flatlaf.useWindowDecorations", "true" ); 
        System.setProperty( "flatlaf.menuBarEmbedded", "true" ); 
        
//        ALL CUSTOMIZATIONS 
    //                https://www.formdev.com/flatlaf/customizing/
    }
}
