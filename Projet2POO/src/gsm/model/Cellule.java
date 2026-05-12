/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gsm.model;

/**
 *
 * @author SIMO M. Laura
 */
public class Cellule {
    private int numeroCellule;
    private double rayonCouverture;
    private double puissanceEmission;
    private int nombreMaxUtilisateurs;
    private MS[] utilisateurs;
    private int nombreUtilisateurs;

    public Cellule(int numeroCellule, double rayonCouverture,
                   double puissanceEmission, int nombreMaxUtilisateurs) {
        this.numeroCellule = numeroCellule;
        this.rayonCouverture = rayonCouverture;
        this.puissanceEmission = puissanceEmission;
        this.nombreMaxUtilisateurs = nombreMaxUtilisateurs;
        this.utilisateurs = new MS[nombreMaxUtilisateurs];
        this.nombreUtilisateurs = 0;
    }

    public int getNumeroCellule()         { return numeroCellule; }
    public double getRayonCouverture()    { return rayonCouverture; }
    public double getPuissanceEmission()  { return puissanceEmission; }
    public int getNombreUtilisateurs()    { return nombreUtilisateurs; }
    public int getNombreMaxUtilisateurs() { return nombreMaxUtilisateurs; }

    public void ajouterMS(MS ms) throws Exception {
        if (nombreUtilisateurs >= nombreMaxUtilisateurs) {
            throw new Exception("Cellule " + numeroCellule + " saturee !");
        }
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getMsisdn().equals(ms.getMsisdn())) {
                throw new Exception("MS " + ms.getMsisdn()
                        + " deja present dans la cellule " + numeroCellule);
            }
        }
        utilisateurs[nombreUtilisateurs] = ms;
        nombreUtilisateurs++;
        System.out.println("MS " + ms.getNom() + " " + ms.getPrenom()
                + " attache a la cellule " + numeroCellule);
    }

    public void supprimerMS(String msisdn) {
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getMsisdn().equals(msisdn)) {
                for (int j = i; j < nombreUtilisateurs - 1; j++) {
                    utilisateurs[j] = utilisateurs[j + 1];
                }
                utilisateurs[nombreUtilisateurs - 1] = null;
                nombreUtilisateurs--;
                System.out.println("MS " + msisdn + " retire de la cellule " + numeroCellule);
                return;
            }
        }
        System.out.println("MS " + msisdn + " introuvable dans la cellule " + numeroCellule);
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
        System.out.println("  -- Cellule " + numeroCellule + " --");
        System.out.println("  Rayon couverture : " + rayonCouverture + " km");
        System.out.println("  Puissance : " + puissanceEmission + " W");
        System.out.println("  Utilisateurs : " + nombreUtilisateurs
                + "/" + nombreMaxUtilisateurs);
        System.out.println("  Etat : " + (estSaturee() ? "SATUREE" : "Disponible"));
    }
}
