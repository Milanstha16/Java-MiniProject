public class UserFactory {
    public static User getUser(String role) {
        return switch (role) {
            case "Customer" -> new Customer();
            case "Restaurant" -> new Restaurant();
            case "Admin" -> new Admin();
            default -> throw new IllegalArgumentException("Unknown role");
        };
    }
}