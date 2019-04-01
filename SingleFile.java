public class SingleFile {
    private String path;
    private int nbDifferentPiecesTypes;

    SingleFile(String path) {
        this.path = path;
        this.nbDifferentPiecesTypes = 0;
    }

    public String getPath() {
        return this.path;
    }

    public int getNbDifferentPiecesTypes() {
        return this.nbDifferentPiecesTypes;
    }
}