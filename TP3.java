public class TP3 {
    public static void main(String args[]) {
        String path = args[1];

        Reader reader = new Reader(path);
        File singleFile = reader.read();

        Model[] models = singleFile.getModels();
        double[] ownedRatios;
        Model bestModel = models[0];

        while (singleFile.getNbRemainingPieces() != 0) {
            singleFile.calculateRatio();
            ownedRatios = singleFile.getRatios();
            bestModel.compareRatios(ownedRatios);
            
            for (Model model : models) {
                if(bestModel.getDiffRatios() > model.compareRatios(ownedRatios)) {
                    bestModel = model;
                }
            }
            singleFile.buildModel(bestModel);
        }
        singleFile.printSolution();
    }
}