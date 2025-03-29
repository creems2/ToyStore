import model.Toy;
import service.ToyStore;

public class Main {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();

        // Добавляем игрушки с разным весом выпадения
        store.addToy(new Toy(1, "Конструктор", 20));  // 20%
        store.addToy(new Toy(2, "Робот", 20));       // 20%
        store.addToy(new Toy(3, "Кукла", 60));       // 60%

        System.out.println("Розыгрыш игрушек:");
        store.writeResultsToFile("toys.txt", 10);  // 10 розыгрышей, запись в файл
    }
}
