/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.tsiory.tpbanquetsiory.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import mg.tsiory.tpbanquetsiory.entities.CompteBancaire;
import mg.tsiory.tpbanquetsiory.service.GestionnaireCompte;
import mg.tsiory.tpbanquetsiory.util.Util;

/**
 *
 * @author tsiory
 */
@Named(value = "modifierNom")
@ViewScoped
public class ModifierNom implements Serializable {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    private Long idCompte;
    private CompteBancaire compte;
    private String nom;
    private String nomAncien;

    public ModifierNom() {
    }

    public GestionnaireCompte getGestionnaireCompte() {
        return gestionnaireCompte;
    }

    public void setGestionnaireCompte(GestionnaireCompte gestionnaireCompte) {
        this.gestionnaireCompte = gestionnaireCompte;
    }

    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomAncien() {
        return nomAncien;
    }

    public void setNomAncien(String nomAncien) {
        this.nomAncien = nomAncien;
    }


    public void loadCompte() {
        compte = gestionnaireCompte.findById(idCompte);
        setNomAncien(compte.getNom());
    }

    public String modifier() {
        compte.setNom(nom);
        gestionnaireCompte.update(compte);
        Util.addFlashInfoMessage("Nouveau nom enregistré : " + compte.getNom()
                + " à la place de " + this.getNomAncien());
        return "listeComptes?faces-redirect=true";
    }
}
