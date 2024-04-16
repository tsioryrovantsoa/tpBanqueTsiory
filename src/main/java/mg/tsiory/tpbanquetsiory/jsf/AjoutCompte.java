/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.tsiory.tpbanquetsiory.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.constraints.PositiveOrZero;
import mg.tsiory.tpbanquetsiory.entities.CompteBancaire;
import mg.tsiory.tpbanquetsiory.service.GestionnaireCompte;
import mg.tsiory.tpbanquetsiory.util.Util;

/**
 *
 * @author tsiory
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {

    private String nom;
    @PositiveOrZero(message = "Le solde ne peut pas être négatif.")
    private int solde;

    @Inject
    GestionnaireCompte gestionnaireCompte;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    /**
     * Creates a new instance of AjoutCompte
     */
    public AjoutCompte() {
    }

    public String creerCompte() {
        CompteBancaire compteBancaire = new CompteBancaire(nom, solde);
        gestionnaireCompte.creerCompte(compteBancaire);
        Util.addFlashInfoMessage("Ajout de compte correctement effectué!");
        return "listeComptes?faces-redirect=true";
    }
}
