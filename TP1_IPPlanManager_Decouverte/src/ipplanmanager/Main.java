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
         System.out.println("===== IPPlan-Manager : TP1 =====");
         System.out.println("Découverte des premières classes du projet"); 
         System.out.println();

         AdresseIP ipRouteur = new AdresseIP("192.168.1.1");
         AdresseIP ipServeur = new AdresseIP("192.168.1.10"); 
         AdresseIP ipClient = new AdresseIP("192.168.1.50");
                 
         // Un point d'accès WiFi
        AdresseIP ipAP = new AdresseIP("10.0.0.2");
         
         InterfaceReseau interfaceRouteur = new InterfaceReseau("eth0", ipRouteur);
         InterfaceReseau interfaceServeur = new InterfaceReseau("eth0", ipServeur);
         InterfaceReseau interfaceClient = new InterfaceReseau("wlan0", ipClient); 
         
        // On crée l'interface avec "null" pour l'adresse IP
        InterfaceReseau intSwitch = new InterfaceReseau("vlan1", null);
        InterfaceReseau intAP = new InterfaceReseau("wlan0", ipAP);
       
         interfaceRouteur.activer();
         interfaceServeur.activer();
         intAP.activer();
         
         Equipement routeur = new Equipement("R1_EDGE", "Routeur", interfaceRouteur);
         Equipement serveur = new Equipement("SRV_DNS", "Serveur", interfaceServeur);
         Equipement client = new Equipement("PC_ADMIN", "Poste client", interfaceClient);
         
         // nommination de l'interface
         Equipement Switch = new Equipement("SW", "Switch", intSwitch);
         Equipement pointAcces = new Equipement("AP-Bureau", "Access Point", intAP);
         
         ReseauIP reseauPrincipal = new ReseauIP(
                 "192.168.1.0",
                 24,
                 "Réseau principal du laboratoire IRT"
         );
         
         System.out.println("----- Réseau créé -----");
         reseauPrincipal.afficher();
         
         System.out.println();
         System.out.println("----- Équipements créés -----");
         
         System.out.println();
         routeur.afficher(); 
         
         System.out.println();
         serveur.afficher();
         
         
         System.out.println();
         client.afficher();
         
         System.out.println();
         Switch.afficher();
         
         System.out.println();
         pointAcces.afficher();

         // 2. Création et affichage du deuxième réseau (Manquant dans votre code)
         ReseauIP reseauInvite = new ReseauIP("10.0.0.0", 8, "WiFi Invités");
         System.out.println();
         System.out.println("----- Deuxième réseau créé -----");
         reseauInvite.afficher();
    }   
}