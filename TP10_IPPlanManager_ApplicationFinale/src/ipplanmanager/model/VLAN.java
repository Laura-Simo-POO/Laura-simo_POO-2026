/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.model;

/**
 *
 * @author laura
 */
public class VLAN {
    private int id;
    private String nom;
    private ResultatVLSM reseauAssocie;
    private String description;

    public VLAN(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.description = "VLAN automatique";
    }

    public VLAN(int id, String nom, ResultatVLSM reseauAssocie, String description) {
        this.id = id;
        this.nom = nom;
        this.reseauAssocie = reseauAssocie;
        this.description = description;
    }

    public void afficher() {
        System.out.print("VLAN [ID=" + id + ", Nom=" + nom + "]");
        if (reseauAssocie != null) {
            System.out.print(" -> Réseau associé : " + reseauAssocie.getAdresseReseau() + "/" + reseauAssocie.getCidr());
        }
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public ResultatVLSM getReseauAssocie() { return reseauAssocie; }
    
    // Setter crucial pour lier le réseau après la création du VLAN
    public void setReseauAssocie(ResultatVLSM reseauAssocie) { 
        this.reseauAssocie = reseauAssocie; 
    }
}

