/*
 * PROCEDURE D'EXECUTION DU PROGRAMME
 * compilé le code avec javac >>> javac Main.class
 * executé le byte code avec java >>> java Main
 * nous avons eu à remarqué qu'en utilisant l'extension java de vs code nous rencontrons des problèmes liés à la class Main,
 * sans doute parceque cette dernière est utilisé dans des bibliothèques natives de java... :)
 */
//importation de la class Year pour gérer automatiquement l'année courante...
import java.time.Year;

class Institution {
    private String nomInstitution;
    private String typeInstitution;
    private String paysInstitution;
    private int anneeCreation;
    // constructeur de la class Institution...
    public Institution(String nomInstitution, String typeInstitution, String paysInstitution, int anneeCreation) {
        this.nomInstitution = nomInstitution;
        this.typeInstitution = typeInstitution;
        this.paysInstitution = paysInstitution;
        this.anneeCreation = anneeCreation;
    }

    // Accesseurs et mutateurs de la class Institution
    public String getNomInstitution() { return nomInstitution; }
    public void setNomInstitution(String nomInstitution) { this.nomInstitution = nomInstitution; }

    public String getTypeInstitution() { return typeInstitution; }
    public void setTypeInstitution(String typeInstitution) { this.typeInstitution = typeInstitution; }

    public String getPaysInstitution() { return paysInstitution; }
    public void setPaysInstitution(String paysInstitution) { this.paysInstitution = paysInstitution; }

    public int getAnneeCreation() { return anneeCreation; }
    public void setAnneeCreation(int anneeCreation) { this.anneeCreation = anneeCreation; }

    // Méthodes d'instance toujours du fameux Institution
    public int calculerAge() {
        return Year.now().getValue() - anneeCreation;
    }

    public String decrireInstitution() {
        return "Nom: " + nomInstitution 
            + "\nType: " + typeInstitution
            + "\nPays: " + paysInstitution
            + "\nÂge: " + calculerAge() + " ans";
    }
}
//class univ extension du fameux institution... possède aussi un constructeur,des attributs + ceux de institution et autres
class Universite extends Institution {
    private String systemeEnseignement;
    private int nombreFacultes;
    private String nomRecteur;

    public Universite(String nomInstitution, String typeInstitution, String paysInstitution, int anneeCreation,
                     String systemeEnseignement, int nombreFacultes, String nomRecteur) {
        super(nomInstitution, typeInstitution, paysInstitution, anneeCreation);
        this.systemeEnseignement = systemeEnseignement;
        this.nombreFacultes = nombreFacultes;
        this.nomRecteur = nomRecteur;
    }

    // Accesseurs et mutateurs de univ
    public String getSystemeEnseignement() { return systemeEnseignement; }
    public void setSystemeEnseignement(String systemeEnseignement) { this.systemeEnseignement = systemeEnseignement; }

    public int getNombreFacultes() { return nombreFacultes; }
    public void setNombreFacultes(int nombreFacultes) { this.nombreFacultes = nombreFacultes; }

    public String getNomRecteur() { return nomRecteur; }
    public void setNomRecteur(String nomRecteur) { this.nomRecteur = nomRecteur; }

    // Méthodes d'instance toujours de univ
    public String decrireUniversite() {
        return super.decrireInstitution() 
            + "\nSystème: " + systemeEnseignement
            + "\nFacultés: " + nombreFacultes
            + "\nRecteur: " + nomRecteur;
    }

    public static String listerRecteurs(Universite u1, Universite u2) {
        return "Recteurs: " + u1.getNomRecteur() + " et " + u2.getNomRecteur();
    }
}
// notre Ecole extensions de, deviné quoi :) institution
class Ecole extends Institution {
    private int nbrClasse;
    private String typeEcole;
    private String nomPromoteur;

    public Ecole(String nomInstitution, String nomPromoteur, String paysInstitution, int anneeCreation,
                String typeInstitution, String typeEcole, int nbrClasse) {
        super(nomInstitution, typeInstitution, paysInstitution, anneeCreation);
        this.nbrClasse= nbrClasse;
        this.typeEcole = typeEcole;
        this.nomPromoteur= nomPromoteur;
    }

    // Accesseurs et mutateurs de ecole class
    public int getNbrClasse() { return nbrClasse; }
    public void setNbrClasse(int nbrClasse) { this.nbrClasse = nbrClasse; }

    public String getTypeEcole() { return typeEcole; }
    public void setTypeEcole(String typeEcole) { this.typeEcole = typeEcole; }

    public String getNomPromoteur() { return nomPromoteur; }
    public void setNomPromoteur(String nomPromoteur) { this.nomPromoteur = nomPromoteur; }

    // Méthodes d'instance toujours ecole
    public String decrireEcole() {
        return super.decrireInstitution()
            + "\nType: " + typeEcole
            + "\nClasses: " + nbrClasse
            + "\npromoteur: "+ nomPromoteur;
    }

    public static String listerPromoteurs(Ecole e1, Ecole e2, Ecole e3) {
        return "Promoteurs: " + e1.getNomPromoteur() + ", " + e2.getNomPromoteur() + ", " + e3.getNomPromoteur();
    }
}

public class Main{
    public static void main(String[] args) {
        // Création d'instances ou objets de nos fameux class 
        Institution ins=new Institution("ISP", "public","RDC" ,2000 ); 
        Universite u1 = new Universite("ULPGL", "privée", "RDC",1995,"LMD",8,"prof WASO" );
        Universite u2 = new Universite("UCS", "public", "RDC", 2000, "LMD", 7, "Recteur_UCS");
        
        Ecole e1 = new Ecole("École Primaire karibu", "Eglise catholique", "RDC", 2000,"privée","primaire",18);
        Ecole e2 = new Ecole("Institut Isidore Bakanja", "Eglise catholique", "RDC", 1989, "Public", "Secondaire",24);
        Ecole e3 = new Ecole("Institut Technique Kyeshero", "Eglise CEPAC", "RDC", 1990, "public", "Secondaire",24);

        // Affichage des informations
        System.out.println("==== Description Institution ==\n");
        System.out.println(ins.decrireInstitution());
        
        System.out.println("\n\n==== Description Université ====\n");
        System.out.println(u1.decrireUniversite());
        System.out.println("\n==================================\n");
        System.out.println(u2.decrireUniversite());
        System.out.println("\n\n==== Liste des Recteurs ====\n");
        System.out.println(Universite.listerRecteurs(u1, u2));
        
        System.out.println("\n==== Description École ====\n");
        System.out.println("\n==================================\n");
        System.out.println(e1.decrireEcole());
        System.out.println("\n==================================\n");
        System.out.println(e2.decrireEcole());
        System.out.println("\n==================================\n");
        System.out.println(e3.decrireEcole());
        System.out.println("\n\n==== Liste des Promoteurs ====\n");
        System.out.println(Ecole.listerPromoteurs(e1, e2, e3));
    }
}


