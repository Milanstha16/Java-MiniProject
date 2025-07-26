public class Main {
    public static void main(String[] args) {

        DatabaseManager db = DatabaseManager.getInstance();
        db.connect();


        User user1 = UserFactory.getUser("Customer");
        user1.showRole();

        User user2 = UserFactory.getUser("Admin");
        user2.showRole();


        OrderStatus order = new OrderStatus();
        order.attach(new CustomerObserver());
        order.attach(new DeliveryObserver());

        order.setStatus("Out for delivery");
        order.setStatus("Delivered");
    }
}