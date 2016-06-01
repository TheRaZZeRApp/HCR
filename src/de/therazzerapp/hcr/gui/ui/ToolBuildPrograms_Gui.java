package de.therazzerapp.hcr.gui.ui;

import de.therazzerapp.hcr.HCR;
import de.therazzerapp.hcr.content.BuildProgram;
import de.therazzerapp.hcr.content.BuildProgramType;
import de.therazzerapp.hcr.gui.ConsoleCommander;
import de.therazzerapp.hcr.gui.ContentUpdater;
import de.therazzerapp.hcr.gui.GUIUtils;
import de.therazzerapp.hcr.managers.BuildProgramManager;
import de.therazzerapp.hcr.managers.BuildSettingsManager;
import de.therazzerapp.hcr.managers.CompileQueueManager;

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
public class ToolBuildPrograms_Gui implements ContentUpdater{
    private JPanel jPanel;
    private JPanel programsPanel;
    private JPanel selectedProgramPanel;
    private JButton addButton;
    private JButton removeButton;
    private JButton renameButton;
    private JList vbspList;
    private JList vvisList;
    private JList vradList;
    private JPanel currentBuildProgramPane;
    private JTextArea commentArea;
    private JLabel nameLabel;
    private JLabel pathLabel;
    private JLabel typeLabel;
    private DefaultListModel vbspDefaultListModel = new DefaultListModel();
    private DefaultListModel vvisDefaultListModel = new DefaultListModel();
    private DefaultListModel vradDefaultListModel = new DefaultListModel();

    public ToolBuildPrograms_Gui(JFrame jFrame) {
        vbspList.setModel(vbspDefaultListModel);
        vvisList.setModel(vvisDefaultListModel);
        vradList.setModel(vradDefaultListModel);
        vradList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        vvisList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        vbspList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addListener();
    }

    public void updateLabel(BuildProgram buildProgram){
        if (buildProgram == null){
            ConsoleCommander.sendError("Build program update error!");
            return;
        }
        nameLabel.setText(buildProgram.getDisplayName() + " (" + buildProgram.getName() + ")");
        pathLabel.setText(buildProgram.getPath());
        typeLabel.setText(buildProgram.getBuildProgramType() + " (" + buildProgram.getBuildProgramType().getName() + ")");
        commentArea.setText(buildProgram.getComment());
    }

    private void addListener(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HCR.openSaveProgramDialog();
            }
        });

        vbspList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vbspList.getSelectedIndex() != -1){
                    updateLabel((BuildProgram) vbspList.getSelectedValue());
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

        vvisList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vvisList.getSelectedIndex() != -1){
                    updateLabel((BuildProgram) vvisList.getSelectedValue());
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

        vradList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (vradList.getSelectedIndex() != -1){
                    updateLabel((BuildProgram) vradList.getSelectedValue());
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
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    @Override
    public void updateContent(int contentID) {
        if (contentID == -1 || contentID == 1){
            vradDefaultListModel.removeAllElements();
            vbspDefaultListModel.removeAllElements();
            vvisDefaultListModel.removeAllElements();
            vbspList.removeAll();
            vvisList.removeAll();
            vradList.removeAll();
            for (BuildProgram buildProgram : BuildProgramManager.getBuildProgramms()) {
                switch (buildProgram.getBuildProgramType()){
                    case VBSP:
                        vbspDefaultListModel.addElement(buildProgram);
                        break;
                    case VVIS:
                        vvisDefaultListModel.addElement(buildProgram);
                        break;
                    case VRAD:
                        vradDefaultListModel.addElement(buildProgram);
                        break;
                }
            }

            if(vbspDefaultListModel.size() > 0){
                vbspList.setSelectedIndex(0);
                updateLabel((BuildProgram) vbspList.getSelectedValue());
            } else if (vvisDefaultListModel.size() > 0){
                vvisList.setSelectedIndex(0);
                updateLabel((BuildProgram) vvisList.getSelectedValue());
            } else if(vradDefaultListModel.size() > 0){
                vradList.setSelectedIndex(0);
                updateLabel((BuildProgram) vradList.getSelectedValue());
            }
        }
    }
}
