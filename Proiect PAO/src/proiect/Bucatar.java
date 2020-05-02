package proiect;

public class Bucatar extends Angajat {
    private String produse;

    public Bucatar(String nume, int varsta, int salariu, String produse) {
        super(nume, varsta, salariu);
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

    public void setProduse(String produse) {
        this.produse = produse;
    }
}
