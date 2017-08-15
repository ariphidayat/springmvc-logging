package org.arip.logging.aop;

/**
 * Created by Arip Hidayat on 8/15/2017.
 */
public enum AuditActionType {

    CREATE("CREATE"),
    UPDATE("UPDATE"),
    DELETE("DELETE");

    private final String type;

    AuditActionType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
