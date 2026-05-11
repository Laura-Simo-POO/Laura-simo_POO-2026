/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;

import ipplanmanager.model.Recommandation;
import ipplanmanager.model.ResultatVLSM;
import ipplanmanager.model.VLAN;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author laura
 */
public class RapportService {
    public void genererRapport(String nomProjet,
                               ArrayList<ResultatVLSM> resultats,
                               ArrayList<VLAN> vlans,
                               ArrayList<Recommandation> recommandations,
                               String cheminFichier) throws IOException {

        FileWriter writer = new FileWriter(cheminFichier);

        writer.write("==========================================\n");
        writer.write("   RAPPORT TECHNIQUE - " + nomProjet + "\n");
        writer.write("==========================================\n\n");

        writer.write("--- PLAN D'ADRESSAGE VLSM ---\n");
        for (ResultatVLSM r : resultats) {
            writer.write(r.getNomBesoin() + " -> " + r.getAdresseReseau() + "/" + r.getCidr()
                    + " | Masque : "   + r.getMasqueDecimal()
                    + " | Demandés : " + r.getHotesDemandes()
                    + " | Capacité : " + r.getCapacite()
                    + " | Marge : "    + r.getMarge() + "\n");
        }

        writer.write("\n--- VLANS GENERÉS ---\n");
        for (VLAN v : vlans) {
            writer.write("VLAN " + v.getId() + " : " + v.getNom()
                    + " | Réseau : " + v.getReseauAssocie().getAdresseReseau() + "\n");
        }

        writer.write("\n--- RECOMMANDATIONS ---\n");
        for (Recommandation rec : recommandations) {
            writer.write("- " + rec.getMessage() + "\n");
        }

        writer.write("\n==========================================\n");
        writer.write("Fin du rapport\n");
        writer.write("==========================================\n");

        writer.close();
        System.out.println("Rapport généré : " + cheminFichier);
    }
}

