package primitives;

public class Vector {
    Point3D head;
   public Vector (Point3D in) throws IllegalArgumentException
    {
        this.head.x = new Coordinate(in.x.get());
        this.head.y = new Coordinate(in.y.get());
        this.head.z = new Coordinate(in.z.get());
        if (head.equals (Point3D.ZERO)) throw new IllegalArgumentException ("all arguments are zero");
    }
    public Vector (Coordinate x, Coordinate y, Coordinate z) throws IllegalArgumentException
    {
        this.head.x = x;
        this.head.y = y;
        this.head.z = z;
        if (head.equals (Point3D.ZERO)) throw new IllegalArgumentException ("all arguments are zero");
    }
    public Vector (double x, double y, double z) throws IllegalArgumentException
    {
        this.head.x = new Coordinate(x);
        this.head.y = new Coordinate(y);
        this.head.z = new Coordinate(z);
        if (head.equals (Point3D.ZERO)) throw new IllegalArgumentException ("all arguments are zero");
    }
    public Vector (Vector other)
    {
        this.head.x = new Coordinate( other.head.getX());
        this.head.y = new Coordinate( other.head.getY());
        this.head.z = new Coordinate( other.head.getZ());
    }
    public Vector subtract(Vector other)
    {
        return new Vector(this.head.Subtract(other.head));
    }
    public Vector add (Vector other)
    {
        return new Vector(this.head.add(other));
    }
    public Vector scale (double scalar)
    {
        return new Vector(scalar*this.head.getX(),scalar*this.head.getY(),scalar*this.head.getZ());
    }
    public double dotProduct (Vector other)
    {
        return((this.head.getX()*other.head.getX())+(this.head.getY()*other.head.getY())+(this.head.getZ()*other.head.getZ()));
    }
    public  Vector crossProduct(Vector oth)
    {
        return new Vector((this.head.getY()*oth.head.getZ())-(this.head.getZ()*oth.head.getY())
                         ,(this.head.getZ()*oth.head.getX())-(this.head.getX()*oth.head.getZ())
                         ,(this.head.getX()*oth.head.getY())-(this.head.getY()*oth.head.getX()));
    }
    public Double lengthSquared(Vector vec)
    {
        double d = Math.sqrt((vec.head.getX()*vec.head.getX())+(vec.head.getY()*vec.head.getY())+(vec.head.getZ()*vec.head.getZ()));
        return d*d;
    }
    public double length(Vector vec)
    {
       double l = this.lengthSquared(vec);
       return Math.sqrt(l);
    }
    public Vector normalize()
    {
        double divider = length(this);
        this.head.x = new Coordinate(head.getX()/divider);
        this.head.y = new Coordinate(head.getY()/divider);
        this.head.z = new Coordinate(head.getZ()/divider);
        return this;
    }
    public Vector normalized()
    {
        Vector vec = new Vector(this);
        vec.normalize();
        return vec;
    }

    @Override
    public boolean equals (Object obj)
    {
        if (this== obj) return true;
        if (obj==null) return false;
        if (!(obj instanceof Vector)) return false;
        Vector other = (Vector) obj;
        return head.equals(other);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "head=" + head +
                '}';
    }
}
