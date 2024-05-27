import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        this.toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public boolean removeToy(Toy toy) {
        return toys.remove(toy);
    }

    public List<Toy> listToys() {
        return new ArrayList<>(toys);
    }

    public void saveState() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("state.csv"))) {
            for (Toy toy : toys) {
                writer.write(toy.getName() + "," + toy.getPrice());
                writer.newLine();
            }
        }
    }

    public void restoreState() throws IOException {
        toys.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("state.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                toys.add(new Toy(name, price));
            }
        }
    }

    @Override
    public String toString() {
        return "ToyStore{toys=" + toys + "}";
    }
}