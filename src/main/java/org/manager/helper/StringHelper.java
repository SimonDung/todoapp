package org.manager.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StringHelper {
    public static List<String> wrapTextByWords(String text, int maxWidth) {
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();

        for (String word : text.split(" ")) {
            if (line.length() + word.length() + 1 > maxWidth) {
                lines.add(line.toString().trim());
                line = new StringBuilder();
            }
            line.append(word).append(" ");
        }

        if (!line.isEmpty()) {
            lines.add(line.toString().trim());
        }
        return lines;
    }

    public static String booleanToString(boolean value) {
        String text;
        if (value) {
            text = "DONE";
        }
        else {
            text = "PEN";
        }
        return text;
    }

    public static String dateToString(Date date) {
        String text;
        if (date == null) {
            text = "N/A";
        }
        else {
            text = date.toString();
        }
        return text;
    }
}
