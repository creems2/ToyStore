package service;

import model.Toy;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyStore {
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>((a, b) -> b.getWeight() - a.getWeight());
    private Random random = new Random();

    public void addToy(Toy toy) {
        toyQueue.add(toy);
    }

    public Toy getRandomToy() {
        if (toyQueue.isEmpty()) return null;

        int chance = random.nextInt(100); // Генерируем число от 0 до 99
        int cumulativeWeight = 0;

        for (Toy toy : toyQueue) {
            cumulativeWeight += toy.getWeight();
            if (chance < cumulativeWeight) {
                return toy;
            }
        }
        return null;
    }

    public void writeResultsToFile(String filename, int draws) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < draws; i++) {
                Toy toy = getRandomToy();
                if (toy != null) {
                    writer.write(toy.toString() + "\n");
                    System.out.println("Выдана игрушка: " + toy);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
