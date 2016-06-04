package de.therazzerapp.hcr.content.saver;

import de.therazzerapp.hcr.config.JSONConfig;
import de.therazzerapp.hcr.config.JSONConfigSection;
import de.therazzerapp.hcr.content.BuildSettings;
import de.therazzerapp.hcr.content.VBSPSettings;
import de.therazzerapp.hcr.content.VRADSettings;
import de.therazzerapp.hcr.content.VVISSettings;

import java.io.File;
import java.util.Map;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class BuildSettingsSaver {

    public static void rename(BuildSettings buildSettings, String newDisplayName){
        File file = new File("./Data/compile_presets/" + buildSettings.getName() + "/config.json");
        JSONConfig config = new JSONConfig();
        JSONConfigSection root = config.newRootSection();
        root.setString("name",newDisplayName);
        root.setString("comment",buildSettings.getComment());
        root.setString("vbsp",buildSettings.getVbsp() != null ? buildSettings.getVbsp().getName() : "null");
        root.setString("vvis",buildSettings.getVvis() != null ? buildSettings.getVvis().getName() : "null");
        root.setString("vrad",buildSettings.getVrad() != null ? buildSettings.getVrad().getName() : "null");
        config.save(root,file);
    }

    public static void save(Map<String,BuildSettings> buildSettingsMap){
        for (BuildSettings buildSettings : buildSettingsMap.values()) {
            File directory = new File("./Data/compile_presets/" + buildSettings.getName() + "/");
            saveVBSP(buildSettings.getVbspSettings(),new File(directory,"vbsp.json"));
            saveVVIS(buildSettings.getVvisSettings(),new File(directory,"vvis.json"));
            saveVRAD(buildSettings.getVradSettings(),new File(directory,"vrad.json"));
            File file = new File(directory,"config.json");
            JSONConfig config = new JSONConfig();
            JSONConfigSection root = config.newRootSection();
            root.setString("name",buildSettings.getDisplayName());
            root.setString("comment",buildSettings.getComment());
            root.setString("vbsp",buildSettings.getVbsp() != null ? buildSettings.getVbsp().getName() : "null");
            root.setString("vvis",buildSettings.getVvis() != null ? buildSettings.getVvis().getName() : "null");
            root.setString("vrad",buildSettings.getVrad() != null ? buildSettings.getVrad().getName() : "null");
            config.save(root,file);
        }
    }
    
    private static void saveVBSP(VBSPSettings vbspSettings, File file){
        JSONConfig config = new JSONConfig();
        JSONConfigSection root = config.newRootSection();
        root.setBoolean("verbose",vbspSettings.isVerbose()); 
        root.setBoolean("onlyEnts",vbspSettings.isOnlyEnts());
        root.setBoolean("onlyProps",vbspSettings.isOnlyProps());
        root.setBoolean("glview",vbspSettings.isGlview());
        root.setBoolean("noDetail",vbspSettings.isNoDetail());
        root.setBoolean("noWater",vbspSettings.isNoWater());
        root.setBoolean("low",vbspSettings.isLow());
        root.setString("vProject",vbspSettings.getvProject());
        root.setString("game",vbspSettings.getGame());
        root.setString("embed",vbspSettings.getEmbed());
        root.setBoolean("novConfig",vbspSettings.isNoVConfig());
        root.setString("threads",vbspSettings.getThreads()+ "");
        root.setBoolean("verboseEntities",vbspSettings.isVerboseEntities());
        root.setBoolean("noWeld",vbspSettings.isNoWeld());
        root.setBoolean("noCSG",vbspSettings.isNoCSG());
        root.setBoolean("noShare",vbspSettings.isNoShare());
        root.setBoolean("noJunc",vbspSettings.isNoJunc());
        root.setBoolean("noOpt",vbspSettings.isNoOpt());
        root.setBoolean("noPrune",vbspSettings.isNoPrune());
        root.setBoolean("noMerge",vbspSettings.isNoMerge());
        root.setBoolean("noMergeWater",vbspSettings.isNoMergeWater());
        root.setBoolean("noSubDiv",vbspSettings.isNoSubDiv());
        root.setString("micro",vbspSettings.getMicro()+ "");
        root.setBoolean("fullDetail",vbspSettings.isFullDetail());
        root.setBoolean("leakTest",vbspSettings.isLeakTest());
        root.setBoolean("bumpAll",vbspSettings.isBumpAll());
        root.setBoolean("snapaxial",vbspSettings.isSnapaxial());
        root.setString("block1",vbspSettings.getBlock1()+ "");
        root.setString("block2",vbspSettings.getBlock2()+ "");
        root.setString("blocks1",vbspSettings.getBlocks1()+ "");
        root.setString("blocks2",vbspSettings.getBlocks2()+ "");
        root.setString("blocks3",vbspSettings.getBlocks3()+ "");
        root.setString("blocks4",vbspSettings.getBlocks4()+ "");
        root.setBoolean("dumpStaticProps",vbspSettings.isDumpStaticProps());
        root.setBoolean("dumpCollide",vbspSettings.isDumpCollide());
        root.setString("luxelscale",vbspSettings.getLuxelscale()+ "");
        root.setBoolean("lightIfMissing",vbspSettings.isLightIfMissing());
        root.setBoolean("localphysx",vbspSettings.isLocalphysx());
        root.setBoolean("keepStaleZip",vbspSettings.isKeepStaleZip());
        root.setBoolean("replacematerials",vbspSettings.isReplacematerials());
        root.setBoolean("fullMindumps",vbspSettings.isFullMindumps());
        config.save(root,file);
    }
    
    private static void saveVVIS(VVISSettings vvisSettings, File file){
        JSONConfig config = new JSONConfig();
        JSONConfigSection root = config.newRootSection();
        root.setBoolean("fast",vvisSettings.isFast());
        root.setString("radius_override", vvisSettings.getRadius_override()+ "");
        root.setBoolean("noSort", vvisSettings.isNoSort());
        root.setBoolean("tmpin", vvisSettings.isTmpin());
        root.setBoolean("tmpout", vvisSettings.isTmpout());
        root.setBoolean("low", vvisSettings.isLow());
        root.setString("threads", vvisSettings.getThreads()+ "");
        root.setBoolean("verbose", vvisSettings.isVerbose());
        root.setBoolean("noVConfig", vvisSettings.isNoVConfig());
        root.setBoolean("mpi", vvisSettings.isMpi());
        root.setString("mpi_pw", vvisSettings.getMpi_pw());
        root.setString("vProject", vvisSettings.getvProject());
        root.setString("game", vvisSettings.getGame());
        config.save(root,file);
    }
    
    private static void saveVRAD(VRADSettings vradSettings, File file){
        JSONConfig config = new JSONConfig();
        JSONConfigSection root = config.newRootSection();

        root.setBoolean("ldr", vradSettings.isLdr());
        root.setBoolean("hdr", vradSettings.isHdr());
        root.setBoolean("both", vradSettings.isBoth());
        root.setBoolean("fast", vradSettings.isFast());
        root.setBoolean("finalCompile", vradSettings.isFinalCompile());
        root.setString("extraSky", vradSettings.getExtraSky()+ "");
        root.setString("lights", vradSettings.getLights());
        root.setString("bounce", vradSettings.getBounce()+ "");
        root.setString("smooth", vradSettings.getSmooth()+ "");
        root.setString("luxelDensity", vradSettings.getLuxelDensity()+ "");
        root.setString("softSun", vradSettings.getSoftSun()+ "");
        root.setBoolean("staticPropLighting", vradSettings.isStaticPropLighting());
        root.setBoolean("staticPropPolys", vradSettings.isStaticPropPolys());
        root.setBoolean("textureShadows", vradSettings.isTextureShadows());
        root.setBoolean("low", vradSettings.isLow());
        root.setString("threads", vradSettings.getThreads()+ "");
        root.setBoolean("mpi", vradSettings.isMpi());
        root.setString("mpi_pw", vradSettings.getMpi_pw());
        root.setBoolean("noExtra", vradSettings.isNoExtra());
        root.setString("chop", vradSettings.getChop()+ "");
        root.setString("maxChop", vradSettings.getMaxChop()+ "");
        root.setBoolean("largeDispSampleRadius", vradSettings.isLargeDispSampleRadius());
        root.setString("compressconstant", vradSettings.getCompressconstant()+ "");
        root.setString("staticPropSampleScale", vradSettings.getStaticPropSampleScale()+ "");
        root.setBoolean("rederrors", vradSettings.isRederrors());
        root.setString("vProject", vradSettings.getvProject());
        root.setString("game", vradSettings.getGame());
        root.setBoolean("verbose", vradSettings.isVerbose());
        root.setBoolean("noVConfig", vradSettings.isNoVConfig());
        root.setBoolean("dump", vradSettings.isDump());
        root.setBoolean("dumpNormals", vradSettings.isDumpNormals());
        root.setBoolean("debugExtra", vradSettings.isDebugExtra());
        root.setBoolean("dlightmap", vradSettings.isDlightmap());
        root.setBoolean("stopOnExit", vradSettings.isStopOnExit());
        root.setBoolean("noDetailLight", vradSettings.isNoDetailLight());
        root.setBoolean("centerSamples", vradSettings.isCenterSamples());
        root.setBoolean("logHash", vradSettings.isLogHash());
        root.setBoolean("onlyDetail", vradSettings.isOnlyDetail());
        root.setString("maxDispSampleSize", vradSettings.getMaxDispSampleSize()+ "");
        root.setBoolean("fullMinidump", vradSettings.isFullMinidump());
        root.setBoolean("onlyStaticProps", vradSettings.isOnlyStaticProps());
        root.setBoolean("staticPropNormals", vradSettings.isStaticPropNormals());
        root.setBoolean("noSkyBoxRecurse", vradSettings.isNoSkyBoxRecurse());
        root.setBoolean("noSProps", vradSettings.isNoSProps());
        
        config.save(root,file);
    }
}
