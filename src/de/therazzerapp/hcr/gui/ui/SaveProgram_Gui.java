package de.therazzerapp.hcr.gui.ui;

import de.therazzerapp.hcr.HCR;
import de.therazzerapp.hcr.content.BuildProgram;
import de.therazzerapp.hcr.content.BuildProgramType;
import de.therazzerapp.hcr.content.BuildSettings;
import de.therazzerapp.hcr.filter.ExeFileFilter;
import de.therazzerapp.hcr.filter.RadFileFilter;
import de.therazzerapp.hcr.gui.ConsoleCommander;
import de.therazzerapp.hcr.gui.ContentUpdater;
import de.therazzerapp.hcr.gui.GUIUtils;
import de.therazzerapp.hcr.managers.BuildProgramManager;
import de.therazzerapp.hcr.managers.BuildSettingsManager;
import de.therazzerapp.hcr.managers.FileFilterManager;

import javax.swing.*;
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
public class SaveProgram_Gui implements ContentUpdater{
    private JPanel mainPanel;
    private JPanel overwrirePanel;
    private JPanel savePanel;
    private JButton overwriteCancelButton;
    private JTextField displayNameField;
    private JComboBox typeBox;
    private JTextArea commentArea;
    private JButton saveCancelButton;
    private JButton saveButton;
    private JTextField nameField;
    private JComboBox vvisBox;
    private JComboBox vradBox;
    private JButton overwriteButton;
    private JLabel errorLabel;
    private JTextField pathField;
    private JButton openButton;
    private JFileChooser openDialog = new JFileChooser();

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

    public SaveProgram_Gui(JFrame jFrame) {

        overwrirePanel.setEnabled(false);
        overwrirePanel.setVisible(false);

        openDialog.setDialogTitle("Choose a .exe");
        openDialog.setFileSelectionMode(JFileChooser.FILES_ONLY);
        openDialog.addChoosableFileFilter(FileFilterManager.getExeFileFilter());
        openDialog.setFileFilter(FileFilterManager.getExeFileFilter());
        openDialog.setAcceptAllFileFilterUsed(false);

        addListener(jFrame);

        for(BuildProgramType type : BuildProgramType.values()){
            typeBox.addItem(type);
        }
    }

    private void reset(){
        pathField.setText("");
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

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDialog.showOpenDialog(jFrame);
                try{
                    pathField.setText(openDialog.getSelectedFile().getPath());
                } catch (NullPointerException exception){
                    ConsoleCommander.sendError("No file selected!");
                }
            }
        });

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

                if(BuildProgramManager.containsBuildProgram(nameField.getText())){
                    HCR.openOverwritePresetDialog();
                    return;
                }
                BuildProgram buildProgram = new BuildProgram(
                        nameField.getText(),
                        displayNameField.getText(),
                        commentArea.getText(),
                        pathField.getText(),
                        (BuildProgramType) typeBox.getSelectedItem()
                );
                BuildProgramManager.addBuildProgram(buildProgram);
                ConsoleCommander.sendInfo("Added build program: " + displayNameField.getText() + " (" + nameField.getText() + ")");
                HCR.savePresetFrame.setVisible(false);
                reset();
            }
        });

        overwriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuildProgram buildProgram = new BuildProgram(
                        nameField.getText(),
                        displayNameField.getText(),
                        commentArea.getText(),
                        pathField.getText(),
                        (BuildProgramType) typeBox.getSelectedItem()
                );
                BuildProgramManager.removeBuildProgram(buildProgram);
                BuildProgramManager.addBuildProgram(buildProgram);
                ConsoleCommander.sendInfo("Overwrite build program: " + displayNameField.getText() + " (" + nameField.getText() + ")");
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
    public void updateContent() {

    }
}
