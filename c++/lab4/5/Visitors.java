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
            
            System.out.println("Задание 5: Вывести максимальное число добавленных в избранное книг.");
            
            int maxBooks = visitors.stream().mapToInt(v -> v.getFavoriteBooks().size()).max().orElse(0);
            System.out.println("Количество книг в избранном: " + maxBooks);
            
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}