package eadanilov;

public enum CardData {

    INVALID_PAN("4444444444444444", "0224", "199", "Недопустимый номер карты."),
    INVALID_YEAR("4444444444444448", "0218", "199", "Год истечения срока действия карты относится к прошлому.");

    private String pan;
    private String mmyy;
    private String cvc;
    private String errorMessage;

    CardData(String pan, String mmyy, String cvc, String errrorMessage) {
        this.pan = pan;
        this.mmyy = mmyy;
        this.cvc = cvc;
        this.errorMessage = errrorMessage;
    }

    public String getPan() {
        return pan;
    }

    public String getExpire() {
        return mmyy;
    }

    public String getCvc() {
        return cvc;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
