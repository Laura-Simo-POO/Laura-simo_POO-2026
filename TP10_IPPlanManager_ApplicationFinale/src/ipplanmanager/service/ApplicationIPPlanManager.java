package ipplanmanager.service;

import ipplanmanager.model.*;
import ipplanmanager.repository.*;
import ipplanmanager.console.ConsoleService;
import java.util.ArrayList;

/**
 * @author laura
 */
public class ApplicationIPPlanManager {
    private ConsoleService console = new ConsoleService();
    private MoteurVLSM moteurVLSM = new MoteurVLSM();
    private GestionnaireVLAN gestionnaireVLAN = new GestionnaireVLAN();
    private MoteurRecommandation moteurRecommandation = new MoteurRecommandation();
    private FichierPlanRepository fichierRepo = new FichierPlanRepository();

    public void demarrer() {
        int choix = 0;
        while (choix != 3) {
            System.out.println("\n===== MENU IPPLAN-MANAGER (SIKOMPE) =====");
            System.out.println("1. Saisir les besoins manuellement");
            System.out.println("2. Charger les besoins depuis un fichier CSV");
            System.out.println("3. Quitter");
            choix = console.saisirEntier("Choix : ");

            if (choix == 1) {
                lancerTraitement(null);
            } else if (choix == 2) {
                String path = console.saisirTexte("Chemin du fichier : ");
                BesoinRepository repo = new BesoinRepository();
  
            }
        }
    }

    private void lancerTraitement(ArrayList<BesoinReseau> besoins) {
        try {
            String nom = console.saisirTexte("Nom du projet : ");
            String ip = console.saisirTexte("IP de départ : ");
            if (besoins == null) besoins = console.saisirBesoins();

            this.gestionnaireVLAN.viderVlans();
            
            // Calcul du plan
            ArrayList<ResultatVLSM> resultats = moteurVLSM.genererPlan(ip, besoins);
            
            // Correction de l'erreur : on passe la liste et on gère l'exception
            this.genererVLANS(resultats); 
            
            // Recommandations
            ArrayList<Recommandation> recs = moteurRecommandation.genererRecommandations(gestionnaireVLAN.getVlans());

            // Sauvegarde
            fichierRepo.sauvegarderPlanCSV(resultats, "exports/" + nom + "_plan.csv");
            System.out.println("✅ Dossier 'exports' mis à jour.");

        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    // La méthode doit être déclarée ainsi pour accepter les résultats
    private void genererVLANS(ArrayList<ResultatVLSM> resultats) {
        int id = 10;
        for (ResultatVLSM r : resultats) {
            VLAN v = new VLAN(id, r.getNomBesoin());
            v.setReseauAssocie(r);
            id += 10;
        }
    }
}