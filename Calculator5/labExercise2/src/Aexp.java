package src;


public class Aexp {

    private boolean[] tag = new boolean[3];
    private Integer NUMBER;
    private String ID;
    private Args Operands;
    private int Operator;

    Aexp(Integer x) {

        int i;
        for (i = 0; i <= 2; i++) {
            if (i == 0) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }
        NUMBER = x;
    }

    Aexp(String x) {

        int i;

        for (i = 0; i <= 2; i++) {
            if (i == 1) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }

        ID = x;

    }

    Aexp(Args x, int op) {

        int i;

        for (i = 0; i <= 2; i++) {
            if (i == 2) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }

        Operands = x;
        Operator = op;

    }

    public String getexp() {

        String s = "";
        if (tag[0]) {
            s = "" + NUMBER;
        } else if (tag[1]) {
            s = ID;
        } else if (tag[2]) {

            if (Operator == sym.PLUS) {
                s = "PLUS(" + Operands.getfi().getexp() + "," + Operands.getse().getexp() + ")";
            } 
        }

        return s;
    }

    public int getval() {

        int val = 0;
        if (tag[0]) {
            val = NUMBER;
        } else if (tag[1]) {
            val = Integer.parseInt(SymbolTable.globalTable.get(ID).toString());
        } else if (tag[2]) {

            if (Operator == sym.PLUS) {
                val = Operands.getfi().getval() + Operands.getse().getval();
            } 
        }

        return val;
    }
}
