/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gsm.main;
import gsm.exception.BTSIntrouvableException;
import gsm.exception.BTSSatureException;
import gsm.exception.MSDejaAttacheException;
import gsm.model.BTS;
import gsm.model.Cellule;
import gsm.model.MS;
import gsm.model.Reseau;
import gsm.model.Smartphone;
import gsm.model.Tablet;
/**
 *
 * @author SIMO M. Laura
 */
public class TestReseau {
    public static void main(String[] args) {

        System.out.println("=============================");
        System.out.println("  Etudiante : SIMO M. LAURA");
        System.out.println("  Projet 2 POO - Reseau GSM");
        System.out.println("=============================\n");

        // === Création du réseau ===
        Reseau reseau = new Reseau(
                "Reseau GSM Cameroun",
                890.0, 935.0,
                "TDMA",
                14.4, 14.4, 20.0
        );

        // === Création des BTS ===
        BTS bts1 = new BTS(1, "Yaounde Centre", 30.0, "Urbain", 3);
        BTS bts2 = new BTS(2, "Douala Port",    25.0, "Urbain", 2);
        BTS bts3 = new BTS(3, "Bafoussam",      20.0, "Rural",  2);

        // === Création des cellules ===
        Cellule c1 = new Cellule(1, 1.0, 20.0, 2);
        Cellule c2 = new Cellule(2, 1.5, 25.0, 2);
        Cellule c3 = new Cellule(3, 2.0, 30.0, 2);
        Cellule c4 = new Cellule(4, 1.0, 20.0, 1);
        Cellule c5 = new Cellule(5, 3.0, 35.0, 2);

        // === Ajout des cellules aux BTS ===
        System.out.println("--- Ajout des cellules aux BTS ---");
        bts1.ajouterCellule(c1);
        bts1.ajouterCellule(c2);
        bts2.ajouterCellule(c3);
        bts2.ajouterCellule(c4);
        bts3.ajouterCellule(c5);

        // === Ajout des BTS au réseau ===
        System.out.println("\n--- Ajout des BTS au reseau ---");
        reseau.ajouterBTS(bts1);
        reseau.ajouterBTS(bts2);
        reseau.ajouterBTS(bts3);

        // === Création des MS ===
        Smartphone sm1 = new Smartphone(
                "Simo m.", "Laura", "1234",
                "699000001", "208010000000001",
                "Android", 6.5
        );
        Smartphone sm2 = new Smartphone(
                "Mbarga", "Pierre", "5678",
                "699000002", "208010000000002",
                "iOS", 6.1
        );
        Tablet tab1 = new Tablet(
                "Nkeng", "Marie", "abcd",
                "699000003", "208010000000003",
                10.5, true
        );
        MS ms4 = new MS("Fopa", "Jean",  "pass",  "699000004", "208010000000004");
        MS ms5 = new MS("Tabi", "Alice", "pass2", "699000005", "208010000000005");

        // === Attachement des MS aux BTS ===
        System.out.println("\n--- Attachement des MS aux BTS ---");
        try {
            bts1.ajouterMS(sm1);
            bts1.ajouterMS(sm2);
            bts1.ajouterMS(tab1);
            bts2.ajouterMS(ms4);
            bts2.ajouterMS(ms5);
            bts3.ajouterMS(sm1);
        } catch (BTSSatureException e) {
            System.out.println("Erreur saturation : " + e.getMessage());
        } catch (MSDejaAttacheException e) {
            System.out.println("Erreur doublon : " + e.getMessage());
        }

        // === Test saturation ===
        System.out.println("\n--- Test saturation BTS2 ---");
        try {
            MS msExtra = new MS("Extra", "User", "000",
                    "699000099", "208010000000099");
            bts2.ajouterMS(msExtra);
        } catch (BTSSatureException e) {
            System.out.println("Erreur saturation : " + e.getMessage());
        } catch (MSDejaAttacheException e) {
            System.out.println("Erreur doublon : " + e.getMessage());
        }

        // === Test doublon MS ===
        System.out.println("\n--- Test doublon MS ---");
        try {
            bts1.ajouterMS(sm1);
        } catch (BTSSatureException e) {
            System.out.println("Erreur saturation : " + e.getMessage());
        } catch (MSDejaAttacheException e) {
            System.out.println("Erreur doublon : " + e.getMessage());
        }

        // === Affichage cellules ===
        System.out.println("\n--- Cellules de BTS1 ---");
        bts1.afficherCellules();

        System.out.println("\n--- Cellules de BTS2 ---");
        bts2.afficherCellules();

        System.out.println("\n--- Cellules de BTS3 ---");
        bts3.afficherCellules();

        // === Affichage performances ===
        System.out.println("\n--- Performances du reseau ---");
        reseau.afficherPerformances();

        // === Affichage toutes les BTS ===
        System.out.println("\n--- Liste des BTS ---");
        reseau.afficherToutesBTS();

        // === Recherche localisation MS ===
        System.out.println("\n--- Localisation des MS ---");
        System.out.println(reseau.rechercherLocalisationMS("699000002"));
        System.out.println(reseau.rechercherLocalisationMS("699999999"));

        // === Test appel entre MS ===
        System.out.println("\n--- Test appel ---");
        sm1.appeler(sm2);
        sm1.appeler(tab1);
        ms4.appeler(sm1);

        // === Affichage appels reçus ===
        System.out.println("\n--- Appels recus de sm1 ---");
        sm1.afficherAppelsRecus();

        System.out.println("\n--- Appels recus de sm2 ---");
        sm2.afficherAppelsRecus();

        // === Affichage détaillé MS ===
        System.out.println("\n--- Details des MS ---");
        sm1.afficher();
        System.out.println();
        tab1.afficher();

        // === Test suppression MS ===
        System.out.println("\n--- Suppression MS de BTS1 ---");
        bts1.supprimerMS("699000001");
        bts1.afficherTousLesMS();

        // === Test suppression BTS ===
        System.out.println("\n--- Suppression BTS 3 ---");
        try {
            reseau.supprimerBTS(3);
        } catch (BTSIntrouvableException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        // === Test BTS introuvable ===
        System.out.println("\n--- Test BTS introuvable ---");
        try {
            reseau.rechercherBTS(99);
        } catch (BTSIntrouvableException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        // === Performances finales ===
        System.out.println("\n--- Performances finales ---");
        reseau.afficherPerformances();

        System.out.println("\n=============================");
        System.out.println("  Fin des tests - SIMO M. LAURA");
        System.out.println("=============================");
    }
}

