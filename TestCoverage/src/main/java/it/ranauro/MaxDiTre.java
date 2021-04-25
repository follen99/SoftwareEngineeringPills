package it.ranauro;

public class MaxDiTre {
    /**
     * PER TORNARE N1
     * n1 deve essere piu grande sia di n2 che di n3
     *
     * PER TORNARE N2
     * n2 deve essere piu grande di n1 e di n3
     *
     * PER TORNARE N3
     * n1 deve essere piu grande di n2, ma piu piccolo di n3*/


    public static int max(int num1, int num2, int num3) {
        if(num1 >= num2) {
            if(num1 >= num3)
                return num1;
            else
                return num3;
        }
        else {
            if(num2 >= num3)
                return num2;
            else
                return num3;
        }
    }
}
