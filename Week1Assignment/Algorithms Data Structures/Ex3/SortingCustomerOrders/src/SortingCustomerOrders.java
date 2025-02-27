// Order Class
class Order {
    private String orderId;
    private String customerName;
    private double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
    }
}

// Sorting Algorithms
class Sorting {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

// Main Class
public class SortingCustomerOrders {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O001", "Alice", 250.0),
            new Order("O002", "Bob", 125.5),
            new Order("O003", "Charlie", 325.75),
            new Order("O004", "David", 50.0),
            new Order("O005", "Eve", 400.0)
        };

        // Bubble Sort
        Sorting.bubbleSort(orders);
        System.out.println("Bubble Sort Result:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Reinitialize the array for Quick Sort
        orders = new Order[]{
            new Order("O001", "Alice", 250.0),
            new Order("O002", "Bob", 125.5),
            new Order("O003", "Charlie", 325.75),
            new Order("O004", "David", 50.0),
            new Order("O005", "Eve", 400.0)
        };

        // Quick Sort
        Sorting.quickSort(orders, 0, orders.length - 1);
        System.out.println("Quick Sort Result:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
