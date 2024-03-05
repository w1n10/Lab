package com.mycompany.analyze_file_path_vipro;

import Controller.PathAnalyzerController;
import Model.FilePathAnalyzer;

public class Analyze_File_Path_Vipro{
    public static void main(String[] args) {
        PathAnalyzerController controller = new PathAnalyzerController(new FilePathAnalyzer(""));
        controller.run();
    }
}