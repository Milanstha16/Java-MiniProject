public class CustomerObserver implements Observer {
    @Override
    public void update(String status) {
        System.out.println("Customer: Order status updated to " + status);
    }
}