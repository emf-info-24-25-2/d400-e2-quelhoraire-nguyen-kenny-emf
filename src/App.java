import models.Horraire;
import models.ModuleInfo;
import models.Professeur;
import services.ServiceFormationMaitres;

public class App {
    public static void main(String[] args) {

        Horraire horaire = new Horraire();

        ModuleInfo[] modules1ere = new ModuleInfo[12];
        modules1ere[0] = new ModuleInfo("G300");
        modules1ere[1] = new ModuleInfo("187");
        modules1ere[2] = new ModuleInfo("162");
        modules1ere[3] = new ModuleInfo("123");
        modules1ere[4] = new ModuleInfo("293");
        modules1ere[5] = new ModuleInfo("117");
        modules1ere[6] = new ModuleInfo("164");
        modules1ere[7] = new ModuleInfo("216");
        modules1ere[8] = new ModuleInfo("106");
        modules1ere[9] = new ModuleInfo("231");
        modules1ere[10] = new ModuleInfo("122");
        modules1ere[11] = new ModuleInfo("431");

        Professeur[] profs = new Professeur[5];
        profs[0] = new Professeur("Friedli", "Paul");
        profs[1] = new Professeur("Ramalho", "Mario");
        profs[2] = new Professeur("Riedo", "Fanny");
        profs[3] = new Professeur("Hurtlin", "Blaise");
        profs[4] = new Professeur("Egger", "Nadia");

        boolean tousModulesCouverts;
        do {
            ServiceFormationMaitres.attribuerModules(profs, modules1ere);
            tousModulesCouverts = ServiceFormationMaitres.tousModulesCouverts(profs, modules1ere);
        } while (tousModulesCouverts == false);

        System.out.println("L'école a engagé les professeurs suivants");
        for (int i = 0; i < profs.length; i++) {
            System.out.println("- " + profs[i].toString() + " peut enseigner les modules :");
            ModuleInfo[] modules1ereEneseigne = profs[i].getModulesEnseignes();
            for (int j = 0; j < modules1ereEneseigne.length; j++) {
                System.out.println(" " + modules1ereEneseigne[i].getNom());
            }
            System.out.println();

        }
        System.out.println("\nIl est temps de préparer l'horaire\n");

        boolean planificationReussi = horaire.planifier(modules1ere, profs);
        if (planificationReussi) {
            System.out.println("Modules planifiés avec succès!");
        } else {
            System.out.println("Problème de planification!");

        }
    }
}
