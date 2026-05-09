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
        
        ReseauIP reseauAdmin = new ReseauIP("192.168.1.0", 24, "Réseau administration");
        ReseauIP reseauTech = new ReseauIP("192.168.2.0", 24, "Réseau technique");
        ReseauIP reseauWiFi = new ReseauIP("192.168.3.0", 24, "Reseau WiFi");
        
                 //sous-réseaux
        SousReseau admin = new SousReseau("ADMIN", reseauAdmin);
        SousReseau tech = new SousReseau("TECH", reseauTech);
        SousReseau wifi = new SousReseau("WIFI", reseauWiFi);
        
        infrastructure.ajouterSousReseau(admin);
        infrastructure.ajouterSousReseau(tech);
        infrastructure.ajouterSousReseau(wifi);
        
                //Routeur
        AdresseIP ip1 = new AdresseIP("192.168.1.1");
        AdresseIP ip2 = new AdresseIP("10.0.0.1");

        
        InterfaceReseau eth0 = new InterfaceReseau("eth0", ip1);
        InterfaceReseau eth1 = new InterfaceReseau("eth1", ip2);
        
        eth0.activer();
        eth1.activer();
        
        Equipement routeur = new Equipement("R1_EDGE", "Routeur");
        routeur.ajouterInterface(eth0);
        routeur.ajouterInterface(eth1);
        
        infrastructure.ajouterEquipement(routeur);
        
                //SWITCHS
        AdresseIP ipSw1 = new AdresseIP("192.168.1.2");
        AdresseIP ipSw2 = new AdresseIP("192.168.2.2");
        AdresseIP ipSw3 = new AdresseIP("192.168.3.2");
        
        InterfaceReseau sweth0 = new InterfaceReseau("GigaEthernet0/0", ipSw1);       
        InterfaceReseau sweth1 = new InterfaceReseau("GigaEthernet0/1", ipSw2);        
        InterfaceReseau sweth2 = new InterfaceReseau("GigaEthernet0/2", ipSw3);
        
        sweth0.activer();
        sweth1.activer();
        sweth2.activer();
        
        Equipement sw1 = new Equipement("SW1_CORE", "Switch");
        sw1.ajouterInterface(sweth0);
        sw1.ajouterInterface(sweth1);
        sw1.ajouterInterface(sweth2);        
        
        infrastructure.ajouterEquipement(sw1);
        
                //Serveur WEB
        AdresseIP ipServ1 = new AdresseIP("192.168.1.10");
        AdresseIP ipServ2 = new AdresseIP("192.168.2.10");
        
        InterfaceReseau serveth0 = new InterfaceReseau("eth0", ipServ1);       
        InterfaceReseau serveth1 = new InterfaceReseau("eth1", ipServ2);        
        
        serveth0.activer();
        
        Equipement serveurWeb = new Equipement("SRV_WEB", "Serveur");
        serveurWeb.ajouterInterface(serveth0);
        serveurWeb.ajouterInterface(serveth1);        
        
        infrastructure.ajouterEquipement(serveurWeb);
        
          // ===== SERVEUR BASE DE DONNÉES =====
        AdresseIP ipDB1 = new AdresseIP("192.168.1.20");
        AdresseIP ipDB2 = new AdresseIP("192.168.2.20");
        
        InterfaceReseau dbEth0 = new InterfaceReseau("eth0", ipDB1);
        InterfaceReseau dbEth1 = new InterfaceReseau("eth1", ipDB2);
        
        dbEth0.activer();
        dbEth1.activer();
        
        Equipement serveurDB = new Equipement("SRV_DB", "Serveur");
        serveurDB.ajouterInterface(dbEth0);
        serveurDB.ajouterInterface(dbEth1);
        
        infrastructure.ajouterEquipement(serveurDB);

        // ===== POINT D'ACCÈS WIFI =====
        AdresseIP ipAP1 = new AdresseIP("192.168.3.1");
        AdresseIP ipAP2 = new AdresseIP("192.168.1.100");
        
        InterfaceReseau apEth0 = new InterfaceReseau("eth0", ipAP1);
        InterfaceReseau apWlan0 = new InterfaceReseau("wlan0", ipAP2);
        
        apEth0.activer();
        apWlan0.activer();
        
        Equipement pointAcces = new Equipement("AP_WIFI_01", "Point d'acces WiFi");
        pointAcces.ajouterInterface(apEth0);
        pointAcces.ajouterInterface(apWlan0);
        
        infrastructure.ajouterEquipement(pointAcces);

        // ===== FIREWALL =====
        AdresseIP ipFw1 = new AdresseIP("10.0.0.2");
        AdresseIP ipFw2 = new AdresseIP("192.168.1.254");
        AdresseIP ipFw3 = new AdresseIP("192.168.2.254");
        
        InterfaceReseau fwWan = new InterfaceReseau("WAN", ipFw1);
        InterfaceReseau fwLan1 = new InterfaceReseau("LAN1", ipFw2);
        InterfaceReseau fwLan2 = new InterfaceReseau("LAN2", ipFw3);
        
        fwWan.activer();
        fwLan1.activer();
        fwLan2.activer();
        
        Equipement firewall = new Equipement("FW_BORDER", "Firewall");
        firewall.ajouterInterface(fwWan);
        firewall.ajouterInterface(fwLan1);
        firewall.ajouterInterface(fwLan2);
        
        infrastructure.ajouterEquipement(firewall);
        
                //Affichage
        infrastructure.afficher();
        
                //Test
        System.out.println("===== TEST RECHERCHE =====");
        infrastructure.rechercherEquipement("SW1_CORE");
        System.out.println();
        infrastructure.rechercherEquipement("EQUIPEMENT_INEXISTANT");
    }
}