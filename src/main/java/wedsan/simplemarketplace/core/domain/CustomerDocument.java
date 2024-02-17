package wedsan.simplemarketplace.core.domain;

public class CustomerDocument extends UserDocument {

    public CustomerDocument(String documentNumber) {
        super(documentNumber);
    }

    @Override
    boolean validateDocument(String document) {
        document = document.replaceAll("\\D", "");

        if (document.length() != 11 || !document.matches("\\d{11}")) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (document.charAt(i) - '0') * (10 - i);
        }

        int digit1 = 11 - (sum % 11);
        if (digit1 > 9) {
            digit1 = 0;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (document.charAt(i) - '0') * (11 - i);
        }

        int digit2 = 11 - (sum % 11);
        if (digit2 > 9) {
            digit2 = 0;
        }

        return document.charAt(9) - '0' == digit1 && document.charAt(10) - '0' == digit2;
    }
}


