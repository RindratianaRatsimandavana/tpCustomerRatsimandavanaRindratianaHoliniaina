/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.ratsimandavanarindratiana.tp1.entities.tpcustomerratsimandavanarindratianaholiniaina.jsf;

import mg.itu.ratsimandavanarindratiana.tp1.entities.tpcustomerratsimandavanarindratianaholiniaina.entity.Customer;
import mg.itu.ratsimandavanarindratiana.tp1.entities.tpcustomerratsimandavanarindratianaholiniaina.service.CustomerManager;
import java.io.Serializable;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.List;
import mg.itu.ratsimandavanarindratiana.tp1.entities.tpcustomerratsimandavanarindratianaholiniaina.entity.Discount;
import mg.itu.ratsimandavanarindratiana.tp1.entities.tpcustomerratsimandavanarindratianaholiniaina.service.DiscountManager;

/**
 * Backing bean pour la page customerDetails.xhtml.
 *
 * @author rindr
 */
@Named(value = "customerDetailsBean")
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    private List<Discount> listDiscounts;

    @Inject
    private CustomerManager customerManager;

    @Inject
    private DiscountManager discountManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (contenu dans l'attribut customer
     * de cette classe).
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        customer = customerManager.update(customer);
        return "cutomerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }

    // Getter pour la propriété
    public List<Discount> getListDiscounts() {
        return listDiscounts;
    }

// Setter pour la propriété
    public void setListDiscounts(List<Discount> listDiscounts) {
        this.listDiscounts = listDiscounts;
    }

    public void loadDiscounts() {
        this.listDiscounts = discountManager.getAllDiscounts();
    }

}
