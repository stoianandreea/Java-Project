package proiect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVRepository {
    static private CSVRepository instance = null;

    private CSVRepository(){
    }

    public static CSVRepository getInstance() {
        if (instance == null) {
            synchronized (CSVRepository.class) {
                if (instance == null) {
                    instance = new CSVRepository();
                }
            }
        }
        return instance;
    }

    public void citesteBucatari(List <Bucatar> bucatari){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("bucatari.csv"));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] infoBucatar = line.split(", ");
                Bucatar bucatar = new Bucatar(infoBucatar[0], Integer.parseInt(infoBucatar[1]), Integer.parseInt(infoBucatar[2]), infoBucatar[3]);
                bucatari.add(bucatar);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul \"bucatari.csv\" nu a fost gasit");
        } catch (IOException e) {
            System.out.println("Eroare");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void scrieBucatari(List<Bucatar> bucatari) {
        try (FileWriter file = new FileWriter("bucatari.csv", false)) {
            for (Bucatar bucatar : bucatari ) {
                String newRow = bucatar.getNume() + ", " +
                        bucatar.getVarsta() + ", " +
                        bucatar.getSalariu() + ", " +
                        bucatar.getProduse() + "\n";
                file.write(newRow);
                file.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul \"bucatari.csv\" nu a fost gasit");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void citesteOspatari(List<Ospatar> ospatari) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("ospatari.csv"));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] infoOspatar = line.split(", ");
                Ospatar ospatar = new Ospatar(infoOspatar[0], Integer.parseInt(infoOspatar[1]), Integer.parseInt(infoOspatar[2]));
                ospatari.add(ospatar);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul \"ospatari.csv\" nu a fost gasit");
        } catch (IOException e) {
            System.out.println("Eroare");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void scrieOspatari(List<Ospatar> ospatari) {
        try (FileWriter file = new FileWriter("ospatari.csv", false)) {
            for (Ospatar ospatar : ospatari) {
                String newRow = ospatar.getNume() + ", " +
                        ospatar.getVarsta() + ", " +
                        ospatar.getSalariu() + "\n";
                file.write(newRow);
                file.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul \"ospatari.csv\" nu a fost gasit");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void citesteComenzi(List<Comanda> comenzi) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("comenzi.csv"));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] infoComanda = line.split(", ");
                Comanda comanda = new Comanda(Integer.parseInt(infoComanda[0]), Double.parseDouble(infoComanda[1]), infoComanda[2]);
                comenzi.add(comanda);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul \"comenzi.csv\" nu a fost gasit");
        } catch (IOException e) {
            System.out.println("Eroare");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void scrieComenzi(List<Comanda> comenzi) {
        try (FileWriter file = new FileWriter("comenzi.csv", false)) {
            for (Comanda comanda : comenzi) {
                String newRow = comanda.getIdComanda() + ", " +
                        comanda.getPretComanda() + ", " +
                        comanda.getProduseComanda() + "\n";
                file.write(newRow);
                file.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul \"comenzi.csv\" nu a fost gasit");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void citesteProduse(List<Produse> preparate) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("produse.csv"));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] infoPreparat = line.split(", ");
                Produse preparat = null;
                if(infoPreparat[0].equals("mancare")) {
                    preparat = new Mancare(infoPreparat[1], infoPreparat[2], Double.parseDouble(infoPreparat[3]), infoPreparat[4],
                            Boolean.parseBoolean(infoPreparat[5]));
                }
                else if(infoPreparat[0].equals("bautura")){
                    preparat = new Bautura(infoPreparat[1], infoPreparat[2], Double.parseDouble(infoPreparat[3]), infoPreparat[4],
                            Boolean.parseBoolean(infoPreparat[5]));
                }
                preparate.add(preparat);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul \"produse.csv\" nu a fost gasit");
        } catch (IOException e) {
            System.out.println("Eroare");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void scrieProduse(List<Mancare> foods, List<Bautura> drinks) {
        try (FileWriter file = new FileWriter("produse.csv", false)) {
            for (Mancare food : foods) {
                    String newRow = "mancare, " +
                            food.getCategorieProdus() + ", " +
                            food.getNumeProdus() + ", " +
                            food.getPretProdus() + ", " +
                            food.getIngrediente() + ", " +
                            food.isDePost() + "\n";
                file.write(newRow);
                file.flush();
            }
            for (Bautura drink : drinks) {
                String newRow = "bautura, " +
                        drink.getCategorieProdus() + ", " +
                        drink.getNumeProdus() + ", " +
                        drink.getPretProdus() + ", " +
                        drink.getIngrediente() + ", " +
                        drink.areZahar() + "\n";
                file.write(newRow);
                file.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul \"produse.csv\" nu a fost gasit");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
