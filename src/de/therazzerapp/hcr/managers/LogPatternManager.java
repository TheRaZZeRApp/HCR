package de.therazzerapp.hcr.managers;

import de.therazzerapp.hcr.LogPattern;
import de.therazzerapp.hcr.content.loader.LogPatternLoader;
import de.therazzerapp.hcr.content.saver.LogPatternSaver;
import de.therazzerapp.hcr.gui.ContentObserver;

import java.util.HashSet;
import java.util.Set;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class LogPatternManager {
    private static Set<LogPattern> logPatternSet = new HashSet<>();

    public static void load(){
        logPatternSet = LogPatternLoader.load();
    }

    public static void save(){
        LogPatternSaver.save(logPatternSet);
    }

    public static void addLogPattern(LogPattern logPattern){
        logPatternSet.add(logPattern);
        save();
        load();
        ContentObserver.update(3);
    }

    public static void removeLogPattern(LogPattern logPattern){
        logPatternSet.remove(logPattern);
        save();
        load();
        ContentObserver.update(3);
    }

    public static String formatText(String text){
        for (LogPattern logPattern : logPatternSet) {
            System.out.println(logPattern.getPattern().toString());
            text = logPattern.format(text);
        }
        return text;
    }
}
