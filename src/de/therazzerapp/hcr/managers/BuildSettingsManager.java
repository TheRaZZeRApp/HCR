package de.therazzerapp.hcr.managers;

import de.therazzerapp.hcr.HCRUtils;
import de.therazzerapp.hcr.content.BuildSettings;
import de.therazzerapp.hcr.content.VBSPSettings;
import de.therazzerapp.hcr.content.loader.BuildSettingsLoader;
import de.therazzerapp.hcr.content.saver.BuildSettingsSaver;
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
public class BuildSettingsManager {
    private static Map<String,BuildSettings> buildSettingsMap = new HashMap<>();

    public static void load(){
        buildSettingsMap = BuildSettingsLoader.load();
    }

    public static void save(){
        BuildSettingsSaver.save(buildSettingsMap);
    }

    public static void addBuildSetting(BuildSettings buildSettings){
        buildSettingsMap.put(buildSettings.getName().toLowerCase(),buildSettings);
        save();
        load();
        ContentObserver.update();
    }

    public static void removeBuildSetting(String name){
        HCRUtils.deleteDirectory(new File("./content/buildSettings/" + name));
        buildSettingsMap.remove(name.toLowerCase());
        save();
        load();
        ContentObserver.update();
    }

    public static BuildSettings getBuildSetting(String name){
        return buildSettingsMap.get(name.toLowerCase());
    }

    public static boolean containsBuildSettings(String name){
        return buildSettingsMap.containsKey(name.toLowerCase());
    }

    public static Set<BuildSettings> getBuildSettings(){
        Set<BuildSettings> buildSettingsSet = new HashSet<>();
        for (BuildSettings settings : buildSettingsMap.values()) {
            buildSettingsSet.add(settings);
        }
        return buildSettingsSet;
    }
}
