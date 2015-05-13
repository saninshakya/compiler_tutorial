package src;


public class Astat {

    int statementType;
    public static int assignment = 0;
    public static int print = 1;
    public static int block = 2;
    public static int whileloop = 3;
    
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
     * while loop: while whileCondition begin whileBody end
     *
     */
    Aexp whileCondition;
    Astat whileBody;

    public static Astat whileloop(Aexp condition, Astat WhileBody) {
        Astat statement = new Astat();
        statement.statementType = whileloop;
        statement.whileCondition = condition;
        statement.whileBody = WhileBody;
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


    /*
     * block statement: begin statement_list end
     */
    Lstat blockBody;

    public static Astat block(Lstat l) {

        Astat statement = new Astat();
        statement.statementType = block;
        statement.blockBody = l;
        return statement;

    }

    public String getstat() {



        if (statementType == assignment) {
            return assVariable + "=" + assExpr.getexp();
        } else if (statementType == print) {
            return "print " + printE.getexp();
        } else if (statementType == whileloop) {
            return "while " + whileCondition.getexp() + " do " + whileBody.getstat();
        } else if (statementType == block) {
            return "block";
        }  else {
            return "unknown";
        }
    }

    public void execute() {


        if (statementType == assignment) {
            SymbolTable.setValue(assVariable, assExpr.getval());
        } else if (statementType == whileloop) {

            for (;;) {

                if (whileCondition.getval() != 0) {
                    whileBody.execute();
                } else {
                    break;
                }

            }

        } else if (statementType == print) {

            System.out.println(printE.getval());

        } else if (statementType == block) {

            for (Astat s : blockBody.statementList) {
                s.execute();
            }

        }
    }
}
