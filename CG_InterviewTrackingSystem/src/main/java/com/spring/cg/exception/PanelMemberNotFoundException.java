package com.spring.cg.exception;

public class PanelMemberNotFoundException extends Exception{
    public String Message;
    public PanelMemberNotFoundException(){
        this.Message = "";
    }
    public PanelMemberNotFoundException(String customMessage) {
        this.Message = customMessage;
    }
    @Override
    public String toString() {
        return "Panel Member not found " + this.Message;
    }
}
