package org.abstractica.clickconnect.impl;

import org.abstractica.javacsg.*;


public class StepMotor3DModel {
    private final JavaCSG csg;


    public StepMotor3DModel(JavaCSG csg) {
        this.csg = csg;
    }

    public Geometry3D getStepMotorHolder(){
        Geometry3D cylindr = csg.cylinder3D(29, 20, 128, false);
        Geometry3D rect = csg.box3D(14.5, 14.5, 20, false);
        Geometry3D rect2 = csg.box3D(17.5, 17.5, 20, false);


        Geometry3D hookhole = csg.cylinder3D(7, 42, 128, false);
        hookhole = csg.rotate3DY(csg.degrees(90)).transform(hookhole);
        hookhole = csg.translate3DZ(20).transform(hookhole);
        hookhole = csg.translate3DX(-21).transform(hookhole);


        Geometry3D hookholeRect = csg.box3D(42, 7, 1, false);
        hookholeRect = csg.translate3DZ(19).transform(hookholeRect);
        hookholeRect = csg.translate3DX(0).transform(hookholeRect);

        Geometry3D hole = csg.cylinder3D(4.5, 50, 128, false);
        hole = csg.translate3DX(18).transform(hole);
        Geometry3D hole2 = csg.cylinder3D(4.5, 50, 128, false);
        hole2 = csg.translate3DX(-18).transform(hole2);
        hookhole = csg.intersection3D(hookhole, hookholeRect);
        hookhole = csg.difference3D(hookhole, hole, hole2);


        rect = csg.translate3DY(11.5).transform(rect);
        rect2 = csg.translate3DY(6).transform(rect2);
        cylindr = csg.union3D(cylindr, rect, rect2, hookhole);
        return cylindr;
    }

    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createDefault();
        StepMotor3DModel stepMotor3DModel = new StepMotor3DModel(csg);
        Geometry3D res = stepMotor3DModel.getStepMotorHolder();
        csg.view(res);
    }
}
