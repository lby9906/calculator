package org.example.lv3;

public enum OperatorType {
    SUM("+"), SUB("-"), MUI("*") ,DIV("/");

    private final String content;

    OperatorType(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public static OperatorType fromContent(String operation) {
        for (OperatorType oper : values()) {
            if (oper.getContent().equals(operation)){
                return oper;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }
}

