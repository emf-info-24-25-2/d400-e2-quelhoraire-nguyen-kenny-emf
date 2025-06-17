package services;

import models.ModuleInfo;
import models.Professeur;

public class ServiceFormationMaitres {
    public static void attribuerModules(Professeur[] professeurs, ModuleInfo[] modules) {
        int min = 0;
        int max = (professeurs.length - 1);

        boolean peutEnseignerCeModule = false;
        int professeurAleatoire = (int) (Math.random() * (max - min + 1)) + min;
        Professeur professeurChoisi = professeurs[professeurAleatoire];

        for (int i = 0; i < modules.length; i++) {
            do {
                if (modules[i].getProfesseur() == professeurChoisi) {
                    professeurChoisi = professeurs[professeurAleatoire];

                } else {
                    modules[i].setProfesseur(professeurChoisi);
                    professeurChoisi.ajouterModuleEnseigne(modules[i]);
                    peutEnseignerCeModule = true;
                }
            } while (!peutEnseignerCeModule);
        }
    }

    public static boolean tousModulesCouverts(Professeur[] profs, ModuleInfo[] modules) {
        boolean tousModulesCouverts = false;
        for (int i = 0; i < profs.length; i++) {
            if (modules[i].getProfesseur() == profs[i]) {
                tousModulesCouverts = true;
            }

        }
        return tousModulesCouverts;
    }
}
