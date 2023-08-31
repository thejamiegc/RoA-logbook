#include <Arduino.h>

// put function declarations here:

int count =0;
int buttonPin = D1;


void setup() {
  Serial.begin(9600);
  pinMode(buttonPin,INPUT_PULLUP);
  
  
}

void loop() {
  //Serial.println(digitalRead(buttonPin));
  if(digitalRead(buttonPin)==LOW){
    count++;
    Serial.println(count);
    delay(10);
    while (digitalRead(buttonPin) == LOW)
    {}
    delay(10);
  }
  
  
}

