package tp04;

/* UV : LO17 - TP04
 * Analyse Syntaxique
 * Fichier : Tal_simpleMain.java
 */

import java.io.*;
import java.util.Scanner;
import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonTokenStream;
import antlr.output.Tal_simpleLexer;
import antlr.output.Tal_simpleParser;

public class Tal_simpleMain {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Texte : ");
		String s = scanner.nextLine();
		System.out.println(s);

		while (!s.equals("*")) {

			try {
				Tal_simpleLexer lexer = new Tal_simpleLexer(new ANTLRReaderStream(new StringReader(s)));
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				Tal_simpleParser parser = new Tal_simpleParser(tokens);
				String arbre = parser.listephrases();
				System.out.println(arbre);
			} catch(Exception e) {  }

			System.out.print("Texte : ");
			s = scanner.nextLine();
		}
	}
}
