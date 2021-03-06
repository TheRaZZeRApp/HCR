package de.therazzerapp.hcr.managers;

import de.therazzerapp.hcr.HCRUtils;
import de.therazzerapp.hcr.content.BuildProgram;
import de.therazzerapp.hcr.content.BuildProgramType;
import de.therazzerapp.hcr.content.BuildSettings;
import de.therazzerapp.hcr.content.loader.BuildProgramLoader;
import de.therazzerapp.hcr.content.saver.BuildProgramSaver;
import de.therazzerapp.hcr.gui.ContentObserver;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class BuildProgramManager {
    private static Map<String, BuildProgram> buildProgramMap = new HashMap<String, BuildProgram>();

    public static void load(){
        buildProgramMap = BuildProgramLoader.load();
    }

    public static void save(){
        BuildProgramSaver.save(buildProgramMap);
    }

    public static void addBuildProgram(BuildProgram buildProgram){
        buildProgramMap.put(buildProgram.getName().toLowerCase(),buildProgram);
        save();
        ContentObserver.update(1);
    }

    public static void removeBuildProgram(BuildProgram buildProgram){
        HCRUtils.deleteDirectory(new File("./Data/build_programs/" + buildProgram.getName()));
        buildProgramMap.remove(buildProgram.getName());
        save();
        ContentObserver.update(1);
    }

    public static boolean containsBuildProgram(String name){
        return buildProgramMap.containsKey(name.toLowerCase());
    }

    public static BuildProgram getBuildProgram(String name){
        return buildProgramMap.get(name.toLowerCase());
    }


    public static Set<BuildProgram> getBuildProgramms(){
        Set<BuildProgram> buildPrograms = new HashSet<BuildProgram>();
        for (BuildProgram buildProgram : buildProgramMap.values()) {
            buildPrograms.add(buildProgram);
        }
        return buildPrograms;
    }
}
