package org.abstractica.newtrainsystem;

import org.abstractica.javacsg.Geometry2D;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.Vector2D;

import java.util.ArrayList;
import java.util.List;

public abstract class AClicker implements ClickerInterface {

    @Override
    public Geometry3D getClicker(JavaCSG csg, double unit) {
        double delta = 0.1;
        List<Vector2D> vertices = new ArrayList<>();
        vertices.add(csg.vector2D(0, 0));
        vertices.add(csg.vector2D(4*unit-delta, 0));
        vertices.add(csg.vector2D(4*unit-delta, 1*unit));
        vertices.add(csg.vector2D(3*unit-delta, 2*unit));
        vertices.add(csg.vector2D(3*unit-delta, (8-0.3)*unit)); //Tighten the grip
        vertices.add(csg.vector2D(4*unit-delta, (9-0.3)*unit)); //Tighten the grip
        vertices.add(csg.vector2D(3*unit-delta, 10*unit));
        vertices.add(csg.vector2D((1-0.2)*unit, 10*unit));
        vertices.add(csg.vector2D((1-0.2)*unit, 2*unit));
        vertices.add(csg.vector2D(0, 2*unit));
        Geometry2D half = csg.polygon2D(vertices);
        Geometry2D full = csg.union2D(half, csg.mirror2D(1,0).transform(half));
        Geometry3D full3D = csg.linearExtrude(4*unit, false, full);
        return full3D;
    }

    @Override
    public Geometry3D getHole(JavaCSG csg, double unit) {
        double delta = 0.1;
        List<Vector2D> vertices = new ArrayList<>();
        vertices.add(csg.vector2D(0, 0));
        vertices.add(csg.vector2D(4*unit+delta, 0));
        vertices.add(csg.vector2D(4*unit+delta, 1*unit));
        vertices.add(csg.vector2D(3*unit+delta, 2*unit));
        vertices.add(csg.vector2D(3*unit+delta, 3*unit));
        vertices.add(csg.vector2D(4*unit+delta, 4*unit));
        vertices.add(csg.vector2D(4*unit+delta, 5*unit));
        vertices.add(csg.vector2D(0, 5*unit));
        Geometry2D half = csg.polygon2D(vertices);
        Geometry2D full = csg.union2D(half, csg.mirror2D(1,0).transform(half));
        Geometry3D full3D = csg.linearExtrude(4*unit+2*delta, true, full);
        full3D = csg.rotate3DX(csg.degrees(90)).transform(full3D);
        return full3D;
    }
}
