
package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DocumentModel {
    private String originalText;
    private String normalizedText;

    public DocumentModel() {
        originalText = "";
        normalizedText = "";
    }

    public void loadDocument(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        originalText = sb.toString();
    }

    public void normalizeDocument() {
        normalizedText = originalText.replaceAll("\\s+", " ")
                .replaceAll("\\s+(?=[.,:])", "")
                .replaceAll("(?<=[.!?])\\s+([a-zA-Z])", " $1")
                .replaceAll("\"\\s+", "\"")
                .replaceAll("\\s+\"", "\"")
                .replaceAll("\\n\\s*\\n", "\n");

        normalizedText = Character.toUpperCase(normalizedText.charAt(0)) + normalizedText.substring(1);

        if (!normalizedText.endsWith(".")) {
            normalizedText += ".";
        }

    }

    public String getNormalizedText() {
        return normalizedText;
    }

    public void saveNormalizedDocument(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(normalizedText);
        }
    }
}
