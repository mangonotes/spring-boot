package com.example.demo.ui.dto;

import java.io.Serializable;
import java.util.Objects;

public class JmsResult implements Serializable {
    private int id;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JmsResult jmsResult = (JmsResult) o;
        return id == jmsResult.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
