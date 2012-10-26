package viergewinnt;
/*
 * Vier Gewinnt
 * @author alknippe, stegbhar
 * @version 24.10.2012
 * Status:
 * Fehlerbehandlung f�r text Eingaben noch nicht implementiert
 * Momentan 7x7 Matrix wegen Fehler bei Spalten�berlaufbehandlung
 */

public class vierGewinnt {
	public static void main(String[] args) {

        int[][] field = new int[7][7];
        VGMethoden.draw(field);
        while (!VGMethoden.winCheck(field)) {
            System.out.printf("%nSpieler %d ist an der Reihe.%n", VGMethoden.getPlayer());
            System.out.println("In welche Spalte soll ein Stein geworfen werden? [1-7]");
            System.out.print(">>");

            while (VGMethoden.setInput(field) == false) {
                System.err.println("Ung�ltige Eingabe");
                System.out.printf(">>");
            }
            field[VGMethoden.getInput() - 1][VGMethoden.getHeight(field)] = VGMethoden.getPlayer();

            VGMethoden.draw(field);
            VGMethoden.setPlayer();
            VGMethoden.raiseRound();
        }
        VGMethoden.setPlayer();
        System.out.printf("Spieler %d hat in Runde %d gewonnen!%n", VGMethoden.getPlayer(), VGMethoden.getRound());
    }
}