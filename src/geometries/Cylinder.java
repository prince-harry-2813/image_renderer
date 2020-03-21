package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Cylinder extends Tube {
    double height;

    public Cylinder(double radius, Point3D point, Vector vec, double h) {
        super(radius, point, vec);
        this.height = h;
    }

    @Override
    public Vector getNormal(Point3D point) {
        return super.getNormal(point);
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", axisRay=" + axisRay +
                ", _radius=" + _radius +
                "} " + super.toString();
    }
}
