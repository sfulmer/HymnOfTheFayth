package net.draconia.hymn;

import java.io.Serializable;
import java.util.Arrays;

public class MidiNote implements Serializable
{
	private static final long serialVersionUID = 1414862903354670785L;
	private static final String[] mssArrNames = {"C", "C#", "D", "D#", "E", "E#", "F", "F#", "G", "G#", "A", "A#", "B", "B#"};
	
	private int miNote;
	
	public MidiNote(final int iNote)
	{
		setNote(iNote);
	}
	
	public MidiNote(final String sName, final int iOctave)
	{
		setNote((iOctave * 12) + Arrays.asList(getNames()).indexOf(sName));
	}
	
	public String getName()
	{
		return(getNames()[getNote() % 12]);
	}
	
	private static String[] getNames()
	{
		return(mssArrNames);
	}
	
	public int getNote()
	{
		return(miNote);
	}
	
	public int getOctave()
	{
		return((int)(Math.floor(miNote / 12)));
	}
	
	public void setNote(final int iNote)
	{
		miNote = iNote;
	}
}