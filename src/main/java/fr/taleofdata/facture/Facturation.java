package fr.taleofdata.facture;

import java.util.List;

public class Facturation {
    private int idCat;
    private String designation;
    private int prix;
    private int points;

    public Facturation(int idCat, String designation, int prix, int points) {
        this.idCat = idCat;
        this.designation = designation;
        this.prix = prix;
        this.points = points;
    }

    public int getIdCat() {
        return idCat;
    }

    public String getDesignation() {
        return designation;
    }

    public int getPrix() {
        return prix;
    }

    public int getPoints() {
        return points;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public static List<Facturation> renvoiListe ()
    {
         Facturation object1 = new Facturation(1,"Basic",20,1);
         Facturation object2 = new Facturation(2,"Business",30,3);
        Facturation object3 = new Facturation(3,"Luxury",50,7);
         return List.of(object1,object2,object3);
    }
}
