package lcs;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        LCS lcs = new LCS();

        String s1 ="abbaac";//"kajak";
        String s2 ="bacbacba";//"ccckjuuk";

        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();

        //System.out.println(lcs.length(cs1,cs2));
        IntCharO ico = lcs.length(cs1,cs2);

        System.out.println("Najdluzszy wspolny podciag LCS wyrazow: "+s1+" i "+s2+":");
        lcs.printLCS(cs1,cs2,ico.getCharArr(),cs1.length,cs2.length);
        ico.print(s1,s2);
        System.out.println("\n");

        Set<String> s = lcs.findAllLCS(s1,s2,s1.length(),s2.length(),lcs.length(cs1,cs2).getIntArr());
        System.out.println("Wszystkie najdluzsze wspolne podciagi LCS wyrazow: "+s1+" i "+s2+":");
        for (String str : s) {
            System.out.println(str);
        }

    }
}
