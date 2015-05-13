package src;


public class Astat {

    int statementType;
    public static int print = 1;
  
 
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

        if (statementType == print) {
            return "print " + printE.getexp();
        } else {
            return "unknown";
        }
    }

    public void execute() {


        if (statementType == print) {

            System.out.println(printE.getval());

        } 
    }
}
