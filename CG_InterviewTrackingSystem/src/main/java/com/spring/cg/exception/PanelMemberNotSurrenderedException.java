package com.spring.cg.exception;

public class PanelMemberNotSurrenderedException extends Exception{
    public String Message;
    public PanelMemberNotSurrenderedException(){
        this.Message = "";
    }
    public PanelMemberNotSurrenderedException(String customMessage) {
        this.Message = customMessage;
    }
    @Override
    public String toString() {
        return "Panel Member not yet surrenderd " + this.Message;
    }
}
