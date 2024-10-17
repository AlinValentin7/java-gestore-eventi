package it.milestone.java.gestore.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainProve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            boolean continua = true;
            while (continua) {
                System.out.println("Scegli un'opzione:\n" +
                    "1) Gestisci un evento di tipo generico \n" +
                    "2) Gestisci un evento concerto\n" +
                    "3) Esci\n");
                System.out.print("Scelta: ");
                String scelta = scanner.nextLine();

                switch (scelta) {
                    case "1":
                        setEvento(scanner);
                        break;
                    case "2":
                        setConcerto(scanner);
                        break;
                    case "3":
                        continua = false;
                        System.out.println("Uscita dal programma.");
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                }
            }

        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        } finally {
            scanner.close();
        }

    }

    public static void setConcerto(Scanner scanner) {
        Concerto concerto = null;

        try {
            System.out.print("Inserisci il titolo del concerto: ");
            String titolo = scanner.nextLine();

            System.out.print("Inserisci la data del concerto (gg/mm/aaaa): ");
            String dataString = scanner.nextLine();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataString, dateFormatter);

            System.out.print("Inserisci l'ora del concerto (hh:mm): ");
            String oraString = scanner.nextLine();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime ora = LocalTime.parse(oraString, timeFormatter);

            System.out.print("Inserisci il numero di posti totali: ");
            int postiTotali = Integer.parseInt(scanner.nextLine());

            System.out.print("Inserisci il prezzo del biglietto: ");
            double prezzo = Double.parseDouble(scanner.nextLine());

            concerto = new Concerto(titolo, data, postiTotali, ora, prezzo);
            System.out.println("\nConcerto creato:\n " + concerto);

            boolean continua = true;
            while (continua) {
                System.out.println("\nScegli un'opzione:\n" +
                    "1) Prenota posti\n" +
                    "2) Disdici posti\n" +
                    "3) Visualizza posti prenotati e disponibili\n" +
                    "4) Visualizza dettagli del concerto\n" +
                    "5) Esci\n");
                System.out.print("Scelta: ");
                String scelta = scanner.nextLine();

                switch (scelta) {
                    case "1":
                        System.out.print("Quanti posti vuoi prenotare? ");
                        int numeroPrenotazioni = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < numeroPrenotazioni; i++) {
                            if (!concerto.prenota()) {
                                break;
                            }
                        }
                        break;

                    case "2":
                        System.out.print("Quanti posti vuoi disdire? ");
                        int numeroDisdette = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < numeroDisdette; i++) {
                            if (!concerto.disdici()) {
                                break;
                            }
                        }
                        break;

                    case "3":
                        System.out.println("Posti prenotati: " + concerto.getPostiPrenotati());
                        System.out.println("Posti disponibili: " + (concerto.getPostiTotale() - concerto.getPostiPrenotati()));
                        break;

                    case "4":
                        System.out.println(concerto.toString());
                        break;

                    case "5":
                        continua = false;
                        System.out.println("Uscita dal programma.");
                        break;

                    default:
                        System.out.println("Scelta non valida. Riprova.");
                }
            }

        } catch (DateTimeParseException e) {
            System.err.println("Formato data o ora non valido. Assicurati di inserire la data nel formato gg/mm/aaaa e l'ora nel formato hh:mm.");
        } catch (NumberFormatException e) {
            System.err.println("Formato numero non valido. Assicurati di inserire un numero valido.");
        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        }
        
    }

    public static void setEvento(Scanner scanner) {
        Evento evento = null;
        try {
            System.out.print("Inserisci il titolo dell'evento: ");
            String titolo = scanner.nextLine();

            System.out.print("Inserisci la data dell'evento (gg/mm/aaaa): ");
            String dataString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataString, formatter);

            System.out.print("Inserisci il numero di posti totali: ");
            int postiTotali = Integer.parseInt(scanner.nextLine());

            evento = new Evento(titolo, data, postiTotali);
            System.out.println("\nEvento creato:\n " + evento);

            boolean continua = true;
            while (continua) {
                System.out.println("\nScegli un'opzione:\n" +
                    "1) Prenota posti\n" +
                    "2) Disdici posti\n" +
                    "3) Visualizza posti prenotati e disponibili\n" +
                    "4) Esci\n");
                System.out.print("Scelta: ");
                String scelta = scanner.nextLine();

                switch (scelta) {
                    case "1":
                        System.out.print("Quanti posti vuoi prenotare? ");
                        int numeroPrenotazioni = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < numeroPrenotazioni; i++) {
                            if (!evento.prenota()) {
                                break;
                            }
                        }
                        break;

                    case "2":
                        System.out.print("Quanti posti vuoi disdire? ");
                        int numeroDisdette = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < numeroDisdette; i++) {
                            if (!evento.disdici()) {
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
            System.err.println("Formato data non valido. Assicurati di inserire la data nel formato gg/mm/aaaa.");

        } catch (NumberFormatException e) {
            System.err.println("Formato numero non valido. Assicurati di inserire un numero intero.");

        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());

        }
        
    }

}

