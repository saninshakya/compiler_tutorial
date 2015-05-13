package src;


import java.util.Hashtable;


public class SymbolTable extends Hashtable<String,Object>{

    static SymbolTable globalTable;

    static {globalTable = new SymbolTable();}

    static void setValue(String id, String value){
        globalTable.put(id,value);
    }

    static Integer getValue(String id){
        return (Integer) globalTable.get(id);
    }
}
