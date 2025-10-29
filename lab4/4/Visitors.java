package maven;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Visitors {
    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            String filePath = "C:\\javavs\\demo\\book.json";
            FileReader reader = new FileReader(filePath);
            Type visitorListType = new TypeToken<List<Visitor>>(){}.getType();
            List<Visitor> visitors = gson.fromJson(reader, visitorListType);
            
            System.out.println("Задание 4: Проверить, есть ли у кого-то в избранном книга автора Jane Austen.");
            
            boolean found = visitors.stream().flatMap(v -> v.getFavoriteBooks().stream())
                .anyMatch(b -> "Jane Austen".equalsIgnoreCase(b.getAuthor()));           
            System.out.println("Есть ли у кого-то книги Jane Austen в избранном: " + 
                    (found ? "Да" : "Нет"));

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}