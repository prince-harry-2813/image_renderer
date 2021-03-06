package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Plane extends Geometry {

    Point3D p;
    Vector normal;

    public Plane(Color emission, Material material, Point3D point, Vector vec) {
        super(emission, material);

        p = new Point3D(point);
        normal = new Vector(vec.normalize());

    }

    /**
     * ctor of plane by point and vector
     *
     * @param point Point3D
     * @param vec   Vector of plane
     */
    public Plane(Point3D point, Vector vec) {
        super();//define emission and material to default values

        p = new Point3D(point);
        normal = new Vector(vec.normalize());

    }

    /**
     * ctor of plane by point and vector
     *
     * @param point    Point3D
     * @param vec      Vector of plane
     * @param emission color of plane
     */
    public Plane(Color emission, Point3D point, Vector vec) {
        super(emission);//define emission to params. and material to default

        p = new Point3D(point);
        normal = new Vector(vec.normalize());

    }

    /**
     * ctor of plane by three points, calculate the plane normal
     *
     * @param a Point3D A
     * @param b Point3D B
     * @param c Point3D C
     */
    public Plane(Point3D a, Point3D b, Point3D c) {
        super();//define emission and material to default values
        p = new Point3D(a);
        Vector v1 = b.subtract(p);
        Vector v2 = c.subtract(p);
        normal = (v1.crossProduct(v2).normalize());
    }

    /**
     * ctor of plane by three points, calculate the plane normal
     *
     * @param emission color
     * @param a        Point3D A
     * @param b        Point3D B
     * @param c        Point3D C
     */
    public Plane(Color emission, Point3D a, Point3D b, Point3D c) {
        super(emission);//define emission default color
        p = new Point3D(a);
        Vector v1 = b.subtract(p);
        Vector v2 = c.subtract(p);
        normal = (v1.crossProduct(v2).normalize());
    }

    public Plane(Color emission, Material material, Point3D a, Point3D b, Point3D c) {
        super(emission, material);//define emission default color
        p = new Point3D(a);
        Vector v1 = b.subtract(p);
        Vector v2 = c.subtract(p);
        normal = (v1.crossProduct(v2).normalize());
    }

    /**
     * @return Normal
     */
    public Vector getNormal() {
        return normal;
    }

    /**
     * @param point to extract out normal vector
     * @return Normal
     */
    @Override
    public Vector getNormal(Point3D point) {
        return normal;
    }

    /**
     * @param ray A ray that light on an the plane
     * @return list of intersection points
     */
    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        Vector p_0;
        try {
            p_0 = p.subtract(ray.getP0());
        } catch (IllegalArgumentException e) {
            return null;
        }

        double nv = alignZero(getNormal().dotProduct(ray.getDir()));
        if (isZero(nv))
            return null;
        double t = alignZero((getNormal().dotProduct(p.subtract(ray.getP0()))) / (nv));

        if (t <= 0)
            return null;
        return List.of(new GeoPoint(this, ray.getPointOnRay(t)));
    }
}
