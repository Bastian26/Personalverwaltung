//-----------------------------------
//Name: Bastian Struggl
//Projektkname: Personalverwaltung OOP / Klasse: Mitarbeiter
//Datum: 19.06.2020
//-----------------------------------

package pers2;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Mitarbeiter implements Comparable<Mitarbeiter> {

	// Attributes
	private String name;
	private String vorname;
	private Date einstellungsdatum;

	// Constructor
	public Mitarbeiter(String vorname, String name, Date einstellungsdatum) {
		this.name = name;
		this.vorname = vorname;
		this.einstellungsdatum = einstellungsdatum;
	}

	// Methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public Date getEinstellungsdatum() {
		return this.einstellungsdatum;
	}

	// Set with DATE
	public void setEinstellungsdatum(String einstellungsdatum) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fd = null;
		try {
			fd = (Date) formatter.parse(einstellungsdatum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(fd.getTime());
		this.einstellungsdatum = sqlDate;
	}

	public String get_vollerName() {
		return this.vorname + " " + this.name;
	}

	@Override
	public String toString() {
		return "Mitarbeiter [name=" + name + ", vorname=" + vorname + ", einstellungsdatum=" + einstellungsdatum + "]";
	}

	// Um Mitarbeiter sortieren zu können, wird diese Methode benötigt
	@Override
	public int compareTo(Mitarbeiter m) {
		return this.getName().compareTo(((Mitarbeiter) m).getName());
	}

}
