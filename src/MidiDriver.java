/**
 * Driver class for MIDI input decoder.
 * @author Charles Housh
 *
 */
public class MidiDriver {

	private MidiDriver(){}
	
	public static void main(String[] args) {
		if(args.length > 0){
			new MidiHandler(args[0]);
		}
		else{
			new MidiHandler();
		}
	}

}
