package proiect;

public class Ospatar extends Angajat {

    public Ospatar(String nume, int varsta, int salariu) {
        super(nume, varsta, salariu);
    }

    @Override
    public void afiseazaJobul() {
        System.out.println(this.nume + " este ospatar");
    }
}
