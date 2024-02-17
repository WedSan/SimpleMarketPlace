package wedsan.simplemarketplace.core.domain;

public class SellerDocument extends UserDocument{

    public SellerDocument(String documentNumber) {
        super(documentNumber);
    }

    @Override
    boolean validateDocument(String document) {
        document = document.replaceAll("\\D", "");

        if (document.length() != 14 || !document.matches("\\d{14}")) {
            return false;
        }

        int[] weights = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (document.charAt(i) - '0') * weights[i];
        }

        int digit1 = 11 - (sum % 11);
        if (digit1 > 9) {
            digit1 = 0;
        }

        sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (document.charAt(i) - '0') * weights[i + 1];
        }

        int digit2 = 11 - (sum % 11);
        if (digit2 > 9) {
            digit2 = 0;
        }

        return document.charAt(12) - '0' == digit1 && document.charAt(13) - '0' == digit2;
    }
}
