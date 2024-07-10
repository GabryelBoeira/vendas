package br.com.gabryel.vendas.exception;

import java.io.Serializable;

public class BusinessException extends Exception implements Serializable {

    private static final long serialVersionUID = -6723179714411612071L;

    public BusinessException(String message) {
        super(message);
    }

}
