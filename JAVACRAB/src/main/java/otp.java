import java.util.Random;

public class otp {

    public static void main(String[] args) {
        otp otpGenerator = new otp();
        String otp = otpGenerator.gen_otp();
        System.out.println("Generated OTP: " + otp);
    }

    public String gen_otp() {
        Random rand = new Random();
        int otp = rand.nextInt(9999);
        if (otp < 1000) {
            otp += 1000;
        }
        return String.valueOf(otp);
    }
}