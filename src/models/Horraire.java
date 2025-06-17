package models;

public class Horraire {
    public final static int NMBRE_DE_BLOCS = 6;

    private Bloc[] blocs;

    public Horraire() {
        blocs = new Bloc[NMBRE_DE_BLOCS];
        blocs[0] = new Bloc("B1S1");
        blocs[1] = new Bloc("B2S1");
        blocs[2] = new Bloc("B3S1");
        blocs[3] = new Bloc("B4S2");
        blocs[4] = new Bloc("B5S2");
        blocs[5] = new Bloc("B6S2");
    }

    public boolean planifier(ModuleInfo[] modules, Professeur[] profs) {
        boolean estPLanifier = false;

        for (int i = 0; i < modules.length; i++) {
            for (int j = 0; j < profs.length; j++) {
                if (profs[i].enseigneCeModule(modules[i].getNom())) {
                    profs[i].ajouterModuleEnseigne(modules[i]);
                    estPLanifier = true;

                }

            }
        }
        return estPLanifier;

    }

    public void afficherHorraire() {
        for (int i = 0; i < blocs.length; i++) {
            blocs[i].afficherHorraire();
        }

    }

    public Bloc moduleDansQuelBloc(ModuleInfo module) {
        Bloc blocDuModule = null;
        if (module != null) {
            for (int i = 0; i < blocs.length; i++) {
                if (blocs[i].contientModule(module)) {
                    blocDuModule = blocs[i];

                }
            }
        }
        return blocDuModule;
    }

}
