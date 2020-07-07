//-----------------------------------
//Name: Bastian Struggl
//Projektkname: Personalverwaltung OOP / Klasse: Datenbank
//Datum: 19.06.2020
//-----------------------------------

package pers2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Datenbank {

	// This Array will take the created Mitarbeiter-Objects in UserInterface
	Mitarbeiter[] mitarbeiter_arr = new Mitarbeiter[50];
	static Scanner scan = new Scanner(System.in);

	// Methods
	// ---------------------------------------------------------------------------------------------------------------------
	public void addMitarbeiter(Mitarbeiter mit) {
		for (int i = 0; i <= mitarbeiter_arr.length - 1; i++) {
			if (this.mitarbeiter_arr[i] == null) {
				this.mitarbeiter_arr[i] = mit;
				// Verlassen der For-Schleife
				break;
			}
		}
	}

	// Method to show all Employees
	public void showAll() {
		System.out.println("Folgende Datensätze befinden sich in der Datenbank )");
		for (int i = 0; i < mitarbeiter_arr.length; i++) {
			if (mitarbeiter_arr[i] != null) {
				// System.out.println(this.mitarbeiter_arr[i].getName()); // old Version
				System.out.println(this.mitarbeiter_arr[i].toString());
			}

		}
		System.out.println("");
	}

	// Method to sort employees, it calls the Compare-To-Method from Mitarbeiter and also uses the Comperator Interface
	public void sortMitarbeiterArray() {
		// It requires a Comperator because the array pockets (slots) also contain
		// null-values, the the comparable alone can't handle with that.
		Arrays.sort(mitarbeiter_arr, new Comparator<Mitarbeiter>() {
			@Override
			public int compare(Mitarbeiter o1, Mitarbeiter o2) {
				if (o1 == null && o2 == null) {
					return 0;
				}
				if (o1 == null) {
					return 1;
				}
				if (o2 == null) {
					return -1;
				}
				return o1.compareTo(o2);
			}
		});
		System.out.println("Das Array wurde aufsteigend/alphabetisch nach den Nachnamen sortiert\n");
	}
	
	// Method to find a specific User
	public void findSpecificUser() {
		// Type in the Forname and Surname to delete the right person
		System.out.println("Bitte geben Sie den Vornamen ein");
		String vorName = scan.nextLine();
		vorName = vorName.toLowerCase();
		System.out.println("Bitte geben Sie den Nachnamen ein");
		String nachName = scan.nextLine();
		nachName = nachName.toLowerCase();

		for (int i = 0; i <= mitarbeiter_arr.length - 1; i++) {
			// User not found
			if (i == 49 && mitarbeiter_arr[i] == null) { 
				System.out.println(
						"Der angegebene User wurde konnte nicht gefunden werden (Achten Sie auf die korrekte Schreibweise)"
								+ "\n-------------------------------------------------------");
				break;
			}
			// if a Array-Slot contains null = continue
			else if (this.mitarbeiter_arr[i] == null) {
				continue;
			}
			// if it finds the User
			else if (this.mitarbeiter_arr[i].getVorname().contentEquals(vorName)&& this.mitarbeiter_arr[i].getName().contentEquals(nachName)) {
				System.out.println("Der Mitarbeiter: " + this.mitarbeiter_arr[i].getVorname() + " "
				+ this.mitarbeiter_arr[i].getName() + " mit dem Einstellungsdatum " + this.mitarbeiter_arr[i].getEinstellungsdatum() + " wurde gefunden! "
				+ "\n-------------------------------------------------------");
				// Leave the loop with break
				break;
			}
		}
	}

	// Method to delete specific User
	public void deletepecificUser() {
		// Type in the Forname and Surname for the search
		System.out.println("Bitte geben Sie den Vornamen ein");
		String vorName = scan.nextLine();
		vorName = vorName.toLowerCase();
		System.out.println("Bitte geben Sie den Nachnamen ein");
		String nachName = scan.nextLine();
		nachName = nachName.toLowerCase();

		// User not found
		for (int i = 0; i <= mitarbeiter_arr.length - 1; i++) {
			if (i == 49 && mitarbeiter_arr[i] == null) {
				System.out.println(
						"Der angegebene User wurde konnte nicht gefunden und somit auch nicht gelöscht werden (Achten Sie auf die korrekte Schreibweise)"
								+ "\n-------------------------------------------------------");
				break;
			}
			// if a Array-Slot contains null = continue
			else if (this.mitarbeiter_arr[i] == null) {
				continue;
			}
			// if it finds the User
			else if (this.mitarbeiter_arr[i].getVorname().contentEquals(vorName) && this.mitarbeiter_arr[i].getName().contentEquals(nachName)) {
				System.out.println("Der Mitarbeiter: " + this.mitarbeiter_arr[i].getVorname() + " "
						+ this.mitarbeiter_arr[i].getName() + " wurde gelöscht."
						+ "\n-------------------------------------------------------");
				this.mitarbeiter_arr[i] = null;
				// Leave the loop with break
				break;
			}
		}
	}
	public void bubblesort() {
        Mitarbeiter temp;
        for(int i=1; i< mitarbeiter_arr.length; i++) {
            for(int j=0; j< mitarbeiter_arr.length-i; j++) {
                if (mitarbeiter_arr[j] == null && mitarbeiter_arr[j + 1] != null)  {
                    mitarbeiter_arr[j]=mitarbeiter_arr[j+ 1];
                    mitarbeiter_arr[j + 1]=null;
                    }
                    else if (mitarbeiter_arr[j] != null && mitarbeiter_arr[j + 1] != null){
                        if(mitarbeiter_arr[j].getName().compareTo(mitarbeiter_arr[j+1].getName()) > 0) {
                            temp=mitarbeiter_arr[j];
                            mitarbeiter_arr[j]=mitarbeiter_arr[j+ 1];
                            mitarbeiter_arr[j + 1]=temp;
                            }
                        }
                }
            }
    }
}
