package it.milestone.java.gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MainProve {
	public static void main(String[] args) {
		
		//Evento evento = new Evento("Untold", LocalDate.of(2025, 03, 12), 10 );
		//Evento evento = new Evento("Untold", LocalDate.of(2022, 03, 12), 10 );
		//Evento evento = new Evento("Untold", LocalDate.of(2025, 03, 12), 0 );
		
		 Scanner scanner = new Scanner(System.in);
	        Evento evento = null;
	        try {
	            System.out.print("Inserisci il titolo dell'evento: ");
	            String titolo = scanner.nextLine();

	            System.out.print("Inserisci la data dell'evento (dd/mm/yyyy): ");
	            String dataString = scanner.nextLine();
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	            LocalDate data = LocalDate.parse(dataString, formatter);

	            System.out.print("Inserisci il numero di posti totali: ");
	            int postiTotali = Integer.parseInt(scanner.nextLine());

	           
	            evento = new Evento(titolo, data, postiTotali);
	            System.out.println("\nEvento creato: " + evento);

	            
	            boolean continua = true;
	            while (continua) {
	                System.out.println("Scegli un'opzione:\n" + 
	                					"1) Prenota posti\n"+
	                					"2) Disdici posti\n" +
	                					"3) Visualizza posti prenotati e disponibili\n"+
	                					"4) Esci");
	                System.out.print("Scelta: ");
	                String scelta = scanner.nextLine();

	                switch (scelta) {
	                    case "1":
	                        System.out.print("Quanti posti vuoi prenotare? ");
	                        int numeroPrenotazioni = Integer.parseInt(scanner.nextLine());
	                        for (int i = 0; i < numeroPrenotazioni; i++) {
	                            if (!evento.prenota()) {
	                                System.out.println("Non è stato possibile effettuare la prenotazione n° " + (i + 1));
	                                break;
	                            }
	                        }
	                        break;

	                    case "2":
	                        System.out.print("Quanti posti vuoi disdire? ");
	                        int numeroDisdette = Integer.parseInt(scanner.nextLine());
	                        for (int i = 0; i < numeroDisdette; i++) {
	                            if (!evento.disdici()) {
	                                System.out.println("Non è stato possibile effettuare la disdetta n° " + (i + 1));
	                                break;
	                            }
	                        }
	                        break;

	                    case "3":
	                        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
	                        System.out.println("Posti disponibili: " + (evento.getPostiTotale() - evento.getPostiPrenotati()));
	                        break;

	                    case "4":
	                        continua = false;
	                        System.out.println("Uscita dal programma.");
	                        break;

	                    default:
	                        System.out.println("Scelta non valida. Riprova.");
	                }
	            }

	        } catch (DateTimeParseException e) {
	            System.err.println("Formato data non valido. Assicurati di inserire la data nel formato dd/MM/yyyy.");
	            
	        } catch (NumberFormatException e) {
	            System.err.println("Formato numero non valido. Assicurati di inserire un numero intero.");
	            
	        } catch (IllegalArgumentException e) {
	            System.err.println("Errore: " + e.getMessage());
	            
	        } finally {
	            scanner.close();
	        }
	    }
	
        

}

