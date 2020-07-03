package lcs;

/**
 * Klasa, ktorej obiekty przechowuja tablice 2-wymiarowa intow i charow z informacjami o
 * najdluzszym wspolnym podciagu (lcs)
 */
class IntCharO {
    private int [][] intArr;
    private char [][] charArr;

    IntCharO(int m, int n){
        intArr = new int[m][n];
        charArr = new char[m][n];
    }

    public char[][] getCharArr() {
        return charArr;
    }
    public int[][] getIntArr() {
        return intArr;
    }
    public void setCharArr(char[][] charArr) {
        this.charArr = charArr;
    }
    public void setIntArr(int[][] intArr) {
        this.intArr = intArr;
    }

    void print(String s1, String s2){
        System.out.println();
        for(int i=0;i<this.charArr.length;i++){
            if(i==0) {
                System.out.print("        ");
                for(int t=0;t<s2.length();t++)
                    System.out.print(s2.charAt(t)+"   ");
                System.out.println();
            }
            for(int j=0;j<this.charArr[i].length;j++)
            {
                if(j==0 && i!=0)
                    System.out.print(s1.charAt(i-1));
                if(j==0 && i==0)
                    System.out.print(" ");
                //System.out.print(" "+this.charArr[i][j]+this.intArr[i][j]);
                System.out.print(" ");
                if(this.charArr[i][j]==0)
                    System.out.print("  "+this.intArr[i][j]);
                else
                    System.out.print(" "+this.charArr[i][j]+this.intArr[i][j]);
            }
            System.out.println();
        }
    }
}
