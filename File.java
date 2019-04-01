public class File {
    private int nbPieceTypes;
    private int nbModels;
    private int[] ownedPieces;
    private int[] piecePrices;
    private Model[]  models;

    File(int nbTypes) {
        this.nbPieceTypes = nbTypes;
        this.ownedPieces = new int[nbTypes];
        this.models = new Model[nbTypes];
        this.piecePrices = new int[nbTypes];
    }

    public int getNbPiecesTypes() {
        return this.nbPieceTypes;
    }

    public int getNbModels() {
        return this.nbModels;
    }

    public void setNbModels(int nbModels) {
        this.nbModels = nbModels;
    }

    public void setNbPiecesTypes(int nbPieceTypes) {
        this.nbPieceTypes = nbPieceTypes;
    }

    public void addOwnedPiece(int nbPieceTypes, int index) {
        this.ownedPieces[index] = nbPieceTypes;
    }

    public void addPiecePrice(int price, int index) {
        this.piecePrices[index] = price;
    }

    public void addModel(Model model, int index) {
        this.models[index] = model;
    }

    public Model getModel(int index) {
        return this.models[index];
    }

    public int getPrice(int index) {
        return this.piecePrices[index];
    }

    public int getNbPiece(int index) {
        return this.ownedPieces[index];
    }
}