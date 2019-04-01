public class TP3 {
    public static void main(String args[]) {
        /*String path = args[1];*/
        String path = "./exemplaires/LEGO_50_50_1000";

        Reader reader = new Reader(path);
        File singleFile = reader.read();

        System.out.println(path);
    }
}