#include "WiFiServerController.h"


WiFiServerController::WiFiServerController(char* ssid, char* password)
    : server(80), _ssid(ssid), _password(password), _isOn(false) {}

void WiFiServerController::begin() {
    setupWiFi();
    server.begin();
}

void WiFiServerController::handleClient() {
    WiFiClient client = server.accept(); // Changed from available() to accept()
    if (!client) {
        return;
    }

    client.setTimeout(5000);

    String req = client.readStringUntil('\r');

    
    
    if (req.indexOf("/gpio/0") != -1) {
        setIsOn(false);

    } else if (req.indexOf("/gpio/1") != -1) {
        setIsOn(true);
    } 

    while (client.available()) {
        client.read();
    }

    client.print("HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<!DOCTYPE HTML>\r\n<html>\r\nWine is now ");
    client.print("<br><br>Click <a href='http://");
    client.print(WiFi.localIP());
    client.print("/gpio/1'>here</a> to start sequence, or <a href='http://");
    client.print(WiFi.localIP());
    client.print("/gpio/0'>here</a> to end sepqunce.</html>");

    client.stop();
}

void WiFiServerController::setupWiFi() {
   

    Serial.println();
    Serial.println();
    Serial.print(F("Connecting to "));
    Serial.println(_ssid);

    WiFi.mode(WIFI_STA);
    WiFi.begin(_ssid, _password);

    while (WiFi.status() != WL_CONNECTED) {
        delay(500);
        Serial.print(F("."));
    }
    Serial.println();
    Serial.println(F("WiFi connected"));

    Serial.println(WiFi.localIP());
}

void WiFiServerController::setIsOn(bool status) {
    _isOn = status;
}

bool WiFiServerController::getIsOn() {
    return _isOn;
}