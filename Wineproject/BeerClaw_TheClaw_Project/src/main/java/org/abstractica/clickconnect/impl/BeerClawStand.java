package org.abstractica.clickconnect.impl;
import org.abstractica.javacsg.*;


public class BeerClawStand {
    private final JavaCSG csg;
    private final double unit;

    public BeerClawStand(JavaCSG csg, double unit) {
        this.csg = csg;
        this.unit = unit;
    }

    public Geometry3D getStandFace() {
        Geometry2D text = csg.text2D(".͜.", 16,30,64);
        text = csg.rotate2D(csg.degrees(90)).transform(text);
        Geometry3D text3d = csg.linearExtrude(3, true,text);
        text3d = csg.translate3DZ(44).transform(text3d);
        text3d = csg.translate3DX(-12.5).transform(text3d);
        text3d = csg.translate3DY(-24).transform(text3d);


return text3d;
    }
    public Geometry3D getBeerClawStand() {
        Geometry3D stand = csg.box3D(70, 80, 45, false);
        Geometry3D standHole = csg.cone3D(56, 75, 86, 64, false);
        Geometry3D standTongue = csg.flatRing3D(0, 80, 10, 64, false);
        standTongue = csg.translate3DX(35).transform(standTongue);
        standHole = csg.translate3DZ(2).transform(standHole);
        standHole = csg.translate3DX(30).transform(standHole);
        stand = csg.union3D(stand, standTongue);


        stand = csg.difference3D(stand, standHole, getStandFace(), getClickHole());


        return stand;
    }

    public Geometry3D getClickHole(){
        RoundClicker roundClicker = new RoundClicker();
        Geometry3D clickerHole = roundClicker.getHole(csg,1.0);
        clickerHole = csg.translate3DZ(40).transform(clickerHole);
        clickerHole = csg.translate3DX(-25).transform(clickerHole);
        clickerHole = csg.translate3DY(-30).transform(clickerHole);
        return clickerHole;
    }

    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createDefault();
        BeerClawStand beerClawStand = new BeerClawStand(csg, 15);
        Geometry3D res = beerClawStand.getBeerClawStand();
        csg.view(res);
    }
}

