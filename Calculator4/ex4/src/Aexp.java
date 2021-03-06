package src;


public class Aexp {

    private boolean[] tag = new boolean[4];
    private Integer NUMBER;
    private Float FLOAT;
    private String ID;
    private Args Operands;
    private int Operator;
    private int Type = -1; // int_type = 0, float_type = 1;

    Aexp(Integer x) {

        int i;
        for (i = 0; i <= 3; i++) {
            if (i == 0) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }
        NUMBER = x;
        Type = 0;
    }

  
    Aexp(Float x) {

        int i;
        for (i = 0; i <= 3; i++) {
            if (i == 3) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }
        FLOAT = x;
        Type = 1;
    }
    
    
    Aexp(String x) {

        int i;

        for (i = 0; i <= 3; i++) {
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

        for (i = 0; i <= 3; i++) {
            if (i == 2) {
                tag[i] = true;
            } else {
                tag[i] = false;
            }
        }
              
        if (x.getfi().Type == 0 && x.getse().Type == 0) { 
            
            Type = 0;
            
        } else if (x.getfi().Type == 1 && x.getse().Type == 1){
               
            Type = 1;
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
            } else if (Operator == sym.MINUS) {
                s = "MINUS(" + Operands.getfi().getexp() + "," + Operands.getse().getexp() + ")";
            }
            if (Operator == sym.TIMES) {
                s = "TIMES(" + Operands.getfi().getexp() + "," + Operands.getse().getexp() + ")";
            }
            if (Operator == sym.DIVIDE) {
                s = "DIVIDE(" + Operands.getfi().getexp() + "," + Operands.getse().getexp() + ")";
            }
        } else if (tag[3]) {
            s = "" + FLOAT;
        }
        

        return s;
    }

    public String getval() {

        String val="";
        String n1,n2;
        int t1,t2;
        if (tag[0]) {
            val = Integer.toString(NUMBER);
        } else if (tag[1]) {
            val="";
        } else if (tag[2]) {
            
            n1 = Operands.getfi().getval();
            n2 = Operands.getse().getval();
            
            t1 = Operands.getfi().Type;
            t2 = Operands.getse().Type;
            
            if (Operator == sym.PLUS) {
                if (t1 == 0 && t2 == 0) {
                   val =Integer.toString(Integer.parseInt(n1) + Integer.parseInt(n2));
                } else if (t1 == 1 && t2 == 1) {
                   val = Float.toString(Float.parseFloat(n1) + Float.parseFloat(n2));
                } else {
                    System.err.print("Error: Type mismatch at PLUS operator!");
                    System.exit(0);
                }
                
            } else if (Operator == sym.MINUS) {
                if (t1 == 0 && t2 == 0) {
                   val =Integer.toString(Integer.parseInt(n1) - Integer.parseInt(n2));
                } else if (t1 == 1 && t2 == 1) {
                   val = Float.toString(Float.parseFloat(n1) - Float.parseFloat(n2));
                } else {
                    System.err.print("Error: Type mismatch at MINUS operator!");
                    System.exit(0);
                }
                
            } else if (Operator == sym.TIMES) {
                if (t1 == 0 && t2 == 0) {
                   val =Integer.toString(Integer.parseInt(n1) * Integer.parseInt(n2));
                } else if (t1 == 1 && t2 == 1) {
                   val = Float.toString(Float.parseFloat(n1) * Float.parseFloat(n2));
                } else {
                    System.err.print("Error: Type mismatch at TIMES operator!");
                    System.exit(0);
                }
                
            } else if (Operator == sym.DIVIDE) {
                if (t1 == 0 && t2 == 0) {
                   val =Integer.toString(Integer.parseInt(n1) / Integer.parseInt(n2));
                } else if (t1 == 1 && t2 == 1) {
                   val = Float.toString(Float.parseFloat(n1) / Float.parseFloat(n2));
                } else {
                    System.err.print("Error: Type mismatch at DEVIDE operator!");
                    System.exit(0);
                }
            }
        } else if (tag[3]) {
            val = Float.toString(FLOAT);
        }

        return val;
    }
    
    
}
