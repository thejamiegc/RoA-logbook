#include <Arduino.h>
#include "SimpleLED.h"

SimpleLED led1(BUILTIN_LED,false,450,50);
SimpleLED led2(LED_BUILTIN_AUX,false,950,50);


void setup() {
  // put your setup code here, to run once:
  long start = millis();
  led1.setup(start);
  led2.setup(start);
}

void loop() {
  // put your main code here, to run repeatedly:
  long now = millis();
  led1.update(now);
  led2.update(now);
}
