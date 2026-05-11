package ipplanmanager.service;

import ipplanmanager.model.BesoinReseau;
import ipplanmanager.model.ResultatVLSM;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author laura
 */
public class MoteurVLSM {
    public ArrayList<ResultatVLSM> genererPlan(String adresseDepart, ArrayList<BesoinReseau> besoins) {
        ArrayList<ResultatVLSM> resultats = new ArrayList<>();

        Collections.sort(besoins, (b1, b2) -> b2.getNombreHotes() - b1.getNombreHotes());

        int adresseCourante = CalculateurReseau.convertirIpEnEntier(adresseDepart);

        for (BesoinReseau besoin : besoins) { 
            int cidr = CalculateurReseau.calculerCidrPourHotes(besoin.getNombreHotes());
            int capacite = CalculateurReseau.calculerNombreHotes(cidr); 
            String masque = CalculateurReseau.obtenirMasqueDecimal(cidr); 
            String adresseReseau = CalculateurReseau.convertirEntierEnIp(adresseCourante);

            ResultatVLSM resultat = new ResultatVLSM(
                besoin.getNom(), adresseReseau, cidr, masque, capacite, besoin.getNombreHotes()
            );
            
            resultats.add(resultat);
            
            // On décale l'adresse pour éviter le chevauchement [cite: 243]
            adresseCourante += CalculateurReseau.calculerTailleBloc(cidr); 
        }
        return resultats; 
    }
}