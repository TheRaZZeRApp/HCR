package de.therazzerapp.hcr.gui.ui;

import de.therazzerapp.hcr.HCR;
import de.therazzerapp.hcr.content.BuildProgram;
import de.therazzerapp.hcr.content.BuildProgramType;
import de.therazzerapp.hcr.content.BuildSettings;
import de.therazzerapp.hcr.gui.ConsoleCommander;
import de.therazzerapp.hcr.gui.ContentUpdater;
import de.therazzerapp.hcr.managers.BuildProgramManager;
import de.therazzerapp.hcr.managers.BuildSettingsManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class SavePreset_Gui implements ContentUpdater{
    private JPanel mainPanel;
    private JPanel overwrirePanel;
    private JPanel savePanel;
    private JButton overwriteCancelButton;
    private JTextField displayNameField;
    private JComboBox vbspBox;
    private JTextArea commentArea;
    private JButton saveCancelButton;
    private JButton saveButton;
    private JTextField nameField;
    private JComboBox vvisBox;
    private JComboBox vradBox;
    private JButton overwriteButton;
    private JLabel errorLabel;
    private JEditorPane editorPane1;
    private String noneItem = "<None>";

    public JPanel getOverwrirePanel() {
        return overwrirePanel;
    }

    public JPanel getSavePanel() {
        return savePanel;
    }

    public JButton getSaveCancelButton() {
        return saveCancelButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public SavePreset_Gui(JFrame jFrame) {
        overwrirePanel.setEnabled(false);
        overwrirePanel.setVisible(false);

        addListener(jFrame);

        vbspBox.setSelectedItem(HCR.hcr_gui.getVbspChooser().getSelectedItem());
        vvisBox.setSelectedItem(HCR.hcr_gui.getVbspChooser().getSelectedItem());
        vradBox.setSelectedItem(HCR.hcr_gui.getVradChooser().getSelectedItem());
    }

    private void reset(){
        overwrirePanel.setVisible(false);
        savePanel.setVisible(true);
        saveCancelButton.setVisible(true);
        saveButton.setVisible(true);
        displayNameField.setText("");
        nameField.setText("");
        commentArea.setText("");
        errorLabel.setText("");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void addListener(JFrame jFrame){

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameField.getText().isEmpty()){
                    errorLabel.setText("Please add a save name.");
                    return;
                }

                if (displayNameField.getText().isEmpty()){
                    errorLabel.setText("Please add a name.");
                    return;
                }

                if(BuildSettingsManager.containsBuildSettings(nameField.getText())){
                    HCR.openOverwritePresetDialog();
                    return;
                }

                BuildSettings buildSettings = new BuildSettings(
                        HCR.hcr_gui.getVradSettings(),
                        HCR.hcr_gui.getVBSPSettings(),
                        HCR.hcr_gui.getVvisSettings(),
                        vbspBox.getSelectedItem().equals(noneItem) ? null : (BuildProgram) vbspBox.getSelectedItem(),
                        vvisBox.getSelectedItem().equals(noneItem) ? null : (BuildProgram) vvisBox.getSelectedItem(),
                        vradBox.getSelectedItem().equals(noneItem) ? null : (BuildProgram) vradBox.getSelectedItem(),
                        nameField.getText(),
                        displayNameField.getText(),
                        commentArea.getText() == null ? "" : commentArea.getText()
                );

                BuildSettingsManager.addBuildSetting(buildSettings);
                ConsoleCommander.sendInfo("Added compile preset: " + displayNameField.getText() + " (" + nameField.getText() + ")");
                HCR.savePresetFrame.setVisible(false);
                reset();
            }
        });

        overwriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuildSettings buildSettings = new BuildSettings(
                        HCR.hcr_gui.getVradSettings(),
                        HCR.hcr_gui.getVBSPSettings(),
                        HCR.hcr_gui.getVvisSettings(),
                        vbspBox.getSelectedItem().equals(noneItem) ? null : (BuildProgram) vbspBox.getSelectedItem(),
                        vvisBox.getSelectedItem().equals(noneItem) ? null : (BuildProgram) vvisBox.getSelectedItem(),
                        vradBox.getSelectedItem().equals(noneItem) ? null : (BuildProgram) vradBox.getSelectedItem(),
                        nameField.getText(),
                        displayNameField.getText(),
                        commentArea.getText() == null ? "" : commentArea.getText()
                );

                BuildSettingsManager.removeBuildSetting(nameField.getText());
                BuildSettingsManager.addBuildSetting(buildSettings);
                ConsoleCommander.sendInfo("Overwrite compile preset: " + displayNameField.getText() + " (" + nameField.getText() + ")");
                HCR.savePresetFrame.setVisible(false);
                reset();
            }
        });

        overwriteCancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                HCR.savePresetFrame.setVisible(false);
            }
        });

        saveCancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                HCR.savePresetFrame.setVisible(false);
            }
        });
    }

    @Override
    public void updateContent(int contentID) {
        if (contentID == -1 || contentID == 1){
            vbspBox.setSelectedIndex(-1);
            vvisBox.setSelectedIndex(-1);
            vradBox.setSelectedIndex(-1);
            vbspBox.removeAllItems();
            vradBox.removeAllItems();
            vvisBox.removeAllItems();
            vbspBox.addItem(noneItem);
            vvisBox.addItem(noneItem);
            vradBox.addItem(noneItem);
            for(BuildProgram buildProgram : BuildProgramManager.getBuildProgramms()){
                switch (buildProgram.getBuildProgramType()){
                    case VBSP:
                        vbspBox.addItem(buildProgram);
                        break;
                    case VVIS:
                        vvisBox.addItem(buildProgram);
                        break;
                    case VRAD:
                        vradBox.addItem(buildProgram);
                        break;
                }
            }
            updateChooser();
        }
    }

    public void updateChooser(){
        vbspBox.setSelectedItem(HCR.hcr_gui.getSelectedBuildProgram(BuildProgramType.VBSP) == null ? -1 : HCR.hcr_gui.getSelectedBuildProgram(BuildProgramType.VBSP));
        vvisBox.setSelectedItem(HCR.hcr_gui.getSelectedBuildProgram(BuildProgramType.VVIS) == null ? -1 : HCR.hcr_gui.getSelectedBuildProgram(BuildProgramType.VVIS));
        vradBox.setSelectedItem(HCR.hcr_gui.getSelectedBuildProgram(BuildProgramType.VRAD) == null ? -1 : HCR.hcr_gui.getSelectedBuildProgram(BuildProgramType.VRAD));
    }
}
