package de.therazzerapp.hcr.content.saver;

import de.therazzerapp.hcr.content.CompileSet;
import de.therazzerapp.hcr.config.JSONConfig;
import de.therazzerapp.hcr.config.JSONConfigSection;

import java.io.File;
import java.util.ArrayList;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class CompileQueueSaver {
    public static void save(ArrayList<CompileSet> compileQueue){
        File file = new File("./compileQueue.json");
        JSONConfig config = new JSONConfig();
        JSONConfigSection root = config.newRootSection();
        for (CompileSet compileSet : compileQueue) {
            JSONConfigSection root2 = root.addConfigSectionArrayEntry("files");
            root2.setString("vmfPath",compileSet.getVmfPath());
            root2.setString("buildSettings",compileSet.getBuildSettings().getName());
        }
        config.save(root,file);
    }
}
