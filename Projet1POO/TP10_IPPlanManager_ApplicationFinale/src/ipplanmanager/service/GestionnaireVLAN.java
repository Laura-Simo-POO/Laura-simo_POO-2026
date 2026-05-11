package ipplanmanager.service;

import ipplanmanager.model.VLAN;
import ipplanmanager.exception.ConflitVLANException;
import java.util.ArrayList;

/**
 *
 * @author laura
 */
public class GestionnaireVLAN {
    private ArrayList<VLAN> vlans;

    public GestionnaireVLAN() {
        this.vlans = new ArrayList<>();
    }

    public ArrayList<VLAN> getVlans() {
        return this.vlans;
    }

    public void viderVlans() {
        this.vlans.clear();
    }

    public void ajouterVLAN(VLAN vlan) throws ConflitVLANException {
        if (vlan == null) {
            return;
        }
        for (VLAN v : vlans) {
            if (v.getId() == vlan.getId()) {
                throw new ConflitVLANException("Conflit VLAN : l'identifiant "
                        + vlan.getId() + " est deja utilise.");
            }
        }
        vlans.add(vlan);
    }

    public void afficherTousLesVLANs() {
        for (VLAN vlan : vlans) {
            vlan.afficher();
            System.out.println();
        }
    }

    public int obtenirNombreVLANs() {
        return vlans.size();
    }

    public void afficherVLANsCritiques() {
        System.out.println("===== VLANs CRITIQUES (capacite > 100 hotes) =====");
        for (VLAN vlan : vlans) {
            // Vérifiez que getCapacite() est bien public dans ResultatVLSM.java
            if (vlan.getReseauAssocie().getCapacite() > 100) {
                System.out.println("VLAN: " + vlan.getNom());
            }
        }
    }
} 