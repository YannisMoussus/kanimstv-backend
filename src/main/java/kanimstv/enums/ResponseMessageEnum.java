package kanimstv.enums;

public enum ResponseMessageEnum {

    RESOURCE_FIELD_UPDATED_OK("Field %s of %s resource has been updatede.");

    private String message;

    ResponseMessageEnum(String message) {
	this.message = message;
    }

    public String getMessage() {
	return message;
    }
}
