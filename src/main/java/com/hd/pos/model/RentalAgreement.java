package main.java.com.hd.pos.model;

import java.util.Date;

// Class representing a rental agreement
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RentalAgreement {
    private Tool tool;
    private Date checkoutDate;
    private int rentalDays;
    private double discount;

    // Constructor
    public RentalAgreement(Tool tool, Date checkoutDate, int rentalDays, double discount) {
        this.tool = tool;
        this.checkoutDate = checkoutDate;
        this.rentalDays = rentalDays;
        this.discount = discount;
    }

    // Formatting the string
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        DecimalFormat currencyFormat = new DecimalFormat("$#,##0.00");
        DecimalFormat percentFormat = new DecimalFormat("##%");
        StringBuilder sb = new StringBuilder();
        sb.append("Tool code: ").append(tool.getType()).append("\n");
        sb.append("Tool type: ").append(tool.getType()).append("\n");
        sb.append("Tool brand: ").append(tool.getBrand()).append("\n");
        sb.append("Rental days: ").append(rentalDays).append("\n");
        sb.append("Check out date: ").append(dateFormat.format(checkoutDate)).append("\n");
        sb.append("Due date: ").append(dateFormat.format(calculateDueDate())).append("\n");
        sb.append("Daily rental charge: ").append(currencyFormat.format(tool.getDailyRentalFee())).append("\n");
        int chargeDays = calculateChargeDays();
        sb.append("Charge days: ").append(chargeDays).append("\n");
        double preDiscountCharge = chargeDays * tool.getDailyRentalFee();
        sb.append("Pre-discount charge: ").append(currencyFormat.format(preDiscountCharge)).append("\n");
        sb.append("Discount percent: ").append(percentFormat.format(discount / 100.0)).append("\n");
        double discountAmount = calculateDiscountAmount(preDiscountCharge);
        sb.append("Discount amount: ").append(currencyFormat.format(discountAmount)).append("\n");
        double finalCharge = preDiscountCharge - discountAmount;
        sb.append("Final charge: ").append(currencyFormat.format(finalCharge)).append("\n");
        return sb.toString();
    }

    // Calculate due date based on the rental days
    private Date calculateDueDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(checkoutDate);
        cal.add(Calendar.DAY_OF_MONTH, rentalDays);
        return cal.getTime();
    }

    // Calculate charge days by excluding holidays
    private int calculateChargeDays() {
        int chargeDays = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(checkoutDate);
        for (int i = 0; i < rentalDays; i++) {
            if (!isNoChargeDay(cal.getTime())) {
                chargeDays++;
            }
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        return chargeDays;
    }

    // excludes holidays - independence day and labor day
    private boolean isNoChargeDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return (month == Calendar.JULY && dayOfMonth == 4) || // Independence Day
               (month == Calendar.SEPTEMBER && cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && dayOfMonth <= 7); // Labor Day
    }

    // calculates the discount amount with pre discount charge
    private double calculateDiscountAmount(double preDiscountCharge) {
        return Math.round((preDiscountCharge * discount / 100.0) * 100.0) / 100.0;
    }
}
