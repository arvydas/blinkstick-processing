/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 * All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR "AS IS" AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
 * EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
 * IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY
 * OF SUCH DAMAGE.
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package blinkstick;

import com.codeminders.hidapi.HIDDeviceInfo;
import com.codeminders.hidapi.HIDManager;
import com.codeminders.hidapi.HIDDevice;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/**
 * This is a template class and can be used to start a new processing library or
 * tool. Make sure you rename this class as well as the name of the example
 * package 'template' to your own library or tool naming convention.
 * 
 * @example Hello
 * 
 *          (the tag @example followed by the name of an example included in
 *          folder 'examples' will automatically include the example in the
 *          javadoc.)
 * 
 */

/**
 * @author Arvydas
 *
 */
public class BlinkStick {

	public final static String VERSION = "##library.prettyVersion##";

	private static Boolean Initialized = false;

	private static final Hashtable<String, String> COLORS = new Hashtable<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("aqua", "#00ffff");
			put("aliceblue", "#f0f8ff");
			put("antiquewhite", "#faebd7");
			put("black", "#000000");
			put("blue", "#0000ff");
			put("cyan", "#00ffff");
			put("darkblue", "#00008b");
			put("darkcyan", "#008b8b");
			put("darkgreen", "#006400");
			put("darkturquoise", "#00ced1");
			put("deepskyblue", "#00bfff");
			put("green", "#008000");
			put("lime", "#00ff00");
			put("mediumblue", "#0000cd");
			put("mediumspringgreen", "#00fa9a");
			put("navy", "#000080");
			put("springgreen", "#00ff7f");
			put("teal", "#008080");
			put("midnightblue", "#191970");
			put("dodgerblue", "#1e90ff");
			put("lightseagreen", "#20b2aa");
			put("forestgreen", "#228b22");
			put("seagreen", "#2e8b57");
			put("darkslategray", "#2f4f4f");
			put("darkslategrey", "#2f4f4f");
			put("limegreen", "#32cd32");
			put("mediumseagreen", "#3cb371");
			put("turquoise", "#40e0d0");
			put("royalblue", "#4169e1");
			put("steelblue", "#4682b4");
			put("darkslateblue", "#483d8b");
			put("mediumturquoise", "#48d1cc");
			put("indigo", "#4b0082");
			put("darkolivegreen", "#556b2f");
			put("cadetblue", "#5f9ea0");
			put("cornflowerblue", "#6495ed");
			put("mediumaquamarine", "#66cdaa");
			put("dimgray", "#696969");
			put("dimgrey", "#696969");
			put("slateblue", "#6a5acd");
			put("olivedrab", "#6b8e23");
			put("slategray", "#708090");
			put("slategrey", "#708090");
			put("lightslategray", "#778899");
			put("lightslategrey", "#778899");
			put("mediumslateblue", "#7b68ee");
			put("lawngreen", "#7cfc00");
			put("aquamarine", "#7fffd4");
			put("chartreuse", "#7fff00");
			put("gray", "#808080");
			put("grey", "#808080");
			put("maroon", "#800000");
			put("olive", "#808000");
			put("purple", "#800080");
			put("lightskyblue", "#87cefa");
			put("skyblue", "#87ceeb");
			put("blueviolet", "#8a2be2");
			put("darkmagenta", "#8b008b");
			put("darkred", "#8b0000");
			put("saddlebrown", "#8b4513");
			put("darkseagreen", "#8fbc8f");
			put("lightgreen", "#90ee90");
			put("mediumpurple", "#9370db");
			put("darkviolet", "#9400d3");
			put("palegreen", "#98fb98");
			put("darkorchid", "#9932cc");
			put("yellowgreen", "#9acd32");
			put("sienna", "#a0522d");
			put("brown", "#a52a2a");
			put("darkgray", "#a9a9a9");
			put("darkgrey", "#a9a9a9");
			put("greenyellow", "#adff2f");
			put("lightblue", "#add8e6");
			put("paleturquoise", "#afeeee");
			put("lightsteelblue", "#b0c4de");
			put("powderblue", "#b0e0e6");
			put("firebrick", "#b22222");
			put("darkgoldenrod", "#b8860b");
			put("mediumorchid", "#ba55d3");
			put("rosybrown", "#bc8f8f");
			put("darkkhaki", "#bdb76b");
			put("silver", "#c0c0c0");
			put("mediumvioletred", "#c71585");
			put("indianred", "#cd5c5c");
			put("peru", "#cd853f");
			put("chocolate", "#d2691e");
			put("tan", "#d2b48c");
			put("lightgray", "#d3d3d3");
			put("lightgrey", "#d3d3d3");
			put("thistle", "#d8bfd8");
			put("goldenrod", "#daa520");
			put("orchid", "#da70d6");
			put("palevioletred", "#db7093");
			put("crimson", "#dc143c");
			put("gainsboro", "#dcdcdc");
			put("plum", "#dda0dd");
			put("burlywood", "#deb887");
			put("lightcyan", "#e0ffff");
			put("lavender", "#e6e6fa");
			put("darksalmon", "#e9967a");
			put("palegoldenrod", "#eee8aa");
			put("violet", "#ee82ee");
			put("azure", "#f0ffff");
			put("honeydew", "#f0fff0");
			put("khaki", "#f0e68c");
			put("lightcoral", "#f08080");
			put("sandybrown", "#f4a460");
			put("beige", "#f5f5dc");
			put("mintcream", "#f5fffa");
			put("wheat", "#f5deb3");
			put("whitesmoke", "#f5f5f5");
			put("ghostwhite", "#f8f8ff");
			put("lightgoldenrodyellow", "#fafad2");
			put("linen", "#faf0e6");
			put("salmon", "#fa8072");
			put("oldlace", "#fdf5e6");
			put("bisque", "#ffe4c4");
			put("blanchedalmond", "#ffebcd");
			put("coral", "#ff7f50");
			put("cornsilk", "#fff8dc");
			put("darkorange", "#ff8c00");
			put("deeppink", "#ff1493");
			put("floralwhite", "#fffaf0");
			put("fuchsia", "#ff00ff");
			put("gold", "#ffd700");
			put("hotpink", "#ff69b4");
			put("ivory", "#fffff0");
			put("lavenderblush", "#fff0f5");
			put("lemonchiffon", "#fffacd");
			put("lightpink", "#ffb6c1");
			put("lightsalmon", "#ffa07a");
			put("lightyellow", "#ffffe0");
			put("magenta", "#ff00ff");
			put("mistyrose", "#ffe4e1");
			put("moccasin", "#ffe4b5");
			put("navajowhite", "#ffdead");
			put("orange", "#ffa500");
			put("orangered", "#ff4500");
			put("papayawhip", "#ffefd5");
			put("peachpuff", "#ffdab9");
			put("pink", "#ffc0cb");
			put("red", "#ff0000");
			put("seashell", "#fff5ee");
			put("snow", "#fffafa");
			put("tomato", "#ff6347");
			put("white", "#ffffff");
			put("yellow", "#ffff00");
		}
	};

	/**
	 * BlinkStick vendor ID 
	 */
	public final static int VENDOR_ID = 0x20a0;

	/**
	 * BlinkStick product ID 
	 */
	public final static int PRODUCT_ID = 0x41e5;

	/** 
	 * HID device object to communicate directly with BlinkStick
	 */
	private HIDDevice device = null;

	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

	/** 
	 * Assign HIDDevice
	 * 
	 * @param device HID device object to communicate directly with BlinkStick
	 */
	private void setDevice(HIDDevice device) {
		this.device = device;
	}

	/** 
	 * Load hidapi library based on the OS. This function is automatically called whenever 
	 * a search for BlinkStick is performed for the first time.
	 */
	public static void Initialize() {
		if (!Initialized) {
			Initialized = true;

			com.codeminders.hidapi.ClassPathLibraryLoader
			.loadNativeHIDLibrary();
		}
	}

	/** 
	 * Find first BlinkStick connected to the computer
	 * 
	 * @return BlinkStick object or null if no BlinkSticks are connected
	 * @throws IOException 
	 */
	public static BlinkStick findFirst() throws IOException {
		Initialize();

		HIDDeviceInfo[] infos = findAllDescriptors();

		if (infos.length > 0) {
			BlinkStick result = new BlinkStick();

			result.setDevice(infos[0].open());
			return result;
		}

		return null;
	}

	/** Find BlinkStick by serial number
	 * 
	 * @param serial	The serial number to search
	 * 
	 * @return			BlinkStick object or null if device was not found
	 * @throws IOException 
	 */
	public static BlinkStick findBySerial(String serial) throws IOException {
		Initialize();

		HIDDeviceInfo[] infos = findAllDescriptors();

		for (HIDDeviceInfo info : infos) {
			if (info.getSerial_number().equals(serial)) {
				BlinkStick result = new BlinkStick();

				result.setDevice(infos[0].open());
				return result;
			}
		}

		return null;
	}

	/** 
	 * Find all BlinkStick HIDDeviceInfo descriptions connected to the computer
	 * 
	 * @return an array of HIDDeviceInfo objects with VID and PID matching BlinkStick
	 * @throws IOException 
	 */
	private static HIDDeviceInfo[] findAllDescriptors() throws IOException {
		Initialize();

		List<HIDDeviceInfo> blinkstickList = new ArrayList<HIDDeviceInfo>();

		HIDManager hidManager = HIDManager.getInstance();

		HIDDeviceInfo[] infos = hidManager.listDevices();

		for (HIDDeviceInfo info : infos) {
			if (info.getVendor_id() == VENDOR_ID
					&& info.getProduct_id() == PRODUCT_ID) {
				blinkstickList.add(info);
			}
		}

		return blinkstickList.toArray(new HIDDeviceInfo[blinkstickList.size()]);
	}

	/** 
	 * Find all BlinkSticks connected to the computer
	 * 
	 * @return an array of BlinkStick objects
	 * @throws IOException 
	 */
	public static BlinkStick[] findAll() throws IOException {
		List<BlinkStick> blinkstickList = new ArrayList<BlinkStick>();

		HIDDeviceInfo[] infos = findAllDescriptors();

		for (HIDDeviceInfo info : infos) {
			BlinkStick blinkstick = new BlinkStick();

			blinkstick.setDevice(info.open());
			blinkstickList.add(blinkstick);
		}

		return blinkstickList.toArray(new BlinkStick[blinkstickList.size()]);
	}

	/** 
	 * Set the color of the device with separate r, g and b int values.
	 * The values are automatically converted to byte values
	 * 
	 * @param r	red int color value 0..255
	 * @param g gree int color value 0..255
	 * @param b blue int color value 0..255
	 * @throws IOException 
	 */
	public void setColor(int r, int g, int b) throws IOException {
		this.setColor((byte) r, (byte) g, (byte) b);
	}

	/** 
	 * Set the color of the device with separate r, g and b byte values
	 * 
	 * @param r	red byte color value 0..255
	 * @param g gree byte color value 0..255
	 * @param b blue byte color value 0..255
	 * @throws IOException 
	 */
	public void setColor(byte r, byte g, byte b) throws IOException {
		device.sendFeatureReport(new byte[] {1, r, g, b});
	}

	/** 
	 * Set indexed color of the device with separate r, g and b byte values for channel and LED index
	 * 
	 * @param channel	Channel (0 - R, 1 - G, 2 - B)
	 * @param index	Index of the LED
	 * @param r	red int color value 0..255
	 * @param g gree int color value 0..255
	 * @param b blue int color value 0..255
	 * @throws IOException 
	 */
	public void setIndexedColor(int channel, int index, int r, int g, int b) throws IOException {
		this.setIndexedColor((byte)channel, (byte)index, (byte)r, (byte)g, (byte)b);
	}

	/** 
	 * Set indexed color of the device with separate r, g and b byte values for channel and LED index
	 * 
	 * @param channel	Channel (0 - R, 1 - G, 2 - B)
	 * @param index	Index of the LED
	 * @param r	red byte color value 0..255
	 * @param g gree byte color value 0..255
	 * @param b blue byte color value 0..255
	 * @throws IOException 
	 */
	public void setIndexedColor(byte channel, byte index, byte r, byte g, byte b) throws IOException {
		device.sendFeatureReport(new byte[] {5, channel, index, r, g, b});

	}

	/** 
	 * Set the indexed color of BlinkStick Pro with Processing color value
	 * 
	 * @param channel	Channel (0 - R, 1 - G, 2 - B)
	 * @param index	Index of the LED
	 * @param value	color as int
	 * @throws IOException 
	 */
	public void setIndexedColor(int channel, int index, int value) throws IOException {
		int r = (value >> 16) & 0xFF;
		int g = (value >> 8)  & 0xFF;
		int b =  value        & 0xFF;

		this.setIndexedColor(channel, index, r, g, b);
	}

	/** 
	 * Set the indexed color of BlinkStick Pro with Processing color value for channel 0
	 * 
	 * @param index	Index of the LED
	 * @param value	color as int
	 * @throws IOException 
	 */
	public void setIndexedColor(int index, int value) throws IOException {
		int r = (value >> 16) & 0xFF;
		int g = (value >> 8)  & 0xFF;
		int b =  value        & 0xFF;

		this.setIndexedColor(0, index, r, g, b);
	}

	/** 
	 * Set the color of the device with Processing color value
	 * 
	 * @param value	color as int
	 * @throws IOException 
	 */
	public void setColor(int value) throws IOException {
		int r = (value >> 16) & 0xFF;
		int g = (value >> 8)  & 0xFF;
		int b =  value        & 0xFF;

		this.setColor(r, g, b);
	}

	/** 
	 * Set the color of the device with string value
	 * 
	 * @param value	this can either be a named color "red", "green", "blue" and etc.
	 * 			or a hex color in #rrggbb format
	 * @throws IOException 
	 */
	public void setColor(String value) throws IOException {
		if (COLORS.containsKey(value)) {
			this.setColor(hex2Rgb(COLORS.get(value)));
		} else {
			this.setColor(hex2Rgb(value));
		}
	}

	/** 
	 * Set random color
	 * @throws IOException 
	 */
	public void setRandomColor() throws IOException {
		Random random = new Random();
		this.setColor(
				random.nextInt(256), 
				random.nextInt(256),
				random.nextInt(256));
	}

	/** 
	 * Turn the device off
	 * @throws IOException 
	 */
	public void turnOff() throws IOException {
		this.setColor(0, 0, 0);
	}

	/** 
	 * Convert hex string to color object
	 * 
	 * @param colorStr	Color value as hex string #rrggbb
	 * 
	 * @return			color object
	 */
	private int hex2Rgb(String colorStr) {
		int red   = Integer.valueOf(colorStr.substring(1, 3), 16)+ 0;
		int green = Integer.valueOf(colorStr.substring(3, 5), 16) + 0;
		int blue  = Integer.valueOf(colorStr.substring(5, 7), 16) + 0;

		return (255 << 24) | (red << 16) | (green << 8) | blue;
	}

	/** 
	 * Get the current color of the device as int
	 * 
	 * @return The current color of the device as int
	 * @throws IOException 
	 */
	public int getColor() throws IOException {
		byte[] data = new byte[33];
		data[0] = 1;// First byte is ReportID

		int read = device.getFeatureReport(data);
		if (read > 0) {
			return (255 << 24) | (data[1] << 16) | (data[2] << 8) | data[3];
		}

		return 0;
	}

	/** 
	 * Get the current color of the device in #rrggbb format 
	 * 
	 * @return Returns the current color of the device as #rrggbb formated string
	 * @throws IOException 
	 */
	public String getColorString() throws IOException {
		int c = getColor();

		int red   = (c >> 16) & 0xFF;
		int green = (c >> 8)  & 0xFF;
		int blue  =  c        & 0xFF;

		return "#" + String.format("%02X", red)
				+ String.format("%02X", green)
				+ String.format("%02X", blue);
	}

	/** 
	 * Get value of InfoBlocks
	 * 
	 * @param id	InfoBlock id, should be 1 or 2 as only supported info blocks
	 * @throws IOException 
	 */
	private String getInfoBlock(int id) throws IOException {
		byte[] data = new byte[33];
		data[0] = (byte) (id + 1);

		String result = "";

		int read = device.getFeatureReport(data);
		if (read > 0) {
			for (int i = 1; i < data.length; i++) {
				if (i == 0) {
					break;
				}

				result += (char) data[i];
			}
		}

		return result;
	}

	/** 
	 * Get value of InfoBlock1
	 * 
	 * @return The value of info block 1
	 * @throws IOException 
	 */
	public String getInfoBlock1() throws IOException {
		return getInfoBlock(1);
	}

	/** 
	 * Get value of InfoBlock2
	 * 
	 * @return The value of info block 2
	 * @throws IOException 
	 */
	public String getInfoBlock2() throws IOException {
		return getInfoBlock(2);
	}

	/** 
	 * Set value for InfoBlocks
	 * 
	 * @param id	InfoBlock id, should be 1 or 2 as only supported info blocks
	 * @param value	The value to be written to the info block
	 * @throws IOException 
	 */
	private void setInfoBlock(int id, String value) throws IOException {
		char[] charArray = value.toCharArray();
		byte[] data = new byte[33];
		data[0] = (byte) (id + 1);

		for (int i = 0; i < charArray.length; i++) {
			if (i > 32) {
				break;
			}

			data[i + 1] = (byte) charArray[i];
		}

		device.sendFeatureReport(data);
	}

	/** 
	 * Set value for InfoBlock1
	 * 
	 * @param value	The value to be written to the info block 1
	 * @throws IOException 
	 */
	public void setInfoBlock1(String value) throws IOException {
		setInfoBlock(1, value);
	}

	/** 
	 * Set value for InfoBlock2
	 * 
	 * @param value	The value to be written to the info block 2
	 * @throws IOException 
	 */
	public void setInfoBlock2(String value) throws IOException {
		setInfoBlock(2, value);
	}

	/** 
	 * Get the manufacturer of the device
	 * 
	 * @return Returns the manufacturer name of the device
	 * @throws IOException 
	 */
	public String getManufacturer() throws IOException {
		return device.getManufacturerString();
	}

	/** 
	 * Get the product description of the device
	 * 
	 * @return Returns the product name of the device.
	 * @throws IOException 
	 */
	public String getProduct() throws IOException {
		return device.getProductString();
	}

	/** 
	 * Get the serial number of the device
	 * 
	 * @return Returns the serial number of device.
	 * @throws IOException 
	 */
	public String getSerial() throws IOException {
		return device.getSerialNumberString();
	}

	/** 
	 * Determine report id for the amount of data to be sent
	 * 
	 * @return Returns the report id
	 */
	private byte determineReportId(int length) {
		byte reportId = 9;
		//Automatically determine the correct report id to send the data to
		if (length <= 8 * 3)
		{
			reportId = 6;
		}
		else if (length <= 16 * 3)
		{
			reportId = 7;
		}
		else if (length <= 32 * 3)
		{
			reportId = 8;
		}
		else if (length <= 64 * 3)
		{
			reportId = 9;
		}
		else if (length <= 128 * 3)
		{
			reportId = 10;
		}

		return reportId;
	}

	/** 
	 * Determine the adjusted maximum amount of LED for the report
	 * 
	 * @return Returns the adjusted amount of LED data
	 */
	private byte determineMaxLeds(int length) {
		byte maxLeds = 64;
		//Automatically determine the correct report id to send the data to
		if (length <= 8 * 3)
		{
			maxLeds = 8;
		}
		else if (length <= 16 * 3)
		{
			maxLeds = 16;
		}
		else if (length <= 32 * 3)
		{
			maxLeds = 32;
		}
		else if (length <= 64 * 3)
		{
			maxLeds = 64;
		}
		else if (length <= 128 * 3)
		{
			maxLeds = 64;
		}

		return maxLeds;
	}

	/** 
	 * Send a packet of data to LEDs on channel 0 (R)
	 * 
	 * @param colorData	Report data must be a byte array in the following format: [g0, r0, b0, g1, r1, b1, g2, r2, b2 ...]
	 * @throws IOException 
	 */
	public void setColors(byte[] colorData) throws IOException
	{
		this.setColors((byte)0, colorData);
	}

	/** 
	 * Send a packet of data to LEDs
	 * 
	 * @param channel	Channel (0 - R, 1 - G, 2 - B)
	 * @param colorData	Report data must be a byte array in the following format: [g0, r0, b0, g1, r1, b1, g2, r2, b2 ...]
	 * @throws IOException 
	 */
	public void setColors(int channel, byte[] colorData) throws IOException
	{
		this.setColors((byte)channel, colorData);
	}

	/** 
	 * Send a packet of data to LEDs
	 * 
	 * @param channel	Channel (0 - R, 1 - G, 2 - B)
	 * @param colorData	Report data must be a byte array in the following format: [g0, r0, b0, g1, r1, b1, g2, r2, b2 ...]
	 * @throws IOException 
	 */
	public void setColors(byte channel, byte[] colorData) throws IOException
	{
		byte leds = this.determineMaxLeds(colorData.length);
		byte[] data = new byte[leds * 3 + 2];

		data[0] = this.determineReportId(colorData.length);
		data[1] = channel;


		for (int i = 0; i < Math.min(colorData.length, data.length - 2); i++)
		{
			data[i + 2] = colorData[i];
		}

		for (int i = colorData.length + 2; i < data.length; i++)
		{
			data[i] = 0;
		}

		device.sendFeatureReport(data);
	}

	/** 
	 * Set the mode of BlinkStick Pro as int
	 * 
	 * @param mode	0 - Normal, 1 - Inverse, 2 - WS2812, 3 - WS2812 mirror
	 * @throws IOException 
	 */
	public void setMode(int mode) throws IOException
	{
		this.setMode((byte)mode);
	}

	/** 
	 * Set the mode of BlinkStick Pro as byte
	 * 
	 * @param mode	0 - Normal, 1 - Inverse, 2 - WS2812, 3 - WS2812 mirror
	 * @throws IOException 
	 */
	public void setMode(byte mode) throws IOException
	{
		device.sendFeatureReport(new byte[] {4, mode});

	}

	/** 
	 * Get the mode of BlinkStick Pro
	 * 
	 * @return 0 - Normal, 1 - Inverse, 2 - WS2812, 3 - WS2812 mirror
	 * @throws IOException 
	 */
	public byte getMode() throws IOException
	{
		byte[] data = new byte[2];
		data[0] = 4;// First byte is ReportID

		int read = device.getFeatureReport(data);
		if (read > 0) {
			return data[1];
		}

		return -1;
	}
}
