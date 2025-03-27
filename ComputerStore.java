public class ComputerStore {
    private Product[] products = new Product[100];
    private Customer[] customers = new Customer[100];
    private Order[] orders = new Order[100];
    private int productCount = 0, customerCount = 0, orderCount = 0;

    public void addProduct(Product product) {
        products[productCount++] = product;
    }

    public void addCustomer(Customer customer) {
        customers[customerCount++] = customer;
    }

    public Order createOrder(Customer customer, Product[] orderProducts, int[] orderQuantities) {
        Order order = new Order(orderCount + 1, customer, orderProducts, orderQuantities, "2025-03-28", "New");
        orders[orderCount++] = order;
        return order;
    }

    public void updateStockAfterOrder(Order order) {
        Product[] prods = order.getProducts();
        int[] qty = order.getQuantities();
        for (int i = 0; i < prods.length; i++) {
            prods[i].setStockQuantity(prods[i].getStockQuantity() - qty[i]);
        }
    }

    public void changeOrderStatus(int orderId, String newStatus) {
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getId() == orderId) {
                orders[i].setStatus(newStatus);
                break;
            }
        }
    }

    public void displayProductsInCategory(String category) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getCategory().equalsIgnoreCase(category)) {
                products[i].displayInfo();
            }
        }
    }

    public void displayCustomerOrders(int customerId) {
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getCustomer().getId() == customerId) {
                orders[i].displayDetails();
            }
        }
    }
}
