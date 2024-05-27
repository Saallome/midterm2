import java.io.IOException;

public class StoreTester {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();

        Toy toy1 = new Toy("Action Figure", 19.99);
        Toy toy2 = new Toy("Doll", 15.99);
        Toy toy3 = new Toy("Puzzle", 12.99);

        store.addToy(toy1);
        store.addToy(toy2);
        store.addToy(toy3);

        System.out.println("Toys in store: " + store.listToys());

        try {
            store.saveState();
            System.out.println("State saved.");
        } catch (IOException e) {
            System.err.println("Error saving state: " + e.getMessage());
        }

        store.removeToy(toy2);
        System.out.println("Toys in store after removing Doll: " + store.listToys());

        try {
            store.restoreState();
            System.out.println("State restored.");
        } catch (IOException e) {
            System.err.println("Error restoring state: " + e.getMessage());
        }

        System.out.println("Toys in store after restoring state: " + store.listToys());
    }
}