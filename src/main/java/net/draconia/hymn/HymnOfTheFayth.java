package net.draconia.hymn;

import java.io.Serializable;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;

public class HymnOfTheFayth implements Runnable, Serializable
{
	private static final long serialVersionUID = -5243413839029814191L;
	
	public HymnOfTheFayth()
	{ }
	
	public void run()
	{
		MidiDevice objDevice = null;
		MidiDevice.Info[] arrDevices = MidiSystem.getMidiDeviceInfo();
		ShortMessage objMessage;
		
		for(int iLength = arrDevices.length, iLoop = 0; iLoop < iLength; iLoop++)
			try
				{
				objDevice = MidiSystem.getMidiDevice(arrDevices[iLoop]);
				}
			catch(MidiUnavailableException objException)
				{
				objException.printStackTrace(System.err);
				}
		
		if((objDevice != null) && (!objDevice.isOpen()))
			try
				{
				objDevice.open();
				
				MidiSystem.getReceiver().send(new ShortMessage(ShortMessage.NOTE_ON, 0, new MidiNote("A", 4).getNote(), 93), -1);
				Thread.sleep(1500);
				MidiSystem.getReceiver().send(new ShortMessage(ShortMessage.NOTE_ON, new MidiNote("C", 4).getNote(), 93), 64);
				}
			catch(InterruptedException | InvalidMidiDataException | MidiUnavailableException objException)
				{
				objException.printStackTrace(System.err);
				}
	}
	
	public static void main(String[] args)
	{
		new Thread(new HymnOfTheFayth()).start();
	}
}