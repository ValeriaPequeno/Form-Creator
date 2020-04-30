package persistence;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.IOException;

public class FileImporter {

//  FileChooser
    private FileChooser fileChooser = new FileChooser();
    private File file = null;
    private String importedFilePath;
    private FileType fileType;

    public FileImporter(FileType fileType) {
        this.fileType = fileType;
    }

    public PDDocument importFile(){
        pickFile(FileType.PDF);
        PDDocument pdDocument = null;
        if(file != null){
            importedFilePath = file.getPath();
            try{
                pdDocument = PDDocument.load(file);
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return pdDocument;
    }

    public void pickFile(FileType type) {
        FileChooser.ExtensionFilter fileFilter;
        switch (type){
            case PDF:
                fileFilter = new FileChooser.ExtensionFilter("PDF files (*.PDF)", "*.pdf");
                break;
            case FDF:
                fileFilter = new FileChooser.ExtensionFilter("FDF files (*.FDF)", "*.fdf");
                break;
            case CSV:
                fileFilter = new FileChooser.ExtensionFilter("CSV files (*.CSV)", "*.csv");
                break;
            case XFDF:
                fileFilter = new FileChooser.ExtensionFilter("XFDF files (*.XFDF)", "*.xfdf");
                break;
            case XML:
                fileFilter = new FileChooser.ExtensionFilter("XML files (*.XML)", "*.xml");
                break;
            default:
                fileFilter = null;
        }
        if(fileFilter != null)
            fileChooser.getExtensionFilters().add(fileFilter);
        file = fileChooser.showOpenDialog(new Stage());
    }




//  Getters & Setters
    public String getImportedFilePath() {
        return importedFilePath;
    }

    public void setImportedFilePath(String importedFilePath) {
        this.importedFilePath = importedFilePath;
    }

}
