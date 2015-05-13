package src;


public class Astat {

    int statementType;
    public static int assignment = 0;
    
  
    /*
     * assignment statement: variable = expr
     *
     */
    String assVariable;
    Aexp assExpr;

    public static Astat assignment(String Variable, Aexp expr) {
        Astat statement = new Astat();
        statement.statementType = assignment;

        statement.assVariable = Variable;
        statement.assExpr = expr;



        return statement;

    }
   


    public String getstat() {

        if (statementType == assignment) {
            return assVariable + "=" + assExpr.getexp();
        } else {
            return "unknown";
        }
    }

    
    public void execute() {

        if (statementType == assignment) {
            int val = assExpr.getval();
            SymbolTable.setValue(assVariable, val);
            System.out.println(assVariable + " is assigned to " + val );
        } 
    }
}
