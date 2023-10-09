# RoA-logbook
# 22-08-2023
vi blev introduceret til node MCU og lidt c++ kode.

# 25-08-2023
vi har i dag lavet en SimpleLED class i c++.
vi started på trafiklys projktet. [trafiklys]([url](https://github.com/thejamiegc/RoA-logbook/tree/main/TrafficLight_Project)

# 28-08-2023 
vi fik lavet første udkast til vores trafiklysprojekt. vi havde lidt en ide til hvordan den skulle laves og efter justeringer så kom vi frem til et svar vi godt vil snakke med tobias om i morgen til undervisningen. vi kom selv frem til løsningen og så ingen videoer eller guides. 

# 29-08-2023
Vi lærte i dag om knepper (buttons) og hvordan vi skal sætte en class op til at kun bruge den. så fik vi ud leveret en servomotor som vi skal lave en geneal class til.

# 30-08-2023
Vi fik arbejdet på vores ServoMotor, testet forskellige teorier og kom til sidst i mål med at få lavet en class der i sidste ende blev ret plug-and-play til fremtidigt brug hvilket var godt! - herudover fandt vi ud af at man kan læse den præcise position hvor "armen" på servoen og hvor den befinder sig samt at servoen ikke kan gå under et 850 millis delay eftersom vi også testede på 700 milisekunder og 500 milisekunder men jo kortere delay jo mindre præcis var bevægelsesgangen. teorien lyder at der ikke er nok volt for servoenn at arbejde med eftersom at servoen skal bruge 5V og ESP8266 kun giver 3.3V men sjov og lærerig dag!
[servo motor]([url](https://github.com/thejamiegc/RoA-logbook/tree/main/Servo_Project)

# 31-08-2023
I dag lavede vi et exampel på wifi på nodeMCUen. og lærte om at downloade libaries til platfromio. Vi stødte på et sjov problem med at vi havde for meget modstand så at vi havde en LED der slukkede når vi havde begge LED tændt. [WIFI]([url](https://github.com/thejamiegc/RoA-logbook/tree/main/WifiExample)

# 05-09-2023
I dag lærte vi at bruge javacsg og legede lidt med 3d modulering

# 07-09-2023
I dag lavede vi en holder til den lille NodeMCU samme med Tobias og lavede vi en selv til den stor som vi 3dprinted restultatet må vi se på mandag.

# 11-09-2023
Vores holder til nodeMCU passede ikke helt og printet var ikke den bedst kvalitet da vi brugte en af de dårligere printer. 

# 12-09-2023
Vi som klasse started på vores overordnet projekt togbane og vi startede så på at lave en clicker ting som vi kunne bruge til at sætte skinder samme med.

# 15-09-2023
Vi/(Tobias med lidt hjælp fra os i klassen) forsat på clicker delen og dermed blev vist den iterative process i at arbejde med 3D print.

# 19-09-2023
vi lavede clicker delen færdig og kaldte den click-Connect fik som opgave til at lave en sej ting med den da min taske var i stykker tænkte kunne bruge den click-connect til at lave en erstatning til den ting der var gå i stykker på min taske som var låsen som lukker remmene der går henover brystet. 

# 22-09-2023
Vi stoppede med at lave på tog banen og fik lov til at lave projekter i gruppe. Så vi brianstormede og fandt på at vi skulle lave en robot der hælder vin op i en kop fra wifi og stopper når den er fyldt.

# 26-09-2023
Jeg var syg men gruppe gik i gang med at designe det 3d print vi skal bruge til projektet.

# 29-09-2023
Vi lavede videre på projektet hvor Matias og jeg kiggede på en moisture sensor og fik den til at virke så når den bliver fugtig nok så skriver den stop i terminalen og det output kan vi så andre til at få den til at stoppe når glasset er fyldt op. Vi startede også med at lave Wifi så vi kan trykke på et link på en hjemmeside så man senere hen kan starte motor der skal hælde op i glasset. vi blev ikke helt færdig med wifi i dag men det forsætter vi på næste gang. mens resten forsatte med modulering af 3d print delene til projektet. 

# 03-10-2023
Vi skulle forsætte med Wifi men på grund problem som viste sig at være nogle ledning der forhindre også i at uploade til node MCUen. der fra kunne vi så forstætte med wifi og det fik vi til at virke. I mens fik vi 3d printet et par dele og vi fik rettet dem til så de passede bedre sammen.

# 06-10-2023
Vi startede på at få stepo motoren til at virke. Vi løb ind i et problem med at wifiet gik ud når motoren kører. Det viser sig at motoren bruger en while loop mens den kører hvilket lidt fungere som et delay og gøre at wifi slukker. så til næste gang skal vi finde en løsning til det. 
I mens fik vi 3d printet et par dele og vi fik rettet dem til så de passede bedre sammen. Vi fik også kigget lidt mere på den måden vi skulle vi papvinen til at hælde op på ved at bruge snore i stedet for lave en form for krog med gear i som motoren kunne dreje. Det jo bedst at keep it simple stupid.  

# 10-10-2023

# 13-10-2023

