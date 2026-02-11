package maven;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Library {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            String filePath = "C:\\javavs\\demo\\book.json";
            FileReader reader = new FileReader(filePath);
            Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
            List<Visitor> visitors = gson.fromJson(reader, visitorListType);
            
        
            System.out.println("Задание 1: Вывести список посетителей и их количество");
            visitors.stream().forEach(visitor -> {
                    System.out.println("Имя: " + visitor.getName());
                    System.out.println("Фамилия: " + visitor.getSurname());
                    System.out.println("Телефон: " + visitor.getPhone());
                    System.out.println("Подписка: " + (visitor.isSubscribed() ? "активна" : "неактивна"));
                    System.out.println("Количество любимых книг: " + visitor.getFavoriteBooks().size());
                    System.out.println(" ");
                    });            
            System.out.println("Общее количество посетителей: " + visitors.size());
            
        } catch (IOException e) {System.err.println("Ошибка: " + e.getMessage());}
    }
}