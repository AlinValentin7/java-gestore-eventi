package it.milestone.java.gestore.eventi;

import java.time.LocalDate;

public class MainProve {
	public static void main(String[] args) {
		
		//Evento evento = new Evento("Untold", LocalDate.of(2025, 03, 12), 10 );
		//Evento evento = new Evento("Untold", LocalDate.of(2022, 03, 12), 10 );
		Evento evento = new Evento("Untold", LocalDate.of(2025, 03, 12), 0 );
		
		for (int i = 0; i < 5; i++) {
            evento.prenota();
        }
		System.out.println("Posti prenotati per l'evento:" + evento.getPostiPrenotati());
		
		for (int i = 0; i < 2; i++) {
            evento.disdici();
        }
		System.out.println("I posti per l' evento dopo avreli disdetti sono:" + evento.getPostiPrenotati());
		
		 for (int i = 0; i < 11; i++) {
             evento.prenota();
         }
         System.out.println("Hai raggiunto il numero massi di posti: " + evento.getPostiPrenotati());
	}
	
	

}
