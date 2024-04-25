package main.java.com.hd.pos.model;

// Class representing a tool
public class Tool {
   private ToolType type;
   private String brand;
   private double dailyRentalFee;
   private boolean weekendCharge;
   private boolean holidayCharge;

   public Tool(ToolType type, String brand, double dailyRentalFee, boolean weekendCharge, boolean holidayCharge) {
      this.type = type;
      this.brand = brand;
      this.dailyRentalFee = dailyRentalFee;
      this.weekendCharge = weekendCharge;
      this.holidayCharge = holidayCharge;
   }

   public ToolType getType() {
      return type;
   }

   public String getBrand() {
      return brand;
   }

   public double getDailyRentalFee() {
      return dailyRentalFee;
   }

   public boolean isWeekendCharge() {
      return weekendCharge;
   }

   public boolean isHolidayCharge() {
      return holidayCharge;
   }
}