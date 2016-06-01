package de.therazzerapp.hcr;

import de.therazzerapp.hcr.content.BuildSettings;
import de.therazzerapp.hcr.content.CompileSet;
import de.therazzerapp.hcr.content.CompileThread;
import de.therazzerapp.hcr.gui.CompilerLogSyncThread;
import de.therazzerapp.hcr.gui.ConsoleCommander;
import de.therazzerapp.hcr.gui.ContentObserver;
import de.therazzerapp.hcr.gui.ui.*;
import de.therazzerapp.hcr.managers.BuildProgramManager;
import de.therazzerapp.hcr.managers.BuildSettingsManager;
import de.therazzerapp.hcr.managers.CompileQueueManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;


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

    public static final HCR_Gui hcr_gui = new HCR_Gui(mainFrame);
    public static final SavePreset_Gui savePreset_gui = new SavePreset_Gui(savePresetFrame);
    public static final SaveProgram_Gui saveProgram_gui = new SaveProgram_Gui(savePresetFrame);
    public static final ToolPresets_Gui toolPresets_gui = new ToolPresets_Gui(toolPresetsFrame);
    public static final ToolBuildPrograms_Gui toolBuildPrograms_gui = new ToolBuildPrograms_Gui(toolPresetsFrame);

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


    public static void openToolPresetDialoga(){
        toolPresetsFrame.setContentPane(toolPresets_gui.getjPanel());
        toolPresetsFrame.setTitle("Compile Presets");
        toolPresetsFrame.setVisible(true);
        toolPresetsFrame.setAutoRequestFocus(true);
    }

    public static void openToolBuildProggramsDialoga(){
        toolPresetsFrame.setContentPane(toolBuildPrograms_gui.getjPanel());
        toolPresetsFrame.setTitle("Build Programs");
        toolPresetsFrame.setVisible(true);
        toolPresetsFrame.setAutoRequestFocus(true);
    }

    private static void openSaveDialog(JPanel panel){
        savePresetFrame.setContentPane(panel);
        savePresetFrame.setVisible(true);
        savePresetFrame.setEnabled(true);
        savePresetFrame.setAutoRequestFocus(true);
        saveProgram_gui.getSavePanel().setVisible(true);
        saveProgram_gui.getOverwrirePanel().setVisible(false);
        saveProgram_gui.getSaveButton().setVisible(true);
        saveProgram_gui.getSaveCancelButton().setVisible(true);
    }

    public static void openSaveProgramDialog(){
        openSaveDialog(saveProgram_gui.getMainPanel());
    }

    public static void openSavePresetDialog(){
        openSaveDialog(savePreset_gui.getMainPanel());
    }

    public static void openOverwritePresetDialog(){
        savePresetFrame.setContentPane(savePreset_gui.getMainPanel());
        savePresetFrame.setVisible(true);
        savePresetFrame.setEnabled(true);
        savePresetFrame.setAutoRequestFocus(true);
        savePreset_gui.getSavePanel().setVisible(false);
        savePreset_gui.getOverwrirePanel().setVisible(true);
        savePreset_gui.getSaveButton().setVisible(false);
        savePreset_gui.getSaveCancelButton().setVisible(false);
    }

    public static void main(String[] args) {

        BuildProgramManager.load();
        BuildSettingsManager.load();
        CompileQueueManager.load();

        URL resource1 = HCR.class.getResource( "images/icon_32.png" );
        mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(resource1));
        mainFrame.setContentPane(hcr_gui.getjPanel());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setSize(1000,650);
        mainFrame.setTitle("Hammer Compiler Replacement " + buildNumber);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setMinimumSize(new Dimension(900,550));
        mainFrame.setResizable(false);

        savePresetFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(resource1));
        savePresetFrame.setContentPane(savePreset_gui.getMainPanel());
        savePresetFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        savePresetFrame.pack();
        savePresetFrame.setVisible(false);
        savePresetFrame.setSize(600,300);
        savePresetFrame.setTitle("Save Compile Preset");
        savePresetFrame.setLocationRelativeTo(null);
        savePresetFrame.setResizable(false);

        toolPresetsFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(resource1));
        toolPresetsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        toolPresetsFrame.pack();
        toolPresetsFrame.setVisible(false);
        toolPresetsFrame.setSize(700,400);
        toolPresetsFrame.setLocationRelativeTo(null);
        toolPresetsFrame.setResizable(false);

        ContentObserver.addContentUser(hcr_gui);
        ContentObserver.addContentUser(savePreset_gui);
        ContentObserver.addContentUser(saveProgram_gui);
        ContentObserver.addContentUser(toolBuildPrograms_gui);
        ContentObserver.addContentUser(toolPresets_gui);
        ContentObserver.update();

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
                    hcr_gui.setCompileThread(compileThread);
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
    }
}
