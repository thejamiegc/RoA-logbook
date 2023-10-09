rotate([0.0, 90.0, 0.0])
{
    difference()
    {
        difference()
        {
            difference()
            {
                difference()
                {
                    difference()
                    {
                        linear_extrude(height = 25.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                        {
                            scale([10.0, 30.0])
                            {
                                M22();
                            }
                        }
                        translate([0.0, -11.5, 2.5])
                        {
                            linear_extrude(height = 20.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                            {
                                scale([10.0, 2.0])
                                {
                                    M22();
                                }
                            }
                        }
                    }
                    translate([0.0, 4.5, 0.0])
                    {
                        translate([0.0, -11.5, 2.5])
                        {
                            linear_extrude(height = 20.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                            {
                                scale([10.0, 2.0])
                                {
                                    M22();
                                }
                            }
                        }
                    }
                }
                translate([0.0, 10.0, 0.0])
                {
                    linear_extrude(height = 8.65, twist = 0.0, scale = 1.0, slices = 1, center = false)
                    {
                        scale([10.0, 10.0])
                        {
                            M22();
                        }
                    }
                }
            }
            translate([0.0, 0.0, 16.7])
            {
                translate([0.0, 10.0, 0.0])
                {
                    linear_extrude(height = 8.65, twist = 0.0, scale = 1.0, slices = 1, center = false)
                    {
                        scale([10.0, 10.0])
                        {
                            M22();
                        }
                    }
                }
            }
        }
        translate([0.0, 10.0, 0.0])
        {
            intersection()
            {
                rotate_extrude(angle = 360.0, $fn = 128)
                {
                    M144();
                }
                translate([0.0, 0.0, -0.2])
                {
                    linear_extrude(height = 30.4, twist = 0.0, scale = 1.0, slices = 1, center = false)
                    {
                        scale([5.0, 10.0])
                        {
                            M22();
                        }
                    }
                }
            }
        }
    }
}

module M144()
{
    polygon
    (
        points =
        [
            [0.0, -0.2], 
            [4.1, -0.2], 
            [4.1, 1.4], 
            [3.1, 2.4], 
            [3.1, 2.6], 
            [4.1, 3.6], 
            [4.1, 25.2], 
            [0.0, 25.2]
        ],
        paths =
        [
            [0, 1, 2, 3, 4, 5, 6, 7]
        ]
    );
}

module M22()
{
    polygon
    (
        points =
        [
            [-0.5, -0.5], 
            [0.5, -0.5], 
            [0.5, 0.5], 
            [-0.5, 0.5]
        ],
        paths =
        [
            [0, 1, 2, 3]
        ]
    );
}
