package de.therazzerapp.hcr.gui.ui;

import de.therazzerapp.hcr.HCR;
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

    public void removePreset(BuildSettings buildSettings){
        defaultListModel.removeElement(buildSettings);
    }

    public void addPreset(BuildSettings buildSettings){
        defaultListModel.addElement(buildSettings);
    }

    public ToolPresets_Gui(JFrame jFrame) {
        presetList.setModel(defaultListModel);
        presetList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        for (BuildSettings buildSettings : BuildSettingsManager.getBuildSettings()) {
            defaultListModel.addElement(buildSettings);
        }

        if(defaultListModel.size() > 0){
            presetList.setSelectedIndex(0);
            updateLabel((BuildSettings)presetList.getSelectedValue());
        }

        addListener();
    }


    private void updateLabel(BuildSettings buildSettings){
        nameLabel.setText(buildSettings.getDisplayName() + " (" + buildSettings.getName() + ")");
        vbspLabel.setText(buildSettings.getVbsp().getDisplayName() + " (" + buildSettings.getVbsp().getPath() + ")");
        vbspParameterLabel.setText("<html>" + buildSettings.getVbspSettings().getParam(buildSettings.getGameDir()).replace(" -","<br>-") + "</hmlt>");
        vvisLabel.setText(buildSettings.getVvis().getDisplayName() + " (" + buildSettings.getVvis().getPath() + ")");
        vvisParameterLabel.setText("<html>" + buildSettings.getVvisSettings().getParam(buildSettings.getGameDir()).replace(" -","<br>-") + "</hmlt>");
        vradLabel.setText(buildSettings.getVrad().getDisplayName() + " (" + buildSettings.getVrad().getPath() + ")");
        vradParameterLabel.setText("<html>" + buildSettings.getVradSettings().getParam(buildSettings.getGameDir()).replace(" -","<br>-") + "</hmlt>");
        customGameDirLabel.setText(buildSettings.getGameDir() == null ? "default" : buildSettings.getGameDir());
        commentArea.setText(buildSettings.getComment() == null ? "" : buildSettings.getComment());
    }
    private void addListener(){

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HCR.savePresetFrame.setVisible(true);
                HCR.savePresetFrame.setEnabled(true);
                HCR.savePresetFrame.toFront();
            }
        });

        presetList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateLabel((BuildSettings)presetList.getSelectedValue());
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

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuildSettingsManager.removeBuildSetting(((BuildSettings)presetList.getSelectedValue()).getName());
                HCR.hcr_gui.removeCompilePresetFromList((BuildSettings)presetList.getSelectedValue());
                ConsoleCommander.sendInfo("Compile preset removed: " + ((BuildSettings)presetList.getSelectedValue()).getDisplayName() + " ("  + ((BuildSettings)presetList.getSelectedValue()).getName() + ")");
                defaultListModel.removeElement((BuildSettings)presetList.getSelectedValue());
            }
        });
    }

    public JPanel getjPanel() {
        return jPanel;
    }
}
