package de.fresko.auftragsverwaltung.exceptions;

public class JobnummerException extends Exception
{
	public JobnummerException()
	{
		super("Beim Erstellen der Jobnummer ist ein Fehler aufgetreten.\nMöglicherweise stimmt das Datum des Servers nicht.");
	}
	
	public JobnummerException(String message)
	{
		super(message);
	}
}
