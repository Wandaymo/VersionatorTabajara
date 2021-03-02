/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package versionatortabajara;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author wgsousa
 */
public class VersionatorTabajara {
    
    public static void main(String[] args) {
        String param = JOptionPane.showInputDialog(null, "As versões devem estar separados por vírgula");
        String nrOS = JOptionPane.showInputDialog(null, "Número da OS");
        String cherry = JOptionPane.showInputDialog(null, "Cherry-pick");
        String out = "";
        param = param.replaceAll(" ", "");
        String[] parts = param.split("\\,");

        for (int i = 0; i < parts.length; i++) {
            if (i != 0) {
                out = out + " ";
            }
            out = out + "git checkout " + parts[i] + " && git pull origin " + parts[i] + " && git checkout -b " + parts[i] + "_" + nrOS + " && git cherry-pick " + cherry + " && git push origin " + parts[i] + "_" + nrOS;
            if(i < parts.length - 1) {
                out = out + " &&";
            }
        }
        out = out + "&& git checkout dev && git pull origin dev";
        JTextArea text = new JTextArea(out);
        JOptionPane.showMessageDialog(null, text, "Output", 1);
        System.out.println(out); 
    }
}
