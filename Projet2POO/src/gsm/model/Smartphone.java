/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gsm.model;

/**
 *
 * @author SIMO M. Laura
 */

public class Smartphone extends MS {
    private String systemeExploitation;
    private double tailleEcran;

    public Smartphone(String nom, String prenom, String motDePasse,
                      String msisdn, String imsi,
                      String systemeExploitation, double tailleEcran) {
        super(nom, prenom, motDePasse, msisdn, imsi);
        this.systemeExploitation = systemeExploitation;
        this.tailleEcran = tailleEcran;
    }

    public String getSystemeExploitation() { return systemeExploitation; }
    public double getTailleEcran()         { return tailleEcran; }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Type : Smartphone");
        System.out.println("OS : " + systemeExploitation);
        System.out.println("Ecran : " + tailleEcran + " pouces");
    }
}
