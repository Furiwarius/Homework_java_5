import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 */

public class homework_016 {
    public static void main(String[] args) throws IOException {
        String pathFile = "file_1.txt";
        InputStreamReader fr = new InputStreamReader(new FileInputStream(pathFile), "UTF-8");
        BufferedReader reader = new BufferedReader(fr);
        
        ArrayList<String> names = new ArrayList<>();
        String line = null;
        boolean flow = true;
        while (flow) {
            line = reader.readLine();
            if (line!=null) {
                names.add(line);
            } else {
                flow = false;
            }
        }
        reader.close();
        System.out.println("\n"+names);
        Map<String, Integer> duplicateNames = createRepetitionList(names);
        printMap(duplicateNames);
    }


    public static Map<String, Integer> createRepetitionList(ArrayList<String> namesList) {
        Map <String, Integer> repetitionList = new HashMap<>();
        String str;
        for (int i = 0; i < namesList.size(); i++) {
            str = namesList.get(i);
            str = str.substring(0, str.indexOf(" "));
            if (repetitionList.containsKey(str)) {
                repetitionList.put(str, repetitionList.get(str)+1);
            } else {
                repetitionList.put(str, 1);
            }
        }
        return repetitionList;
    }


    public static void printMap(Map<String, Integer> names) {
        System.out.println();
        int val = 0;
        String key = null;
        int ind = 0;
        ArrayList<String> name = new ArrayList<>(names.keySet());
        ArrayList<Integer> values = new ArrayList<>(names.values());
        while (name.size()>0) {
            val = values.get(0);
            for (int i = 0; i < name.size(); i++) {
                if (values.get(i)>=val) {
                    val = values.get(i);
                    key = name.get(i);
                    ind = i;
                }
            }
            System.out.printf("%s = %d\n" , key, names.get(key));
            name.remove(ind);
            values.remove(ind);
        }
    }
}
