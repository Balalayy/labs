import java.util.Iterator;
import java.util.ArrayList;

public class PrimesGenerator implements Iterator<Long> {
    int numbersNeed; //сколько чисел нужно
    int numbersGenerated; //сколько сгенерировано
    int numberCorrect; //число на проверку

    public PrimesGenerator(int numbersNeed) {
        this.numbersNeed = numbersNeed;
        this.numbersGenerated = 0;
        this.numberCorrect = 2;
    }

    public boolean hasNext() {
        return numbersGenerated < numbersNeed;
    }
    
    public boolean isPrime (int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int m = 3; m*m <= n; m += 2) {if (n % m == 0) {return false;}}
        return true;
    }

    public Long next() {
        while (!isPrime(numberCorrect)) {
            numberCorrect++;
        }
        long prime = numberCorrect;
        numberCorrect++;
        numbersGenerated++;
        return prime;
    }
}

class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 5;
        PrimesGenerator generator = new PrimesGenerator(N);
        ArrayList<Long> primes = new ArrayList<>();

        System.out.println(N + " простых чисел в прямом порядке: ");
        while (generator.hasNext()) {primes.add(generator.next());}
        for (Long prime : primes) System.out.print(prime + " ");

        System.out.println("\n\n" + N + " простых чисел в обратном порядке: ");
        for (int b = primes.size() - 1; b >= 0; b--) System.out.print(primes.get(b) + " ");
    }
}

