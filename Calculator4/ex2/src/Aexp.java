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

    public int getTag() {

        if (tag[0] == true) {
            return 0;
        } else {
            return 1;
        }
    }

    public String getexp() {
        Aexp Fi, Se;
        String s = "";
        if (tag[0]) {
            s = s + NUMBER;
        } else if (tag[1]) {
            Fi = Operands.getfi();
            Se = Operands.getse();

            if (Operator == sym.PLUS) {

                if (Fi.getTag() == 0) {
                    s = "E(" + "E(" + Fi.getexp() + ")" + " " + Se.getexp() + " PLUS " + ")";
                }
                if (Fi.getTag() == 1) {
                s = "E(" + Fi.getexp() + " " + Se.getexp() + " PLUS " + ")";
                }
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
            }
        }

        return val;
    }
}
