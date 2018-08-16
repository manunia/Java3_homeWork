package lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Maria_L
 */

public class MainClass {

    private static FileInputStream in;

    public static void main(String[] args) {
        try {
            getMemorySize();
            //1.
            readFileToBite("123/1.txt");

            //создадим файлы
        create("123/2.txt");
        create("123/3.txt");
        create("123/4.txt");
        create("123/5.txt");
            //2.
            sewTogetherFiles();
            //3.
            long t = System.currentTimeMillis();
            readFileToString("123/6.txt");
            System.out.println(System.currentTimeMillis() - t);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль
    public static void readFileToBite(String path) throws IOException {
        in = new FileInputStream(path);

        byte[] bytes = new byte[50];
        int x;
        while ((x = in.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, x));
        }
    }

    //2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт)
    public static void sewTogetherFiles() throws IOException {
        //создадим список потоков
        ArrayList<InputStream> inputStreams = new ArrayList<>();
        //добавим файлы в список потоков
        inputStreams.add(new FileInputStream("123/1.txt"));
        inputStreams.add(new FileInputStream("123/2.txt"));
        inputStreams.add(new FileInputStream("123/3.txt"));
        inputStreams.add(new FileInputStream("123/4.txt"));
        inputStreams.add(new FileInputStream("123/5.txt"));

        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(inputStreams));

        int x;
        while ((x = in.read()) != -1) {
            System.out.print((char) x);
        }
    }

//    3. Написать консольное приложение, которое умеет постранично читать текстовые файлы
//    (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов), программа
//    выводит ее в консоль. Контролируем время выполнения: программа не должна загружаться
//    дольше 10 секунд, а чтение – занимать свыше 5 секунд.
    public static void readFileToString(String path) throws IOException {
        in = new FileInputStream(path);
        byte[] bytes = new byte[2219];
        int x;
        while ((x = in.read(bytes) )!= -1) {
            //System.out.println(new String(bytes,0,x));
        }
}

    //создание файла
    public static void create(String path) throws IOException {
//        File dir = new File("123");
//        dir.mkdir();
        File file = new File(path);
        file.createNewFile();
    }

    //узнать размер памяти, выделяемой JVM
    public static void getMemorySize() throws IOException {
        FileOutputStream file = new FileOutputStream("junk");
        ByteCounterOutputStream bcos = new ByteCounterOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(bcos);
        int start = bcos.bytesWrittenSoFar();
        out.writeObject(";");
        out.flush();
        int objectsize = bcos.bytesWrittenSoFar() - start;
        System.out.println("MyObject occupies " + objectsize + " bytes when serialized");





    }

}
