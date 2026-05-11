/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;
import ipplanmanager.model.ResultatVLSM;
import ipplanmanager.exception.AdresseIPInvalideException;
import ipplanmanager.exception.ChevauchementReseauException;
import java.util.ArrayList;
/**
 *
 * @author laura
 */
public class ValidateurPlanAdressage {
    public void verifierChevauchements(ArrayList<ResultatVLSM> resultats) throws ChevauchementReseauException {
        for (int i = 0; i < resultats.size(); i++) {
            ResultatVLSM r1 = resultats.get(i);
            for (int j = i + 1; j < resultats.size(); j++) {
                ResultatVLSM r2 = resultats.get(j);
                boolean conflit = 
                        CalculateurReseau.reseauxSeChevauchent(
                                r1.getAdresseReseau(), r1.getCidr(),
                                r2.getAdresseReseau(), r2.getCidr()
                        );
                if (conflit) {
                    throw new ChevauchementReseauException("Chevauchement détecté entre " 
                            + r1.getNomBesoin() + " et " + r2.getNomBesoin()
                    );
                }
            }
        }
    }
    
    public void verifierAdresses(ArrayList<ResultatVLSM> resultats) throws AdresseIPInvalideException {
        for (ResultatVLSM resultat : resultats) {
            CalculateurReseau.verifierAdresseIP(resultat.getAdresseReseau());
        }
    }
    
    public void afficherValidationReussie() {
        System.out.println("Validation terminée : aucun conflit critique détecté.");
    }
    public void validerAdresseIP(String adresse) throws AdresseIPInvalideException {
    if (adresse == null || adresse.isEmpty()) {
        throw new AdresseIPInvalideException("L'adresse IP est vide.");
    }
    String[] parties = adresse.split("\\.");
    if (parties.length != 4) {
        throw new AdresseIPInvalideException("Adresse IP invalide : " + adresse);
    }
    for (String partie : parties) {
        try {
            int valeur = Integer.parseInt(partie);
            if (valeur < 0 || valeur > 255) {
                throw new AdresseIPInvalideException("Adresse IP invalide : " + adresse);
            }
        } catch (NumberFormatException e) {
            throw new AdresseIPInvalideException("Adresse IP invalide : " + adresse);
        }
    }
}

public void validerPlan(ArrayList<ResultatVLSM> resultats) throws ChevauchementReseauException {
    verifierChevauchements(resultats);
}
}
