package Controller;

import Model.FilePathAnalyzer;
import View.Menu;

import java.util.Scanner;

public class PathAnalyzerController extends Menu {
    private FilePathAnalyzer model;

    public PathAnalyzerController() {
        super("File Path Analyzer", new String[]{"Analyze Path", "Exit"});
    }

    public PathAnalyzerController(FilePathAnalyzer model) {
        this();
        this.model = model;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                analyzePath();
                break;
            case 2:
                System.out.println("Exiting the program...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
        }
    }

    public void analyzePath() {
        System.out.println("Please enter the file path:");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        model = new FilePathAnalyzer(filePath);

        String disk = model.getDisk();
        String path = model.getPath();
        String extension = model.getExtension();
        String fileName = model.getFileName();
        String[] folders = model.getFolders();

        System.out.println("Disk: " + disk);
        System.out.println("Result Analysis");
        System.out.println("Extension: " + extension);
        System.out.println("File Name: " + fileName);
        System.out.println("Path: " + path);
        System.out.println("Folders: " + String.join(", ", folders));
    }
}