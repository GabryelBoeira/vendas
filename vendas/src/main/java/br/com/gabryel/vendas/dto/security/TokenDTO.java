package br.com.gabryel.vendas.dto.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenDTO {

    private String token;
    private String login;

    public TokenDTO() {
    }

    public TokenDTO(String login, String token) {
        this.token = token;
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
