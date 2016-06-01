package de.therazzerapp.hcr.gui.ui;

import de.therazzerapp.hcr.HCR;
import de.therazzerapp.hcr.content.*;
import de.therazzerapp.hcr.filter.RadFileFilter;
import de.therazzerapp.hcr.filter.VMFFileFilter;
import de.therazzerapp.hcr.gui.CompilerLogSyncThread;
import de.therazzerapp.hcr.gui.ConsoleCommander;
import de.therazzerapp.hcr.gui.ContentUpdater;
import de.therazzerapp.hcr.managers.BuildProgramManager;
import de.therazzerapp.hcr.managers.BuildSettingsManager;
import de.therazzerapp.hcr.managers.CompileQueueManager;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class HCR_Gui implements ContentUpdater{
    private JPanel jPanel;
    private JButton welcomeChooseVMFButton;
    private JPanel mainPanel;
    private JPanel welcomePane;
    private JPanel consolePanel;
    private JPanel settingsPanel;
    private JPanel buildSettingsPanel;
    private JPanel compilePanel;
    private JScrollPane consoleScrollpane;
    private JTextPane consoleOutputArea;
    private JComboBox buildSettingsChooser;
    private JButton savePresetButton;
    private JButton editPresetsButton;
    private JComboBox vbspChooser;
    private JComboBox vvisChooser;
    private JComboBox vradChooser;
    private JRadioButton compileQueueRadioButton;
    private JButton runButton;
    private JButton stopButton;
    private JButton pauseButton;
    private JTabbedPane tabbedPane1;
    private JTabbedPane compileTabbedPane;
    private JTextArea compileOutputArea;
    private JScrollPane compileOutputScrollPane;
    private JTextField vmfFilePathTextFiel;
    private JButton chooseVMFFileButton;
    private JPanel queuePane;
    private JCheckBox enableCompileQueueCheckBox;
    private JButton addButton;
    private JButton removeButton;
    private JButton upButton;
    private JButton downButton;
    private JPanel vbspPanel;
    private JCheckBox vbspGameCheckBox;
    private JTextField vbspGameField;
    private JCheckBox vbspthreadsCheckBox;
    private JSpinner vbspThreadsSpinner;
    private JCheckBox vbspverboseCheckBox;
    private JCheckBox vbsponlyEntsCheckBox;
    private JCheckBox vbsponlyPropsCheckBox;
    private JCheckBox vbspglViewCheckBox;
    private JCheckBox vbspnoWaterCheckBox;
    private JCheckBox vbspnoDetailCheckBox;
    private JCheckBox vbsplowCheckBox;
    private JCheckBox vbspvProjectCheckBox;
    private JTextField vbspVProjectField;
    private JCheckBox vbspembedCheckBox;
    private JTextField vbspEmbedField;
    private JCheckBox vbspnovConfigCheckBox;
    private JCheckBox vbspverboseEntitiesCheckBox;
    private JCheckBox vbspnoWeldCheckBox;
    private JCheckBox vbspnoCSGCheckBox;
    private JCheckBox vbspnoShareCheckBox;
    private JCheckBox vbspfullMinDumpsCheckBox;
    private JCheckBox vbspreplaceMaterialsCheckBox;
    private JCheckBox vbspkeepStaleZipCheckBox;
    private JCheckBox vbsplocalPhysXCheckBox;
    private JCheckBox vbsplightIfMissingCheckBox;
    private JCheckBox vbspluxelScaleCheckBox;
    private JSpinner vbspLuxelScaleSpinner;
    private JCheckBox vbspdumpCollideCheckBox;
    private JCheckBox vbspdumpStaticPropsCheckBox;
    private JCheckBox vbspblocksCheckBox;
    private JTextField vbspBlocks1;
    private JTextField vbspBlocks2;
    private JTextField vbspBlocks3;
    private JTextField vbspBlocks4;
    private JCheckBox vbspblockCheckBox;
    private JTextField vbspBlock1;
    private JTextField vbspBlock2;
    private JCheckBox vbspsnapAxialCheckBox;
    private JCheckBox vbspbumpAllCheckBox;
    private JCheckBox vbspleakTestCheckBox;
    private JCheckBox vbspfullDetailCheckBox;
    private JCheckBox vbspmicroCheckBox;
    private JTextField vbspMicroField;
    private JCheckBox vbspnoSubDivCheckBox;
    private JCheckBox vbspnoMergeWaterCheckBox;
    private JCheckBox vbspnoMergeCheckBox;
    private JCheckBox vbspnoPruneCheckBox;
    private JPanel vvisPanel;
    private JTextField vvisGameField;
    private JCheckBox vvisthreadsCheckBox;
    private JCheckBox vvisfastCheckBox;
    private JCheckBox vvisradius_overrideCheckBox;
    private JSpinner vvisRadiusSpinner;
    private JCheckBox vvisnoSortCheckBox;
    private JCheckBox vvistmpinCheckBox;
    private JCheckBox vvistmpoutCheckBox;
    private JCheckBox vvisLowCheckBox;
    private JCheckBox vvisverboseCheckBox;
    private JCheckBox vvisnoVConfigCheckBox;
    private JCheckBox vvisvProjectCheckBox;
    private JTextField vvisVProjectField;
    private JCheckBox vvismpiCheckBox;
    private JCheckBox vvismpi_pwCheckBox;
    private JTextField vvisMPIPW;
    private JCheckBox vvisGameCheckBox;
    private JSpinner vvisThreadsSpinner;
    private JRadioButton vbspRadioButton;
    private JRadioButton vvisRadioButton;
    private JRadioButton vradRadioButton;
    private JPanel vradPane;
    private JTextField vradGameField;
    private JCheckBox vradThreadCheckBox;
    private JSpinner vradTreadSpinner;
    private JCheckBox vradverboseCheckBox;
    private JCheckBox vradldrCheckBox;
    private JCheckBox vradhdrCheckBox;
    private JCheckBox vradbothCheckBox;
    private JCheckBox vradfinalCheckBox;
    private JCheckBox vradstaticPropLightingCheckBox;
    private JCheckBox vradstaticPropPolysCheckBox;
    private JCheckBox vradtextureShadowsCheckBox;
    private JCheckBox vradstaticPropSampleScaleCheckBox;
    private JSpinner vradStaticPropSampleScaleSpinner;
    private JCheckBox vradlightsCheckBox;
    private JTextField vradLightsField;
    private JCheckBox vbspNoTJuncCheckBox;
    private JCheckBox vbspNoOptCheckBox;
    private JCheckBox vradGameCheckBox;
    private JCheckBox vradfastCheckBox;
    private JCheckBox vradnoSPropsCheckBox;
    private JCheckBox vradnoSkyBoxRecurseCheckBox;
    private JCheckBox vradstaticPropNormalsCheckBox;
    private JCheckBox vradonlyStaticPropsCheckBox;
    private JCheckBox vradfullMinidumpCheckBox;
    private JCheckBox vradmaxDispSampleSizeCheckBox;
    private JSpinner vradmaxDispSampleSize;
    private JCheckBox vradonlyDetailCheckBox;
    private JCheckBox vradlogHashCheckBox;
    private JCheckBox vradcenterSamplesCheckBox;
    private JCheckBox vradnoDetailLightCheckBox;
    private JCheckBox vradstopOnExitCheckBox;
    private JCheckBox vraddlightmapCheckBox;
    private JCheckBox vraddebugExtraCheckBox;
    private JCheckBox vraddumpNormalsCheckBox;
    private JCheckBox vraddumpCheckBox;
    private JCheckBox vradnoVConfigCheckBox;
    private JCheckBox vradvProjectCheckBox;
    private JTextField vradvProjectField;
    private JCheckBox vradrederrorsCheckBox;
    private JCheckBox vradcompressconstantCheckBox;
    private JSpinner vradcompressconstantSpinner;
    private JCheckBox vradlargeDispSampleRadiusCheckBox;
    private JCheckBox vradmaxChopCheckBox;
    private JSpinner vradmaxChopSpinner;
    private JCheckBox vradchopCheckBox;
    private JSpinner vradChopSpinner;
    private JCheckBox vradnoExtraCheckBox;
    private JCheckBox vradmpi_pwCheckBox;
    private JTextField vradmpi_pwField;
    private JCheckBox vradmpiCheckBox;
    private JCheckBox vradlowCheckBox;
    private JCheckBox vradsoftSunCheckBox;
    private JSpinner vradsoftSunSpinner;
    private JCheckBox vradluxelDensityCheckBox;
    private JSpinner vradluxelDensitySpinner;
    private JCheckBox vradsmoothCheckBox;
    private JSpinner vradsmoothSpinner;
    private JCheckBox vradextraSkyCheckBox;
    private JSpinner vradextraSkySpinner;
    private JCheckBox vradbounceCheckBox;
    private JSpinner vradbounceSpinner;
    private JButton welcomeSettingsButton;
    private JCheckBox shutDownAfterCompileCheckBox;
    private JTextPane compileOutputAnalysisTextPane;

    private boolean pauseToggle = false;

    private CompileThread compileThread;
    private String lastSelectedVMF;

    private JFileChooser openVMFDialog = new JFileChooser();
    private JFileChooser openRadDialog = new JFileChooser();

    private String unselectedBuildPreset = "<Unsaved Preset>";

    public void setCompileThread(CompileThread compileThread) {
        this.compileThread = compileThread;
    }

    private void addCheckListener(JCheckBox checkBox, JComponent component){
        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checkBox.isSelected()){
                    component.setEnabled(true);
                } else {
                    component.setEnabled(false);
                }
            }
        });
    }

    public HCR_Gui(JFrame jFrame) {


        welcomePane.setEnabled(false);
        welcomePane.setVisible(false);

        /*
        if (HCR.getVmfPath().isEmpty() || HCR.getVmfPath() == null || !(new File(HCR.getVmfPath()).exists())){
            mainPanel.setEnabled(false);
            mainPanel.setVisible(false);
            welcomePane.setEnabled(true);
            welcomePane.setVisible(true);
        }
        */



        addListener(jFrame);

        VMFFileFilter vmfFileFilter = new VMFFileFilter();
        openVMFDialog.setDialogTitle("Choose a VMF");
        openVMFDialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
        openVMFDialog.addChoosableFileFilter(vmfFileFilter);
        openVMFDialog.setFileFilter(vmfFileFilter);
        openVMFDialog.setAcceptAllFileFilterUsed(false);

        RadFileFilter radFileFilter = new RadFileFilter();
        openRadDialog.setDialogTitle("Choose a .rad");
        openRadDialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
        openRadDialog.addChoosableFileFilter(radFileFilter);
        openRadDialog.setFileFilter(radFileFilter);
        openRadDialog.setAcceptAllFileFilterUsed(false);

        addMenuBar(jFrame);

        DefaultCaret caret = (DefaultCaret) compileOutputArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        compileOutputScrollPane.getViewport().setAutoscrolls(true);

        //CheckBox Listener
        addCheckListener(vbspGameCheckBox,vbspGameField);
        addCheckListener(vbspthreadsCheckBox,vbspThreadsSpinner);
        addCheckListener(vbspvProjectCheckBox,vbspVProjectField);
        addCheckListener(vbspembedCheckBox,vbspEmbedField);
        addCheckListener(vbspmicroCheckBox,vbspMicroField);
        addCheckListener(vbspblockCheckBox,vbspBlock1);
        addCheckListener(vbspblockCheckBox,vbspBlock2);
        addCheckListener(vbspblocksCheckBox,vbspBlocks1);
        addCheckListener(vbspblocksCheckBox,vbspBlocks2);
        addCheckListener(vbspblocksCheckBox,vbspBlocks3);
        addCheckListener(vbspblocksCheckBox,vbspBlocks4);
        addCheckListener(vbspluxelScaleCheckBox,vbspLuxelScaleSpinner);

        addCheckListener(vvisGameCheckBox,vvisGameField);
        addCheckListener(vvisthreadsCheckBox,vvisThreadsSpinner);
        addCheckListener(vvisradius_overrideCheckBox,vvisRadiusSpinner);
        addCheckListener(vvisvProjectCheckBox,vvisVProjectField);
        addCheckListener(vvismpi_pwCheckBox,vvisMPIPW);

        addCheckListener(vradGameCheckBox,vradGameField);
        addCheckListener(vradThreadCheckBox,vradTreadSpinner);
        addCheckListener(vradstaticPropSampleScaleCheckBox,vradStaticPropSampleScaleSpinner);
        addCheckListener(vradlightsCheckBox,vradLightsField);
        addCheckListener(vradbounceCheckBox,vradbounceSpinner);
        addCheckListener(vradextraSkyCheckBox,vradextraSkySpinner);
        addCheckListener(vradsmoothCheckBox,vradsmoothSpinner);
        addCheckListener(vradluxelDensityCheckBox,vradluxelDensitySpinner);
        addCheckListener(vradsoftSunCheckBox,vradsoftSunSpinner);
        addCheckListener(vradmpi_pwCheckBox,vradmpi_pwField);
        addCheckListener(vradchopCheckBox,vradChopSpinner);
        addCheckListener(vradmaxChopCheckBox,vradmaxChopSpinner);
        addCheckListener(vradcompressconstantCheckBox,vradcompressconstantSpinner);
        addCheckListener(vradvProjectCheckBox,vradvProjectField);
        addCheckListener(vradmaxDispSampleSizeCheckBox,vradmaxDispSampleSize);
    }

    private void addListener(JFrame jFrame){

        editPresetsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HCR.openToolPresetDialoga();
            }
        });

        savePresetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HCR.openSavePresetDialog();
            }
        });

        buildSettingsChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (buildSettingsChooser.getSelectedIndex() != -1 && !buildSettingsChooser.getSelectedItem().equals(unselectedBuildPreset) && buildSettingsChooser.getItemCount() > 0){
                    buildSettingsChooser.setToolTipText(((BuildSettings)buildSettingsChooser.getSelectedItem()).getComment() != null ? ((BuildSettings)buildSettingsChooser.getSelectedItem()).getComment() : "");
                    applyBuildSettings((BuildSettings)buildSettingsChooser.getSelectedItem());
                }
            }
        });

        welcomeChooseVMFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openVMFDialog.showOpenDialog(jFrame);
                if (openVMFDialog.getSelectedFile() != null){
                    lastSelectedVMF = openVMFDialog.getSelectedFile().getPath();
                    vmfFilePathTextFiel.setText(lastSelectedVMF);
                    mainPanel.setEnabled(true);
                    mainPanel.setVisible(true);
                    welcomePane.setEnabled(false);
                    welcomePane.setVisible(false);
                }
            }
        });

        chooseVMFFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openVMFDialog.showOpenDialog(jFrame);
                if (openVMFDialog.getSelectedFile() != null){
                    lastSelectedVMF = openVMFDialog.getSelectedFile().getPath();
                    vmfFilePathTextFiel.setText(lastSelectedVMF);
                } else {
                    ConsoleCommander.sendError("No vmf file selected.");
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (compileThread != null){
                    compileThread.interrupt();
                    compileThread = null;
                }
            }
        });

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (compileQueueRadioButton.isSelected()){
                    compileTabbedPane.setSelectedIndex(1);
                    CompileQueueManager.runCompiles();
                } else {
                    compileTabbedPane.setSelectedIndex(1);
                    CompileSet compileSet = new CompileSet(lastSelectedVMF,new BuildSettings(
                            getVradSettings(),
                            getVBSPSettings(),
                            getVvisSettings(),
                            vbspChooser.isEnabled() ? (BuildProgram) vbspChooser.getSelectedItem() : null,
                            vvisChooser.isEnabled() ? (BuildProgram) vvisChooser.getSelectedItem() : null,
                            vradChooser.isEnabled() ? (BuildProgram) vradChooser.getSelectedItem() : null,
                            null,
                            null,
                            null
                    ));
                    compileThread = new CompileThread(compileSet);
                    compileThread.start();
                    new CompilerLogSyncThread(compileThread.getLog()).start();

                }

            }
        });


        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!pauseToggle){
                    pauseToggle = true;
                    //todo pause
                } else {
                    pauseToggle = false;
                    //todo pause
                }
            }
        });

        enableCompileQueueCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        vradLightsField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(vradLightsField.isEnabled()){
                    openRadDialog.showOpenDialog(jFrame);
                    try{
                        vradLightsField.setText(openRadDialog.getSelectedFile().getPath());
                    } catch (NullPointerException exception){
                        ConsoleCommander.sendError("No file selected!");
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        vbspRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vbspRadioButton.isSelected()){
                    vbspChooser.setEnabled(true);
                } else {
                    vbspChooser.setEnabled(false);
                }
            }
        });

        vvisRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vvisRadioButton.isSelected()){
                    vvisChooser.setEnabled(true);
                } else {
                    vvisChooser.setEnabled(false);
                }
            }
        });

        vradRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vradRadioButton.isSelected()){
                    vradChooser.setEnabled(true);
                } else {
                    vradChooser.setEnabled(false);
                }
            }
        });
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public VBSPSettings getVBSPSettings() {
        return new VBSPSettings(
                vbspGameCheckBox.isSelected() ? vbspGameField.getText() : null,
                vbspthreadsCheckBox.isSelected() ? (Integer) vbspThreadsSpinner.getValue() : null,
                vbspverboseCheckBox.isSelected(),
                vbsplowCheckBox.isSelected(),
                vbspnovConfigCheckBox.isSelected(),
                vbspvProjectCheckBox.isSelected() ? vbspVProjectField.getText() : null,
                vbsponlyEntsCheckBox.isSelected(),
                vbsponlyPropsCheckBox.isSelected(),
                vbspglViewCheckBox.isSelected(),
                vbspnoDetailCheckBox.isSelected(),
                vbspnoWaterCheckBox.isSelected(),
                vbspembedCheckBox.isSelected() ? vbspembedCheckBox.getText() : null,
                vbspverboseEntitiesCheckBox.isSelected(),
                vbspnoWeldCheckBox.isSelected(),
                vbspnoCSGCheckBox.isSelected(),
                vbspnoShareCheckBox.isSelected(),
                vbspNoTJuncCheckBox.isSelected(),
                vbspNoOptCheckBox.isSelected(),
                vbspnoPruneCheckBox.isSelected(),
                vbspnoMergeCheckBox.isSelected(),
                vbspnoMergeWaterCheckBox.isSelected(),
                vbspnoSubDivCheckBox.isSelected(),
                vbspmicroCheckBox.isSelected() ? Double.valueOf(vbspMicroField.getText()) : null,
                vbspfullDetailCheckBox.isSelected(),
                vbspleakTestCheckBox.isSelected(),
                vbspbumpAllCheckBox.isSelected(),
                vbspsnapAxialCheckBox.isSelected(),
                vbspblockCheckBox.isSelected() ? Double.valueOf(vbspBlock1.getText()) : null,
                vbspblockCheckBox.isSelected() ? Double.valueOf(vbspBlock2.getText()) : null,
                vbspblocksCheckBox.isSelected() ? Double.valueOf(vbspBlocks1.getText()) : null,
                vbspblocksCheckBox.isSelected() ? Double.valueOf(vbspBlocks2.getText()) : null,
                vbspblocksCheckBox.isSelected() ? Double.valueOf(vbspBlocks3.getText()) : null,
                vbspblocksCheckBox.isSelected() ? Double.valueOf(vbspBlocks4.getText()) : null,
                vbspdumpStaticPropsCheckBox.isSelected(),
                vbspdumpCollideCheckBox.isSelected(),
                vbspluxelScaleCheckBox.isSelected() ? (Double) vbspLuxelScaleSpinner.getValue() : null,
                vbsplightIfMissingCheckBox.isSelected(),
                vbsplocalPhysXCheckBox.isSelected(),
                vbspkeepStaleZipCheckBox.isSelected(),
                vbspreplaceMaterialsCheckBox.isSelected(),
                vbspfullMinDumpsCheckBox.isSelected()
        );
    }

    public VVISSettings getVvisSettings() {
        return new VVISSettings(
                vvisGameCheckBox.isSelected() ? vvisGameField.getText() : null,
                vvisthreadsCheckBox.isSelected() ? (Integer) vvisThreadsSpinner.getValue() : null,
                vvisverboseCheckBox.isSelected(),
                vvisLowCheckBox.isSelected(),
                vvisnoVConfigCheckBox.isSelected(),
                vvisvProjectCheckBox.isSelected() ? vvisVProjectField.getText() : null,
                vvisfastCheckBox.isSelected(),
                vvisradius_overrideCheckBox.isSelected() ? (Integer) vvisRadiusSpinner.getValue() : null,
                vvisnoSortCheckBox.isSelected(),
                vvistmpinCheckBox.isSelected(),
                vvistmpoutCheckBox.isSelected(),
                vvismpiCheckBox.isSelected(),
                vvismpi_pwCheckBox.isSelected() ? vvisMPIPW.getText() : null
        );
    }

    public VRADSettings getVradSettings(){
        return new VRADSettings(
                vradGameCheckBox.isSelected() ? vradGameField.getText() : null,
                vradThreadCheckBox.isSelected() ? (Integer) vradTreadSpinner.getValue() : null,
                vradverboseCheckBox.isSelected(),
                vradlowCheckBox.isSelected(),
                vradnoVConfigCheckBox.isSelected(),
                vradvProjectCheckBox.isSelected() ? vradvProjectField.getText() : null,
                vradldrCheckBox.isSelected(),
                vradhdrCheckBox.isSelected(),
                vradbothCheckBox.isSelected(),
                vradfastCheckBox.isSelected(),
                vradfinalCheckBox.isSelected(),
                vradlightsCheckBox.isSelected() ? vradLightsField.getText() : null,
                vradstaticPropLightingCheckBox.isSelected(),
                vradstaticPropPolysCheckBox.isSelected(),
                vradtextureShadowsCheckBox.isSelected(),
                vradstaticPropSampleScaleCheckBox.isSelected() ? (Integer) vradStaticPropSampleScaleSpinner.getValue() : null,
                vradbounceCheckBox.isSelected() ? (Integer) vradbounceSpinner.getValue() : null,
                vradextraSkyCheckBox.isSelected() ? (Integer) vradextraSkySpinner.getValue() : null,
                vradsmoothCheckBox.isSelected() ? (Integer) vradsmoothSpinner.getValue() : null,
                vradluxelDensityCheckBox.isSelected() ? (Float) vradluxelDensitySpinner.getValue() : null,
                vradsoftSunCheckBox.isSelected() ? (Float) vradsoftSunSpinner.getValue() : null,
                vradmpiCheckBox.isSelected(),
                vradmpi_pwCheckBox.isSelected() ? vradmpi_pwField.getText() : null,
                vradnoExtraCheckBox.isSelected(),
                vradchopCheckBox.isSelected() ? (Integer) vradChopSpinner.getValue() : null,
                vradmaxChopCheckBox.isSelected() ? (Integer) vradmaxChopSpinner.getValue() : null,
                vradlargeDispSampleRadiusCheckBox.isSelected(),
                vradcompressconstantCheckBox.isSelected() ? (Integer) vradcompressconstantSpinner.getValue() : null,
                vradrederrorsCheckBox.isSelected(),
                vraddumpCheckBox.isSelected(),
                vraddumpNormalsCheckBox.isSelected(),
                vraddebugExtraCheckBox.isSelected(),
                vraddlightmapCheckBox.isSelected(),
                vradstopOnExitCheckBox.isSelected(),
                vradnoDetailLightCheckBox.isSelected(),
                vradcenterSamplesCheckBox.isSelected(),
                vradlogHashCheckBox.isSelected(),
                vradonlyDetailCheckBox.isSelected(),
                vradmaxDispSampleSizeCheckBox.isSelected() ? (Integer) vradmaxDispSampleSize.getValue() : null,
                vradfullMinidumpCheckBox.isSelected(),
                vradonlyStaticPropsCheckBox.isSelected(),
                vradstaticPropNormalsCheckBox.isSelected(),
                vradnoSkyBoxRecurseCheckBox.isSelected(),
                vradnoSPropsCheckBox.isSelected()
        );

    }

    public void applyBuildSettings(BuildSettings buildSettings){

        if (buildSettings == null){
            return;
        }

        if (buildSettings.getVbsp() != null){
            vbspRadioButton.setSelected(true);
            vbspChooser.setSelectedItem(buildSettings.getVbsp());
        }
        if (buildSettings.getVvis() != null){
            vvisChooser.setSelectedItem(buildSettings.getVvis());
            vvisRadioButton.setSelected(true);
        }
        if (buildSettings.getVrad() != null){
            vradChooser.setSelectedItem(buildSettings.getVrad());
            vradRadioButton.setSelected(true);
        }


        //vbsp
        vbspverboseCheckBox.setSelected(buildSettings.getVbspSettings().isVerbose());
        vbsponlyEntsCheckBox.setSelected(buildSettings.getVbspSettings().isOnlyEnts());
        vbsponlyPropsCheckBox.setSelected(buildSettings.getVbspSettings().isOnlyProps());
        vbspglViewCheckBox.setSelected(buildSettings.getVbspSettings().isGlview());
        vbspnoDetailCheckBox.setSelected(buildSettings.getVbspSettings().isNoDetail());
        vbspnoWaterCheckBox.setSelected(buildSettings.getVbspSettings().isNoWater());
        vbsplowCheckBox.setSelected(buildSettings.getVbspSettings().isLow());
        applyBuildSettingsToComponent(vbspGameCheckBox, vbspGameField, buildSettings.getVbspSettings().getGame());
        applyBuildSettingsToComponent(vbspvProjectCheckBox, vbspVProjectField, buildSettings.getVbspSettings().getvProject());
        applyBuildSettingsToComponent(vbspembedCheckBox, vbspEmbedField, buildSettings.getVbspSettings().getEmbed());
        vbspnovConfigCheckBox.setSelected(buildSettings.getVbspSettings().isNoVConfig());
        applyBuildSettingsToComponent(vbspthreadsCheckBox, vbspThreadsSpinner, buildSettings.getVbspSettings().getThreads());
        vbspverboseEntitiesCheckBox.setSelected(buildSettings.getVbspSettings().isVerbose());
        vbspnoWeldCheckBox.setSelected(buildSettings.getVbspSettings().isNoWeld());
        vbspnoCSGCheckBox.setSelected(buildSettings.getVbspSettings().isNoCSG());
        vbspnoShareCheckBox.setSelected(buildSettings.getVbspSettings().isNoShare());
        vbspNoTJuncCheckBox.setSelected(buildSettings.getVbspSettings().isNoJunc());
        vbspNoOptCheckBox.setSelected(buildSettings.getVbspSettings().isNoOpt());
        vbspnoPruneCheckBox.setSelected(buildSettings.getVbspSettings().isNoPrune());
        vbspnoMergeCheckBox.setSelected(buildSettings.getVbspSettings().isNoMerge());
        vbspnoMergeWaterCheckBox.setSelected(buildSettings.getVbspSettings().isNoMergeWater());
        vbspnoSubDivCheckBox.setSelected(buildSettings.getVbspSettings().isNoSubDiv());
        applyBuildSettingsToComponent(vbspmicroCheckBox, vbspMicroField, buildSettings.getVbspSettings().getMicro());
        vbspfullDetailCheckBox.setSelected(buildSettings.getVbspSettings().isFullDetail());
        vbspleakTestCheckBox.setSelected(buildSettings.getVbspSettings().isLeakTest());
        vbspbumpAllCheckBox.setSelected(buildSettings.getVbspSettings().isBumpAll());
        vbspsnapAxialCheckBox.setSelected(buildSettings.getVbspSettings().isSnapaxial());

        if(buildSettings.getVbspSettings().getBlock1() == null || buildSettings.getVbspSettings().getBlock2() == null){
            vbspblockCheckBox.setSelected(false);
            vbspBlock1.setText("");
            vbspBlock1.setEnabled(false);
            vbspBlock2.setText("");
            vbspBlock2.setEnabled(false);
        } else {
            vbspblockCheckBox.setSelected(true);
            vbspBlock1.setText(buildSettings.getVbspSettings().getBlock1() + "");
            vbspBlock1.setEnabled(true);
            vbspBlock2.setText(buildSettings.getVbspSettings().getBlock2() + "");
            vbspBlock2.setEnabled(true);
        }

        if(buildSettings.getVbspSettings().getBlocks1() == null || buildSettings.getVbspSettings().getBlocks2() == null || buildSettings.getVbspSettings().getBlocks3() == null || buildSettings.getVbspSettings().getBlocks4() == null){
            vbspblocksCheckBox.setSelected(false);
            vbspBlocks1.setText("");
            vbspBlocks1.setEnabled(false);
            vbspBlocks2.setText("");
            vbspBlocks2.setEnabled(false);
            vbspBlocks3.setText("");
            vbspBlocks3.setEnabled(false);
            vbspBlocks4.setText("");
            vbspBlocks4.setEnabled(false);
        } else {
            vbspblocksCheckBox.setSelected(true);
            vbspBlocks1.setText(buildSettings.getVbspSettings().getBlocks1() + "");
            vbspBlocks1.setEnabled(true);
            vbspBlocks2.setText(buildSettings.getVbspSettings().getBlocks2() + "");
            vbspBlocks2.setEnabled(true);
            vbspBlocks3.setText(buildSettings.getVbspSettings().getBlocks3() + "");
            vbspBlocks3.setEnabled(true);
            vbspBlocks4.setText(buildSettings.getVbspSettings().getBlocks4() + "");
            vbspBlocks4.setEnabled(true);
        }
        vbspdumpStaticPropsCheckBox.setSelected(buildSettings.getVbspSettings().isDumpStaticProps());
        vbspdumpCollideCheckBox.setSelected(buildSettings.getVbspSettings().isDumpCollide());
        applyBuildSettingsToComponent(vbspluxelScaleCheckBox, vbspLuxelScaleSpinner, buildSettings.getVbspSettings().getLuxelscale());
        vbsplightIfMissingCheckBox.setSelected(buildSettings.getVbspSettings().isLightIfMissing());
        vbsplocalPhysXCheckBox.setSelected(buildSettings.getVbspSettings().isLocalphysx());
        vbspkeepStaleZipCheckBox.setSelected(buildSettings.getVbspSettings().isKeepStaleZip());
        vbspreplaceMaterialsCheckBox.setSelected(buildSettings.getVbspSettings().isReplacematerials());
        vbspfullMinDumpsCheckBox.setSelected(buildSettings.getVbspSettings().isFullMindumps());

        //vvis
        applyBuildSettingsToComponent(vvisGameCheckBox, vvisGameField, buildSettings.getVvisSettings().getGame());
        applyBuildSettingsToComponent(vvisthreadsCheckBox, vvisThreadsSpinner, buildSettings.getVvisSettings().getThreads());
        vvisverboseCheckBox.setSelected(buildSettings.getVvisSettings().isVerbose());
        vvisLowCheckBox.setSelected(buildSettings.getVvisSettings().isLow());
        vvisnoVConfigCheckBox.setSelected(buildSettings.getVvisSettings().isNoVConfig());
        applyBuildSettingsToComponent(vvisvProjectCheckBox, vvisVProjectField, buildSettings.getVvisSettings().getvProject());
        vvisfastCheckBox.setSelected(buildSettings.getVvisSettings().isFast());
        applyBuildSettingsToComponent(vvisradius_overrideCheckBox, vvisRadiusSpinner, buildSettings.getVvisSettings().getRadius_override());
        vvisnoSortCheckBox.setSelected(buildSettings.getVvisSettings().isNoSort());
        vvistmpinCheckBox.setSelected(buildSettings.getVvisSettings().isTmpin());
        vvistmpoutCheckBox.setSelected(buildSettings.getVvisSettings().isTmpout());
        vvismpiCheckBox.setSelected(buildSettings.getVvisSettings().isMpi());
        applyBuildSettingsToComponent(vvismpi_pwCheckBox, vvisMPIPW, buildSettings.getVvisSettings().getMpi_pw());

        //vrad
        vradverboseCheckBox.setSelected(buildSettings.getVradSettings().isVerbose());
        vradlowCheckBox.setSelected(buildSettings.getVradSettings().isLow());
        vradnoVConfigCheckBox.setSelected(buildSettings.getVradSettings().isNoVConfig());
        applyBuildSettingsToComponent(vradvProjectCheckBox,vradvProjectField, buildSettings.getVradSettings().getvProject());
        vradldrCheckBox.setSelected(buildSettings.getVradSettings().isLdr());
        vradhdrCheckBox.setSelected(buildSettings.getVradSettings().isHdr());
        vradbothCheckBox.setSelected(buildSettings.getVradSettings().isBoth());
        vradfastCheckBox.setSelected(buildSettings.getVradSettings().isFast());
        vradfinalCheckBox.setSelected(buildSettings.getVradSettings().isFinalCompile());
        vradstaticPropLightingCheckBox.setSelected(buildSettings.getVradSettings().isStaticPropLighting());
        vradstaticPropPolysCheckBox.setSelected(buildSettings.getVradSettings().isStaticPropPolys());
        vradtextureShadowsCheckBox.setSelected(buildSettings.getVradSettings().isTextureShadows());
        applyBuildSettingsToComponent(vradstaticPropSampleScaleCheckBox, vradStaticPropSampleScaleSpinner, buildSettings.getVradSettings().getStaticPropSampleScale());
        applyBuildSettingsToComponent(vradbounceCheckBox, vradbounceSpinner, buildSettings.getVradSettings().getBounce());
        applyBuildSettingsToComponent(vradextraSkyCheckBox, vradextraSkySpinner, buildSettings.getVradSettings().getExtraSky());
        applyBuildSettingsToComponent(vradsmoothCheckBox, vradsmoothSpinner, buildSettings.getVradSettings().getSmooth());
        applyBuildSettingsToComponent(vradluxelDensityCheckBox, vradluxelDensitySpinner, buildSettings.getVradSettings().getLuxelDensity());
        applyBuildSettingsToComponent(vradsoftSunCheckBox, vradsoftSunSpinner, buildSettings.getVradSettings().getSoftSun());
        vradmpiCheckBox.setSelected(buildSettings.getVradSettings().isMpi());
        applyBuildSettingsToComponent(vradmpi_pwCheckBox,vradmpi_pwField, buildSettings.getVradSettings().getMpi_pw());
        vradnoExtraCheckBox.setSelected(buildSettings.getVradSettings().isNoExtra());
        applyBuildSettingsToComponent(vradchopCheckBox, vradChopSpinner, buildSettings.getVradSettings().getChop());
        applyBuildSettingsToComponent(vradmaxChopCheckBox, vradmaxChopSpinner, buildSettings.getVradSettings().getMaxChop());
        vradlargeDispSampleRadiusCheckBox.setSelected(buildSettings.getVradSettings().isLargeDispSampleRadius());
        applyBuildSettingsToComponent(vradcompressconstantCheckBox, vradcompressconstantSpinner, buildSettings.getVradSettings().getCompressconstant());
        vradrederrorsCheckBox.setSelected(buildSettings.getVradSettings().isRederrors());
        vraddumpCheckBox.setSelected(buildSettings.getVradSettings().isDump());
        vraddumpNormalsCheckBox.setSelected(buildSettings.getVradSettings().isDumpNormals());
        vraddebugExtraCheckBox.setSelected(buildSettings.getVradSettings().isDebugExtra());
        vraddlightmapCheckBox.setSelected(buildSettings.getVradSettings().isDlightmap());
        vradstopOnExitCheckBox.setSelected(buildSettings.getVradSettings().isStopOnExit());
        vradnoDetailLightCheckBox.setSelected(buildSettings.getVradSettings().isNoDetailLight());
        vradcenterSamplesCheckBox.setSelected(buildSettings.getVradSettings().isCenterSamples());
        vradlogHashCheckBox.setSelected(buildSettings.getVradSettings().isLogHash());
        vradonlyDetailCheckBox.setSelected(buildSettings.getVradSettings().isOnlyDetail());
        applyBuildSettingsToComponent(vradmaxDispSampleSizeCheckBox, vradmaxDispSampleSize, buildSettings.getVradSettings().getMaxDispSampleSize());
        vradfullMinidumpCheckBox.setSelected(buildSettings.getVradSettings().isFullMinidump());
        vradonlyStaticPropsCheckBox.setSelected(buildSettings.getVradSettings().isOnlyStaticProps());
        vradstaticPropNormalsCheckBox.setSelected(buildSettings.getVradSettings().isStaticPropNormals());
        vradnoSkyBoxRecurseCheckBox.setSelected(buildSettings.getVradSettings().isNoSkyBoxRecurse());
        vradnoSPropsCheckBox.setSelected(buildSettings.getVradSettings().isNoSProps());
        applyBuildSettingsToComponent(vradGameCheckBox, vradGameField, buildSettings.getVradSettings().getGame());
        applyBuildSettingsToComponent(vradThreadCheckBox, vradTreadSpinner, buildSettings.getVradSettings().getThreads());
        applyBuildSettingsToComponent(vradlightsCheckBox, vradLightsField, buildSettings.getVradSettings().getLights());
    }

    private void applyBuildSettingsToComponent(JCheckBox checkBox, JComponent component, Object value){
        if (component instanceof JSpinner){
            JSpinner spinner = (JSpinner) component;
            if (value == null){
                checkBox.setSelected(false);
                spinner.setValue(0);
                spinner.setEnabled(false);
            } else {
                checkBox.setSelected(true);
                spinner.setValue(value);
                spinner.setEnabled(true);
            }
        } else if (component instanceof JTextField){
            JTextField area = (JTextField) component;
            if (value == null){
                checkBox.setSelected(false);
                area.setText("");
                area.setEnabled(false);
            } else {
                checkBox.setSelected(true);
                area.setText((String) value);
                area.setEnabled(true);
            }
        }

    }

    private void addMenuBar(JFrame frame){
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenu sdk = new JMenu("SDK");
        JMenu options = new JMenu("Options");
        JMenu help = new JMenu("Help");
        menuBar.add(file);
        menuBar.add(tools);
        menuBar.add(sdk);
        menuBar.add(options);
        menuBar.add(help);

        JMenuItem open = new JMenuItem("Open");
        JMenuItem close = new JMenuItem("Close");
        JMenuItem compile = new JMenuItem("Compile");
        JMenuItem compileQueue = new JMenuItem("Compile Queue");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(open);
        file.add(new JSeparator());
        file.add(close);
        file.add(new JSeparator());
        file.add(compile);
        file.add(compileQueue);
        file.add(new JSeparator());
        file.add(exit);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setEnabled(false);
                mainPanel.setVisible(false);
                welcomePane.setEnabled(true);
                welcomePane.setVisible(true);
            }
        });

        JMenuItem compilePresets = new JMenuItem("Compile Presets");
        JMenuItem buildPrograms = new JMenuItem("Build Programs");
        tools.add(compilePresets);
        tools.add(buildPrograms);

        compilePresets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HCR.openToolPresetDialoga();
            }
        });

        buildPrograms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HCR.openToolBuildProggramsDialoga();
            }
        });

        JCheckBoxMenuItem resiszable = new JCheckBoxMenuItem("Resizable");
        JMenuItem settings = new JMenuItem("Settings");
        options.add(resiszable);
        options.add(new JSeparator());
        options.add(settings);

        exit.addActionListener(e -> System.exit(0));

        resiszable.addActionListener(e -> {
            if(resiszable.isSelected()){
                frame.setResizable(true);
            } else {
                frame.setResizable(false);
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openVMFDialog.showOpenDialog(frame);
                lastSelectedVMF = openVMFDialog.getSelectedFile().getPath();
                vmfFilePathTextFiel.setText(lastSelectedVMF);
                if(welcomePane.isVisible()){
                    mainPanel.setEnabled(true);
                    mainPanel.setVisible(true);
                    welcomePane.setEnabled(false);
                    welcomePane.setVisible(false);
                }
            }
        });

        JMenuItem about = new JMenuItem("About");
        help.add(new JSeparator());
        help.add(about);
    }

    public JTextArea getCompileOutputArea() {
        return compileOutputArea;
    }

    public JTextPane getConsoleOutputArea() {
        return consoleOutputArea;
    }

    public JTabbedPane getCompileTabbedPane() {
        return compileTabbedPane;
    }

    public JTextField getVmfFilePathTextFiel() {
        return vmfFilePathTextFiel;
    }

    public JComboBox getVbspChooser() {
        return vbspChooser;
    }

    public JComboBox getVvisChooser() {
        return vvisChooser;
    }

    public JComboBox getVradChooser() {
        return vradChooser;
    }

    @Override
    public void updateContent(int contetntID) {

        if (contetntID == -1 || contetntID == 0){
            buildSettingsChooser.setSelectedIndex(-1);
            buildSettingsChooser.removeAllItems();

            for (BuildSettings buildSettings : BuildSettingsManager.getBuildSettings()){
                buildSettingsChooser.addItem(buildSettings);
            }

            if (buildSettingsChooser.getItemCount() > 0){
                buildSettingsChooser.setSelectedIndex(0);
                applyBuildSettings((BuildSettings) buildSettingsChooser.getSelectedItem());
                buildSettingsChooser.setToolTipText(((BuildSettings) buildSettingsChooser.getSelectedItem()).getComment());
            } else {
                buildSettingsChooser.addItem(unselectedBuildPreset);
                buildSettingsChooser.setSelectedIndex(0);
            }
        }

        if (contetntID == -1 || contetntID == 1){
            vradChooser.setSelectedIndex(-1);
            vbspChooser.setSelectedIndex(-1);
            vvisChooser.setSelectedIndex(-1);
            vradChooser.removeAllItems();
            vbspChooser.removeAllItems();
            vvisChooser.removeAllItems();

            for(BuildProgram buildProgram : BuildProgramManager.getBuildProgramms()){
                switch (buildProgram.getBuildProgramType()){
                    case VBSP:
                        vbspChooser.addItem(buildProgram);
                        break;
                    case VVIS:
                        vvisChooser.addItem(buildProgram);
                        break;
                    case VRAD:
                        vradChooser.addItem(buildProgram);
                        break;
                }
            }

            if (vradChooser.getItemCount() > 0){
                vradChooser.setSelectedIndex(0);
                vradChooser.setToolTipText(((BuildProgram)vradChooser.getSelectedItem()).getComment());
            }
            if (vvisChooser.getItemCount() > 0){
                vvisChooser.setSelectedIndex(0);
                vvisChooser.setToolTipText(((BuildProgram)vradChooser.getSelectedItem()).getComment());
            }
            if (vbspChooser.getItemCount() > 0){
                vbspChooser.setSelectedIndex(0);
                vbspChooser.setToolTipText(((BuildProgram)vradChooser.getSelectedItem()).getComment());
            }
        }
    }
}
