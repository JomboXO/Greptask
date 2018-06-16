import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
    /*  1) поток текстовой информации вводится из текстового файла
        2) начинается программа с просьбы ввести слово
	    3) после ввода слова, выводятся строки из текстового файла, в которых встречается это слово
	        (вывод идет на консоль)
    */

        String str = null;
        File file = new File("test.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите слово - ");
        if (sc.hasNextLine()) {
            str = sc.nextLine();
        } else {
            System.out.println("Что-то не то");
        }

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    if (s.toLowerCase().indexOf(str.toLowerCase())!= -1){
                        System.out.println(s);
                    }
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}