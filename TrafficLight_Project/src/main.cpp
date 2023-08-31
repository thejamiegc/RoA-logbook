#include <Arduino.h>
#include "SimpleLED.h"

SimpleLED Led(D0, D1, D2, D5, D6, D7);
long duration[8] = {1000,1000,3000,2000,1000,1000,3000,2000};
int CurrentState = 0;
long lastStateTime = 0;

void setup() {
  long start = millis();
  Led.setup();
  lastStateTime = start;
  
}

void loop() {
  // put your main code here, to run repeatedly:
  long now = millis();
  if(CurrentState == 0 && now >= lastStateTime + duration[CurrentState]){ //1 
    Led.update(true, true, false, true, false, false);
    CurrentState++;
    lastStateTime = millis();
  }else if(CurrentState == 1 && now >= lastStateTime + duration[CurrentState]){ //2
    Led.update(false, false, true, true, false, false);
    CurrentState++;
    lastStateTime = millis();
  }else if(CurrentState == 2 && now >= lastStateTime + duration[CurrentState]){ //3
    Led.update(false, true, false, true, false, false);
    CurrentState++;
    lastStateTime = millis();
  }else if(CurrentState == 3 && now >= lastStateTime + duration[CurrentState]){ //4
    Led.update(true, false, false, true, false, false);
    CurrentState++;
    lastStateTime = millis();
  }else if(CurrentState == 4 && now >= lastStateTime + duration[CurrentState]){ //5
    Led.update(true, false, false, true, true, false);
    CurrentState++;
    lastStateTime = millis();
  }else if(CurrentState == 5 && now >= lastStateTime + duration[CurrentState]){ //6
    Led.update(true, false, false, false, false, true);
    CurrentState++;
    lastStateTime = millis();
  }else if(CurrentState == 6 && now >= lastStateTime + duration[CurrentState]){//7
    Led.update(true, false, false, false, true, false); 
    CurrentState++;
    lastStateTime = millis();
  }else if(CurrentState == 7 && now >= lastStateTime + duration[CurrentState]){ //8
    Led.update(true, false, false, true, false, false);
    CurrentState = 0;
    lastStateTime = millis();
  }

}
