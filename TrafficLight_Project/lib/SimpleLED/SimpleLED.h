#ifndef SIMPLELED_H //ALWAYS INCLUDE THESE TWO LINES TO PREVENT REDEFINITION OF A CLASS
#define SIMPLELED_H

class SimpleLED
{
    public:
        SimpleLED(int ledRed, int ledYellow, int ledGreen, int ledRed2,int ledYellow2, int ledGreen2); //constructor
        void setup();
        void update(bool red, bool yellow, bool green, bool red2, bool yellow2, bool green2);
    private:
        int _ledRed;
        int _ledYellow;
        int _ledGreen;
        int _ledRed2;
        int _ledYellow2;
        int _ledGreen2;        

};

#endif //always include this line to end the #ifndef statement