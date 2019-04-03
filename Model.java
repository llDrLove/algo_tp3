
public class Model {
    private double[] piecesRequired;
    private double[] ratios;
    private double totalPieces;
    private double diffRatios;
    private int modelNb;

    Model(int nbPiece, int index) {
        this.piecesRequired = new double[nbPiece];
        this.ratios = new double[nbPiece];
        this.totalPieces = 0;
        this.modelNb = index + 1;
    }

    public double getNbPiece(int index) {
        return this.piecesRequired[index];
    }

    public double[] getPiecesRequired() {
        return this.piecesRequired;
    }

    public int getModelNb() {
        return this.modelNb;
    }

    public void addPieceNb(int index, int numberRequired) {
        this.piecesRequired[index] = numberRequired;
        this.totalPieces += numberRequired;
    }

    public void calculateRatio() {
        for (int i = 0; i < this.piecesRequired.length; i++) {
            this.ratios[i] = this.piecesRequired[i]/this.totalPieces;
        }
    }

    public double compareRatios(double[] ownedRatios) {
        this.diffRatios = 0;
        for (int i = 0; i < this.piecesRequired.length; i++) {
            this.diffRatios += Math.abs(this.ratios[i] - ownedRatios[i]);
        }
        return this.diffRatios;
    }

    public double getDiffRatios() {
        return this.diffRatios;
    }
}