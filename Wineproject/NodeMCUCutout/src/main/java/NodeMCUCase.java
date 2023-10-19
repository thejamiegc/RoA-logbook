import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;
import org.abstractica.javacsgmodules.nodemcu.NodeMCUv2Cutout;
import org.abstractica.javacsgmodules.nodemcu.RoundClickerHoleTest;

public class NodeMCUCase {

    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createDefault();

        NodeMCUv2Cutout cutout = new NodeMCUv2Cutout();

        Geometry3D cutoutGeometry = cutout.getCutout(csg);

        Geometry3D box = csg.box3D(30, 60, 7, false);

        cutoutGeometry = csg.translate3DZ(3).transform(cutoutGeometry);

        Geometry3D result = csg.difference3D(box, cutoutGeometry);
//
//        NodeMCUv3Cutout cutoutv3 = new NodeMCUv3Cutout();
//        Geometry3D cutoutGeometryv3 = cutoutv3.getCutout(csg);
//
//        Geometry3D boxv3 = csg.box3D(35.5, 62, 7, false);
//
//        cutoutGeometryv3 = csg.translate3DZ(3).transform(cutoutGeometryv3);
//
//        Geometry3D resultv3 = csg.difference3D(boxv3, cutoutGeometryv3);

        Geometry3D rightsidesquare = csg.box3D(12, 15, 5, false);
        Geometry3D leftsidesquare = csg.box3D(19, 15, 5, false);
        rightsidesquare = csg.translate3D(20.5, 0, 0).transform(rightsidesquare);
        leftsidesquare = csg.translate3D(-23.5, 0, 0).transform(leftsidesquare);


        result = csg.union3D(result, rightsidesquare);
        result = csg.union3D(result, leftsidesquare);

        RoundClickerHoleTest roundClickerHoleTest = new RoundClickerHoleTest();
        Geometry3D rightsidesquareHole = roundClickerHoleTest.getHole(csg, 1.0);
        rightsidesquareHole = csg.translate3D(20.5, 0, 0).transform(rightsidesquareHole);

        Geometry3D leftsidesquareHole = roundClickerHoleTest.getHole(csg, 1.0);
        leftsidesquareHole = csg.translate3D(-27.5, 0, 0).transform(leftsidesquareHole);


        result = csg.difference3D(result, rightsidesquareHole);
        result = csg.difference3D(result, leftsidesquareHole);









        csg.view(result);

    }










}
