/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gsm.model;

/**
 *
 * @author SIMO M. Laura
 */
public class MS {
    private String nom;
    private String prenom;
    private String motDePasse;
    private String msisdn;
    private String imsi;
    private String[] appelsRecus;
    private int nombreAppels;

    public MS(String nom, String prenom, String motDePasse, String msisdn, String imsi) {
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.msisdn = msisdn;
        this.imsi = imsi;
        this.appelsRecus = new String[50];
        this.nombreAppels = 0;
    }

    public String getNom()        { return nom; }
    public String getPrenom()     { return prenom; }
    public String getMsisdn()     { return msisdn; }
    public String getImsi()       { return imsi; }

    public void recevoirAppel(String appelant) {
        if (nombreAppels < appelsRecus.length) {
            appelsRecus[nombreAppels] = appelant;
            nombreAppels++;
            System.out.println(nom + " " + prenom + " reçoit un appel de : " + appelant);
        } else {
            System.out.println("Boîte d'appels pleine.");
        }
    }

    public void appeler(MS destinataire) {
        System.out.println(nom + " " + prenom + " appelle " + destinataire.getNom()
                + " " + destinataire.getPrenom());
        destinataire.recevoirAppel(this.msisdn);
    }

    public void afficherAppelsRecus() {
        System.out.println("=== Appels reçus de " + nom + " " + prenom + " ===");
        if (nombreAppels == 0) {
            System.out.println("Aucun appel reçu.");
        } else {
            for (int i = 0; i < nombreAppels; i++) {
                System.out.println("- " + appelsRecus[i]);
            }
        }
    }

    public void afficher() {
        System.out.println("=== MS ===");
        System.out.println("Nom : " + nom + " " + prenom);
        System.out.println("MSISDN : " + msisdn);
        System.out.println("IMSI : " + imsi);
    }

    public boolean verifierMotDePasse(String mdp) {
        return this.motDePasse.equals(mdp);
    }
}

