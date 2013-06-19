/**
 * RandomColor.
 *
 * Basic example showing how to set random color.
 */
 
import com.agileinnovative.blinkstick.*;

void setup() {
  BlinkStick device = BlinkStick.findFirst();
  
  if (device == null)
  {
    println("Not found...");  
  } 
  else
  {
    device.setRandomColor();
    println("Current color: " + device.getColorString());
  }

  noLoop();
}
