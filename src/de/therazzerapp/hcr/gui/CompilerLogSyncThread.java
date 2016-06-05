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
    private StringBuilder line = new StringBuilder();

    public CompilerLogSyncThread(CompilerLog log) {
        this.log = log;
    }

    @Override
    public void run() {

        List<Character> newLogs;

        while ((newLogs = log.getLastChars()) != null){
            StringBuilder builder = new StringBuilder();

            for (char c : newLogs){

                if(c == '\n'){
                    CompileOutputCommander.append(LogPatternManager.formatText(line.toString()));
                    line.delete(0,line.length()-1);
                } else {
                    line.append(c);
                }
                builder.append(c);

            }
            CompileOutputCommander.append(builder.toString());
        }

        HCR.hcr_gui.setCompileButton(false);
    }
}
