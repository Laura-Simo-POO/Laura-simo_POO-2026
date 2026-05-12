/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gsm.model;
import gsm.exception.BTSSatureException;
import gsm.exception.MSDejaAttacheException;
/**
 *
 * @author SIMO M. Laura
 */
public class BTS {
    private int numero;
    private String emplacement;
    private double hauteur;
    private String typeMilieu;
    private int nombreMaxUtilisateurs;
    private MS[] utilisateurs;
    private int nombreUtilisateurs;
    private Cellule[] cellules;
    private int nombreCellules;

    public BTS(int numero, String emplacement, double hauteur,
               String typeMilieu, int nombreMaxUtilisateurs) {
        this.numero = numero;
        this.emplacement = emplacement;
        this.hauteur = hauteur;
        this.typeMilieu = typeMilieu;
        this.nombreMaxUtilisateurs = nombreMaxUtilisateurs;
        this.utilisateurs = new MS[nombreMaxUtilisateurs];
        this.nombreUtilisateurs = 0;
        this.cellules = new Cellule[10];
        this.nombreCellules = 0;
    }

    public int getNumero()               { return numero; }
    public String getEmplacement()       { return emplacement; }
    public int getNombreUtilisateurs()   { return nombreUtilisateurs; }
    public int getNombreMaxUtilisateurs(){ return nombreMaxUtilisateurs; }
    public int getNombreCellules()       { return nombreCellules; }

    public void ajouterCellule(Cellule cellule) {
        if (nombreCellules < cellules.length) {
            cellules[nombreCellules] = cellule;
            nombreCellules++;
            System.out.println("Cellule " + cellule.getNumeroCellule()
                    + " ajoutee a BTS " + numero);
        } else {
            System.out.println("BTS " + numero + " : nombre max de cellules atteint.");
        }
    }

    public void afficherCellules() {
        System.out.println("=== Cellules de BTS " + numero + " ===");
        if (nombreCellules == 0) {
            System.out.println("Aucune cellule.");
        } else {
            for (int i = 0; i < nombreCellules; i++) {
                cellules[i].afficher();
            }
        }
    }

    public void ajouterMS(MS ms) throws BTSSatureException, MSDejaAttacheException {
        if (nombreUtilisateurs >= nombreMaxUtilisateurs) {
            throw new BTSSatureException("BTS " + numero + " est saturee !");
        }
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getMsisdn().equals(ms.getMsisdn())) {
                throw new MSDejaAttacheException("MS " + ms.getMsisdn()
                        + " est deja attache a cette BTS.");
            }
        }
        utilisateurs[nombreUtilisateurs] = ms;
        nombreUtilisateurs++;
        System.out.println("MS " + ms.getNom() + " " + ms.getPrenom()
                + " attache a BTS " + numero);
    }

    public void supprimerMS(String msisdn) {
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getMsisdn().equals(msisdn)) {
                for (int j = i; j < nombreUtilisateurs - 1; j++) {
                    utilisateurs[j] = utilisateurs[j + 1];
                }
                utilisateurs[nombreUtilisateurs - 1] = null;
                nombreUtilisateurs--;
                System.out.println("MS " + msisdn + " retire de BTS " + numero);
                return;
            }
        }
        System.out.println("MS " + msisdn + " introuvable dans BTS " + numero);
    }

    public MS rechercherMS(String msisdn) {
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getMsisdn().equals(msisdn)) {
                return utilisateurs[i];
            }
        }
        return null;
    }

    public boolean estSaturee() {
        return nombreUtilisateurs >= nombreMaxUtilisateurs;
    }

    public void afficher() {
        System.out.println("=== BTS " + numero + " ===");
        System.out.println("Emplacement : " + emplacement);
        System.out.println("Hauteur : " + hauteur + " m");
        System.out.println("Type milieu : " + typeMilieu);
        System.out.println("Utilisateurs : " + nombreUtilisateurs
                + "/" + nombreMaxUtilisateurs);
        System.out.println("Etat : " + (estSaturee() ? "SATUREE" : "Disponible"));
        System.out.println("Nombre de cellules : " + nombreCellules);
    }

    public void afficherTousLesMS() {
        System.out.println("=== MS attaches a BTS " + numero + " ===");
        if (nombreUtilisateurs == 0) {
            System.out.println("Aucun MS attache.");
        } else {
            for (int i = 0; i < nombreUtilisateurs; i++) {
                utilisateurs[i].afficher();
                System.out.println();
            }
        }
    }
}
