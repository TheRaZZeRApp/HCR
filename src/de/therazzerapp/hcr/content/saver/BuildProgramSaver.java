package de.therazzerapp.hcr.content.saver;

import de.therazzerapp.hcr.config.JSONConfig;
import de.therazzerapp.hcr.config.JSONConfigSection;
import de.therazzerapp.hcr.content.BuildProgram;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class BuildProgramSaver {
    public static void save(Map<String, BuildProgram> buildProgramMap){
        for (Map.Entry<String, BuildProgram> stringBuildProgramEntry : buildProgramMap.entrySet()) {
            JSONConfig config = new JSONConfig();
            JSONConfigSection root = config.newRootSection();
            File file = new File("./Data/build_programs/" + stringBuildProgramEntry.getKey().toLowerCase() + ".json");
            root.setString("name",stringBuildProgramEntry.getValue().getDisplayName());
            root.setString("comment",stringBuildProgramEntry.getValue().getComment());
            root.setString("path",stringBuildProgramEntry.getValue().getPath());
            root.setString("type",stringBuildProgramEntry.getValue().getBuildProgramType().toString());
            config.save(root,file);
        }
    }
}
