package lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Maria_L
 */

public class MainClass {

    public static void main(String[] args) {
        //1.
        //readFileToBite("123/1.txt");

        //создадим файлы
//        create("123/2.txt");
//        create("123/3.txt");
//        create("123/4.txt");
//        create("123/5.txt");
        //2.
        //sewTogetherFiles();
        //3.
        long t = System.currentTimeMillis();
        readFileToString("123/6.txt");
        System.out.println(System.currentTimeMillis() - t);


    }

    //1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль
    public static void readFileToBite(String path) {
        try (FileInputStream in = new FileInputStream(path)){
            byte[] bytes = new byte[50];
            int x;
            while ((x = in.read(bytes) )!= -1) {
                System.out.println(new String(bytes,0,x));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт)
    public static void sewTogetherFiles() {
        try {
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
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    3. Написать консольное приложение, которое умеет постранично читать текстовые файлы
//    (размером > 10 mb). Вводим страницу (за страницу можно принять 1800 символов), программа
//    выводит ее в консоль. Контролируем время выполнения: программа не должна загружаться
//    дольше 10 секунд, а чтение – занимать свыше 5 секунд.
public static void readFileToString(String path) {
    try (FileInputStream in = new FileInputStream(path)){
        byte[] bytes = new byte[2219];
        int x;
        while ((x = in.read(bytes) )!= -1) {
            //System.out.println(new String(bytes,0,x));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    //создание файла
    public static void create(String path) {
//        File dir = new File("123");
//        dir.mkdir();
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
