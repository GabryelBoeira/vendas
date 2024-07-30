package io.github.gabryel.securitysboot.security;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdentificacaoUsuario implements Serializable {

    private static final long serialVersionUID = 5555235518776844455L;

    private String id;
    private String nome;
    private String login;
    private List<String> permissoes;

    public List<String> getPermissoes() {
        return CollectionUtils.isEmpty(permissoes) ? new ArrayList<>() : permissoes;
    }

}
