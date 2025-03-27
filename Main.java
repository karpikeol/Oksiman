public class Main {
    public static void main(String[] args) {
        ComputerStore store = new ComputerStore();

        Product p1 = new Product(1, "Laptop Dell XPS 13", "Laptop", 4999.99, 10);
        Product p2 = new Product(2, "Mouse Logitech MX Master 3", "Mouse", 349.99, 30);
        Product p3 = new Product(3, "Monitor Samsung 27\"", "Monitor", 1299.99, 15);

        store.addProduct(p1);
        store.addProduct(p2);
        store.addProduct(p3);

        Customer c1 = new Customer(1, "John", "Smith", "john.smith@example.com", true);
        Customer c2 = new Customer(2, "Anna", "Brown", "anna.brown@example.com", false);

        store.addCustomer(c1);
        store.addCustomer(c2);

        Product[] order1Prods = {p1, p2};
        int[] order1Qtys = {1, 1};
        Order order1 = store.createOrder(c1, order1Prods, order1Qtys);
        order1.applyDiscount();
        store.updateStockAfterOrder(order1);
        order1.displayDetails();

        store.changeOrderStatus(order1.getId(), "Completed");

        System.out.println("\nCustomer orders:");
        store.displayCustomerOrders(1);
    }
}
