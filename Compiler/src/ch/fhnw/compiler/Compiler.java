package ch.fhnw.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ch.fhnw.compiler.error.GrammarError;
import ch.fhnw.compiler.parser.Parser;
import ch.fhnw.compiler.parser.concSynTree.Program;
import ch.fhnw.compiler.scanner.Scanner;
import ch.fhnw.compiler.scanner.data.*;

public class Compiler {

    public static void main(String[] args) {

        ITokenList tList = Scanner.scan("Compiler/imlCodes/ourExample.iml");
        System.out.println(tList.toString());

		Parser parser = new Parser(tList);
		try {
			Program prog = parser.parse();
			prog.toAbstrSyntax();
		} catch (GrammarError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
