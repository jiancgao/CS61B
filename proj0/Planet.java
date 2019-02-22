public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    private double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        double dist = this.calcDistance(p);
        return G * this.mass * p.mass / (dist * dist);
    }

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double r = calcDistance(p);
        double force = calcForceExertedBy(p);
        return force * dx / r;
    }

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        double r = calcDistance(p);
        double force = calcForceExertedBy(p);
        return force * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double sum = 0;
        for (Planet p : planets) {
            if (!this.equals(p)) {
                sum += calcForceExertedByX(p);
            }
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double sum = 0;
        for (Planet p : planets) {
            if (!this.equals(p)) {
                sum += calcForceExertedByY(p);
            }
        }
        return sum;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel += aX * dt;
        yyVel += aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
