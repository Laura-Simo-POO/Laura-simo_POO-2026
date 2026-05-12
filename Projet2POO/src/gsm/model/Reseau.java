/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gsm.model;
import gsm.exception.BTSIntrouvableException;
/**
 *
 * @author SIMO M. Laura
 */
public class Reseau {
    private String nom;
    private double bandeFrequenceUplink;
    private double bandeFrequenceDownlink;
    private String typeAccesMultiple;
    private double debitMaxUplink;
    private double debitMaxDownlink;
    private double maxDelai;
    private BTS[] listeBTS;
    private int nombreBTS;

    public Reseau(String nom, double bandeFrequenceUplink,
                  double bandeFrequenceDownlink, String typeAccesMultiple,
                  double debitMaxUplink, double debitMaxDownlink, double maxDelai) {
        this.nom = nom;
        this.bandeFrequenceUplink = bandeFrequenceUplink;
        this.bandeFrequenceDownlink = bandeFrequenceDownlink;
        this.typeAccesMultiple = typeAccesMultiple;
        this.debitMaxUplink = debitMaxUplink;
        this.debitMaxDownlink = debitMaxDownlink;
        this.maxDelai = maxDelai;
        this.listeBTS = new BTS[100];
        this.nombreBTS = 0;
    }

    public String getNom() { return nom; }

    public void ajouterBTS(BTS bts) {
        if (nombreBTS < listeBTS.length) {
            listeBTS[nombreBTS] = bts;
            nombreBTS++;
            System.out.println("BTS " + bts.getNumero() + " ajoutée au réseau.");
        } else {
            System.out.println("Réseau plein, impossible d'ajouter la BTS.");
        }
    }

    public void supprimerBTS(int numero) throws BTSIntrouvableException {
        for (int i = 0; i < nombreBTS; i++) {
            if (listeBTS[i].getNumero() == numero) {
                for (int j = i; j < nombreBTS - 1; j++) {
                    listeBTS[j] = listeBTS[j + 1];
                }
                listeBTS[nombreBTS - 1] = null;
                nombreBTS--;
                System.out.println("BTS " + numero + " supprimée du réseau.");
                return;
            }
        }
        throw new BTSIntrouvableException("BTS " + numero + " introuvable.");
    }

    public BTS rechercherBTS(int numero) throws BTSIntrouvableException {
        for (int i = 0; i < nombreBTS; i++) {
            if (listeBTS[i].getNumero() == numero) {
                return listeBTS[i];
            }
        }
        throw new BTSIntrouvableException("BTS " + numero + " introuvable.");
    }

    public int calculerNombreBTSSaturees() {
        int count = 0;
        for (int i = 0; i < nombreBTS; i++) {
            if (listeBTS[i].estSaturee()) {
                count++;
            }
        }
        return count;
    }

    public int calculerNombreAbonnes() {
        int total = 0;
        for (int i = 0; i < nombreBTS; i++) {
            total += listeBTS[i].getNombreUtilisateurs();
        }
        return total;
    }

    public String rechercherLocalisationMS(String msisdn) {
        for (int i = 0; i < nombreBTS; i++) {
            if (listeBTS[i].rechercherMS(msisdn) != null) {
                return "MS " + msisdn + " localisé dans BTS "
                        + listeBTS[i].getNumero()
                        + " à " + listeBTS[i].getEmplacement();
            }
        }
        return "MS " + msisdn + " introuvable dans le réseau.";
    }

    public void afficherPerformances() {
        System.out.println("=== PERFORMANCES DU RÉSEAU : " + nom + " ===");
        System.out.println("Bande Uplink : "   + bandeFrequenceUplink + " MHz");
        System.out.println("Bande Downlink : " + bandeFrequenceDownlink + " MHz");
        System.out.println("Type accès : "     + typeAccesMultiple);
        System.out.println("Débit max UL : "   + debitMaxUplink + " Mbps");
        System.out.println("Débit max DL : "   + debitMaxDownlink + " Mbps");
        System.out.println("Délai max : "      + maxDelai + " ms");
        System.out.println("Nombre BTS : "     + nombreBTS);
        System.out.println("Nombre abonnés : " + calculerNombreAbonnes());
        System.out.println("BTS saturées : "   + calculerNombreBTSSaturees());
    }

    public void afficherToutesBTS() {
        System.out.println("=== LISTE DES BTS DU RÉSEAU " + nom + " ===");
        if (nombreBTS == 0) {
            System.out.println("Aucune BTS dans le réseau.");
        } else {
            for (int i = 0; i < nombreBTS; i++) {
                listeBTS[i].afficher();
                System.out.println();
            }
        }
    }
}
