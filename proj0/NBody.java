public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int num = in.readInt();
        in.readDouble();
        int index = 0;
        Planet[] planets = new Planet[num];
        while (!in.isEmpty() && index < num) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String imgFileName = in.readString();
            planets[index] = new Planet(xP, yP, xV, yV, m, imgFileName);
            index += 1;
        }
        return planets;
    }

    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        int num = planets.length;
        double[] xForces = new double[num];
        double[] yForces = new double[num];
        for (int t = 0; t < T; t += dt) {
            for (int i = 0; i < num; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < num; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.clear();
            StdDraw.setScale(-radius, radius);
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
