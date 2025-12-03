public class ThreadExample {
    
    // Первый поток, подкласс Thread
    static class Even extends Thread {
        public void run() {         
                for (int i = 2; i <= 10; i += 2) {System.out.println("чётное: " + i);}
        }
    }
    
    public static void main(String[] args) {
        // Второй поток, Runnable
        Runnable odd = () -> {
                for (int i = 1; i <= 9; i += 2) {System.out.println("нечётное: " + i);}
        };
        
        // Экземпляры потоков
        Thread evenThread = new Even();   
        Thread oddRunnable = new Thread(odd);

        evenThread.start();  
        oddRunnable.start();   
        
    }
}