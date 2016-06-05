package de.therazzerapp.hcr.gui;

import de.therazzerapp.hcr.CompilerLog;
import de.therazzerapp.hcr.HCR;
import de.therazzerapp.hcr.managers.LogPatternManager;

import java.util.List;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class CompilerLogSyncThread extends Thread {

    private final CompilerLog log;

    public CompilerLogSyncThread(CompilerLog log) {
        this.log = log;
    }

    @Override
    public void run() {

        List<Character> newLogs;

        while ((newLogs = log.getLastChars()) != null){
            for (char c : newLogs){
                if (c == '\n'){
                    LogPatternManager.formatText(log.getLog());
                    CompileOutputCommander.append(LogPatternManager.formatText(HCR.hcr_gui.getCompileOutputLineArea().getText()) + "<br>");
                    HCR.hcr_gui.getCompileOutputLineArea().setText("");
                } else {
                    HCR.hcr_gui.getCompileOutputLineArea().append(""+c);
                }
            }
        }
        HCR.hcr_gui.setCompileButton(false);
    }
}
