import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader {
    private File singleFile;
    private String path;

    Reader(String path) {
        this.path = path;
    }

    public File read() {

        try {
            FileReader fileReader = new FileReader(this.path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            this.singleFile = new File(Integer.parseInt(bufferedReader.readLine()));
            
            String[] splited = bufferedReader.readLine().split("\\s+");
            for (int i = 0; i < this.singleFile.getNbPiecesTypes(); i++) {
                // Read the pieces owned
                this.singleFile.addOwnedPiece(Integer.parseInt(splited[i]), i);
            }

            splited = bufferedReader.readLine().split("\\s+");
            for (int i = 0; i < this.singleFile.getNbPiecesTypes(); i++) {
                // Read the pieces owned
                this.singleFile.addPiecePrice(Integer.parseInt(splited[i]), i);
            }

            this.singleFile.setNbModels(Integer.parseInt(bufferedReader.readLine()));

            for (int i = 0; i < this.singleFile.getNbModels(); i++) {
                splited = bufferedReader.readLine().split("\\s+");
                Model model = new Model(this.singleFile.getNbPiecesTypes());
                for (int j = 0; j < this.singleFile.getNbPiecesTypes(); j++) {
                    // Read the pieces owned
                    model.addPieceNb(j, Integer.parseInt(splited[j]));
                }
                
                this.singleFile.addModel(model, i);
            }
            
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file " + this.path + " was not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading the file : " + this.path);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Whoops! An unexpected error occurred.");
            e.printStackTrace();
        } 

        return this.singleFile;
    }
}
