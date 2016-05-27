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
        return buildProgramMap.get(name);
    }

    public static BuildProgram getByTypeIndex(int index, BuildProgramType type){
        int a = 0;
        int b = 0;
        int c = 0;
        for(BuildProgram buildProgram : BuildProgramManager.getBuildProgramms()){
            switch (buildProgram.getBuildProgramType()){
                case VBSP:
                    if(a == index && type == BuildProgramType.VBSP){
                        return buildProgram;
                    }
                    a++;
                    break;
                case VVIS:
                    if(b == index && type == BuildProgramType.VVIS){
                        return buildProgram;
                    }
                    b++;
                    break;
                case VRAD:
                    if(c == index && type == BuildProgramType.VRAD){
                        return buildProgram;
                    }
                    c++;
                    break;
            }
        }
        return null;
    }

    public static BuildProgram getByDisplayName(String displayName){
        for (BuildProgram buildProgram : buildProgramMap.values()) {
            if(buildProgram.getDisplayName().equals(displayName)){
                return buildProgram;
            }
        }
        return null;
    }

    public static BuildProgram getBuildProgram(int position){
        int i = 0;
        for (BuildProgram buildProgram : buildProgramMap.values()) {
            if (i == position)
                return buildProgram;
        }
        return null;
    }

    public static Set<BuildProgram> getBuildProgramms(){
        Set<BuildProgram> buildPrograms = new HashSet<BuildProgram>();
        for (BuildProgram buildProgram : buildProgramMap.values()) {
            buildPrograms.add(buildProgram);
        }
        return buildPrograms;
    }
}
