public class Fraction {
    private int numerator;
    private int denominator;
    
    // constructor
    public Fraction(int top, int bottom) {
        numerator = top;
        denominator = bottom;
    }

    // setters and getters
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public void setNumerator(int top) {
        numerator = top;
    }
    public void setDenominator(int bottom) {
        denominator = bottom;
    }

    // simplifying the fraction
    public String simplify(int top, int bottom) {
        String newFraction = "";
        
        // easy stuff that doesnt need to be calculated
        if (top == 0) return "0";
        else if (bottom == 0) return "Can't divide by 0";
        else if (top % bottom == 0) return top/bottom + "";
        
        // the smallest number might be the denominator and smallest has to be positive because of the for loop
        int smallest;
        if (Math.abs(top) < Math.abs(bottom)) smallest = Math.abs(top);
        else smallest = Math.abs(bottom);
        
        for (int i = smallest; i > 0; i--) {
            if (top % i == 0 && bottom % i == 0) {
                // checking if the number is a GCF (larget number that the top and bottom can be divided by), then dividing the top/bottom by the GCF
                top /= i;
                bottom /= i;
                break;
            }
            else continue;
        }
        // ex: (4/-5)  ->  (-4/5)   so it looks incer
        if (bottom < 0) {
            bottom = -bottom;
            top = -top;
        }

        newFraction = top + "/" + bottom;
        return newFraction;
    }

    public String multiply(int top, int bottom) {
        return simplify((numerator * top), (denominator * bottom));
    }
    public String divide(int top, int bottom) {
        return simplify((numerator * bottom), (denominator * top));
    }
    public String add(int top, int bottom) {
        if (denominator != bottom) {
            /*  1     1                   2     4
               --- + ---   will become   --- + ---
                4     2                   8     8        */
            int newNume = numerator * bottom;
            int newDenom = denominator * bottom;
            int newTop = top * denominator;
            return simplify(newNume + newTop, newDenom);
        }
        else return simplify(numerator + top, denominator);
    }
    public String subtract(int top, int bottom) {
        if (denominator != bottom) {
            /*  1     1                   2     4
               --- - ---   will become   --- - ---
                4     2                   8     8        */
            int newNume = numerator * bottom;
            int newDenom = denominator * bottom;
            int newTop = top * denominator;
            return simplify(newNume - newTop, newDenom);
        }
        else return simplify(numerator-top, denominator);   
    }
    public String compare(int top, int bottom) {
        double frac1 = (double) numerator/denominator;
        double frac2 = (double) top/bottom;
        if (frac1 == frac2) return "Both fractions are equal to each other";
        else if (frac1 > frac2) return numerator + "/" + denominator + " is larger than " + top + "/" + bottom;
        else return top + "/" + bottom  + " is larger than " + numerator + "/" + denominator;
    }

    public String toString() {
        return simplify(numerator, denominator);
    }
}