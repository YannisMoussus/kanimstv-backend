package kanimstv.enums;

public enum ExceptionMessageEnum {

    FIELD_OBLIGATORY("Le champ %s est obligatoire."),
    MEMBER_INCUBATOR_NOT_FOUND("Aucun membre de l'incubateur trouvé.");

    private String message;

    ExceptionMessageEnum(String message) {
	this.message = message;
    }

    public String getMessage() {
	return message;
    }
}
