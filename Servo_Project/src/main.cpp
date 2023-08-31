#include <Arduino.h>
#include <Servo.h>
#include <stdlib.h>
#include "MyServo.h"

MyServo myservo(D4);


void setup() {
  // put your setup code here, to run once:
  myservo.setup();
}

void loop() {
  int now = millis();
  myservo.setAngle(180);
  myservo.update(now);
  myservo.setAngle(0);
  myservo.update(now);
  
}