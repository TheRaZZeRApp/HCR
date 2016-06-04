package de.therazzerapp.hcr.content.loader;

import de.therazzerapp.hcr.LogPattern;
import de.therazzerapp.hcr.config.JSONConfig;
import de.therazzerapp.hcr.config.JSONConfigSection;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class LogPatternLoader {
    public static Set<LogPattern> load(){
        Set<LogPattern> logPatternSet = new HashSet<>();

        File file = new File("./Data/logPattern.json");
        if(!file.exists()){
            return logPatternSet;
        }
        JSONConfigSection root = new JSONConfig().load(file);

        for (JSONConfigSection j : root.getConfigSectionArray("pattern")){
            logPatternSet.add(new LogPattern(
                    j.getString("pattern"),
                    j.getString("replace")
            ));
        }
        return logPatternSet;
    }
}
