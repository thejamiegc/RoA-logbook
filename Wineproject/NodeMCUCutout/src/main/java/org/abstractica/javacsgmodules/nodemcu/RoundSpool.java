package org.abstractica.javacsgmodules.nodemcu;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class RoundSpool {


    public Geometry3D getCutout(JavaCSG csg, int diameter, int height, int resolution, boolean centerZ) {
//
        Geometry3D base = csg.cylinder3D(diameter, height, 128, centerZ);

        return base;
    }
}