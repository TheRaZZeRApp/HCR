package de.therazzerapp.hcr;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class CompilerLog {

    private final Semaphore semaphore = new Semaphore(0);

    private final StringBuilder log = new StringBuilder();

    private List<Character> lastChars = new ArrayList<>();

    private boolean finish = false;

    public void finish(){
        finish = true;
        semaphore.release();
    }

    public CompilerLog append(char c){
        synchronized (this) {
            log.append(c);
            lastChars.add(c);
        }
        if (semaphore.availablePermits() == 0){
            semaphore.release();
        }
        return this;
    }

    public CompilerLog append(String text){
        synchronized (this) {
            log.append(text);

            for (char c : text.toCharArray()) {
                lastChars.add(c);
            }
        }
        if (semaphore.availablePermits() == 0){
            semaphore.release();
        }
        return this;
    }

    public List<Character> getLastChars(){
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            return null;
        }
        synchronized (this) {
            List<Character> temp = lastChars;
            lastChars = new ArrayList<>();
            return temp.isEmpty() && finish ? null : temp;
        }
    }


}
