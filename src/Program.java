import java.util.Scanner;
/**
 * Created by huynq on 7/4/17.
 */
//&&and,||or
public class Program {

    public static double inputDouble() {
        Scanner in = new Scanner(System.in);
        return Double.parseDouble(in.nextLine());
    }

    public static double[] equation2(double a, double b, double c) {
        double[] result = new double[2];
//        double a1=inputDouble();
//        double b1=inputDouble();
//        double c1=inputDouble();

        if (a == 0) {
            if (b == 0) {
                result = null;
            } else {
                result[0] = -c / b;
                result[1] = -c / b;
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                result = null;
            } else {
                result[0] = (-b + Math.sqrt(delta)) / 2 / a;
                result[1] = (-b + Math.sqrt(delta)) / 2 / a;

            }
        }
        System.out.println(result[0]);
        return result;

    }


    //    public static double inputDouble() {
//        Scanner in=new Scanner(System.in);
//        return Double.parseDouble(in.nextLine());
//    }
    public static void main(String[] args) {

//        double a=inputDouble();
//        System.out.println(a);
//        double x=Math.sqrt(2);
//        double y=Math.pow(3,3);
        double a1 = inputDouble();
        double b1 = inputDouble();
        double c1 = inputDouble();
        double[] result=equation2(a1, b1, c1);
        if(result==null){
            System.out.println("Can not resolve equation!");
        }else {
            System.out.println("x1:"+result[0]+"x2:"+result[1]);
        }
    }
}


