package de.fresko.auftragsverwaltung.exceptions;

public class AlreadyInUseException extends Exception
{
	public AlreadyInUseException()
	{
		super("Auftrag ist bereits in Bearbeitung.");
	}
	
	public AlreadyInUseException(String host)
	{
		super("Auftrag ist bereits in Bearbeitung von " + host);
	}
}
