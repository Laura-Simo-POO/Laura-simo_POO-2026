/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gsm.model;

/**
 *
 * @author SIMO M. Laura
 */

public class Tablet extends MS {
    private double tailleEcran;
    private boolean wifi;

    public Tablet(String nom, String prenom, String motDePasse,
                  String msisdn, String imsi,
                  double tailleEcran, boolean wifi) {
        super(nom, prenom, motDePasse, msisdn, imsi);
        this.tailleEcran = tailleEcran;
        this.wifi = wifi;
    }

    public double getTailleEcran() { return tailleEcran; }
    public boolean isWifi()        { return wifi; }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Type : Tablet");
        System.out.println("Ecran : " + tailleEcran + " pouces");
        System.out.println("WiFi : " + (wifi ? "Oui" : "Non"));
    }
}
