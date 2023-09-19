package org.abstractica.newtrainsystem;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public interface ClickerInterface {
    public Geometry3D getClicker(JavaCSG csg, double unit);

    public Geometry3D getHole(JavaCSG csg, double unit);
}
