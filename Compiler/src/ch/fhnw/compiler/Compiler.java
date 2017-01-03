package ch.fhnw.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ch.fhnw.compiler.scanner.Scanner;
import ch.fhnw.compiler.scanner.data.*;

public class Compiler {

    public static void main(String[] args) {
        Scanner scanner = new Scanner();
    	StringBuilder code = new StringBuilder();
    	ITokenList tList = new TokenList();
    	BufferedReader br;
        try {
			br = new BufferedReader(new FileReader("imlCodes/ourExample.iml"));
			
        	int i = (char)br.read();
			while(i!=-1){
				char c = (char) i;
				code.append(c);
				i = br.read();
			}
			 tList=scanner.scan(code);
			 br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       System.out.println(tList.toString());
    }
}
