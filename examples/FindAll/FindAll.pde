import com.agileinnovative.blinkstick.*;

void setup() {
  println("Listing all BlinkSticks:");
  for (BlinkStick device: BlinkStick.findAll()) {
    println("  Found BlinkStick: " + device.getSerial());
  } 

  noLoop();
}
