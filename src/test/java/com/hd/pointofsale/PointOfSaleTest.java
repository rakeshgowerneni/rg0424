package test.java.com.hd.pointofsale;

import java.util.Date;

import main.java.com.hd.pointofsale.service.Store;
import main.java.com.hd.pos.model.RentalAgreement;
import main.java.com.hd.pos.model.Tool;
import main.java.com.hd.pos.model.ToolType;

// Unit tests for the classes
class PointOfSaleTest {
                                             // Test checkoutTool method of Store class
                                             public void testCheckoutTool() {
                                                                                          Store store = new Store();
                                                                                          Tool tool = new Tool(ToolType.CHAINSAW, "BrandX", 10.0, true, false);
                                                                                          Date checkoutDate = new Date();
                                                                                          int rentalDays = 5;
                                                                                          double discount = 2.0;
                                                                                          RentalAgreement agreement = store.checkoutTool(tool, checkoutDate, rentalDays, discount);
                                                                                          // Assertions to verify the
                                                                                          // correctness of the
                                                                                          // generated RentalAgreement
                                                                                          assert agreement != null;
                                                                                          assert agreement.calculateTotalCharge() == 48.0;
                                             }

                                             // Test calculateTotalCharge method of RentalAgreement class
                                             public void testCalculateTotalCharge() {
                                                                                          Tool tool = new Tool(ToolType.LADDER, "BrandY", 15.0, false, true);
                                                                                          Date checkoutDate = new Date();
                                                                                          int rentalDays = 3;
                                                                                          double discount = 5.0;
                                                                                          RentalAgreement agreement = new RentalAgreement(tool, checkoutDate, rentalDays, discount);
                                                                                          // Assertions to verify the
                                                                                          // correctness of the
                                                                                          // calculated total charge
                                                                                          assert agreement.calculateTotalCharge() == 40.0;
                                             }
}