package de.therazzerapp.hcr.gui.ui;

import de.therazzerapp.hcr.content.BuildProgram;
import de.therazzerapp.hcr.content.BuildProgramType;
import de.therazzerapp.hcr.managers.BuildProgramManager;
import de.therazzerapp.hcr.managers.BuildSettingsManager;
import de.therazzerapp.hcr.managers.CompileQueueManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class ToolBuildPrograms_Gui {
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
        updateList();
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
        addListener();
    }

    public void updateLabel(BuildProgram buildProgram){
        nameLabel.setText(buildProgram.getDisplayName() + " (" + buildProgram.getName() + ")");
        pathLabel.setText(buildProgram.getPath());
        typeLabel.setText(buildProgram.getBuildProgramType() + " (" + buildProgram.getBuildProgramType().getName() + ")");
        commentArea.setText(buildProgram.getComment());
    }

    public void updateList(){
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

    }

    private void addListener(){

        vbspList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateLabel((BuildProgram) vbspList.getSelectedValue());
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
                updateLabel((BuildProgram) vvisList.getSelectedValue());
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
                updateLabel((BuildProgram) vradList.getSelectedValue());
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
}
