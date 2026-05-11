/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author laura
 */
public class Main {
    
    public static void main(String[] args) {
        InfrastructureReseau infrastructure = new InfrastructureReseau("Infrastructure YFY");
        ReseauIP reseauAdmin = new ReseauIP("192.168.1.0", 24, "Reseau Administration");
        ReseauIP reseauTechnique = new ReseauIP("172.16.0.0", 16, "Reseau Technique");
        ReseauIP reseauWifi = new ReseauIP("10.0.0.0", 8, "Reseau WiFi");
        ReseauIP reseauServeurs = new ReseauIP("192.168.2.0", 25, "Reseau Serveurs");
        ReseauIP reseauDMZ = new ReseauIP("192.168.3.0", 26, "Reseau DMZ");
     
        SousReseau admin = new SousReseau("ADMIN", reseauAdmin);
        SousReseau tech = new SousReseau("TECH", reseauTechnique);
        SousReseau wifi = new SousReseau("WIFI", reseauWifi);
        SousReseau serveurs = new SousReseau("SERVEURS", reseauServeurs);
        SousReseau dmz = new SousReseau("DMZ", reseauDMZ);

        infrastructure.ajouterSousReseau(admin);
        infrastructure.ajouterSousReseau(tech);
        infrastructure.ajouterSousReseau(wifi);
        infrastructure.ajouterSousReseau(serveurs);
        infrastructure.ajouterSousReseau(dmz);

        // ===== AFFICHAGE =====
        infrastructure.afficher();

        // ===== TEST estReseauPrive =====
        System.out.println("===== TEST RESEAU PRIVE =====");
        System.out.println("192.168.1.0 prive : "
                + CalculateurReseau.estReseauPrive("192.168.1.0"));
        System.out.println("172.16.0.0 prive  : "
                + CalculateurReseau.estReseauPrive("172.16.0.0"));
        System.out.println("10.0.0.0 prive    : "
                + CalculateurReseau.estReseauPrive("10.0.0.0"));
        System.out.println("8.8.8.8 prive     : "
                + CalculateurReseau.estReseauPrive("8.8.8.8"));
    }
}
 
