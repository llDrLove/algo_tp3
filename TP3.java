public class TP3 {
    public static void main(String args[]) {
        String path = args[1];

        SingleFile singleFile = new SingleFile(path);

        System.out.println(path);
    }
}