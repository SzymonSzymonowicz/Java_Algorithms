package pattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Klasa z metodami, do obslugi plikow i wczytania
// teskstu T oraz wzorca P z pliku .txt
public class FileToCharArray {


    /**
     *  Metoda ta wczytuje z pliku o podanej sciezce, kazda linie
     *  jako string i po kazdej dodaje znak znowej linii '\n', a
     *  zwraca po konwersji na typ String, nastepnie konwersja na
     *  CharArray, czyli tablice znakow
     * @param   path    sciezka do pliku
     * @return          tablica znakow z pliku .txt o sciezce path
     **/
    static char[] getCharArr(String path, NPos nPos, boolean ifPatt) throws FileNotFoundException {

        StringBuilder strBuild = new StringBuilder();
        File file = new File(path);
        Scanner scr = new Scanner(file);

        if(!ifPatt)
            nPos.positions.clear();

        //strBuild.append(scr.nextLine());
        while(scr.hasNextLine()) {
            strBuild.append(scr.nextLine());
            if(!ifPatt)
                nPos.positions.add(strBuild.length()-1);
        }

        return strBuild.toString().toCharArray();
    }
}
