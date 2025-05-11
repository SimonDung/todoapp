package org.manager.helper;

import java.util.ArrayList;
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
}
