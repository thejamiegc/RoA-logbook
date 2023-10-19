#ifndef MOISTSENSOR_H
#define MOISTSENSOR_H

class MoistSensor
{
    public:
        MoistSensor(int pin);
        void setup();
        void update();
        bool getIsWet();
    private:
        int _pin;
        bool _isWet;
        long _nextChange;
};

#endif