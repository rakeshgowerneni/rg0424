package main.java.com.hd.pos;
import java.util.Date;

import main.java.com.hd.pos.model.RentalAgreement;
import main.java.com.hd.pos.service.Store;

public class App {
    public static void main(String[] args) {
        try {
            // Input parameters for checkout
            String toolCode = "LADW"; // Example tool code
            int rentalDays = 5;
            int discountPercent = 10; // 10% discount
            Date checkoutDate = new Date(); // Current date

            // Simulate checkout process
            Store store = new Store();
            RentalAgreement agreement = store.checkoutTool(toolCode, rentalDays, discountPercent, checkoutDate);

            // Display rental agreement details
            System.out.println("Rental Agreement:");
            System.out.println(agreement);
        } catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }
}
