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
            
            System.out.println("Задание 3: Отсортировать по году издания и вывести список книг.");
            
            List<Book> uniqueBooks = visitors.stream()
                    .flatMap(visitor -> visitor.getFavoriteBooks().stream()).distinct().collect(Collectors.toList());

            List<Book> sortedBooksByYear = uniqueBooks.stream()
                    .sorted((b1, b2) -> Integer.compare(b1.getPublishingYear(), b2.getPublishingYear())).collect(Collectors.toList());
            
            sortedBooksByYear.forEach(book -> {
                System.out.println("Год: " + book.getPublishingYear());
                System.out.println("Название: " + book.getName());
                System.out.println("Автор: " + book.getAuthor());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println(" ");
            });
            
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}