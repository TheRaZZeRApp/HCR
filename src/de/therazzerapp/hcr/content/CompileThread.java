package de.therazzerapp.hcr.content;

import de.therazzerapp.hcr.CompilerLog;
import de.therazzerapp.hcr.HCR;
import de.therazzerapp.hcr.gui.ConsoleCommander;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class CompileThread extends Thread {

    private final CompileSet compileSet;
    private final CompilerLog log = new CompilerLog();
     private       Process process;

    public CompileThread(CompileSet compileSet) {
        this.compileSet = compileSet;
    }

    @Override
    public void run() {
            Runtime rt = Runtime.getRuntime();

                for (BuildProgram program : compileSet.getBuildSettings().getBuildProgramms()) {
                    if (program != null && !isInterrupted()) {
                        BuildProgramSettings settings = compileSet.getBuildSettings().getBuildProgramSettings(program.getBuildProgramType());
                        log.append("\n====================================================================\n")
                                .append("= ").append(program.getBuildProgramType().name()).append(" (").append(program.getBuildProgramType().getName()).append(")       Begin\n")
                                .append("====================================================================\n")
                                .append("Path: ").append(program.getPath()).append('\n')
                                .append("Parameters: ").append(settings.getParam(compileSet.getBuildSettings().getGameDir())).append("\n\n");
                        try {
                            process = rt.exec("\"" + program.getPath() + "\" " + settings.getParam(compileSet.getBuildSettings().getGameDir()) + "\"" + compileSet.getVmfPath().replace(".vmf", settings.getFileType()) + "\"");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

                                int line;
                                while ((line = br.read()) != -1) {
                                    log.append((char) line);
                                }
                                br.close();
                            } catch (IOException e) {
                                process.destroy();
                                log.finish();
                                return;
                            }
                        } catch (IOException e) {
                            //todo Error meldung
                            log.finish();
                            return;
                        }
                    }
                }

        log.finish();
    }

    @Override
    public void interrupt() {
        if (process != null) {
            process.destroy();
        }
        super.interrupt();
    }

    public CompilerLog getLog() {
        return log;
    }
}
