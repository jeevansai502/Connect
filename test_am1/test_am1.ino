#include <EtherCard.h>

static byte mymac[] = { 0x74,0x69,0x69,0x2D,0x30,0x31 };

byte Ethernet::buffer[500];
static uint32_t timer;

int fPin = 10;
int bPin = 9;

char website[]  = "172.16.15.246";

static void my_callback (byte status, word off, word len) {
	Serial.println(">>>");
	Ethernet::buffer[off+300] = 0;
	Serial.print((const char*) Ethernet::buffer + off);
	Serial.println("...");
}

void sendData(){

Serial.println('S');
	int count = 0;
	while(count < 2){

		ether.packetLoop(ether.packetReceive());

		if (millis() > timer) {

			count++;

			if(count >= 2){
				return;  
			}

			timer = millis() + 5000;
			Serial.println();
			Serial.print("<<< REQ ");


			char a1[10],a2[10],a3[10],a4[10],ipSend[20];
			sprintf(ipSend,"%d.%d.%d.%d",ether.myip[0],ether.myip[1],ether.myip[2],ether.myip[3]);

			char b1[10],b2[10],b3[10],b4[10],b5[10],b6[10],macSend[25];
			sprintf(macSend,"%d:%d:%d:%d:%d:%d",mymac[0],mymac[1],mymac[2],mymac[3],mymac[4],mymac[5]);

			Stash stash;
			byte sd = stash.create();
			stash.print("ip=");
			stash.print(ipSend);
			stash.print("&mac=");
			stash.print(macSend);

			stash.save();
			Stash::prepare(PSTR("POST http://$F:8080/Connect/Arduino_data HTTP/1.1" "\r\n"
						"Host: $F:8080" "\r\n"
						"Content-Length: $D" "\r\n"
						"\r\n"
						"$H"),
					website, website, stash.size(), sd);
			ether.tcpSend();

		}
	}
 Serial.println('E');
}


void setup () {

	pinMode(fPin, OUTPUT);
	pinMode(bPin, OUTPUT);

	digitalWrite(bPin,HIGH);

	Serial.begin(9600);
	Serial.println('A');
	Serial.println("\n[webClient]");

	if (ether.begin(sizeof Ethernet::buffer, mymac,8) == 0) 
		Serial.println("Failed to access Ethernet controller");
	if (!ether.dhcpSetup())
		Serial.println("DHCP failed");

	ether.printIp("IP:  ", ether.myip);
	ether.printIp("GW:  ", ether.gwip);  
	ether.printIp("DNS: ", ether.dnsip);  

	ether.parseIp(ether.hisip, website);

	ether.hisport = 8080;

	ether.printIp("SRV: ", ether.hisip);
	sendData();

	ether.hisport = 80;

}


const char page1[] PROGMEM = "HTTP/1.1 200 OK\r\n"
"Content-Type: text/html\r\n"
"Retry-After: 600\r\n"
"\r\n"
"0"
;

const char page2[] PROGMEM = "HTTP/1.1 200 OK\r\n"
"Content-Type: text/html\r\n"
"Retry-After: 600\r\n"
"\r\n"
"1"
;

const char zo[] PROGMEM = "HTTP/1.1 200 OK\r\n"
"Content-Type: text/html\r\n"
"Retry-After: 600\r\n"
"\r\n"
"01"
;

const char oz[] PROGMEM = "HTTP/1.1 200 OK\r\n"
"Content-Type: text/html\r\n"
"Retry-After: 600\r\n"
"\r\n"
"10"
;
const char oo[] PROGMEM = "HTTP/1.1 200 OK\r\n"
"Content-Type: text/html\r\n"
"Retry-After: 600\r\n"
"\r\n"
"11"
;
const char zz[] PROGMEM = "HTTP/1.1 200 OK\r\n"
"Content-Type: text/html\r\n"
"Retry-After: 600\r\n"
"\r\n"
"00"
;




void loop () {


const char page[] PROGMEM = "HTTP/1.1 200 OK\r\n"
"Content-Type: text/html\r\n"
"Retry-After: 600\r\n"
"\r\n"
;

	word len = ether.packetReceive();
	word pos = ether.packetLoop(len); 

	if (strstr((char *)Ethernet::buffer + pos, "GET /?BULB=STATE") != 0 && len != 0) {  

		int state = digitalRead(bPin);

		if(state == 0){
			memcpy_P(ether.tcpOffset(), page1, sizeof page1);
			ether.httpServerReply(sizeof page1 - 1);
		}else if(state == 1){
			memcpy_P(ether.tcpOffset(), page2, sizeof page2);
			ether.httpServerReply(sizeof page2 - 1);
		}

		Serial.println("BULB : Received STATE command");

	}

	if (strstr((char *)Ethernet::buffer + pos, "GET /?FAN=STATE") != 0 && len != 0) {

		int state = digitalRead(fPin);

		if(state == 0){
			memcpy_P(ether.tcpOffset(), page1, sizeof page1);
			ether.httpServerReply(sizeof page1 - 1);
		}else if(state == 1){
			memcpy_P(ether.tcpOffset(), page2, sizeof page2);
			ether.httpServerReply(sizeof page2 - 1);
		}

		Serial.println("FAN : Received STATE command");

	}

	if (strstr((char *)Ethernet::buffer + pos, "GET /?BULB=ON") != 0) {

  digitalWrite(bPin, HIGH);

  int bS = digitalRead(bPin);
  int fS = digitalRead(fPin);

if(bS == 0 && fS == 0){
    memcpy_P(ether.tcpOffset(), zz, sizeof zz);
    ether.httpServerReply(sizeof zz - 1);
}else if(bS == 1 && fS == 0){
    memcpy_P(ether.tcpOffset(), oz, sizeof oz);
    ether.httpServerReply(sizeof oz - 1);
}else if(bS == 0 && fS == 1){
    memcpy_P(ether.tcpOffset(), zo, sizeof zo);
    ether.httpServerReply(sizeof zo- 1);
}else if(bS == 1 && fS == 1){
    memcpy_P(ether.tcpOffset(), oo, sizeof oo);
    ether.httpServerReply(sizeof oo - 1);
}
		Serial.println("BULB : Received ON command");
	}else if (strstr((char *)Ethernet::buffer + pos, "GET /?BULB=OFF") != 0) {

    digitalWrite(bPin, LOW);

  int bS = digitalRead(bPin);
  int fS = digitalRead(fPin);

if(bS == 0 && fS == 0){
    memcpy_P(ether.tcpOffset(), zz, sizeof zz);
    ether.httpServerReply(sizeof zz - 1);
}else if(bS == 1 && fS == 0){
    memcpy_P(ether.tcpOffset(), oz, sizeof oz);
    ether.httpServerReply(sizeof oz - 1);
}else if(bS == 0 && fS == 1){
    memcpy_P(ether.tcpOffset(), zo, sizeof zo);
    ether.httpServerReply(sizeof zo- 1);
}else if(bS == 1 && fS == 1){
    memcpy_P(ether.tcpOffset(), oo, sizeof oo);
    ether.httpServerReply(sizeof oo - 1);
}
  
		Serial.println("BULB : Received OFF command");
	}else if (strstr((char *)Ethernet::buffer + pos, "GET /?FAN=ON") != 0) {

    digitalWrite(fPin, HIGH);
  int bS = digitalRead(bPin);
  int fS = digitalRead(fPin);

if(bS == 0 && fS == 0){
    memcpy_P(ether.tcpOffset(), zz, sizeof zz);
    ether.httpServerReply(sizeof zz - 1);
}else if(bS == 1 && fS == 0){
    memcpy_P(ether.tcpOffset(), oz, sizeof oz);
    ether.httpServerReply(sizeof oz - 1);
}else if(bS == 0 && fS == 1){
    memcpy_P(ether.tcpOffset(), zo, sizeof zo);
    ether.httpServerReply(sizeof zo- 1);
}else if(bS == 1 && fS == 1){
    memcpy_P(ether.tcpOffset(), oo, sizeof oo);
    ether.httpServerReply(sizeof oo - 1);
}

		Serial.println("FAN : Received ON command");


	}else if (strstr((char *)Ethernet::buffer + pos, "GET /?FAN=OFF") != 0) {
		
    digitalWrite(fPin, LOW);

  int bS = digitalRead(bPin);
  int fS = digitalRead(fPin);

if(bS == 0 && fS == 0){
    memcpy_P(ether.tcpOffset(), zz, sizeof zz);
    ether.httpServerReply(sizeof zz - 1);
}else if(bS == 1 && fS == 0){
    memcpy_P(ether.tcpOffset(), oz, sizeof oz);
    ether.httpServerReply(sizeof oz - 1);
}else if(bS == 0 && fS == 1){
    memcpy_P(ether.tcpOffset(), zo, sizeof zo);
    ether.httpServerReply(sizeof zo- 1);
}else if(bS == 1 && fS == 1){
    memcpy_P(ether.tcpOffset(), oo, sizeof oo);
    ether.httpServerReply(sizeof oo - 1);
}
    
		Serial.println("FAN : Received OFF command");

	}


}
