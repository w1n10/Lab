
package controller;

import model.DocumentModel;
import view.DocumentView;

public class DocumentNormalizationApp {
    public static void main(String[] args) {
        DocumentModel model = new DocumentModel();
        DocumentView view = new DocumentView();
        DocumentController controller = new DocumentController(model, view);

        
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        controller.normalizeDocument(inputFile, outputFile);
    }
}
