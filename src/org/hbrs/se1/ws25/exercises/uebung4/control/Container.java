package org.hbrs.se1.ws25.exercises.uebung4.prototype;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
 * Klasse zum Management sowie zur Eingabe unnd Ausgabe von User-Stories.
 * Die Anwendung wird über dies Klasse auch gestartet (main-Methode hier vorhanden)
 *
 * erstellt von Julius P., H-BRS 2025, Version 1.2
 *
 * Strategie für die Wiederverwendung (Reuse):
 * - Anlegen der Klasse UserStory
 * - Anpassen des Generic in der List-Klasse (VORHER: Member, NEU: UserStory)
 * - Anpassen der Methodennamen
 *
 * ToDo: Wie bewerten Sie diese Strategie? Was ist ihre Strategie zur Wiederverwendung? (F1)
 *
 * Entwurfsentscheidung: Die wichtigsten Zuständigkeiten (responsibilities)
 * sind in einer Klasse, d.h. Container?
 * ToDo: Wie bewerten Sie diese Entscheidung? Was wäre ein sinnvolle Aufteilung (F2, F6)
 *
 */

public class Container {

	// Interne ArrayList zur Abspeicherung der Objekte vom Type UserStory
	private List<UserStory> liste = new ArrayList<>();

	// Statische Klassen-Variable, um die Referenz
	// auf das einzige Container-Objekt abzuspeichern
	// Diese Variante sei thread-safe, so hat Hr. P. es gehört... stimmt das?
	// Todo: Bewertung Thread-Safeness (F1)
	// Todo: Bewertung Speicherbedarf (F1)
	private static Container instance = new Container();

	// URL der Datei, in der die Objekte gespeichert werden
	final static String LOCATION = "allStories.ser";

	/**
	 * Liefert ein Singleton zurück.
	 * @return
	 */
	public static Container getInstance() {
		return instance;
	}

	/**
	 * Vorschriftsmäßiges Ueberschreiben des Konstruktors (private) gemaess Singleton-Pattern (oder?)
	 *
	 */
	Container(){
		liste = new ArrayList<UserStory>();
	}

	/**
	 * Start-Methoden zum Starten des Programms
	 * (hier koennen ggf. weitere Initialisierungsarbeiten gemacht werden spaeter)
	 */
	public static void main (String[] args) throws Exception {
		// ToDo: Bewertung Exception-Handling (F3, F7)
		Container con = Container.getInstance();
		con.startEingabe();
	}

	/*
	 * Diese Methode realisiert eine Eingabe ueber einen Scanner
	 * Alle Exceptions werden an den aufrufenden Context (hier: main) weitergegeben (throws)
	 * Das entlastet den Entwickler zur Entwicklungszeit und den Endanwender zur Laufzeit
	 */
	public void startEingabe() throws ContainerException, Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("User-Story Tool (Übung 4)");
		printHelp();

		while (true) {
			System.out.println("> ");
			String line = scanner.nextLine().trim();
			if (line.isEmpty()) continue;

			String cmd = line.split("\\s+")[0].toLowerCase();
			switch (cmd) {
				case "help":
					printHelp();
					break;

				case "dump":
					startAusgabe(scanner);
					break;

				case "enter":
					enterStory(scanner);
					break;

				case "store":
					store();
					break;

				case "load":
					load();
					break;

				case "exit":
					System.out.println("Bye. ");
					return;

				default:
					System.out.println("unbekannter befehl. 'help' eingeben.");
			}
		}
	}

	private void printHelp() {
		System.out.println("""
                Befehle:
                  enter  - Neue User Story eingeben
                  dump   - Alle Stories anzeigen (optional mit Filter)
                  store  - Stories speichern
                  load   - Stories aus Datei laden
                  help   - Diese Hilfe anzeigen
                  exit   - Programm beenden
                Optional bei dump:
                  project=<Name>   (z.B. project=Coll@HBRS)
                  minprio=<Zahl>   (z.B. minprio=1.5)
                  sort=prio|id|value|effort
                """);
	}

	private void enterStory(Scanner scanner) {
		try {
			System.out.println("ID: ");
			int id = Integer.parseInt(scanner.nextLine().trim());

			System.out.println("Titel: ");
			String titel = scanner.nextLine().trim();

			System.out.println("Beschreibung: ");
			String desc = scanner.nextLine().trim();

			System.out.println("Projektname: ");
			String projekt = scanner.nextLine().trim();

			System.out.print("Mehrwert (1–5): ");
			int value = Integer.parseInt(scanner.nextLine().trim());

			System.out.print("Aufwand (Fibonacci): ");
			int effort = Integer.parseInt(scanner.nextLine().trim());

			System.out.print("Risiko (>=0): ");
			int risk = Integer.parseInt(scanner.nextLine().trim());

			UserStory us = new UserStory(id, titel, desc, projekt, value, effort, risk);
			addUserStory(us);
			System.out.printf("User Story gespeichert. Priorität: %.2f%n", us.getPriority());
		} catch (NumberFormatException e) {
			System.out.println("Fehler: Zahl erwartet.");
		} catch (IllegalArgumentException e) {
			System.out.println("Ungültige Eingabe: " + e.getMessage());
		} catch (ContainerException e) {
			System.out.println("Fehler: " + e.getMessage());
		}
	}

	/**
	 * Diese Methode realisiert die Ausgabe.
	 */
	public void startAusgabe(Scanner scanner) {
		// Hier möchte Herr P. die Liste mit einem eigenen Sortieralgorithmus sortieren und dann
		// ausgeben. Allerdings weiss der Student hier nicht weiter!

		// [Sortierung ausgelassen]
		// Todo: Implementierung Sortierung (F4)
		System.out.println("Befehle:");
		String opts = scanner.nextLine().trim();

		String projectFilter = null;
		Double minPrio = null;
		String sortKey = "prio";

		if (!opts.isEmpty()) {
			for (String tok : opts.split("\\s+")) {
				String[] kv = tok.split("=", 2);
				if (kv.length != 2) continue;
				String k = kv[0].toLowerCase();
				String v = kv[1];

				switch (k) {
					case "project":
						projectFilter = v;
						break;
					case "minprio":
						try {
							minPrio = Double.parseDouble(v);
						} catch (Exception ignored) {
						}
						break;
					case "sort":
						sortKey = v.toLowerCase();
						break;
				}
			}
		}

		Comparator<UserStory> cmp = switch (sortKey){
			case "id"    -> Comparator.comparingInt(UserStory::getId);
			case "value" -> Comparator.comparingInt(UserStory::getValue).reversed();
			case "effort"-> Comparator.comparingInt(UserStory::getEffort);
			default      -> Comparator.comparingDouble(UserStory::getPriority).reversed();
		};

		// Klassische Ausgabe ueber eine For-Each-Schleife
		for (UserStory story : liste) {
			System.out.println(story.toString());
		}

		//  [Variante mit forEach-Methode / Streams (--> Lösung Übung Nr. 2)?
		//  Gerne auch mit Beachtung der neuen US1
		//  (Filterung Projekt = "ein Wert (z.B. Coll@HBRS)" und z.B. Prio >=3
		//  Todo: Implementierung Filterung mit Lambda (F5)

		String project = "Coll@HBRS";
		// ToDo: Filterung nach einem Projekt (F5)
	}

	/*
	 * Methode zum Speichern der Liste. Es wird die komplette Liste
	 * inklusive ihrer gespeicherten UserStory-Objekte gespeichert.
	 *
	 */
	public void store() throws ContainerException {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream( Container.LOCATION );
			oos = new ObjectOutputStream(fos);

			oos.writeObject( this.liste );
			System.out.println( this.size() + " UserStory wurden erfolgreich gespeichert!");
		}
		catch (IOException e) {
			e.printStackTrace();
			//  Delegation in den aufrufendem Context
			// (Anwendung Pattern "Chain Of Responsibility)
			throw new ContainerException("Fehler beim Abspeichern");
		}
	}

	/*
	 * Methode zum Laden der Liste. Es wird die komplette Liste
	 * inklusive ihrer gespeicherten UserStory-Objekte geladen.
	 *
	 */
	public void load() {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream( Container.LOCATION );
			ois = new ObjectInputStream(fis);

			// Auslesen der Liste
			Object obj = ois.readObject();
			if (obj instanceof List<?>) {
				this.liste = (List) obj;
			}
			System.out.println("Es wurden " + this.size() + " UserStory erfolgreich reingeladen!");
		}
		catch (IOException e) {
			System.out.println("LOG (für Admin): Datei konnte nicht gefunden werden!");
		}
		catch (ClassNotFoundException e) {
			System.out.println("LOG (für Admin): Liste konnte nicht extrahiert werden (ClassNotFound)!");
		}
		finally {
			if (ois != null) try { ois.close(); } catch (IOException e) {}
			if (fis != null) try { fis.close(); } catch (IOException e) {}
		}
	}

	/**
	 * Methode zum Hinzufügen eines Mitarbeiters unter Wahrung der Schlüsseleigenschaft
	 * @param userStory
	 * @throws ContainerException
	 */
	public void addUserStory ( UserStory userStory ) throws ContainerException {
		if ( contains(userStory) == true ) {
			ContainerException ex = new ContainerException("ID bereits vorhanden!");
			throw ex;
		}
		liste.add(userStory);
	}

	/**
	 * Prüft, ob eine UserStory bereits vorhanden ist
	 * @param userStory
	 * @return
	 */
	private boolean contains( UserStory userStory) {
		int ID = userStory.getId();
		for ( UserStory userStory1 : liste) {
			if ( userStory1.getId() == ID ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Ermittlung der Anzahl von internen UserStory
	 * -Objekten
	 * @return
	 */
	public int size() {
		return liste.size();
	}

	/**
	 * Methode zur Rückgabe der aktuellen Liste mit Stories
	 * Findet aktuell keine Anwendung bei Hr. P.
	 * @return
	 */
	public List<UserStory> getCurrentList() {
		return this.liste;
	}

	/**
	 * Liefert eine bestimmte UserStory zurück
	 * @param id
	 * @return
	 */
	private UserStory getUserStory(int id) {
		for ( UserStory userStory : liste) {
			if (id == userStory.getId() ){
				return userStory;
			}
		}
		return null;
	}
}
