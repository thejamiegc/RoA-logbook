#include "Arduino.h"
#include "MoistSensor.h"

MoistSensor::MoistSensor(int pin)
: _pin(pin), _isWet(false)
{}

void MoistSensor::update()
{
  int sensor_analog = analogRead(_pin);
  float moisture_percentage = ( 100 - ( (sensor_analog/1023.00) * 100 ) );
  if(moisture_percentage>5.00)
  {
    _isWet = true;
  }
  else
  {
    _isWet = false;
  }
}

bool MoistSensor::getIsWet()
{
    return _isWet;
}