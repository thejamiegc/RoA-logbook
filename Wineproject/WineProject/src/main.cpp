#include <Arduino.h>
#include <MoistSensor.h>
#include <MoistSensor.cpp>
#include <WiFiServerController.h>
#include <WiFiServerController.cpp>
#include <AccelStepper.h>

int pin = D0;
long lastUpdateTime;
long interval; 
long currentTime;
char ssid[] = "OnePlus Nord";
char password[] = "123456789";
int targetPosition = 0;
const int maxDistance = 12500;

#define IN1 5
#define IN2 4
#define IN3 14
#define IN4 12

MoistSensor moist(pin);
WiFiServerController server(ssid,password);
AccelStepper stepper(AccelStepper::HALF4WIRE, IN1, IN3, IN2, IN4);

void setup() {
  Serial.begin(115200);
  server.begin();
  lastUpdateTime = 0;
  interval = 500; 

  stepper.setMaxSpeed(1500); 
  stepper.setAcceleration(750);
  stepper.moveTo(0); 
  
}

void loop() 
{
  server.handleClient();
  currentTime = millis();
  
  if (currentTime - lastUpdateTime >= interval) {
    lastUpdateTime = currentTime;
    moist.update();

    if (moist.getIsWet()) {
      server.setIsOn(false);
      stepper.moveTo(-maxDistance);
    } 
    else if(server._isMoving){
      if(targetPosition <= maxDistance){
      targetPosition += 500;
      stepper.moveTo(targetPosition);
      server.move(false);
      }
    }
    else if(server.getIsOn()){

      if(targetPosition <= maxDistance){
      stepper.moveTo(targetPosition);
      
      if (stepper.distanceToGo() == 0) {
      targetPosition += 500;
      } 
      }
    }
  }
  stepper.run();
}



