//-----------------------------------
//Name: Bastian Struggl
//Projektkname: Personalverwaltung OOP / Klasse: UserInterface
//Datum: 19.06.2020
//-----------------------------------

package pers2;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UserInterface {
	
	// Create Database with New-Operator
	static Datenbank db = new Datenbank();
	static Scanner scan = new Scanner(System.in); 
	
	public static void main(String[] args) throws ParseException {
		menue();
	}
	//END of main-method		
	//------------------------------------------------------------------------------------------------------------------------------------
	
	// Menue-Method 
	public static void menue() throws ParseException {
		// Loop of main menue
		boolean breakCondition = true;
		do {
			//Menü
			System.out.println("Willkommen im User-Interface!"
							+ "\n-) Wollen Sie einen neuen Mitarbeiterdatensatz hinzufügen, dann drücken Sie bitte die Taste 'M'"
							+ "\n-) Zur Suche eines Mitarbeiters mithilfe des Vor- und Nachnamens, die Taste 'F'"  
							+ "\n-) Um sich alle Mitarbeiter anzeigen zu lassen, die Taste 'A' drücken" 
							+ "\n-) Zur Löschung eines Datensat zes mithilfe des Vor - und Nachnamens, die Taste 'L'" 
							+ "\n-) Zur Sortierung der Mitarbeiterdatenbank Nachnamens, die Taste 'S'"
							+ "\n-) Zum Beenden des Programms, die Taste 'B'"
							+ "\n-------------------------------------------------------------------------------------------------------"); 
			
			char charAuswahl = scan.nextLine().toLowerCase().charAt(0);
			
			switch (charAuswahl) {
			case 'm':
					 addMitUI();
					 break;
			case 'f':
					 db.findSpecificUser();
					 break;
			case 'a':
				 	 db.showAll();
				 	 break;
			case 'l':
					 db.deletepecificUser();
					 break;
			case 's':
					 //db.sortMitarbeiterArray();
				db.bubblesort();
					 break;
			case 'b':
					 System.out.println("Personalverwaltungsprogramm wird beendet!");
					 breakCondition = false;
					 break;
			}
		
		// End of Menue-Loop
		} while(breakCondition);
	}
	
	public static void addMitUI() throws ParseException {
		// Enter Forname and Surname
		System.out.println("Bitte geben Sie den Vornamen ein");
		String vorName = scan.nextLine();
		vorName = vorName.toLowerCase();
		System.out.println("Bitte geben Sie den Nachnamen ein");
		String nachName = scan.nextLine();
		nachName = nachName.toLowerCase();
		
		Date fd = null;
		boolean wiederholen = true;
		while (wiederholen) {
			try {
				// Input Date
				System.out.println("Bitte geben Sie das Einstellungsdatum nach folgendem Format ein yyyy-MM-dd");
				String einstellDatum = scan.nextLine();
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				fd = (Date) formatter.parse(einstellDatum);
				wiederholen = false;
			} catch (ParseException e) {
				// No valid Date 
				System.out.println("Sie haben kein valides Datum eingegeben (yyyy-MM-dd)");
			}
		}
		
		java.sql.Date sqlDate = new java.sql.Date(fd.getTime());	
		Mitarbeiter mitarbeiter = new Mitarbeiter(vorName, nachName, sqlDate);
		db.addMitarbeiter(mitarbeiter);
		System.out.println("Der Mitarbeiter: " + vorName + " " + nachName + " wurde der Datenbank hinzugefügt"
				+ "\n-------------------------------------------------------");
	}
// End of class UI
}
