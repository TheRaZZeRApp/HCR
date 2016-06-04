package de.therazzerapp.hcr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <description>
 *
 * @author The RaZZeR App <rezzer101@googlemail.com; e-mail@therazzerapp.de>
 * @since <version>
 */
public class LogPattern {

    private final Pattern pattern;
    private final String replace;

    public LogPattern(String pattern, String replace) {
        this.pattern = Pattern.compile(pattern);
        this.replace = replace;
    }

    public String format(String text){
        Matcher matcher = pattern.matcher(text);

        if (matcher.matches()){
            String replaceAll = matcher.replaceAll(replace);
            for (int x = 1; x <= matcher.groupCount(); x++){
                replaceAll.replaceAll("$" + x, matcher.group(x));
            }
            return replaceAll;
        }
        return text;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public String getReplace() {
        return replace;
    }
}
