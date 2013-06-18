import com.agileinnovative.blinkstick.*;

void setup() {
  BlinkStick device = BlinkStick.findFirst();
  
  if (device == null)
  {
    println("Not found...");  
  } 
  else
  {
	device.setColor("red");
	delay(1000);
	device.setColor("green");
	delay(1000);
	device.setColor("blue");
	delay(1000);
	device.turnOff();
  }

  noLoop();
}
