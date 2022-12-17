import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) {
        //Получаем частоты слов
        RussianWordsParser fileParser = new RussianWordsParser("War and piece.txt");
        fileParser.parse();
        Map<String, Integer> frequency = fileParser.frequency();

        //Записываем их в файл
        try(FileWriter fileWriter = new FileWriter("statistics.txt")) {
            //Записываем в файл самое часто используемое слово
            fileWriter.write(fileParser.mostFrequentWord());
            //Записываем в файл среднюю частоту слова
            fileWriter.write("\nСредняя частота каждого слова: "+ fileParser.averageFrequency()+"\n");
            //записываем файл все слова с частотами.
            for(Map.Entry<String, Integer> entry : frequency.entrySet()) {
                String s = String.format("Слово %s встречается %d раз\n", entry.getKey(), entry.getValue());
                fileWriter.write(s);
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(fileParser.mostFrequentWord());
        System.out.printf("Средняя частота каждого слова: "+fileParser.averageFrequency());
    }
}
