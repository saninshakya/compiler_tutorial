package src;


import java.util.Hashtable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nguyenduyhung
 */
public class SymbolTable extends Hashtable<String,Object>{

    static SymbolTable globalTable;

    static {globalTable = new SymbolTable();}

    static void setValue(String id, int value){
        globalTable.put(id,value);
    }

    static Integer getValue(String id){
        return (Integer) globalTable.get(id);
    }
}
