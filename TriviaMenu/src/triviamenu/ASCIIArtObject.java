/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triviamenu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Gingervitis
 */
public class ASCIIArtObject {
    
    private ArrayList<String> stringList;
    
    public ASCIIArtObject(String... varargs){
        stringList = new ArrayList<>();
        stringList.addAll(Arrays.asList(varargs));
    }
    
    @Override
    public String toString(){
        String result = "";
        for (String s : stringList){
            result += s + "\n";
        }
        return result;
    }
    
}
