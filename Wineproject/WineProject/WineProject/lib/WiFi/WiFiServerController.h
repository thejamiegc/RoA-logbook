#ifndef WiFiServerController_h
#define WiFiServerController_h

#include <ESP8266WiFi.h>
#include <AccelStepper.h>

class WiFiServerController {
public:
    WiFiServerController(char* ssid, char* pass);
    void begin();
    void handleClient();
    void setIsOn(bool status);
    bool getIsOn();

private:
    WiFiServer server;
    const char* _ssid;
    const char* _password;
    bool _isOn;

    

    void setupWiFi();
};

#endif
