import java.util.List;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Transmitter;

/**
 * Handles MIDI device input and provides a Receiver for each device.
 * @author Charles Housh
 *
 */
public class MidiHandler {

	/**
	 * Provides a general handler for all detected MIDI devices.
	 */
	public MidiHandler(){
		MidiDevice device;
		MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
		System.out.println("Devices found: " + infos.length);
		for(int i = 0; i < infos.length; i++){
			try{
				device = MidiSystem.getMidiDevice(infos[i]);
				
				//Print device info:
				System.out.println("Device information: " + infos[i]);
				
				//Obtain all transmitters
				List<Transmitter> trans = device.getTransmitters();
				for(Transmitter t: trans){
					//Create new receiver for each transmitter
					System.out.println("   " + t.toString());
					t.setReceiver(new MidiReceiver());
				}
				device.open();
				Transmitter t = device.getTransmitter();
				t.setReceiver(new MidiReceiver());
				//Affirm opening of device
				System.out.println("  " + device.getDeviceInfo() + " opened.");
			}catch(MidiUnavailableException mue){System.out.println("  <!>Device unavailable: " + mue.getMessage());}
			System.out.println("Timestamp\tStatus\tNote\tVelocity");
		}
	}
	
	/**
	 * Provides a handler for a specific device; if not found, program will terminate.
	 * @param deviceName Name of device to provide handler for.
	 */
	public MidiHandler(String deviceName){
		MidiDevice device;
		MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
		System.out.println("Devices found: " + infos.length);
		for(int i = 0; i < infos.length; i++){
			if(!infos[i].toString().equalsIgnoreCase(deviceName)){
				continue;
			}
			try{
				device = MidiSystem.getMidiDevice(infos[i]);
				
				//Print device info:
				System.out.println("Device information: " + infos[i]);
				
				//Obtain all transmitters
				List<Transmitter> trans = device.getTransmitters();
				for(Transmitter t: trans){
					//Create new receiver for each transmitter
					System.out.println("   " + t.toString());
					t.setReceiver(new MidiReceiver());
				}
				device.open();
				Transmitter t = device.getTransmitter();
				t.setReceiver(new MidiReceiver());
				//Affirm opening of device
				System.out.println("  " + device.getDeviceInfo() + " opened.");
			}catch(MidiUnavailableException mue){System.out.println("  <!>Device unavailable: " + mue.getMessage());}
			System.out.println("Timestamp\tStatus\tNote\tVelocity");
		}
	}
}
