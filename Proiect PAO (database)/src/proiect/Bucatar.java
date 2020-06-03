package proiect;

public class Bucatar extends Angajat {
    private int idBucatar;
    private String produse;

    public Bucatar(int idBucatar, String nume, int varsta, int salariu, String produse) {
        super(nume, varsta, salariu);
        this.idBucatar = idBucatar;
        this.produse = produse;
    }

    protected void detaliiBucatar() {
        super.detaliiAngajat();
        System.out.println("Produse preparate: " + produse);
    }

    @Override
    public void afiseazaJobul() {
        System.out.println(this.nume + " este bucatar");
    }

    public String getProduse() {
        return produse;
    }

}
