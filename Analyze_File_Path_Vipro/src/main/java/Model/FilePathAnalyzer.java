package Model;

public class FilePathAnalyzer {
    private String filePath;

    public FilePathAnalyzer(String filePath) {
        this.filePath = filePath;
    }

    public String getPath() {
        int lastIndex = filePath.lastIndexOf("\\");
        return filePath.substring(0, lastIndex);
    }

    public String getFileName() {
        int lastIndex = filePath.lastIndexOf("\\");
        int dotIndex = filePath.lastIndexOf(".");
        return filePath.substring(lastIndex + 1, dotIndex);
    }

    public String getExtension() {
        int dotIndex = filePath.lastIndexOf(".");
        return filePath.substring(dotIndex + 1);
    }

    public String getDisk() {
        int colonIndex = filePath.indexOf(":");
        return filePath.substring(0, colonIndex + 1);
    }

    public String[] getFolders() {
        int firstIndex = filePath.indexOf("\\");
        int lastIndex = filePath.lastIndexOf("\\");
        String folders = filePath.substring(firstIndex + 1, lastIndex);
        return folders.split("\\\\");
    }
}