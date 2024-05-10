package org.italy.generation;

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int nProdotti;
		System.out.println("Quanti prodotti sono presenti in negozio?");
		nProdotti = sc.nextInt();
		sc.nextLine();

		String[] nome = new String[nProdotti];
		double[] prezzo = new double[nProdotti];
		int[] qnt = new int[nProdotti];
		int i;
		boolean trovato;
		String risposta;
		String prodottoDaAcquistare;
		int qntDaAcquistare;
		double importoTotale = 0;

		for (i = 0; i < nProdotti; i++) { // Inserimento di nome, prezzo e quantità da parte del gestore del negozio

			System.out.println("Inserire il nome del " + (i + 1) + "° prodotto: ");
			nome[i] = sc.nextLine().toLowerCase();
			System.out.println("Inserire la quantità del prodotto " + nome[i] + ": ");
			qnt[i] = sc.nextInt();
			System.out.println("Inserire il prezzo del prodotto " + nome[i] + ": ");
			prezzo[i] = sc.nextDouble();
			sc.nextLine();
		}

		do { // Inizio la sezione in cui il cliente può fare gli acquisti
			System.out.println("Quale prodotto vuoi acquistare?");
			prodottoDaAcquistare = sc.nextLine().toLowerCase();
			trovato = false;
			risposta = "";
			for (i = 0; i < nProdotti; i++) { // inizio la ricerca del prodotto inserito
				if (nome[i].contains(prodottoDaAcquistare)) { // controllo se la stringa inserita è contenuta in uno dei
																// prodotti in negozio
					// adesso voglio controllare che il prodotto trovato corrisponda a quello
					// richiesto dall'utente
					System.out.println(nome[i].substring(0, 1).toUpperCase() + nome[i].substring(1)
							+ " è il prodotto che stavi cercando?");
					risposta = sc.nextLine().toLowerCase();
					while (!(risposta.equals("si") || risposta.equals("sì") || risposta.equals("no"))) {
						// controllo che inserisca una risposta sensata
						System.out.println("Scusa, non ho capito. Puoi ripetere?");
						risposta = sc.nextLine().toLowerCase();
					}
					if (risposta.substring(0, 1).equals("s")) { // il prodotto trovato corrisponde a quello voluto dal
																// cliente
						System.out.println(
								"Ok! Sono rimasti " + qnt[i] + " elementi in negozio. Quanto ne vuoi acquistare?");
						qntDaAcquistare = sc.nextInt();
						sc.nextLine();
						trovato = true;
						if (qntDaAcquistare > qnt[i]) {
							System.out.println(
									"Il prodotto richiesto non è presente in negozio nella quantità richiesta.");
						} else {
							importoTotale = importoTotale + (prezzo[i] * qntDaAcquistare);
							System.out.println("Prodotto aggiunto al carrello. L'importo parziale è: "
									+ (prezzo[i] * qntDaAcquistare) + " euro, mentre il totale è: " + importoTotale
									+ " euro.");
							qnt[i] = qnt[i] - qntDaAcquistare;
						}
						break; // se il prodotto trovato era quello cercato, esco dal ciclo
					} else { // il prodotto trovato non corrisponde a quello cercato dal cliente
						System.out.println("Ok, continueremo a cercare!");
					}

				}
			}
			// controllo se non ho mai trovato il prodotto
			if (trovato == false) {
				System.out.println("Il prodotto richiesto non è presente in negozio.");
			}
			risposta = "";
			System.out.println("Vuoi acquistare altri prodotti?");
			risposta = sc.nextLine().toLowerCase();
			while (!(risposta.equals("si") || risposta.equals("sì") || risposta.equals("no"))) {
				// controllo che inserisca una risposta sensata
				System.out.println("Scusa, non ho capito. Puoi ripetere?");
				risposta = sc.nextLine().toLowerCase();
			}
		} while (risposta.substring(0, 1).equals("s"));
		System.out.println("L'importo totale da pagare è " + importoTotale + " euro. Grazie e arrivederci!");
	}

}
