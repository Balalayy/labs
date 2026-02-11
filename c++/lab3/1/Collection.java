package lab3;
import java.util.*;
public class Collection {
    public static void main(String[] args) {

        // a) Создайте массив из N случайных чисел от 0 до 100.    
        Random random = new Random();
        int N = 5;
        Integer[] array = new Integer[N];
        for (int x = 0; x < N; x++) {array[x] = random.nextInt(100);}
        System.out.println("Массив: " + Arrays.toString(array));

        // b) На основе массива создайте список List.
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("Список: " + list);

        // c) Отсортируйте список по возрастанию.
        Collections.sort(list);
        System.out.println("Сортировка по возрастанию: " + list);

        // d) Отсортируйте список в обратном порядке.
        Collections.reverse(list);
        System.out.println("Обратная сортировка: " + list);

        // e) Перемешайте список.
        Collections.shuffle(list);
        System.out.println("Перемешанный список: " + list);

        // f) Выполните циклический сдвиг на 1 элемент.
        Collections.rotate(list, 1);
        System.out.println("Сдвиг: " + list);

        // g) Оставьте в списке только уникальные элементы.
        List<Integer> originalList = new ArrayList<>(list);
        Set<Integer> unique = new HashSet<>();
        Set<Integer> dupList = new HashSet<>();
        for (Integer num : list) {
            if (!unique.add(num)) {dupList.add(num);}
            list.removeAll(dupList);  
        }
        System.out.println("Уникальные элементы: " + list);
        list = new ArrayList<>(originalList);
        
        // h) Оставьте в списке только дублирующиеся элементы.
        Set<Integer> removeDup = new HashSet<>();
        for (Integer num : list) {
            if (Collections.frequency(list, num) == 1) {removeDup.add(num);} 
        }
        list.removeAll(removeDup);
        System.out.println("Дубликаты: " + list);
        list = new ArrayList<>(originalList);
        
       // i) Из списка получите массив. 
        Integer[] newArray = list.toArray(new Integer[0]);
        System.out.println("Новый массив: " + Arrays.toString(newArray));

       // j) Посчитайте количество вхождений каждого числа в массив и выведите на экран
        Set<Integer> freq = new HashSet<>();
        for (Integer num : newArray) {
            if (freq.add(num)) {int frequency = Collections.frequency(Arrays.asList(newArray), num);
            System.out.println(num + ": " + frequency + " штук");}
        }
            

    }
}
    
