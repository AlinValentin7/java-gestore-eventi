package it.milestone.java.gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int postiTotale;
	private int postiPrenotati;
	
	public Evento (String titolo, LocalDate data, int postiTotali) {
		
		 if (data.isBefore(LocalDate.now())) {
	            throw new IllegalArgumentException("La data dell'evento non può essere già passata.");
	        }
		 
		 if (postiTotali <= 0) {
	            throw new IllegalArgumentException("Il numero di posti totali non puo essere negativo.");
	        }
		 
		this.titolo = titolo;
		this.data = data;
		this.postiTotale = postiTotali;
		this.postiPrenotati = 0;		
	}
	
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public int getPostiTotale() {
		return postiTotale;
	}
	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	  private boolean eventoPassato() {
	        return data.isBefore(LocalDate.now());
	    }
	  
	  public void prenota() {
	        if (eventoPassato()) {
	            System.out.println("Impossibile fare una prenotazione, l'evento è gia passato");
	            return;
	        }
	        if (postiPrenotati >= postiTotale) {
	            System.out.println("Impossibile fare una prenotazione, i posti sono tutti occupati.");
	            return;
	        }
	        postiPrenotati++;
	    }
	  
	  public void disdici() {
	        if (eventoPassato()) {
	            System.out.println("Impossibile disdire la prenotazione,  l'evento è già passato.");
	            return;
	        }
	        if (postiPrenotati <= 0) {
	            System.out.println("Impossibile disdire la prenotazione, non ci sono prenotazioni da disdire.");
	            return;
	        }
	        postiPrenotati--;
	    }
	  
	  @Override
	    public String toString() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        return data.format(formatter) + " - " + titolo;
	    }

}
