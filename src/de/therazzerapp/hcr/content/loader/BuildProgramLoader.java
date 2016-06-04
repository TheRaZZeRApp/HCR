package de.therazzerapp.hcr.content.loader;

import de.therazzerapp.hcr.config.JSONConfig;
import de.therazzerapp.hcr.config.JSONConfigSection;
import de.therazzerapp.hcr.content.BuildProgram;
import de.therazzerapp.hcr.content.BuildProgramType;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class BuildProgramLoader {
    public static Map<String, BuildProgram> load(){
        Map<String, BuildProgram> buildProgramMap = new HashMap<String, BuildProgram>();

        File directory = new File("./Data/build_programs/");
        if(!directory.exists()){
            return buildProgramMap;
        }
        File[] files = directory.listFiles();
        for(File klasse : files){
            BuildProgram buildProgram = getBuildProgram(klasse);
            buildProgramMap.put(klasse.getName().toLowerCase().replace(".json",""),buildProgram);
        }

        return buildProgramMap;
    }

    private static BuildProgram getBuildProgram(File file){
        JSONConfigSection root = new JSONConfig().load(file);
        return new BuildProgram(
                file.getName().replace(".json",""),
                root.getString("name"),
                root.getString("comment",""),
                root.getString("path"),
                BuildProgramType.valueOf(root.getString("type")));
    }
}
