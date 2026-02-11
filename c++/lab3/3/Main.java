import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
            new Human("Ваня", "Пирожков", 5),
            new Human("Саня", "Кокосиков", 8),
            new Human("Федя", "Бананчиков", 9),
            new Human("Григорий", "Просто Григорий", 999)
        );
        
        /* a) В main-методе создайте список объектов класса Human. 
        Затем создайте объект HashSet и положите в него содержимое списка.
        Выведите получившийся сет на экран. */
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet: " + hashSet);
        
        // b) Тот же список положите в коллекцию LinkedHashSet. Выведите содержимое.
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        
        // c) Тот же список положите в коллекцию TreeSet. Выведите содержимое.
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet: " + treeSet);
        
        /* d) Создайте пустую коллекцию TreeSet с ранее созданным компаратором. 
        Список объектов Human положите в этот сет. Выведите содержимое. */
        Set<Human> treeSetComparator = new TreeSet<>(new HumanComparatorByLastName());
        treeSetComparator.addAll(humans);
        System.out.println("TreeSet с компаратором: " + treeSetComparator);
        
        /* e) Создайте пустую коллекцию TreeSet с анонимным компаратором по возрасту. 
        Список объектов Human положите в тот сет. Выведите содержимое. */
        Set<Human> treeSetAgeComparator = new TreeSet<>(new Comparator<Human>() {
            public int compare(Human h1, Human h2) {return Integer.compare(h1.getAge(), h2.getAge());}
        });
        treeSetAgeComparator.addAll(humans);
        System.out.println("TreeSet с компаратором по возрасту: " + treeSetAgeComparator);
        
        /* f)
         HashSet: не сохраняет порядок вставки
         LinkedHashSet: сохраняет порядок вставки
         TreeSet: сортирует по компаратору
         */
    }
}