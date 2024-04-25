package main.java.com.hd.pos.service;

import java.util.Date;

import main.java.com.hd.pos.exception.InvalidCheckoutException;
import main.java.com.hd.pos.model.RentalAgreement;
import main.java.com.hd.pos.model.Tool;
import main.java.com.hd.pos.model.ToolType;

public class Store {
   public RentalAgreement checkoutTool(String toolCode, int rentalDays, double discountPercent, Date checkoutDate) throws InvalidCheckoutException {
       // Validate input parameters
       if (rentalDays < 1) {
           throw new InvalidCheckoutException("Rental day count must be 1 or greater.");
       }
       if (discountPercent < 0 || discountPercent > 100) {
           throw new InvalidCheckoutException("Discount percent must be between 0 and 100.");
       }

       // Retrieve tool information based on tool code (you can implement this logic)

       // For demonstration purposes, create a dummy tool
       Tool tool = new Tool(ToolType.LADDER, "BrandX", 10.0, true, false);

       // Generate rental agreement
       return new RentalAgreement(tool, checkoutDate, rentalDays, discountPercent);
   }
}
