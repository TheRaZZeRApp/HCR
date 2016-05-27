package de.therazzerapp.hcr.content.loader;

import de.therazzerapp.hcr.content.CompileSet;
import de.therazzerapp.hcr.config.JSONConfig;
import de.therazzerapp.hcr.config.JSONConfigSection;
import de.therazzerapp.hcr.managers.BuildProgramManager;
import de.therazzerapp.hcr.managers.BuildSettingsManager;

import java.io.File;
import java.util.ArrayList;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class CompileQueueLoader {
    public static ArrayList<CompileSet> load(){
        ArrayList<CompileSet> compileQueue = new ArrayList<>();
        File file = new File("./compileQueue.json");
        if(!file.exists()){
            return compileQueue;
        }
        JSONConfigSection root = new JSONConfig().load(file);

        for (JSONConfigSection j : root.getConfigSectionArray("files")){
            compileQueue.add(new CompileSet(
                    j.getString("vmfPath"),
                    BuildSettingsManager.getBuildSetting(j.getString("buildSettings"))
                    ));
        }
        return compileQueue;
    }
}
