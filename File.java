public class File {
    private int nbPieceTypes;
    private int nbModels;
    private double[] ownedPieces;
    private double[] ownedRatios;
    private double nbOwnedPieces;
    private int[] piecePrices;
    private Model[]  models;
    private int cost;

    File(int nbTypes) {
        this.nbPieceTypes = nbTypes;
        this.nbOwnedPieces = 0;
        this.cost = 0;
        this.ownedPieces = new double[nbTypes];
        this.ownedRatios = new double[nbTypes];
        this.piecePrices = new int[nbTypes];
    }

    public void initModels(int nbModels) {
        this.models = new Model[nbModels];
        this.nbModels = nbModels;
    }

    public int getNbPiecesTypes() {
        return this.nbPieceTypes;
    }

    public int getNbModels() {
        return this.nbModels;
    }

    public int[] getPrices() {
        return this.piecePrices;
    }

    public void setNbPiecesTypes(int nbPieceTypes) {
        this.nbPieceTypes = nbPieceTypes;
    }

    public void addOwnedPiece(int nbPieceTypes, int index) {
        this.ownedPieces[index] = nbPieceTypes;
        this.nbOwnedPieces += nbPieceTypes;
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

    public Model[] getModels() {
        return this.models;
    }

    public double[] getRatios() {
        return this.ownedRatios;
    }

    public int getPrice(int index) {
        return this.piecePrices[index];
    }

    public int getCost() {
        return this.cost;
    }

    public double getNbRemainingPieces() {
        return this.nbOwnedPieces;
    }

    public double getNbPiece(int index) {
        return this.ownedPieces[index];
    }

    public void calculateRatio() {
        for (int i = 0; i < this.ownedPieces.length; i++) {
            this.ownedRatios[i] = this.ownedPieces[i]/this.nbOwnedPieces;
        }
    }

    public void buildModel(Model modelToBuild) {
        modelToBuild.incrementValue();
        double[] piecesToBuild = modelToBuild.getPiecesRequired();
        for (int i = 0; i < this.ownedPieces.length; i++) {
            if(piecesToBuild[i] == 0) {

            }
            else if(this.ownedPieces[i] >= piecesToBuild[i]) {
                this.ownedPieces[i] -=  piecesToBuild[i];
                this.nbOwnedPieces -= piecesToBuild[i];
            }
            else {
                this.nbOwnedPieces -= this.ownedPieces[i];
                addCost(piecesToBuild[i] - this.ownedPieces[i], i);
                this.ownedPieces[i] = 0;
            }
        }
    }

    private void addCost(double nbPieces, int index) {
        this.cost += nbPieces * this.piecePrices[index];
    }

    public void printSolution() {
        String toPrint = "";
        for (Model model : this.models) { 
            toPrint += model.getValue() + " ";
        }
        System.out.print(toPrint);
    }
}