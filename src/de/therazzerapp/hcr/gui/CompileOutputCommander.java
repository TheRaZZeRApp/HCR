package de.therazzerapp.hcr.gui;

import de.therazzerapp.hcr.HCR;

import java.util.ArrayList;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class CompileOutputCommander {

    private static ArrayList<String> messages = new ArrayList<>();

    public static void append(String text){
        messages.add(text);
        HCR.hcr_gui.getCompileOutputEditorPane().setText(getText());
    }

    private static String getText(){
        StringBuilder stringBuilder = new StringBuilder();
        for (String ms : messages){
            stringBuilder.append(ms);
        }
        return stringBuilder.toString();
    }

    public static void clear(){
        messages.clear();
        HCR.hcr_gui.getCompileOutputEditorPane().setText("");
        ConsoleCommander.sendInfo("Cleared compile output log!");
    }
}
