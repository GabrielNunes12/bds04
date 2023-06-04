package com.devsuperior.bds04.config;

public class FieldMessage {
  private String fieldName;
  private String message;

  public FieldMessage() {
  }

  public FieldMessage(String field, String message) {
    this.fieldName = field;
    this.message = message;
  }

  public String getFieldMessage() {
    return fieldName;
  }

  public void setFieldMessage(String fieldMessage) {
    this.fieldName = fieldMessage;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
