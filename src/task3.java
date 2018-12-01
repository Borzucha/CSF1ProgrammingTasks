import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x,y;
        System.out.print("X = ");
        x= scan.nextDouble();
        System.out.print("Y = ");
        y= scan.nextDouble();
        System.out.println("(-1.25,3.5) ->"+getColor(-1.25,3.5));
        System.out.println("(-2,-2) ->"+getColor(-2,-2));
        System.out.println("(2,2) ->"+getColor(2,2));
        System.out.println("(1,-6) ->"+getColor(1,-6));
        System.out.println("(6,2) ->"+getColor(6,2));
        System.out.println("(-4,5) ->"+getColor(-4,5));
        System.out.println(getColor(x,y));
    }
      public static boolean isPointAboveParabola(double x, double y, double a , double y0, double x0) {
        return y >=  a * Math.pow(x - x0,2) + y0; //  выше параболы
    }
      public static boolean isPointAboveLine(double x, double y , double a , double y0, double x0) {
        return y >= a * (x - x0) + y0; // выше линии
    }
      public static boolean isPointInRectangle(double x , double y, double x0, double y0, double h, double w ){
        return x >= x0 && x <= x0 + w && y <= y0 && y >= y0 - h; // в прямоугольнике
    }
    public static boolean isPointUnderTheLineThatContainsUpperEdgeOfRectangle( double y, double y0) {
        return y <= y0; // верхняя прямая прямоугольника
    }
    public static Color getColor(double x, double y) {
        if (isPointAboveLine(x, y, -2, 0, 0) && isPointAboveParabola(x, y, 0.25, -5, 0) && !isPointInRectangle(x, y, -6, 4, 6, 5))
            return Color.YELLOW;
        else if (isPointAboveLine(x, y, -2, 0, 0) && !isPointAboveParabola(x, y, 0.25, -5, 0)
                || (!isPointAboveLine(x, y, -2, 0, 0) && isPointAboveParabola(x, y, 0.25, -5, 0)
                && isPointUnderTheLineThatContainsUpperEdgeOfRectangle( y, 4)))
            return Color.GREY;
        else if (isPointAboveLine(x, y, -2, 0, 0) && isPointInRectangle(x, y, -6, 4, 6, 5))
            return Color.ORANGE;
        else
            return Color.BLUE;
    }
    enum Color {
        YELLOW,
        ORANGE,
        GREY,
        BLUE
    }
}
