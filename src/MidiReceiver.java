import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

/**
 * A receiver that parses raw MIDI data as basic text.
 * @author Charles Housh
 *
 */
public class MidiReceiver implements Receiver{

	@Override
	public void close() {
		try {
			this.finalize();
		} catch (Throwable e) {
			System.exit(1);
		}
		
	}

	@Override
	public void send(MidiMessage msg, long timeStamp) {
		if(msg.getLength() == 1)return;
		if(msg.getMessage()[2] == 0)return;
		System.out.print(timeStamp + "\t\t");
		for(byte b: msg.getMessage()){
			System.out.print(b + "\t\t");
		}
		System.out.println();
	}

}