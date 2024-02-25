package wedsan.simplemarketplace.core.domain;

public class ShopkeeperDocument extends UserDocument {

    public ShopkeeperDocument(String documentNumber) {
        super(documentNumber);
    }

    @Override
    public boolean validateDocument(String cnpj) {
        if(cnpj == null || cnpj.isEmpty() ){
            System.out.println("Fase 1 falhou");
            return false;
        }
        cnpj = cnpj.replaceAll("[^0-9]","");
        if(cnpj.length()>14){
            System.out.println("Fase 2 falhou");
            return false;
        }
        if(cnpj.matches("(\\d)\\1{13}")){
            System.out.println("Fase 3 falhou");
            return false;
        }
        System.out.println(cnpj);
        int firstDigit = calculateFirstDigit(cnpj);
        int secondDigit = calculateSecondDigit(cnpj);

        int firstDigitCnpj = Integer.parseInt(String.valueOf(cnpj.charAt(12))) ;
        int secondDigitCnpj = Integer.parseInt(String.valueOf(cnpj.charAt(13)));
        System.out.println(firstDigit);
        System.out.println(secondDigit);
        System.out.println("Fase 4");
        System.out.println(firstDigitCnpj);
        System.out.println(secondDigitCnpj);
        return  ((firstDigitCnpj == firstDigit) && (secondDigitCnpj == secondDigit));
    }

    private int calculateFirstDigit(String cnpj){
        int[] weight = {5,4,3,2,9,8,7,6,5,4,3,2};
        int verifyingDigit = 0;

        int sum = 0;
        for(int i =0; i<weight.length ; i++) {
            String character = String.valueOf(cnpj.charAt(i));
            int value = Integer.parseInt(character);
            sum += weight[i] * value;
        }
        int rest = sum % 11;

        if (rest < 2) {
            verifyingDigit = 0;
        } else {
            verifyingDigit = 11 - rest;
        }
        return verifyingDigit;
    }


    private int calculateSecondDigit(String cnpj){
        int verifyingDigit;
        int sum = 0;
        int [] weight = {6,5,4,3,2,9,8,7,6,5,4,3,2};
        for(int i = 0; i<weight.length; i++){
            String character = String.valueOf(cnpj.charAt(i));
            int value = Integer.parseInt(character);
            sum += weight[i] * value;
        }

        int rest = sum%11;

        if(rest < 2){
            verifyingDigit =  0;
        }
        else{
            verifyingDigit = 11-rest;
        }
        return verifyingDigit;
    }
}
