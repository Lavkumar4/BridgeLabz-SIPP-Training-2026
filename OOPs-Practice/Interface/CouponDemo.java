// Interface
interface CouponValidator {

    // Abstract method
    boolean validateCoupon(String code);

    // Static method
    static boolean isLengthValid(String code) {
        return code.length() >= 5 && code.length() <= 10;
    }
}

// Implementing class
class ShoppingCart implements CouponValidator {

    @Override
    public boolean validateCoupon(String code) {

        // Coupon must start with "SAVE"
        if (CouponValidator.isLengthValid(code) && code.startsWith("SAVE")) {
            return true;
        }
        return false;
    }
}

// Main class
public class CouponDemo {
    public static void main(String[] args) {

        String[] coupons = {
                "SAVE10",
                "SAVE50",
                "DISCOUNT",
                "ABC",
                "SAVE1000"
        };

        ShoppingCart cart = new ShoppingCart();

        for (String coupon : coupons) {
            if (cart.validateCoupon(coupon)) {
                System.out.println(coupon + " -> Valid Coupon");
            } else {
                System.out.println(coupon + " -> Invalid Coupon");
            }
        }
    }
}