package de.therazzerapp.hcr;

import de.therazzerapp.hcr.content.BuildSettings;
import de.therazzerapp.hcr.content.CompileSet;
import de.therazzerapp.hcr.content.CompileThread;
import de.therazzerapp.hcr.gui.CompilerLogSyncThread;
import de.therazzerapp.hcr.gui.ConsoleCommander;
import de.therazzerapp.hcr.gui.ui.HCR_Gui;
import de.therazzerapp.hcr.gui.ui.SavePreset_Gui;
import de.therazzerapp.hcr.gui.ui.ToolBuildPrograms_Gui;
import de.therazzerapp.hcr.gui.ui.ToolPresets_Gui;
import de.therazzerapp.hcr.managers.BuildProgramManager;
import de.therazzerapp.hcr.managers.BuildSettingsManager;
import de.therazzerapp.hcr.managers.CompileQueueManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class HCR {

    private static String vmfPath = "";
    private static String vmfFile = "";
    private static String gameDir = "";
    private static String selectedBuildSettings = "";
    private static boolean autostart = false;
    private static boolean autoclose = false;
    private static CompileSet autostartCompileSet;

    public static CompileSet getAutostartCompileSet() {
        return autostartCompileSet;
    }

    public static String buildNumber = "b0.0.0";

    public static final JFrame mainFrame = new JFrame("Hammer Compiler Replacement");
    public static final JFrame savePresetFrame = new JFrame("Save Compile Preset");
    public static final JFrame toolPresetsFrame = new JFrame("Presets");
    public static final JFrame toolBuildProgramsFrame = new JFrame("Build Programs");

    public static final HCR_Gui hcr_gui = new HCR_Gui(mainFrame);
    public static final SavePreset_Gui savePreset_gui = new SavePreset_Gui(savePresetFrame);
    public static final ToolPresets_Gui toolPresets_gui = new ToolPresets_Gui(toolPresetsFrame);
    public static final ToolBuildPrograms_Gui toolBuildPrograms_gui = new ToolBuildPrograms_Gui(toolBuildProgramsFrame);

    public static String getVmfPath() {
        return vmfPath;
    }

    public static String getSelectedBuildSettings() {
        return selectedBuildSettings;
    }

    public static boolean isAutostart() {
        return autostart;
    }

    public static boolean isAutoclose() {
        return autoclose;
    }

    public static void main(String[] args) {

        BuildProgramManager.load();
        BuildSettingsManager.load();
        CompileQueueManager.load();

        mainFrame.setContentPane(hcr_gui.getjPanel());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setSize(1000,650);
        mainFrame.setTitle("Hammer Compiler Replacement " + buildNumber);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setMinimumSize(new Dimension(900,550));
        mainFrame.setResizable(false);

        savePresetFrame.setContentPane(savePreset_gui.getMainPanel());
        savePresetFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        savePresetFrame.pack();
        savePresetFrame.setVisible(false);
        savePresetFrame.setSize(600,300);
        savePresetFrame.setTitle("Save Compile Preset");
        savePresetFrame.setLocationRelativeTo(null);
        savePresetFrame.setResizable(false);

        toolPresetsFrame.setContentPane(toolPresets_gui.getjPanel());
        toolPresetsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        toolPresetsFrame.pack();
        toolPresetsFrame.setVisible(false);
        toolPresetsFrame.setSize(700,400);
        toolPresetsFrame.setTitle("Compile Presets");
        toolPresetsFrame.setLocationRelativeTo(null);
        toolPresetsFrame.setResizable(false);


        ConsoleCommander.sendInfo("HCR " +buildNumber+" started successfully.");

        if (args.length > 1){
            switch (args.length){
                case 2:
                    vmfPath = args[0];
                    vmfFile = args[1];
                    break;
                case 3:
                    vmfPath = args[0];
                    vmfFile = args[1];
                    gameDir = args[2];
                    break;
                case 4:
                    vmfPath = args[0];
                    vmfFile = args[1];
                    gameDir = args[2];
                    selectedBuildSettings = args[3];
                    break;
                case 5:
                    vmfPath = args[0];
                    vmfFile = args[1];
                    gameDir = args[2];
                    selectedBuildSettings = args[3];
                    autostart = Boolean.valueOf(args[4]);
                    autoclose = Boolean.valueOf(args[3]);
                    break;
                default:
                    vmfPath = args[0];
                    vmfFile = args[1];
                    gameDir = args[2];
                    selectedBuildSettings = args[3];
                    autostart = Boolean.valueOf(args[4]);
                    autoclose = Boolean.valueOf(args[5]);
                    break;
            }

            if(!BuildSettingsManager.containsBuildSettings(selectedBuildSettings)){
                ConsoleCommander.sendError("Wrong build preset parameter: " + selectedBuildSettings + " not found!");
            } else {
                if(autostart){
                    hcr_gui.getCompileTabbedPane().setSelectedIndex(1);
                    hcr_gui.getVmfFilePathTextFiel().setText(vmfPath);

                    BuildSettings buildSettings = BuildSettingsManager.getBuildSetting(selectedBuildSettings);
                    if(!gameDir.isEmpty() || !gameDir.equals("null")){
                        buildSettings.setGameDir(gameDir);
                    }

                    CompileThread compileThread = new CompileThread(new CompileSet(vmfPath + "\\" + vmfFile,BuildSettingsManager.getBuildSetting(selectedBuildSettings)));
                    compileThread.start();
                    new CompilerLogSyncThread(compileThread.getLog()).start();

                    if(autoclose){
                        Runtime runtime = Runtime.getRuntime();
                        try {
                            Process proc = runtime.exec("shutdown -s -t 1");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.exit(0);
                    }

                } else {
                    CompileQueueManager.addCompileToQueue(new CompileSet(vmfPath,BuildSettingsManager.getBuildSetting(selectedBuildSettings)));
                }
            }
        }

        /*
        BuildProgram vvis1 = new BuildProgram("vvis_0","VVIS 1","Das erste VVIS","E:\\Steam\\SteamApps\\common\\Counter-Strike Global Offensive\\bin\\vvis.exe",BuildProgramType.VVIS);
        BuildProgram vrad1 = new BuildProgram("vrad_0","VRAD 1","","E:\\Steam\\SteamApps\\common\\Counter-Strike Global Offensive\\bin\\vrad_1.34.9.4\\bin\\vrad.exe",BuildProgramType.VRAD);
        BuildProgram vbsp1 = new BuildProgram("vbsp_0","VBSP 1","Der erste VBSP Versuch","E:\\Steam\\SteamApps\\common\\Counter-Strike Global Offensive\\bin\\vbsp.exe",BuildProgramType.VBSP);

        BuildProgramManager.addBuildProgram(vvis1);
        BuildProgramManager.addBuildProgram(vrad1);
        BuildProgramManager.addBuildProgram(vbsp1);
        BuildProgramManager.save();

        VBSPSettings vbspSettings = new VBSPSettings(false,false,false,false,false,false,false,null,"E:\\Steam\\SteamApps\\common\\Counter-Strike Global Offensive\\csgo",null,false,4,false,false,false,false,false,false,false,false,false
                ,false,null,false,false,false,false,null,null,null,null,null,null,false,false,null,false,false,false,false,false);
        VVISSettings vvisSettings = new VVISSettings(true,null,false,false,false,false,4,false,false,false,null,null,"E:\\Steam\\SteamApps\\common\\Counter-Strike Global Offensive\\csgo");
        VRADSettings vradSettings = new VRADSettings(true,false,false,true,false,null,null,null,null,null,null,false,false,false,false,4,false,null,false,null,null,false,null,null,false,null,"E:\\Steam\\SteamApps\\common\\Counter-Strike Global Offensive\\csgo",false,false,
                false,false,false,false,false,false,false,false,false,null,false,false,false,false,false);
        BuildSettings buildSettings = new BuildSettings(vradSettings,vbspSettings,vvisSettings,vbsp1,vvis1,vrad1,"bs_0","Test Nummer ONE","Der aller erste Test!");

        BuildSettingsManager.addBuildSetting("test_1",buildSettings);

        File vmfPath = new File("E:\\Steam\\SteamApps\\common\\Counter-Strike Global Offensive\\sdk_content\\maps\\de_bottlestreet_pre_alpha_b009.vmf");

        CompileSet compileSet = new CompileSet(vmfPath.getPath(),buildSettings,vbsp1,vvis1,vrad1);
        CompileQueueManager.addCompileToQueue(compileSet);
        CompileQueueManager.addCompileToQueue(compileSet);
        CompileQueueManager.runCompiles();

        BuildSettingsManager.load();
        */
    }
}
