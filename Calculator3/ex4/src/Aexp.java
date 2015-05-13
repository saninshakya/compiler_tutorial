package src;


public class Aexp {

    private boolean[] tag = new boolean[2];
    private Integer NUMBER;
    private Args Operands;
    private int Operator;

    Aexp(Integer x) {

        int i;
        for (i = 0; i < 2; i++) {
            if (i == 0) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }
        NUMBER = x;
    }

    Aexp(Args x, int op) {

        int i;

        for (i = 0; i < 2; i++) {
            if (i == 1) {
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

            if (Operator == sym.PLUS) {
                s = "PLUS(" + Operands.getfi().getexp() + "," + Operands.getse().getexp() + ")";
            } else if (Operator == sym.MINUS) {
                s = "MINUS(" + Operands.getfi().getexp() + "," + Operands.getse().getexp() + ")";
            }
            if (Operator == sym.TIMES) {
                s = "TIMES(" + Operands.getfi().getexp() + "," + Operands.getse().getexp() + ")";
            }
            if (Operator == sym.DIVIDE) {
                s = "DIVIDE(" + Operands.getfi().getexp() + "," + Operands.getse().getexp() + ")";
            }
        }

        return s;
    }

    public int getval() {

        int val = 0;
        if (tag[0]) {
            val = NUMBER;
        } else if (tag[1]) {

            if (Operator == sym.PLUS) {
                val = Operands.getfi().getval() + Operands.getse().getval();
            } else if (Operator == sym.MINUS) {
                val = Operands.getfi().getval() - Operands.getse().getval();
            }
            if (Operator == sym.TIMES) {
                val = Operands.getfi().getval() * Operands.getse().getval();
            }
            if (Operator == sym.DIVIDE) {
                val = Operands.getfi().getval() / Operands.getse().getval();
            }
        }

        return val;
    }
}
