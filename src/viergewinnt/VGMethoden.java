package viergewinnt;

import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

public class VGMethoden {

	private static final Scanner input = new Scanner(in);
	private static int player = 1;
	private static int round = 0;
	private static int lastInput;
	private static String test;

	public static void setPlayer() {
		if (player == 1) {
			player = 2;
		} else {
			player = 1;
		}
	}

	public static int getPlayer() {
		return player;
	}

	public static void raiseRound() {
		round++;
	}

	public static int getRound() {
		return round;
	}
	
	// Zeichnet das Feld mit den bisherigen Eingaben
	public static void draw(int[][] f) {
		out.println();
		for (int i = 5; i >= 0; i--) {
			out.print("|");
			for (int j = 0; j < 7; j++) {
				out.print(" ");
				if (f[j][i] == 0) {
					out.print(" ");
				} else if (f[j][i] == 1) {
					out.print("X");
				} else if (f[j][i] == 2) {
					out.print("O");
				}
				out.print(" |");
			}
			out.println();
			out.print("-----------------------------");
			out.println();
		}
		out.println("  1   2   3   4   5   6   7");
	}

	public static int getInput() {
		return lastInput;
	}

	//Wartet auf eine Eingabe und Prüft ob diese korrekt ist
	public static boolean setInput(int f[][]) {

		test = input.next();
		if (test.equals("ende")){
			out.println("Programm beendet");
			System.exit(0);
			return false;
		} else {
		try {
			lastInput = Integer.parseInt(test);
		} catch (NumberFormatException e) {
			return false;
		}
		if ((inputCheck(lastInput) == true) && (getHeight(f) <= 5)) {
			return true;
		} else {
			return false;
		}
		}
	}

	//Gibt die Höhe der Entsprechenden Spalte aus
	public static int getHeight(int f[][]) {
		int height = 0;
		int t;
		while (true) {
			t = f[lastInput - 1][height];
			if (t == 0) {
				break;
			} else {
				height++;
			}
		}
		return height;
	}

	//Prüft ob die eingegebene Zahl zwischen 1 und 7 ist 
	public static boolean inputCheck(int i) {
		if (i > 7 || i < 1) {
			return false;
		} else {
			return true;
		}
	}

	//Prüft ob ein Spieler 4 in einer Reihe hat
	public static boolean winCheck(int f[][]) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if ((f[j][i] != 0) && (f[j][i] == f[j + 1][i])
						&& (f[j][i] == f[j + 2][i]) && (f[j][i] == f[j + 3][i])) {

					return true;
				}
			}
		}
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 3; i++) {
				if ((f[j][i] != 0) && (f[j][i] == f[j][i + 1])
						&& (f[j][i] == f[j][i + 2]) && (f[j][i] == f[j][i + 3])) {
					return true;
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if ((f[i][j] != 0) && (f[i][j] == f[i + 1][j + 1])
						&& (f[i][j] == f[i + 2][j + 2])
						&& (f[i][j] == f[i + 3][j + 3])) {
					return true;
				}
			}
		}
		for (int i = 3; i < 7; i++) {
			for (int j = 0; j < 3; j++) {
				if ((f[i][j] != 0) && (f[i][j] == f[i - 1][j + 1])
						&& (f[i][j] == f[i - 2][j + 2])
						&& (f[i][j] == f[i - 3][j + 3])) {
					return true;
				}
			}
		}
		return false;
	}
}
