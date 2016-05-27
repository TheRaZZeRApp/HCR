package de.therazzerapp.hcr.gui.ui;

import de.therazzerapp.hcr.HCR;
import de.therazzerapp.hcr.content.BuildProgram;
import de.therazzerapp.hcr.content.BuildProgramType;
import de.therazzerapp.hcr.content.BuildSettings;
import de.therazzerapp.hcr.gui.ConsoleCommander;
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
public class SavePreset_Gui {
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

    public SavePreset_Gui(JFrame jFrame) {
        overwrirePanel.setEnabled(false);
        overwrirePanel.setVisible(false);

        addListener(jFrame);

        for(BuildProgram buildProgram : BuildProgramManager.getBuildProgramms()){
            switch (buildProgram.getBuildProgramType()){
                case VBSP:
                    vbspBox.addItem(buildProgram.getDisplayName());
                    break;
                case VVIS:
                    vvisBox.addItem(buildProgram.getDisplayName());
                    break;
                case VRAD:
                    vradBox.addItem(buildProgram.getDisplayName());
                    break;
            }
        }

        vbspBox.setSelectedIndex(HCR.hcr_gui.getVbspChooser().getSelectedIndex());
        vvisBox.setSelectedIndex(HCR.hcr_gui.getVbspChooser().getSelectedIndex());
        vradBox.setSelectedIndex(HCR.hcr_gui.getVradChooser().getSelectedIndex());

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

                if(BuildSettingsManager.containsBuildSettingsByDisplayName(displayNameField.getText()) && !BuildSettingsManager.containsBuildSettings(nameField.getText())){
                    errorLabel.setText("Name already taken.");
                    return;
                }

                if(BuildSettingsManager.containsBuildSettings(nameField.getText())){
                    savePanel.setVisible(false);
                    overwrirePanel.setVisible(true);
                    saveButton.setVisible(false);
                    saveCancelButton.setVisible(false);
                    return;
                }

                BuildSettingsManager.addBuildSetting(nameField.getName(),new BuildSettings(
                        HCR.hcr_gui.getVradSettings(),
                        HCR.hcr_gui.getVBSPSettings(),
                        HCR.hcr_gui.getVvisSettings(),
                        BuildProgramManager.getByTypeIndex(vbspBox.getSelectedIndex(), BuildProgramType.VBSP),
                        BuildProgramManager.getByTypeIndex(vvisBox.getSelectedIndex(), BuildProgramType.VVIS),
                        BuildProgramManager.getByTypeIndex(vradBox.getSelectedIndex(), BuildProgramType.VRAD),
                        nameField.getText(),
                        displayNameField.getText(),
                        commentArea.getText()
                ));
                ConsoleCommander.sendInfo("Added compile preset: " + displayNameField.getText() + " (" + nameField.getText() + ")");
                reset();
                HCR.hcr_gui.reloadBuildSettingsChooser();
                HCR.savePresetFrame.setVisible(false);
            }
        });

        overwriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuildSettingsManager.removeBuildSetting(nameField.getText());
                BuildSettingsManager.addBuildSetting(nameField.getName(),new BuildSettings(
                        HCR.hcr_gui.getVradSettings(),
                        HCR.hcr_gui.getVBSPSettings(),
                        HCR.hcr_gui.getVvisSettings(),
                        BuildProgramManager.getByTypeIndex(vbspBox.getSelectedIndex(), BuildProgramType.VBSP),
                        BuildProgramManager.getByTypeIndex(vvisBox.getSelectedIndex(), BuildProgramType.VVIS),
                        BuildProgramManager.getByTypeIndex(vradBox.getSelectedIndex(), BuildProgramType.VRAD),
                        nameField.getText(),
                        displayNameField.getText(),
                        commentArea.getText()
                ));
                ConsoleCommander.sendInfo("Overwrite compile preset: " + displayNameField.getText() + " (" + nameField.getText() + ")");
                reset();
                HCR.hcr_gui.reloadBuildSettingsChooser();
                HCR.savePresetFrame.setVisible(false);
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
}
