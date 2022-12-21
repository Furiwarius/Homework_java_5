import java.util.ArrayList;

/*
 * Реализовать алгоритм пирамидальной сортировки (HeapSort)
 */


public class homework_017 {
    public static void main(String[] args) {
        ArrayList<Integer> array = arrayGenerator();
        System.out.println("\nРандомный набор элементов");
        System.out.println(array);

        sort(array);
        System.out.println("\nОтсортированный набор элементов");
        System.out.println(array);
    }

    public static void sort(ArrayList<Integer> arr) {
        int n = arr.size();

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // Один за другим извлекаем элементы из кучи   
        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }


    public static void heapify(ArrayList<Integer> arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2

           // Если левый дочерний элемент больше корня
        if (l < n && arr.get(l) > arr.get(largest)){
            largest = l;
        }
          // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr.get(r) > arr.get(largest)){
            largest = r;
        }
       // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, swap);

          // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }


    public static ArrayList<Integer> arrayGenerator() {
        // генерация коллекции случайной длины со случайными значениями без повторений
        int amount = (int) (Math.random()*15)+5; // [5:20]
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        boolean flag = true;
        int value;
        
        for (int i = 0; i < amount; i++) {
            while (flag){
                value = (int) (Math.random()*50)+1; // [1:50]
                if (newArray.indexOf(value)==-1) {
                    newArray.add(value);
                    flag = false;
                }
            }
            flag = true;
        }
        return newArray;
    }
}
