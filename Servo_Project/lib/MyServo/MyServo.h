# ifndef MYSERVO_H
# define MYSERVO_H
# include <Servo.h>
# include <stdlib.h>

class MyServo
{
    public:
    MyServo(int pin);
    void setup();
    void update(long now);
    void setAngle(long angle);
    private:
    enum ServoState{
        off,
        accelerate,
        topSpeed,
        deaccelerate
    };
    const static long _noiseCancelTimer = 10;
    const static long _degreePerSecond = 5;
    int _pin;
    ServoState _servoState;
    Servo _servo;
    long _nextAngle=0;
    long _nextChangeTime;
    long _difference;
};

# endif // MYSERVO_H