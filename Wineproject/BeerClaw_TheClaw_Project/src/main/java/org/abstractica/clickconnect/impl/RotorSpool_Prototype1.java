package org.abstractica.clickconnect.impl;

import org.abstractica.clickconnect.RoundClickSystem;
import org.abstractica.javacsg.*;

public class RotorSpool_Prototype1 implements RoundClickSystem {

    private final JavaCSG csg;
    private final double unit;

    public RotorSpool_Prototype1(JavaCSG csg, double unit) {
        this.csg = csg;
        this.unit = unit;
    }

    public Geometry3D getRotorSpoolHole() {
        Geometry3D cylindr = csg.cylinder3D(5, 1*unit, 128, false);
        Geometry3D rect = csg.box3D(3, 5, 1*unit, false);
        cylindr = csg.intersection3D(cylindr, rect);
        return cylindr;
    }

    public Geometry3D getSpoolFork(){
        Geometry3D cylindr = csg.cylinder3D(5, 15, 6, false);
        Geometry3D cylindr2 = csg.cylinder3D(5, 15, 6, false);
        cylindr = csg.translate3DX(15).transform(cylindr);
        cylindr = csg.translate3DZ(8).transform(cylindr);
        cylindr2 = csg.translate3DZ(8).transform(cylindr2);
        cylindr2 = csg.translate3DX(-15).transform(cylindr2);
        cylindr = csg.union3D(cylindr, cylindr2);
        return cylindr;
    }

    public Geometry3D getNeedleEye(){
        Geometry3D cylindr = csg.cylinder3D(1, 4.75, 128, false);
        cylindr = csg.rotate3DX(csg.degrees(90)).transform(cylindr);
        cylindr = csg.translate3DZ(21).transform(cylindr);
        cylindr = csg.translate3DX(15).transform(cylindr);
        cylindr = csg.translate3DY(2.5).transform(cylindr);
        return cylindr;
    }

    public Geometry3D getSpoolMainBody(){
        Geometry3D mainBody = csg.box3D(40, 8, 8, false);
        mainBody = csg.translate3DX(0).transform(mainBody);
        mainBody = csg.union3D(mainBody, getSpoolFork());
        mainBody = csg.difference3D(mainBody, getRotorSpoolHole(), getNeedleEye());

        return mainBody;
    }

    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createDefault();
        RotorSpool_Prototype1 rotorSpoolPrototype1 = new RotorSpool_Prototype1(csg, 15);
//        Geometry3D res = rotorSpoolPrototype1.getBeerClawHole();
        Geometry3D res = rotorSpoolPrototype1.getSpoolMainBody();
//        Geometry3D res = rotorSpoolPrototype1.getBeerClawLink();

        csg.view(res);
    }

    @Override
    public Geometry3D getClicker(double extraLength, boolean tight) {
        return null;
    }

    @Override
    public Geometry3D getRoundHoleCutout(double extraLength) {
        return null;
    }

    @Override
    public Geometry3D getLockedHoleCutout(double extraLength) {
        return null;
    }
}
