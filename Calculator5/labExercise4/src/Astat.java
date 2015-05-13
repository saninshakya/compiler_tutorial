package src;


public class Astat {

    int statementType;
    public static int assignment = 0;
    public static int print = 1;
    public static int ifthen = 2;
  
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
    
    /*
     * if then statement: if ifcondition then ifbody
     *
     */
    Aexp ifcondition;
    Astat ifbody;

    public static Astat ifthen(Aexp Condition, Astat Ifbody) {
        Astat statement = new Astat();
        statement.statementType = ifthen;
        statement.ifcondition = Condition;
        statement.ifbody = Ifbody;

        return statement;
    }

    /*
     * print statement: print e
     */
    Aexp printE;

    public static Astat print(Aexp expr) {

        Astat statement = new Astat();
        statement.statementType = print;
        statement.printE = expr;
        return statement;

    }


    public String getstat() {



        if (statementType == assignment) {
            return assVariable + "=" + assExpr.getexp();
        } else if (statementType == ifthen) {
            return "if " + ifcondition.getexp() + " " + ifbody.getstat();
        } else if (statementType == print) {
            return "print " + printE.getexp();
        } else {
            return "unknown";
        }
    }

    public void execute() {


        if (statementType == assignment) {
            SymbolTable.setValue(assVariable, assExpr.getval());
        } else if (statementType == ifthen) {

            if (ifcondition.getval() != 0) {
                ifbody.execute();
            }



        } else if (statementType == print) {

            System.out.println(printE.getval());

        } 
    }
}
