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
        this.pattern = Pattern.compile(pattern, Pattern.DOTALL);
        this.replace = replace;
    }

    public String format(String text){
        text = "CustomMaterialManager: Cached KeyValues materials/models/weapons/v_models/knife_butterfly/knife_butterfly.vmt.";
        Matcher matcher = pattern.matcher(text);
        System.out.println("in: " + text);

        if (matcher.matches()){
            System.out.println("match");
            String replaceAll = matcher.replaceAll(replace);
            System.out.println("replace: " + replaceAll);
            for (int x = 1; x <= matcher.groupCount(); x++){
                replaceAll.replaceAll("$" + x, matcher.group(x));
            System.out.println("replace group " + x + ": " + replaceAll);
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
