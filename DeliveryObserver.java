public class DeliveryObserver implements Observer {
    @Override
    public void update(String status) {
        System.out.println("Delivery: Order status updated to " + status);
    }
}