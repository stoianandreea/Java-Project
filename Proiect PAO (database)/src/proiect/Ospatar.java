package proiect;

public class Ospatar extends Angajat {
    private int idOspatar;

    public Ospatar(int idOspatar, String nume, int varsta, int salariu) {
        super(nume, varsta, salariu);
        this.idOspatar = idOspatar;
    }

    protected void detaliiOspatar() {
        super.detaliiAngajat();
    }

    @Override
    public void afiseazaJobul() {
        System.out.println(this.nume + " este ospatar");
    }
}
