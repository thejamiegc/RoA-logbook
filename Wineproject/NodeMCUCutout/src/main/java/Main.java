import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;
import org.abstractica.javacsgmodules.nodemcu.NodeMCUv2Cutout;
import org.abstractica.javacsgmodules.nodemcu.RoundClickerHoleTest;
import org.abstractica.javacsgmodules.nodemcu.RoundSpool;

public class Main {
    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createDefault();
        RoundSpool roundSpool = new RoundSpool();
//
//        NodeMCUv2Cutout cutout = new NodeMCUv2Cutout();
//
//        Geometry3D cutoutGeometry = cutout.getCutout(csg);
//
//        Geometry3D box = csg.box3D(30, 60, 7, false);
//
//        cutoutGeometry = csg.translate3DZ(3).transform(cutoutGeometry);
//
//        Geometry3D result = csg.difference3D(box, cutoutGeometry);
////
////        NodeMCUv3Cutout cutoutv3 = new NodeMCUv3Cutout();
////        Geometry3D cutoutGeometryv3 = cutoutv3.getCutout(csg);
////
////        Geometry3D boxv3 = csg.box3D(35.5, 62, 7, false);
////
////        cutoutGeometryv3 = csg.translate3DZ(3).transform(cutoutGeometryv3);
////
////        Geometry3D resultv3 = csg.difference3D(boxv3, cutoutGeometryv3);
//
//        Geometry3D rightsidesquare = csg.box3D(12, 15, 5, false);
//        Geometry3D leftsidesquare = csg.box3D(19, 15, 5, false);
//        rightsidesquare = csg.translate3D(20.5, 0, 0).transform(rightsidesquare);
//        leftsidesquare = csg.translate3D(-23.5, 0, 0).transform(leftsidesquare);
//
//
//        result = csg.union3D(result, rightsidesquare);
//        result = csg.union3D(result, leftsidesquare);
//
//        RoundClickerHoleTest roundClickerHoleTest = new RoundClickerHoleTest();
//        Geometry3D rightsidesquareHole = roundClickerHoleTest.getHole(csg, 1.0);
//        rightsidesquareHole = csg.translate3D(20.5, 0, 0).transform(rightsidesquareHole);
//
//        Geometry3D leftsidesquareHole = roundClickerHoleTest.getHole(csg, 1.0);
//        leftsidesquareHole = csg.translate3D(-27.5, 0, 0).transform(leftsidesquareHole);
//
//
//        result = csg.difference3D(result, rightsidesquareHole);
//        result = csg.difference3D(result, leftsidesquareHole);


        Geometry3D innerCircle = roundSpool.getCutout(csg, 10, 8, 10, false);


        innerCircle = csg.rotate3DY(csg.degrees(90)).transform(innerCircle);
        innerCircle = csg.translate3D(-3.5, 0, 0).transform(innerCircle);

        Geometry3D innerbar = csg.cylinder3D(2, 2, 15, false);
        innerbar = csg.translate3D(0.5,0,5).transform(innerbar);

        Geometry3D result = csg.union3D(innerCircle, innerbar);

        Geometry3D innerBarTop = csg.cylinder3D(3.5, 0.5, 15, false);
        innerBarTop = csg.translate3D(0.5,0,6.5).transform(innerBarTop);

        result = csg.union3D(result, innerBarTop);


        Geometry3D rightSideCircle = roundSpool.getCutout(csg, 20, 1, 10, false);
        rightSideCircle = csg.rotate3DY(csg.degrees(90)).transform(rightSideCircle);
        rightSideCircle = csg.translate3D(3.5, 0, 0).transform(rightSideCircle);

        result = csg.union3D(result, rightSideCircle);

        Geometry3D leftSideCircle = roundSpool.getCutout(csg, 20, 1, 10, false);
        leftSideCircle = csg.rotate3DY(csg.degrees(90)).transform(leftSideCircle);
        leftSideCircle = csg.translate3D(-3.5, 0, 0).transform(leftSideCircle);

        result = csg.union3D(result, leftSideCircle);


        Geometry3D armhole = csg.box3D(40, 8, 8, false);
        armhole = csg.translate3DX(0).transform(armhole);


        Geometry3D cylindr = csg.cylinder3D(5, 30, 128, false);
        Geometry3D rect = csg.box3D(3, 5, 30, false);
        Geometry3D motorHole = csg.intersection3D(cylindr, rect);

//        result = csg.union3D(result, motorHole);


        motorHole = csg.rotate3DY(csg.degrees(90)).transform(motorHole);
        motorHole = csg.translate3D(-10, 0, 0).transform(motorHole);

        result = csg.difference3D(result, motorHole);



//        result = csg.difference3D(result, armhole);


        csg.view(result);
    }
}