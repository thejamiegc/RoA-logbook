linear_extrude(height = 4.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
{
    union()
    {
        M238();
        mirror([1.0, 0.0])
        {
            M238();
        }
    }
}

module M238()
{
    polygon
    (
        points =
        [
            [0.0, 0.0], 
            [3.9, 0.0], 
            [3.9, 1.0], 
            [2.9, 2.0], 
            [2.9, 7.7], 
            [3.9, 8.7], 
            [2.9, 10.0], 
            [0.8, 10.0], 
            [0.8, 2.0], 
            [0.0, 2.0]
        ],
        paths =
        [
            [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        ]
    );
}
