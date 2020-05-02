package proiect;

public abstract class Angajat {
    protected String nume;
    private int varsta;
    private int salariu;

    public Angajat(String nume, int varsta, int salariu) {
        this.nume = nume;
        this.varsta = varsta;
        this.salariu = salariu;
    }

    protected void detaliiAngajat() {
        System.out.println("Nume angajat: " + nume);
        System.out.println("Varsta: " + varsta);
        System.out.println("Salariu: " + salariu);
    }

    public abstract void afiseazaJobul();

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }
}
