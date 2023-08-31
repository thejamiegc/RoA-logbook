#include "MyServo.h"
#include <Arduino.h>
#include <Servo.h>
#include <stdlib.h>

MyServo::MyServo(int pin) : _pin(pin) {}
void MyServo :: setup()
{
    _servo.attach(_pin, 500, 2400); // these last to parameters are needed for the servo to spin at almost exaact 180 degrees.
    _servo.write(_nextAngle);
    _servoState = off;

}

void MyServo::setAngle(long angle)
{
   _nextAngle  = angle;
}

void MyServo::update(long now){

    switch (_servoState)
    {
    case off:
        if(_nextAngle == _servo.read()) return;
        _servoState = accelerate;
        _difference = abs( _nextAngle - _servo.read());
        _servo.write(_nextAngle);
        _nextChangeTime = now + _noiseCancelTimer;
        break;
    
    case accelerate:
        if(now <_nextChangeTime) return;
        _servoState = topSpeed;
        _nextChangeTime = now + _degreePerSecond * _difference;
        break;
    
    case topSpeed:
        if(now < _nextChangeTime) return;
        _servoState = deaccelerate;
        _nextChangeTime = now + _noiseCancelTimer;
        break;
    
    case deaccelerate:
        if(now < _nextChangeTime) return;
        _servoState = off;
        break;
    
    default:
        break;
    }

}