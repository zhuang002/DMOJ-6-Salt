/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class Salt {

    static HashMap<Integer, HashSet<Integer>> rows = new HashMap();
    static HashMap<Integer, HashSet<Integer>> cols = new HashMap();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();
            String[] nq = line.split(" ");
            int n=Integer.parseInt(nq[0]);
            int q=Integer.parseInt(nq[1]);
            for (int i=0;i<n;i++) {
                line = reader.readLine();
                String[] cord = line.split(" ");
                int row=Integer.parseInt(cord[0]);
                int col=Integer.parseInt(cord[1]);
                if (!rows.containsKey(row)) {
                    rows.put(row, new HashSet<>());
                } 
                rows.get(row).add(col);
                if (!cols.containsKey(col)) {
                    cols.put(col, new HashSet<>());
                } 
                cols.get(col).add(row);
            }
            
            
            for (int i=0;i<q;i++) {
                line = reader.readLine();
                String[] query= line.split(" ");
                char cmd=query[0].charAt(0);
                if (cmd=='1') {
                    int row=Integer.parseInt(query[1]);
                    int col=Integer.parseInt(query[2]);
                    if (rows.containsKey(row)) {
                        if (rows.get(row).contains(col)) {
                            System.out.println("salty");
                        } else {
                            System.out.println("bland");
                        } 
                    } else {
                        System.out.println("bland");
                    }
                } else if (cmd=='2') {
                    char c = query[1].charAt(0);
                    int rc = Integer.parseInt(query[2]);
                    if (c=='X') {
                        if (rows.containsKey(rc)) {
                            System.out.println(rows.get(rc).size());
                        } else
                            System.out.println(0);
                    } else if (c=='Y') {
                        if (cols.containsKey(rc)) {
                            System.out.println(cols.get(rc).size());
                        } else
                            System.out.println(0);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }
}
