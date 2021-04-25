package it.ranauro;

public class UnaClasse {
    public class EccezioneNonVoglioZero extends Exception{
        private static final long serialVersionUID = 1L;

        public EccezioneNonVoglioZero(String msg){
            super();
            System.err.println(msg);
        }
    }

    public int unMetodo(int i) throws EccezioneNonVoglioZero{
        if (i==0){
            throw new EccezioneNonVoglioZero("Come ti permetti criminologo");
        }
        return i;
    }

    private String unMetodoPrivato(){
        return "Sono FrattoLILLO";
    }
}
