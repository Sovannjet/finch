public class Svjt {
    private static Finch f;

    public static void main(String[] args) {
        f = new Finch();
        regularPolygon(5, 5);
        parabola(0,5);

        // f.disconnect();
    }

    public static void regularPolygon(int n, double sideLength) {
        for (int i = 0; i < n; i++) {
            f.setMove("F", sideLength, 50);
            f.setTurn("L", 360 / n, 50);
        }
    }

    public static void parabola(double domainL, double domainR) {
        for (double i = domainL*10; i <= domainR*10; i++) {
            double x0 = (i-1)/10;
            double x = i/10; // x-intervals of 0.1
            double x2 = (i+1)/10;
            double y0 = sq(x0);
            double y = sq(x);
            double y2 = sq(x2);

            double dist = Math.sqrt(sq(x2-x) + sq(y2-y));
            double angle = Math.atan((y2-y)/0.1) - Math.atan((y-y0)/0.1); // current angle - previous angle
            angle *= 180/Math.PI; // convert from radians to degrees

            System.out.println(x + " " + x2 + " " + y + " " + y2 + " " + dist + " " + angle);

            f.setMove("F", dist, 25);
            f.setTurn("L", angle, 25); // turn left for +x^2, right for -x^2
        }
    }

    private static double sq(double x) {
        return x*x;
    }
}
