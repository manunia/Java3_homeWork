package lesson4.DopDZ;

import java.io.*;

public class MyFile {

    private static File file = new File("123/8.txt");
    private static FileWriter fileWriter = null;
    private static BufferedWriter bufferedWriter = null;
    private static String str = "Hello Java!";

    private static FileReader fileReader = null;
    private static BufferedReader bufferedReader = null;

    private static FileInputStream in;

    public static void createFile() throws IOException {
        file.createNewFile();
        fileWriter = new FileWriter(file);
        bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < 10; i++) {
            bufferedWriter.write(i + ". " + str + "\n");
        }
        bufferedWriter.write("end");
        bufferedWriter.close();
        fileWriter.close();
    }

    public static void readFile() throws IOException {
        in = new FileInputStream(file);
        byte bytes[] = new byte[1800];
        int x;
        while ((x = in.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, x));
        }
        in.close();
    }
}
