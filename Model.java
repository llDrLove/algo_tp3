public class Model {
    private int[] piecesRequired;

    Model(int nbPiece) {
        this.piecesRequired = new int[nbPiece];
    }

    public int getNbPiece(int index) {
        return this.piecesRequired[index];
    }

    public int[] getPiecesRequired() {
        return this.piecesRequired;
    }

    public void addPieceNb(int index, int numberRequired) {
        this.piecesRequired[index] = numberRequired;
    }
}