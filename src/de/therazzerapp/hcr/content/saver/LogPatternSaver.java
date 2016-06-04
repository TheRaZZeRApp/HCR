package de.therazzerapp.hcr.content.saver;

import de.therazzerapp.hcr.LogPattern;
import de.therazzerapp.hcr.config.JSONConfig;
import de.therazzerapp.hcr.config.JSONConfigSection;

import java.io.File;
import java.util.Set;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class LogPatternSaver {
    public static void save(Set<LogPattern> logPatternSet){
        File file = new File("./Data/logPattern.json");

        JSONConfig config = new JSONConfig();
        JSONConfigSection root = config.newRootSection();

        for (LogPattern logPattern : logPatternSet) {
            JSONConfigSection root2 = root.addConfigSectionArrayEntry("pattern");
            root2.setString("pattern",logPattern.getPattern().toString());
            root2.setString("replace",logPattern.getReplace());
        }
        config.save(root,file);
    }
}
