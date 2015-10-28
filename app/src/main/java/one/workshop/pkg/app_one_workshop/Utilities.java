package one.workshop.pkg.app_one_workshop;

/**
 * Created by Abhinav Tripathi on 25-Oct-15.
 */
public class Utilities {

    private static String numOne;
    public static void setNumOne(String nOne)
    {
        numOne = nOne;
    }
    public static String getNumOne()
    {
        return numOne;
    }

    public static double calcExp(double num, long upto)
    {
        double xpow = 1;
        double fact = 1;
        double result = 1;
        for(long i=1; i<upto;++i)
        {
            xpow *= num;
            fact *= i;
            result += xpow/fact;
        }
        return result;
    }
}
