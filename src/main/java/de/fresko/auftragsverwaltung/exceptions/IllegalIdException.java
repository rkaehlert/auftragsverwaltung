package de.fresko.auftragsverwaltung.exceptions;

public class IllegalIdException extends Exception
{
	public IllegalIdException()
	{
		super("Ungültige ID");
	}
	
	public IllegalIdException(String text)
	{
		super(text);
	}
}
