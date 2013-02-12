/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kissingnumberproblem;

/**
 *
 * @author Julian
 */
public class KissingNumberProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Point a = Point.rndPoint(3);
//        a.echo();
//        System.out.println(a.getAbs());
        echo(kissTest(3, 11));
    }

    public static Point[] kissTest(int dim, int points) {
        Point[] p = Point.rndPoints(dim, points);
        boolean schnitt = true;
        int step = 0;
        while (schnitt) {
            schnitt = false;
            Point[] changes = new Point[points];
            for (int i = 0; i < changes.length; i++) {
                changes[i] = Point.nullPoint(dim);
            }
            // Sammeln der Differenzen
            for (int i = 0; i < points; i++) {
                for (int j = i + 1; j < points; j++) {
                    Point diff = Point.difference(p[i], p[j]);
                    double dist = diff.getAbs();
                    // Im schnittfall Änderung festlegen
                    if (dist < 2) {
                        System.out.println("Touch of spheres " + i + " and " + j + " , distance " + dist);
                        diff.multiply((2 - dist) / 3);
                        changes[i] = Point.sum(changes[i], diff);
                        diff.multiply(-1);
                        changes[j] = Point.sum(changes[j], diff);
                        schnitt = true;
                    }
                }
            }
            System.out.println("Solution of step " + step);
            echo(p);
            System.out.println("Change of step " + step);
            echo(changes);
            // Anwenden der Differenzen
            for (int i = 0; i < points; i++) {
                p[i] = Point.sum(p[i], changes[i]);
            }
            // Punkte normalisieren
            for (int i = 0; i < points; i++) {
                if (p[i].getAbs() != 2) {
                    p[i].multiply(2 / p[i].getAbs());
                }
            }
            step++;
        }
        return p;
    }

    public static void echo(Point[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i].echo();
            System.out.print(" || = " + a[i].getAbs());
            System.out.println();
        }
    }
}
