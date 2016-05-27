package de.therazzerapp.hcr.gui.ui;

import de.therazzerapp.hcr.content.BuildSettings;
import de.therazzerapp.hcr.gui.ConsoleCommander;
import de.therazzerapp.hcr.managers.BuildSettingsManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class ToolPresets_Gui {
    private JPanel jPanel;
    private JPanel presetsPanel;
    private JPanel selectedPresetPanel;
    private JList presetList;
    private JPanel currentPresetPanel;
    private JButton addButton;
    private JButton removeButton;
    private JButton renameButton;
    private JLabel nameLabel;
    private JLabel vbspLabel;
    private JLabel vvisLabel;
    private JLabel vbspParameterLabel;
    private JLabel vvisParameterLabel;
    private JLabel vradParameterLabel;
    private JLabel vradLabel;
    private JLabel customGameDirLabel;
    private JTextArea commentArea;
    private JLabel commentLabel;
    private DefaultListModel defaultListModel = new DefaultListModel();

    private BuildSettings[] buildSettingses;

    public ToolPresets_Gui(JFrame jFrame) {
        presetList.setModel(defaultListModel);
        updatePresetList();

        if(defaultListModel.size() > 0){
            presetList.setSelectedIndex(0);
            updateLabel(presetList.getSelectedIndex());
        }

        addListener();

    }

    public void updatePresetList(){
        buildSettingses = new BuildSettings[BuildSettingsManager.getSize()];
        int i = 0;
        for (BuildSettings buildSettings : BuildSettingsManager.getBuildSettings()) {
            defaultListModel.add(i,buildSettings.getDisplayName());
            buildSettingses[i] = buildSettings;
            i++;
        }
    }

    private void updateLabel(int index){
        nameLabel.setText(buildSettingses[index].getDisplayName() + " (" + buildSettingses[index].getName() + ")");
        vbspLabel.setText(buildSettingses[index].getVbsp().getDisplayName() + " (" + buildSettingses[index].getVbsp().getPath() + ")");
        vbspParameterLabel.setText("<html>" + buildSettingses[index].getVbspSettings().getParam(buildSettingses[index].getGameDir()).replace(" -","<br>-") + "</hmlt>");
        vvisLabel.setText(buildSettingses[index].getVvis().getDisplayName() + " (" + buildSettingses[index].getVvis().getPath() + ")");
        vvisParameterLabel.setText("<html>" + buildSettingses[index].getVvisSettings().getParam(buildSettingses[index].getGameDir()).replace(" -","<br>-") + "</hmlt>");
        vradLabel.setText(buildSettingses[index].getVrad().getDisplayName() + " (" + buildSettingses[index].getVrad().getPath() + ")");
        vradParameterLabel.setText("<html>" + buildSettingses[index].getVradSettings().getParam(buildSettingses[index].getGameDir()).replace(" -","<br>-") + "</hmlt>");
        customGameDirLabel.setText(buildSettingses[index].getGameDir() == null ? "default" : buildSettingses[index].getGameDir());
        commentArea.setText(buildSettingses[index].getComment() == null ? "" : buildSettingses[index].getComment());
    }



    private void addListener(){

        presetList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                updateLabel(presetList.getSelectedIndex());
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(buildSettingses[presetList.getSelectedIndex()] != null){
                    BuildSettingsManager.removeBuildSetting(buildSettingses[presetList.getSelectedIndex()].getName());
                    ConsoleCommander.sendInfo("Compile preset removed: " + buildSettingses[presetList.getSelectedIndex()].getDisplayName() + " ("  + buildSettingses[presetList.getSelectedIndex()].getName() + ")");
                    BuildSettingsManager.load();
                    updatePresetList();
                    presetList.setSelectedIndex(0);
                }
            }
        });
    }

    public JPanel getjPanel() {
        return jPanel;
    }
}
