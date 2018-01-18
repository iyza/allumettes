import java.util.Scanner;

/**
 * Created by BajLu1731402 on 2018-01-15.
 */
public class jeuAllumettes {

    public static void main(String[] args) {

        int allumettes;
        int allumettesRetire;
        int gagnant;
        boolean retireNb;
        String nom1;
        String nom2;
        int nbRandom;
        int choix;
        boolean whileChoix;
        String joueur[] = new String[2];
        boolean game = true;
        boolean allumettePasZero;
        int decisionsPrises1[] = new int[50];
        int decisionsPrises2[] = new int[50];
        int compteurDeTours;
        int singlePlayer;

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenue a Alummettes the Game!");

        while (game) { // menu
            allumettes = (int)(Math.random()*80 + 20);
            allumettePasZero = true;
            whileChoix = true;
            compteurDeTours = 0;

            System.out.println("Est-ce que vous voulez jouer :");
            System.out.println("1 - Contre un ami");
            System.out.println("2 - Contre un robot");
            singlePlayer = sc.nextInt();

            if (singlePlayer == 1) {
                System.out.print("Entrez le nom du Joueur Un : ");
                nom1 = sc.next();
                System.out.println("");
                System.out.print("Entrez le nom du Joueur Deux : ");
                nom2 = sc.next();
                System.out.println("");
                // decide le premier joueur
                nbRandom = (int)(Math.random()*2);
                if (nbRandom == 1) {
                    joueur[0] = nom1;
                    joueur[1] = nom2;
                }
                else {
                    joueur[1] = nom1;
                    joueur[0] = nom2;
                }
            }
            if (singlePlayer == 2) {
                System.out.print("Entrez votre nom : ");
                nom1 = sc.next();
                System.out.println("");
            }

            while (allumettePasZero) { // jeu
                for (int i=0;i<2;i++) {
                    gagnant = i;
                    System.out.println("Il reste " + allumettes + " allummettes.");
                    System.out.print(joueur[i] + ", combien d'allumettes voulez vous retirer?");
                    allumettesRetire = sc.nextInt();
                    // decisions prises
                    if (joueur[i] == joueur[0]) {
                        decisionsPrises1[compteurDeTours] = allumettesRetire;
                    }
                    if (joueur[i] == joueur[1]) {
                        decisionsPrises2[compteurDeTours] = allumettesRetire;
                    }

                    // si le nombres d'allumettes qu'un joueur prend et plus grand que 3 ou plus petit que 1 le boucle recommence
                    if (allumettesRetire >= 1 && allumettesRetire <= 3) {
                        System.out.println("");
                        allumettes = allumettes - allumettesRetire;
                        if (i==1) {
                            compteurDeTours++;
                        }
                        if (allumettes <= 0) {
                            if (gagnant == 0) {
                                System.out.println(joueur[1] + " a gagne!! Bien joue");
                                i++;
                                allumettePasZero = false;
                            }
                            else {
                                System.out.println(joueur[0] + " a gagne!! Bien joue");
                                i++;
                                allumettePasZero = false;
                            }
                        }
                    }
                    else i--;
                }
            }

            System.out.println("");
            System.out.print("Decisions prises par " + joueur[0] + " : ");
            for (int i=0;i<compteurDeTours;i++) {
                if (decisionsPrises1[i] > 0) {
                    System.out.print(decisionsPrises1[i] + ", ");
                }
            }
            System.out.println("");
            System.out.print("Decisions prises par " + joueur[1] + " : ");
            for (int i=0;i<compteurDeTours;i++) {
                if (decisionsPrises2[i] > 0) {
                    System.out.print(decisionsPrises2[i] + ", ");
                }
            }
            System.out.println("");
            while (whileChoix) {
                System.out.println("Est-ce que vous voulez jouez une autre fois?");
                System.out.println(" 1 - Oui");
                System.out.println(" 2 - Non");
                choix = sc.nextInt();
                if (choix == 1) {
                    whileChoix = false;
                }
                if (choix == 2) {
                    System.exit(0);
                }
                if (choix > 2 && choix < 1) {
                    System.out.println("Choix invalide.");

                }
            }

        }

    }

}
