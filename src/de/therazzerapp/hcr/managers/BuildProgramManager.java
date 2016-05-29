package de.therazzerapp.hcr.managers;

import de.therazzerapp.hcr.content.BuildProgram;
import de.therazzerapp.hcr.content.BuildProgramType;
import de.therazzerapp.hcr.content.BuildSettings;
import de.therazzerapp.hcr.content.loader.BuildProgramLoader;
import de.therazzerapp.hcr.content.saver.BuildProgramSaver;

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
        buildProgramMap.put(buildProgram.getName(),buildProgram);
        save();
    }

    public static void removeBuildProgram(BuildProgram buildProgram){
        buildProgramMap.remove(buildProgram.getName());
        save();
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
