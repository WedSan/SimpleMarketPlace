package wedsan.simplemarketplace.core.domain;

public abstract class UserDocument {

    private String documentNumber;

    public UserDocument(String documentNumber) {
        validateAndSetDocumentNumber(documentNumber);
    }

    abstract boolean validateDocument(String document);

    private void validateAndSetDocumentNumber(String documentNumber){
        if(validateDocument(documentNumber)){
            this.documentNumber = documentNumber;
        }
        else{
            throw new IllegalArgumentException("Document is not valid");
        }
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        validateAndSetDocumentNumber(documentNumber);
    }


}
