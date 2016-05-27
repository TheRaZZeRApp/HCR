package de.therazzerapp.hcr.managers;

import de.therazzerapp.hcr.HCRUtils;
import de.therazzerapp.hcr.content.BuildSettings;
import de.therazzerapp.hcr.content.VBSPSettings;
import de.therazzerapp.hcr.content.loader.BuildSettingsLoader;
import de.therazzerapp.hcr.content.saver.BuildSettingsSaver;

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
public class BuildSettingsManager {
    private static Map<String,BuildSettings> buildSettingsMap = new HashMap<>();

    public static void load(){
        buildSettingsMap = BuildSettingsLoader.load();
    }

    public static void save(){
        BuildSettingsSaver.save(buildSettingsMap);
    }

    public static void addBuildSetting(String name, BuildSettings buildSettings){
        buildSettingsMap.put(name,buildSettings);
        save();
        load();
    }

    public static int getSize(){
        return buildSettingsMap.size();
    }

    public static void removeBuildSetting(String name){
        HCRUtils.deleteDirectory(new File("./buildSettings/" + buildSettingsMap.get(name).getName()));
        buildSettingsMap.remove(name);
        save();
        load();
    }

    public static BuildSettings getBuildSetting(String name){
        return buildSettingsMap.get(name);
    }

    public static boolean containsBuildSettings(String name){
        return buildSettingsMap.containsKey(name);
    }

    public static boolean containsBuildSettingsByDisplayName(String displayname){
        for (BuildSettings buildSettings : buildSettingsMap.values()) {
            if(buildSettings.getDisplayName().equals(displayname)){
                return true;
            }
        }
        return false;
    }

    public static BuildSettings getByDisplayName(String displayname){
        for (BuildSettings buildSettings : buildSettingsMap.values()) {
            if(buildSettings.getDisplayName().equals(displayname)){
                return buildSettings;
            }
        }
        return null;
    }

    public static BuildSettings getBuildSetting(int position){
        int i = 0;
        for (BuildSettings buildSettings : buildSettingsMap.values()) {
            if (i == position){
                return buildSettings;
            }
            i++;
        }
        return null;
    }

    public static Set<BuildSettings> getBuildSettings(){
        Set<BuildSettings> buildSettingsSet = new HashSet<>();
        for (BuildSettings settings : buildSettingsMap.values()) {
            buildSettingsSet.add(settings);
        }
        return buildSettingsSet;
    }
}
