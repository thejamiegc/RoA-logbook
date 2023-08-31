#include "SimpleLED.h"
#include <Arduino.h>

SimpleLED::SimpleLED(int ledRed, int ledYellow, int ledGreen, int ledRed2, int ledYellow2, int ledGreen2) //constructor
        : _ledRed(ledRed), _ledYellow(ledYellow), _ledGreen(ledGreen), _ledRed2(ledRed2), _ledYellow2(ledYellow2), _ledGreen2(ledGreen2)
        {

        }
        

        void SimpleLED:: setup()
        {
            pinMode(_ledRed, OUTPUT);
            pinMode(_ledYellow, OUTPUT);
            pinMode(_ledGreen, OUTPUT);
            pinMode(_ledRed2, OUTPUT);
            pinMode(_ledYellow2, OUTPUT);
            pinMode(_ledGreen2, OUTPUT);
            digitalWrite(_ledRed, HIGH);
            digitalWrite(_ledYellow, LOW);
            digitalWrite(_ledGreen, LOW);
            digitalWrite(_ledRed2, HIGH);
            digitalWrite(_ledYellow2, LOW);
            digitalWrite(_ledGreen2, LOW);
        }
        void SimpleLED:: update(bool red, bool yellow, bool green, bool red2, bool yellow2, bool green2)
        {
            digitalWrite(_ledRed, red);
            digitalWrite(_ledYellow, yellow);
            digitalWrite(_ledGreen, green);
            digitalWrite(_ledRed2, red2);
            digitalWrite(_ledYellow2, yellow2);
            digitalWrite(_ledGreen2, green2);
        };
  