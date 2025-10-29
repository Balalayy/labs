package maven;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class Visitors {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            String filePath = "C:\\javavs\\demo\\book.json";
            FileReader reader = new FileReader(filePath);
            Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
            List<Visitor> visitors = gson.fromJson(reader, visitorListType);
            
            System.out.println("Задание 2: Вывести список и количество книг, добавленных посетителями в избранное, без повторений");
            
            List<Book> uniqueBooks = visitors.stream()
                    .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                    .distinct()
                    .collect(Collectors.toList());

            uniqueBooks.forEach(book -> {
                System.out.println("Название: " + book.getName());
                System.out.println("Автор: " + book.getAuthor());
                System.out.println("Год публикации: " + book.getPublishingYear());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Издатель: " + book.getPublisher());
                System.out.println(" ");
            });
            
            System.out.println("Количество уникальных книг: " + uniqueBooks.size());
            
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}