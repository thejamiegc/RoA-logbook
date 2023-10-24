package org.abstractica.clickconnect.impl;

import org.abstractica.javacsg.*;

public class WineTapHolder {

    private final JavaCSG csg;

public WineTapHolder(JavaCSG csg) {
        this.csg = csg;
    }



    Geometry3D getWineTapHolder(JavaCSG csg) {
    Geometry3D boxtoTapDisc = csg.box3D(90, 5, 65.5, false);
    boxtoTapDisc = csg.translate3DY(-2.5).transform(boxtoTapDisc);

    Geometry3D hole = csg.cylinder3D(35, 110, 128, false);
    hole = csg.rotate3DX(csg.degrees(90)).transform(hole);
    hole = csg.translate3DZ(40).transform(hole);
    hole = csg.translate3DY(41).transform(hole);

    Geometry3D wallHooks = csg.box3D(90, 20, 52.5, false);
    wallHooks = csg.translate3DZ(-47.5).transform(wallHooks);
    wallHooks= csg.translate3DY(7.5).transform(wallHooks);
    Geometry3D wallHookSeperator = csg.cylinder3D(5, 5, 128, false);
    wallHooks = csg.rotate3DX(csg.degrees(90)).transform(wallHooks);

    boxtoTapDisc = csg.union3D(boxtoTapDisc, wallHooks);


    Geometry3D holeExtender = csg.cylinder3D(40, 40, 128, false); //54 cm from floor
    Geometry3D boxIndent = csg.box3D(82, 59.999, 80, false); //54 cm from floor
        boxIndent = csg.translate3DY(30).transform(boxIndent);


        boxtoTapDisc = csg.difference3D(boxtoTapDisc, holeExtender,hole,boxIndent,getFace(),getTapHoleWidener());

        boxtoTapDisc = csg.rotate3DX(csg.degrees(90)).transform(boxtoTapDisc);
    return boxtoTapDisc;
    }

    public Geometry3D getFace() {
        Geometry2D text = csg.text2D(".͜.", 7, 20, 64);
        Geometry3D text3d = csg.linearExtrude(3, true, text);

        text3d = csg.rotate3DX(csg.degrees(90)).transform(text3d);
        text3d = csg.rotate3DY(csg.degrees(0)).transform(text3d);

        text3d = csg.translate3DZ(10).transform(text3d);
        text3d = csg.translate3DX(22.5).transform(text3d);
        text3d = csg.translate3DY(-5).transform(text3d);
        return text3d;
    }

    public Geometry3D getTapHoleWidener(){
        //TODO: VINTAP MED VINGER : BREDDE : 39.23 mm
        //TODO: VINTAP HØJDE: 36.66 mm
        //TODO: VINTAP HØJDE FRA BUND TIL INDHAK : 38mm
        Geometry3D tapHoleWidener = csg.box3D(50, 35.75,20, false);
        tapHoleWidener = csg.rotate3DX(csg.degrees(90)).transform(tapHoleWidener);
        tapHoleWidener = csg.translate3DZ(40).transform(tapHoleWidener);
        return tapHoleWidener;
}

    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createDefault();
        WineTapHolder wineTapHolder = new WineTapHolder(csg);
        Geometry3D res = wineTapHolder.getWineTapHolder(csg);
        csg.view(res);
    }
}
