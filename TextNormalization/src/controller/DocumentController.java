
package controller;

import java.io.IOException;
import model.DocumentModel;
import view.DocumentView;

public class DocumentController {
    private DocumentModel model;
    private DocumentView view;

    public DocumentController(DocumentModel model, DocumentView view) {
        this.model = model;
        this.view = view;
    }

    public void normalizeDocument(String inputFile, String outputFile) {
        try {
            model.loadDocument(inputFile);
            model.normalizeDocument();
            model.saveNormalizedDocument(outputFile);
            view.displayMessage("Document normalized and saved successfully.");
        } catch (IOException e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }
}
