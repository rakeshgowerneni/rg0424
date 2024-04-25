# Point of Sale System

This is a Java application for a point of sale system designed for stores renting out big tools, similar to Home Depot. The system allows customers to rent tools for a specified number of days, generates rental agreements, and calculates charges based on the type of tool, rental duration, and any discounts applied.

## Usage

To use the Point of Sale system, follow these steps:

1. **Checkout Process**: 
    - Provide the following information:
        - Tool code (e.g., LADW, CHNS, JAKD)
        - Rental day count (number of days for rental)
        - Discount percent (0-100)
        - Check out date (current date or specified date)
    - The system will generate a rental agreement with the calculated charges.

2. **Display Rental Agreement**:
    - The system will display the rental agreement details including:
        - Tool code
        - Tool type
        - Tool brand
        - Rental days
        - Check out date
        - Due date
        - Daily rental charge
        - Charge days
        - Pre-discount charge
        - Discount percent
        - Discount amount
        - Final charge

## Sample Inputs and Outputs

### Input:
- Tool code: LADW
- Rental day count: 5
- Discount percent: 10
- Check out date: April 25, 2024

### Output:
- Rental Agreement:
- Tool code: LADW
- Tool type: Ladder
- Tool brand: BrandX
- Rental days: 5
- Check out date: 04/25/24
- Due date: 04/30/24
- Daily rental charge: $10.00
- Charge days: 5
- Pre-discount charge: $50.00
- Discount percent: 10%
- Discount amount: $5.00
- Final charge: $45.00