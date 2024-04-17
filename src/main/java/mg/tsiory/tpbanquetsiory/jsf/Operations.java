/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.tsiory.tpbanquetsiory.jsf;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import mg.tsiory.tpbanquetsiory.entities.CompteBancaire;
import mg.tsiory.tpbanquetsiory.entities.OperationBancaire;
import mg.tsiory.tpbanquetsiory.service.GestionnaireCompte;

/**
 *
 * @author tsiory
 */
@Named(value = "operations")
@RequestScoped
public class Operations implements Serializable {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    private Long idCompteBancaire;
    private CompteBancaire compte;

    public Operations() {
    }

    public Long getIdCompteBancaire() {
        return idCompteBancaire;
    }

    public void setIdCompteBancaire(Long idCompteBancaire) {
        this.idCompteBancaire = idCompteBancaire;
    }

    public List<OperationBancaire> getOperations() {
        return compte.getOperations();
    }

    public void setCompte() {
        compte = gestionnaireCompte.findById(idCompteBancaire);
    }

    public CompteBancaire getCompte() {
        return compte;
    }

}
