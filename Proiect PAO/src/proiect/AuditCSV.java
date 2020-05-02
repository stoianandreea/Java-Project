package proiect;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class AuditCSV {
    private static AuditCSV instance = null;

    private AuditCSV(){
    }

    public static AuditCSV getInstance() {
        if (instance == null) {
            synchronized (AuditCSV.class) {
                if (instance == null) {
                    instance = new AuditCSV();
                }
            }
        }
        return instance;
    }

    public void scrieAudit(String text) {
        try {
            FileWriter file = new FileWriter("audit.csv", true);
            Date data = new Date();
            file.write(text + " , " + data + "\n");
            file.flush();
            file.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
