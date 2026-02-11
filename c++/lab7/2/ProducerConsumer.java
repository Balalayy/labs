import java.util.*;

class Order {
    int id;           
    String type;      
    int quantity;     
    
    Order(int id, String type, int quantity) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
    }
    
    public String toString() {
        return "Заказ №" + id + " - " + type + " (" + quantity + " шт)";
    }
}

// Склад
class ShoeWarehouse {
    public static String[] shoeTypes = {
        "Кроссовки", "Туфли", "Ботинки", "Сапоги", "Сандалии"
    };
    
    // Заказы на складе
    private List<Order> orders = new ArrayList<>();
    private int maxSize = 5;
    
    // Добавление заказа
    public synchronized void receiveOrder(Order order) {
        while (orders.size() >= maxSize) {
            try {
                System.out.println("Склад полон");
                wait(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        orders.add(order);
        System.out.println("Добавлено: " + order + ". Всего: " + orders.size());
        notifyAll();
    }
    
    // Взятие (Бастилии😋) заказа 
    public synchronized Order fulfillOrder() {
        while (orders.isEmpty()) {
            try {
                System.out.println("Склад пуст");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        Order order = orders.remove(0);
        System.out.println("Взяли: " + order + ". Осталось: " + orders.size());
        notifyAll();
        
        return order;
    }
}

// Производитель
class Producer implements Runnable {
    ShoeWarehouse warehouse;
    int countOrders;
    
    Producer(ShoeWarehouse warehouse, int countOrders) {
        this.warehouse = warehouse;
        this.countOrders = countOrders;
    }
    
    public void run() {
        Random rand = new Random();
        
        for (int i = 1; i <= countOrders; i++) {
            String randomType = ShoeWarehouse.shoeTypes[rand.nextInt(ShoeWarehouse.shoeTypes.length)];
            int randomQuantity = rand.nextInt(4) + 1;
            
            Order order = new Order(i, randomType, randomQuantity);
            warehouse.receiveOrder(order);
            
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// Покупатель
class Consumer implements Runnable {
    ShoeWarehouse warehouse;
    String name;
    
    Consumer(ShoeWarehouse warehouse, String name) {
        this.warehouse = warehouse;
        this.name = name;
    }
    
    public void run() {
        System.out.println("Пришёл " + name);

        for (int i = 0; i < 5; i++) {
            Order order = warehouse.fulfillOrder();
            System.out.println(name + " забирает: " + order);
            
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ушёл " + name);
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        ShoeWarehouse warehouse = new ShoeWarehouse();
        int totalOrders = 25;
        
        Thread producer = new Thread(new Producer(warehouse, totalOrders));
        producer.start();
        
        int consumerCount = totalOrders / 5;
        Thread[] consumers = new Thread[consumerCount];
        
        for (int i = 0; i < consumerCount; i++) {
            consumers[i] = new Thread(new Consumer(warehouse, "Покупатель-" + (i+1)));
            consumers[i].start();
            
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        try {
            producer.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (Thread consumer : consumers) {
            try {
                consumer.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }       
        System.out.println("Заказы кончились");
    }
}