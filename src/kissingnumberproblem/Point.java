/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kissingnumberproblem;

/**
 *
 * @author Julian
 */
public class Point {

    private int dims;
    private double[] coordinate;

    public Point(int dimensions) {
        dims = dimensions;
        coordinate = new double[dims];
    }

    public double getCoordinate(int number) {
        return coordinate[number];
    }

    public int getDim() {
        return dims;
    }

    public void setCoordinate(int number, double value) {
        coordinate[number] = value;
    }

    public void setCoordinates(int[] values) {
        System.arraycopy(values, 0, coordinate, 0, values.length);
    }

    public double getAbs() {
        double sqrsum = 0;
        for (int i = 0; i < dims; i++) {
            sqrsum += coordinate[i] * coordinate[i];
        }
        return Math.sqrt(sqrsum);
    }

    public void multiply(double factor) {
        for (int i = 0; i < dims; i++) {
            coordinate[i] *= factor;
        }
    }

    public void echo() {
        System.out.print("P_" + dims + "(");
        for (int i = 0; i < dims; i++) {
            System.out.print(coordinate[i]);
            if (i < dims - 1) {
                System.out.print(",");
            }
        }
        System.out.print(")");
    }

    public static double distance(Point a, Point b) {
        if (a.getDim() == b.getDim()) {
            double sqrsum = 0;
            for (int i = 0; i < a.getDim(); i++) {
                sqrsum += Math.pow(a.getCoordinate(i) - b.getCoordinate(i), 2);
            }
            return Math.sqrt(sqrsum);
        } else {
            return -1;
        }
    }

    public static Point difference(Point a, Point b) {
        if (b.getDim() == b.getDim()) {
            Point c = new Point(b.getDim());
            for (int i = 0; i < a.getDim(); i++) {
                c.setCoordinate(i, a.getCoordinate(i) - b.getCoordinate(i));
            }
            return c;
        } else {
            return new Point(b.getDim());
        }
    }

    public static Point sum(Point a, Point b) {
        if (b.getDim() == b.getDim()) {
            Point c = new Point(b.getDim());
            for (int i = 0; i < a.getDim(); i++) {
                c.setCoordinate(i, a.getCoordinate(i) + b.getCoordinate(i));
            }
            return c;
        } else {
            return new Point(b.getDim());
        }
    }

    public static Point nullPoint(int dim) {
        Point a = new Point(dim);
        for (int j = 0; j < dim; j++) {
            a.setCoordinate(j, 0);
        }
        return a;
    }

    public static Point rndPoint(int dim) {
        Point a = new Point(dim);
        for (int j = 0; j < dim; j++) {
            a.setCoordinate(j, Math.random());
        }
        return a;
    }

    public static Point[] rndPoints(int dim, int points) {
        Point[] a = new Point[points];
        for (int i = 0; i < a.length; i++) {
            a[i] = rndPoint(dim);
        }
        return a;
    }
}
