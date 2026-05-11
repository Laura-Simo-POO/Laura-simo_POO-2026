/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.main;

import ipplanmanager.exception.ConflitVLANException;
import ipplanmanager.model.BesoinReseau;
import ipplanmanager.model.Recommandation;
import ipplanmanager.model.ResultatVLSM;
import ipplanmanager.model.VLAN;
import ipplanmanager.repository.BesoinRepository;
import ipplanmanager.repository.FichierPlanRepository;
import ipplanmanager.service.GestionnaireVLAN;
import ipplanmanager.service.MoteurRecommandation;
import ipplanmanager.service.MoteurVLSM;
import ipplanmanager.service.RapportService;
import ipplanmanager.service.RecommandationGrandVLAN;
import ipplanmanager.service.RecommandationServeurs;
import ipplanmanager.service.RecommandationWifiInvite;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author laura
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("===== IPPlan-Manager : TP9 - Persistance =====");

        // ===== SCENARIO 1 : Universite =====
        String fichierBesoins = "exports/besoins.csv";
        String fichierPlan = "exports/plan_adressage.csv";
        String fichierVlans = "exports/vlans.csv";
        String fichierRecommandations = "exports/recommandations.txt";
        String fichierRapport = "exports/rapport_complet.txt";

        BesoinRepository besoinRepository = new BesoinRepository();
        FichierPlanRepository fichierPlanRepository = new FichierPlanRepository();
        RapportService rapportService = new RapportService();

        try {
            System.out.println("\n===== SCENARIO 1 : Universite =====");
            ArrayList<BesoinReseau> besoins = besoinRepository.chargerBesoins(fichierBesoins);

            MoteurVLSM moteurVLSM = new MoteurVLSM();
            ArrayList<ResultatVLSM> resultats = moteurVLSM.genererPlan("10.10.0.0", besoins);

            GestionnaireVLAN gestionnaireVLAN = new GestionnaireVLAN();
            int numeroVLAN = 10;
            for (ResultatVLSM resultat : resultats) {
                VLAN vlan = new VLAN(numeroVLAN, resultat.getNomBesoin(),
                        resultat, "VLAN " + resultat.getNomBesoin());
                gestionnaireVLAN.ajouterVLAN(vlan);
                numeroVLAN += 10;
            }

            MoteurRecommandation moteurRecommandation = new MoteurRecommandation();
            moteurRecommandation.ajouterRegle(new RecommandationWifiInvite());
            moteurRecommandation.ajouterRegle(new RecommandationServeurs());
            moteurRecommandation.ajouterRegle(new RecommandationGrandVLAN());

            ArrayList<Recommandation> recommandations =
                    moteurRecommandation.analyserVLANs(gestionnaireVLAN.getVlans());

            fichierPlanRepository.sauvegarderPlanCSV(resultats, fichierPlan);
            fichierPlanRepository.sauvegarderVLANsCSV(gestionnaireVLAN.getVlans(), fichierVlans);
            fichierPlanRepository.sauvegarderRecommandations(recommandations, fichierRecommandations);
            rapportService.genererRapportComplet(besoins, resultats,
                    gestionnaireVLAN.getVlans(), recommandations, fichierRapport);

            System.out.println("Fichiers generes : " + fichierRapport);

            // ===== SCENARIO 2 : PME =====
            System.out.println("\n===== SCENARIO 2 : PME =====");
            ArrayList<BesoinReseau> besoinsPme = besoinRepository.chargerBesoins("exports/besoins_pme.csv");

            ArrayList<ResultatVLSM> resultatsPme = moteurVLSM.genererPlan("192.168.1.0", besoinsPme);

            GestionnaireVLAN gestionnairePme = new GestionnaireVLAN();
            numeroVLAN = 10;
            for (ResultatVLSM resultat : resultatsPme) {
                VLAN vlan = new VLAN(numeroVLAN, resultat.getNomBesoin(),
                        resultat, "VLAN " + resultat.getNomBesoin());
                gestionnairePme.ajouterVLAN(vlan);
                numeroVLAN += 10;
            }

            ArrayList<Recommandation> recommandationsPme =
                    moteurRecommandation.analyserVLANs(gestionnairePme.getVlans());

            rapportService.genererRapportComplet(besoinsPme, resultatsPme,
                    gestionnairePme.getVlans(), recommandationsPme, "exports/rapport_pme.txt");

            System.out.println("Fichiers generes : exports/rapport_pme.txt");
            System.out.println("\nTraitement termine avec succes.");

        } catch (IOException e) {
            System.out.println("Erreur de fichier : " + e.getMessage());
        } catch (ConflitVLANException e) {
            System.out.println("Erreur VLAN : " + e.getMessage());
        }
    }
}
