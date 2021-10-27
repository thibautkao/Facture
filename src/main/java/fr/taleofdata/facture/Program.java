package fr.taleofdata.facture;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Program {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

            System.out.println("Voici notre catalogue de vehicule de location");
            System.out.println("1 - Basic - 20 euro/jour -1 point/jour");
            System.out.println("2 - Business - 30 euro/jour - 3 points/jour");
            System.out.println("3 - Luxury - 50 euro/jour - 7 points/jour");
            System.out.println("Saisisez la periode de location et la categorie de vehicule :");

        LocalDate debut = lireDate("Début de la location : ");
        LocalDate fin = lireDate("Fin de la location : ");
        int idcat = lireEntier("Choisir la categorie du vehicule: ");

        boolean dateOK = testerDates(debut, fin);
        boolean categorieOK = testerCategories(idcat);

        if (dateOK && categorieOK) {
            int point = lirepoint(idcat);
            int prix = lireprix(idcat);
            afficherFacture(debut, fin, idcat);
        } else

            System.out.println("Merci, de reprendre la saisie des données");

    }

    /**
     * Demande à l'utilisateur d'entrer un entier.
     *
     * @param message Le message affiché à l'utilisateur
     * @return L'entier entré par l'utilisateur qui correspond à l'id de la categorie
     */


    static int lireEntier(String message) {

        System.out.print(message);
        int entier = scanner.nextInt();
        return entier;
    }


    static LocalDate lireDate(String message) {

        System.out.print(message);
        String date = scanner.next();
        return LocalDate.parse(date);
    }

    /**
     * Vérifie si les données entrées sont cohérentes.
     *
     * @param debut date de début de location
     * @param fin   date de fin de location
     * @return true si la fin est après le début
     */
    static boolean testerDates(LocalDate debut, LocalDate fin) {
        if (ChronoUnit.DAYS.between(debut, fin) <= 0) {
            System.out.println("Bizarre, vous n'avez pas " +
                    "choisis la bonne periode ...");
            return false;
        }

        return true;
    }

    static boolean testerCategories(int idcat) {

        for (Facturation facture : Facturation.renvoiListe()) {
            if (idcat == facture.getIdCat()) {
                return true;

            }


        }
        return false;

    }

    /**
     *
     * @param debut début de location
     * @param fin    fin de la location
     * recuperer le prix du vehicule choisis
     */
    static int lireprix(int idcat) {
        int result = 0;
        for (Facturation facture : Facturation.renvoiListe()) {
            if (idcat == facture.getIdCat()) {
                result = facture.getPrix();
            }
        }
        return result;
    }
    /**
     *
     * @param debut début de location
     * @param fin    fin de la location
     * recuperer le point du vehicule choisis
     */

    static int lirepoint(int idcat) {
        int result = 0;
        for (Facturation facture : Facturation.renvoiListe()) {
            if (idcat == facture.getIdCat()) {
                result = facture.getPoints();
            }
        }
        return result;

    }

    /**
     * Affiche le prix à payer par l'utilisateur
     *
     * @param debut
     * @param fin
     */
    static void afficherFacture(LocalDate debut, LocalDate fin, int idcat) {

        int prix = lireprix(idcat);
        int point = lirepoint(idcat);
        int nbjr = (int) ChronoUnit.DAYS.between(debut, fin);
        int prixTTC = (int) (ChronoUnit.DAYS.between(debut, fin) * prix);
        int points = (int) (ChronoUnit.DAYS.between(debut, fin) * point);

        System.out.println("Votre Facture sur " +nbjr+ " jours est de  "
                + prixTTC + " Euros avec " + points + " Points");
    }


}
