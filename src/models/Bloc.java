package models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Bloc {

    public final static int NMBRE_DEMI_JOURS_SEMAINE = 10;

    private final String nom;
    private final ModuleInfo[] modules;

    public Bloc(String nom) {
        this.nom = nom;
        modules = new ModuleInfo[NMBRE_DEMI_JOURS_SEMAINE];
        ModuleInfo matu = new ModuleInfo("Matu");
        modules[0] = matu;
        modules[1] = matu;
        modules[2] = matu;
        modules[3] = matu;
    }

    public boolean planifierModule(ModuleInfo module) {
        boolean estPLanifier = false;

        if (module != null) {
            for (int i = 0; i < modules.length; i++) {
                if (modules[i] == null) {
                    if (modules[i + 1] == null) {
                        if (modules[i + 2] == null) {
                            modules[i] = module;
                            modules[i + 1] = module;
                            modules[i + 2] = module;
                            estPLanifier = true;
                            break;

                        }

                    }
                }

            }
        }
        return estPLanifier;
    }

    public void afficherHorraire() {

        for (int i = 0; i < modules.length; i++) {
            // jour de la semaine
            DayOfWeek.values()[i / 2].getDisplayName(TextStyle.FULL, Locale.FRANCE);
            // matin
            System.out.println(modules[i]);
            System.out.println(modules[i + 1]);

        }

    }

    public boolean estTotalementPlanifie() {
        boolean estTotalementPlanifie = false;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] != null) {
                estTotalementPlanifie = true;

            }
        }
        return estTotalementPlanifie;
    }

    public boolean contientModule(ModuleInfo module) {
        boolean contientModule = false;
        if (module != null) {
            for (int i = 0; i < modules.length; i++) {
                if (modules[i] == module) {
                    contientModule = true;

                }
            }

        }
        return contientModule;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
