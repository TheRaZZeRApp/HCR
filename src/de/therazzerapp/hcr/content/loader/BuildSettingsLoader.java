package de.therazzerapp.hcr.content.loader;

import de.therazzerapp.hcr.config.JSONConfig;
import de.therazzerapp.hcr.config.JSONConfigSection;
import de.therazzerapp.hcr.content.BuildSettings;
import de.therazzerapp.hcr.content.VBSPSettings;
import de.therazzerapp.hcr.content.VRADSettings;
import de.therazzerapp.hcr.content.VVISSettings;
import de.therazzerapp.hcr.filter.FileFilter;
import de.therazzerapp.hcr.managers.BuildProgramManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class BuildSettingsLoader {
    public static Map<String,BuildSettings> load(){
        Map<String, BuildSettings> buildSettingsMap = new HashMap<>();

        File directory = new File("./content/buildSettings/");
        if(!directory.exists()){
            return buildSettingsMap;
        }
        File[] files = directory.listFiles(FileFilter.buildSettingsDirFilter);
        for (File file : files) {
            JSONConfigSection root = new JSONConfig().load(new File(file,"config.json"));
            buildSettingsMap.put(file.getName().toLowerCase(),new BuildSettings(
                    getVRADSettings(new File(file,"vrad.json")),
                    getVBSPSettings(new File(file,"vbsp.json")),
                    getVVISSettings(new File(file,"vvis.json")),
                    root.getString("vbsp").equals("null") ? null : BuildProgramManager.getBuildProgram(root.getString("vbsp")),
                    root.getString("vvis").equals("null") ? null : BuildProgramManager.getBuildProgram(root.getString("vvis")),
                    root.getString("vrad").equals("null") ? null : BuildProgramManager.getBuildProgram(root.getString("vrad")),
                    file.getName().replace(".json",""),
                    root.getString("name"),
                    root.getString("comment")));
        }
        return buildSettingsMap;
    }

    private static Double getDoubleValue(JSONConfigSection root, String value){
        if (root.getString(value).equals("null") || root.getString(value) == null){
            return null;
        } else {
            return Double.parseDouble(root.getString(value));
        }
    }

    private static Integer getIntValue(JSONConfigSection root, String value){
        if (root.getString(value).equals("null") || root.getString(value) == null){
            return null;
        } else {
            return Integer.parseInt(root.getString(value));
        }
    }

    private static Float getFloatValue(JSONConfigSection root, String value){
        if (root.getString(value).equals("null") || root.getString(value) == null){
            return null;
        } else {
            return Float.parseFloat(root.getString(value));
        }
    }

    private static VBSPSettings getVBSPSettings(File file){
        JSONConfigSection root = new JSONConfig().load(file);

        return new VBSPSettings(
                root.getString("game"),
                getIntValue(root,"threads"),
                root.getBoolean("verbose"),
                root.getBoolean("low"),
                root.getBoolean("novConfig"),
                root.getString("vProject"),
                root.getBoolean("onlyEnts"),
                root.getBoolean("onlyProps"),
                root.getBoolean("glview"),
                root.getBoolean("noDetail"),
                root.getBoolean("noWater"),
                root.getString("embed"),
                root.getBoolean("verboseEntities"),
                root.getBoolean("noWeld"),
                root.getBoolean("noCSG"),
                root.getBoolean("noShare"),
                root.getBoolean("noJunc"),
                root.getBoolean("noOpt"),
                root.getBoolean("noPrune"),
                root.getBoolean("noMerge"),
                root.getBoolean("noMergeWater"),
                root.getBoolean("noSubDiv"),
                getDoubleValue(root,"micro"),
                root.getBoolean("fullDetail"),
                root.getBoolean("leakTest"),
                root.getBoolean("bumpAll"),
                root.getBoolean("snapaxial"),
                getDoubleValue(root,"block1"),
                getDoubleValue(root,"block2"),
                getDoubleValue(root,"blocks1"),
                getDoubleValue(root,"blocks2"),
                getDoubleValue(root,"blocks3"),
                getDoubleValue(root,"blocks4"),
                root.getBoolean("dumpStaticProps"),
                root.getBoolean("dumpCollide"),
                getDoubleValue(root,"luxelscale"),
                root.getBoolean("lightIfMissing"),
                root.getBoolean("localphysx"),
                root.getBoolean("keepStaleZip"),
                root.getBoolean("replacematerials"),
                root.getBoolean("fullMindumps"));

    }

    private static VVISSettings getVVISSettings(File file){
        JSONConfigSection root = new JSONConfig().load(file);
        return new VVISSettings(
                root.getString("game"),
                getIntValue(root,"threads"),
                root.getBoolean("verbose"),
                root.getBoolean("low"),
                root.getBoolean("noVConfig"),
                root.getString("vProject"),
                root.getBoolean("fast"),
                getIntValue(root,"radius_override"),
                root.getBoolean("noSort"),
                root.getBoolean("tmpin"),
                root.getBoolean("tmpout"),
                root.getBoolean("mpi"),
                root.getString("mpi_pw")
        );
    }

    private static VRADSettings getVRADSettings(File file){
        JSONConfigSection root = new JSONConfig().load(file);
        return new VRADSettings(
                root.getString("game"),
                getIntValue(root,"threads"),
                root.getBoolean("verbose"),
                root.getBoolean("low"),
                root.getBoolean("noVConfig"),
                root.getString("vProject"),
                root.getBoolean("ldr"),
                root.getBoolean("hdr"),
                root.getBoolean("both"),
                root.getBoolean("fast"),
                root.getBoolean("finalCompile"),
                root.getString("lights"),
                root.getBoolean("staticPropLighting"),
                root.getBoolean("staticPropPolys"),
                root.getBoolean("textureShadows"),
                getIntValue(root,"staticPropSampleScale"),
                getIntValue(root,"bounce"),
                getIntValue(root,"extraSky"),
                getIntValue(root,"smooth"),
                getFloatValue(root,"luxelDensity"),
                getFloatValue(root,"softSun"),
                root.getBoolean("mpi"),
                root.getString("mpi_pw"),
                root.getBoolean("noExtra"),
                getIntValue(root,"chop"),
                getIntValue(root,"maxChop"),
                root.getBoolean("largeDispSampleRadius"),
                getIntValue(root,"compressconstant"),
                root.getBoolean("rederrors"),
                root.getBoolean("dump"),
                root.getBoolean("dumpNormals"),
                root.getBoolean("debugExtra"),
                root.getBoolean("dlightmap"),
                root.getBoolean("stopOnExit"),
                root.getBoolean("noDetailLight"),
                root.getBoolean("centerSamples"),
                root.getBoolean("logHash"),
                root.getBoolean("onlyDetail"),
                getIntValue(root,"maxDispSampleSize"),
                root.getBoolean("fullMinidump"),
                root.getBoolean("onlyStaticProps"),
                root.getBoolean("staticPropNormals"),
                root.getBoolean("noSkyBoxRecurse"),
                root.getBoolean("noSProps")
                );
    }
}
