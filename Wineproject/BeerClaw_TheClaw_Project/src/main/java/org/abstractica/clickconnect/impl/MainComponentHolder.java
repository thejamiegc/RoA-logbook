package org.abstractica.clickconnect.impl;

import org.abstractica.javacsg.*;

public class MainComponentHolder {

    private final JavaCSG csg;

    public MainComponentHolder(JavaCSG csg) {
        this.csg = csg;
    }

    Geometry3D getMainComp() {
        Geometry3D box = csg.box3D(45, 40, 60, false);
        box = csg.translate3DZ(-40).transform(box);

        StepMotor3DModel stepMotor3DModel = new StepMotor3DModel(csg);
        Geometry3D stepMotor = stepMotor3DModel.getStepMotorHolder();

        Geometry3D wireHole = csg.box3D(14.5,7,6,false);
        wireHole = csg.translate3DZ(11.5).transform(wireHole);
        wireHole = csg.translate3DY(20).transform(wireHole);

        Geometry3D halfcircle = csg.coneSegment3D(2, 90, 40,csg.degrees(180),csg.degrees(0) , 6, false);
        halfcircle = csg.translate3DZ(-80).transform(halfcircle);
        halfcircle = csg.translate3DY(20).transform(halfcircle);

        box = csg.difference3D(box, stepMotor,wireHole,getFace());
        box = csg.union3D(box, getWineBoxPlateHolder(),halfcircle);

        return box;
    }



    Geometry3D getWineBoxPlateHolder(){
        Geometry3D wineHolder = csg.box3D(90, 34, 195, false);
        wineHolder = csg.translate3DZ(-183.5).transform(wineHolder);
        wineHolder = csg.translate3DY(37).transform(wineHolder);

        Geometry3D wineHole = csg.box3D(82, 30, 186, false);
        wineHole = csg.translate3DZ(-179).transform(wineHole);
        wineHole = csg.translate3DY(39.5).transform(wineHole);



        wineHolder = csg.difference3D(wineHolder, wineHole);



        return wineHolder;
    }
    public Geometry3D getFace() {
        Geometry2D text = csg.text2D(".͜.", 16, 30, 64);
        Geometry3D text3d = csg.linearExtrude(3, true, text);

        text3d = csg.rotate3DX(csg.degrees(90)).transform(text3d);
        text3d = csg.rotate3DY(csg.degrees(180)).transform(text3d);

        text3d = csg.translate3DZ(0).transform(text3d);
        text3d = csg.translate3DX(24).transform(text3d);
        text3d = csg.translate3DY(-20).transform(text3d);
        return text3d;
    }

    Geometry3D getMainComponentCollected(){
        Geometry3D MainComponentCollected = getMainComp();
        Geometry3D WineBoxPlateHolder = getWineBoxPlateHolder();

        MainComponentCollected = csg.union3D(MainComponentCollected, WineBoxPlateHolder);

        MainComponentCollected = csg.rotate3DY(csg.degrees(90)).transform(MainComponentCollected);
        MainComponentCollected = csg.rotate3DX(csg.degrees(270)).transform(MainComponentCollected);
        return MainComponentCollected;
    }

    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createDefault();
        MainComponentHolder mainComponentHolder = new MainComponentHolder(csg);
        Geometry3D res = mainComponentHolder.getMainComponentCollected();
        csg.view(res);
    }
}
