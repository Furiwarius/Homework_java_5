import java.util.HashMap;
import java.util.Map;

/*
 * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */

public class homework_015 {
    public static void main(String[] args) {
        Map <String, String> phoneBook = new HashMap<>();
        System.out.println(phoneBook);

        phoneBook.put("89062390323", "Василий");
        System.out.println(phoneBook);
    }
    
}
