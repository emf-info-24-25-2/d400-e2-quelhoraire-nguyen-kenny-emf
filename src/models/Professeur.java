package models;

public class Professeur {
    private final String nom;
    private final String prenom;
    private ModuleInfo[] modulesEnseignes;

    public Professeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        modulesEnseignes = new ModuleInfo[0];
    }

    public boolean enseigneCeModule(String nomDuModule) {
        boolean enseigneCeModule = false;
        if (nomDuModule != null) {
            for (int i = 0; i < modulesEnseignes.length; i++) {
                if (modulesEnseignes[i].getNom().equals(nomDuModule)) {
                    enseigneCeModule = true;
                    break;
                }
            }
        }
        return enseigneCeModule;
    }

    public void ajouterModuleEnseigne(ModuleInfo module) {
        if (module != null) {
            int compteur = 0;

            for (int i = 0; i < modulesEnseignes.length; i++) {
                if (modulesEnseignes[i] != null) {
                    compteur++;
                }
            }

            ModuleInfo[] tabModule = new ModuleInfo[compteur + 1];
            for (int i = 0; i < modulesEnseignes.length; i++) {
                tabModule[i] = modulesEnseignes[i];

            }
            tabModule[tabModule.length - 1] = module;
            modulesEnseignes = tabModule;
        }
    }

    public void viderModules() {
        ModuleInfo[] tabModule = new ModuleInfo[0];
        modulesEnseignes = tabModule;

    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ModuleInfo[] getModulesEnseignes() {
        return modulesEnseignes;
    }

    @Override
    public String toString() {
        return prenom + " " + nom.toUpperCase();
    }

}
