/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetsokoban;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author romai
 */
public class FileBuilder {

    public Board fileBuilder() throws BuilderException {
        Board b = null;
        try {
            //fichier en entré
            FileInputStream prog = new FileInputStream("Prog.txt");
            Scanner bit = new Scanner(prog);
            var build = new TextBoardBuilder(bit.nextLine());
            
            while(bit.hasNextLine()){
                build.addRows(bit.nextLine());
            }
          bit.close();
          b = build.build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}
