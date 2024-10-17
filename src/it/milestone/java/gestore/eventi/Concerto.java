package it.milestone.java.gestore.eventi;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento{
	private LocalTime ora;
	private double prezzo;

	public Concerto(String titolo, LocalDate data, int postiTotali, LocalTime ora, double prezzo) {
		super(titolo, data, postiTotali);
		if (ora == null) {
            throw new IllegalArgumentException("L'ora non può essere nulla.");
        }
        if (prezzo < 0) {
            throw new IllegalArgumentException("Il prezzo non può essere negativo.");
        }
		this.ora = ora;
		this.prezzo = prezzo;
		
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	
	 public String getDataOraFormattata() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.ITALY);
	        LocalDateTime dataOra = LocalDateTime.of(getData(), ora);
	        return dataOra.format(formatter);
	    }
	 
	 public String getPrezzoFormattato() {
	        return String.format(Locale.ITALY, "%.2f€", prezzo);
	    }
	 
	 @Override
	    public String toString() {
	        return getDataOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
	    }
	 
	 

}
