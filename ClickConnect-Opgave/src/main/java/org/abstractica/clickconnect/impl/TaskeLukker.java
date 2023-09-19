package org.abstractica.clickconnect.impl;

import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class TaskeLukker {





    public static void main(String[] args) {
        JavaCSG csg = JavaCSGFactory.createDefault();

        Boolean isMale = false;
        Double delta = 0.15;
        Geometry3D lock = csg.box3D(10, 30, 25, false);
        Geometry3D strapHolder = csg.box3D(10, 2, 20, false);
        Geometry3D space = csg.box3D(10, 10,8.5+delta, false);
        RoundClicker clicker = new RoundClicker(csg, 10);


        //first strap holder hole
        strapHolder = csg.translate3D(0,-11.5,2.5).transform(strapHolder);
        lock = csg.difference3D(lock, strapHolder);
        //second strap holder hole
        strapHolder = csg.translate3DY(4.5).transform(strapHolder);
        lock = csg.difference3D(lock, strapHolder);

        if(isMale){
            //space for the female part
            space = csg.translate3D(0,10, 0).transform(space);
            lock = csg.difference3D(lock, space);
            space = csg.translate3DZ( 17-(delta*2)).transform(space);
            lock = csg.difference3D(lock, space);
        }else {
            //space for the male part
            space = csg.translate3D(0, 10, 8.5-(delta*0.5)).transform(space);
            lock = csg.difference3D(lock, space);
        }

        //clicker
        Geometry3D clickerHole = clicker.getLockedHoleCutout(30);
        clickerHole = csg.translate3DY(10).transform(clickerHole);
        lock = csg.difference3D(lock, clickerHole);


        csg.view(lock);




    }
}
