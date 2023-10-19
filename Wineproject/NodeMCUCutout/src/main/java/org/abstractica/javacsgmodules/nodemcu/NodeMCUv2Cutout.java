package org.abstractica.javacsgmodules.nodemcu;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;

public class NodeMCUv2Cutout {

    private double x = 26.2;
    private double y = 48.6;
    private double z = 6.0;

    private double holeSize = 2.6;
    private double holeXDistance = 21.0;

    private double holeYDistance = 43.4;
    private double pinlength = 38.4;
    private double pinwidth = 3.0;
    private double pinheight = 10.0;
    private double pinXDist = 22.6;

    private double USBWidth = 12.0;
    private double USBLength = 20;
    private double USBHeight = 6.0;

    public Geometry3D getCutout(JavaCSG csg) {
//        Geometry3D box1 = csg.box3D(51.5, 27.5, 13.5, true);
//        Geometry3D box2 = csg.box3D(50, 26, 12, false);
//        return csg.difference3D(box1,box2);
        Geometry3D base = csg.box3D(x, y, z, false);
        Geometry3D hole = csg.cylinder3D(holeSize, z + 2, 32, false);
        hole = csg.translate3DZ(-1).transform(hole);
        Geometry3D hole1 = csg.translate3D(0.5 * holeXDistance, 0.5 * holeYDistance, 0).transform(hole);
        Geometry3D hole2 = csg.translate3D(-0.5 * holeXDistance, 0.5 * holeYDistance, 0).transform(hole);
        Geometry3D hole3 = csg.translate3D(0.5 * holeXDistance, -0.5 * holeYDistance, 0).transform(hole);
        Geometry3D hole4 = csg.translate3D(-0.5 * holeXDistance, -0.5 * holeYDistance, 0).transform(hole);
        base = csg.difference3D(base, hole1, hole2, hole3, hole4);


        Geometry3D pin = csg.box3D(pinwidth, pinlength, pinheight+1, false);
        pin = csg.translate3DZ( -pinheight).transform(pin);
        Geometry3D pin1 = csg.translate3DX(-0.5 * pinXDist).transform(pin);
        Geometry3D pin2 = csg.translate3DX(0.5 * pinXDist).transform(pin);
        base = csg.union3D(base, pin1, pin2);

        Geometry3D usb = csg.box3D(USBWidth, USBLength, USBHeight, false);
        usb = csg.translate3DZ(0.5* (z-USBHeight)).transform(usb);
        usb = csg.translate3DY(0.5*y - 0.5-USBLength+1 + USBLength).transform(usb);
        base = csg.union3D(base, usb);

        return base;
    }
}