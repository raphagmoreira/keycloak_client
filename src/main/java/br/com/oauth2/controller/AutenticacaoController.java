package br.com.oauth2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/autenticacao")
public class AutenticacaoController {

    @Autowired
    private WebClient webClient;

    @GetMapping(value = "/externo")
    public Mono<String> autenticarExterno() {
        return webClient
                .get()
                .uri("http://localhost:9000/api/authentication")
                //.header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJfa0E2bkxjYTBoVEthU1hOd1lRbHAzZU5xSmhvb0VNUk14Qi0xcUJyRFhvIn0.eyJleHAiOjE2MjM5NTk4NDUsImlhdCI6MTYyMzk1OTU0NSwianRpIjoiZTAwYjE1YTctMDRkNS00MDZkLTk4ZjgtMjc5MzhhMDY5NjZhIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4OTk5L2F1dGgvcmVhbG1zL2RlbW8iLCJzdWIiOiJmNGI4ZThkMy02NzU1LTRmMzYtYmYwMy0xMTg1NmE0ZDE4MzMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJwcmltZWlyby10ZXN0ZSIsInNlc3Npb25fc3RhdGUiOiI5MGNkYzY0ZC00MWZiLTQ1NGQtYjkwOC00NGE5OGYzZTlmY2UiLCJhY3IiOiIxIiwic2NvcGUiOiJ0ZXN0ZSIsImF1dGhvcml0aWVzIjpbIi9BZG1pbmlzdHJhZG9yIl19.iVwBMsMKz8Y1kzSujSS95vaIKi_3JeW9Hpvb3mrmENbuQZIEI6qF4NvPCok8sCzv3bfKqDsbmhpg8vvGoaaSw4J-FvN6vbJdeJNo-M6e1ODjDvvoEPraf9sr9iXfXsLseYkXzKa89JvMPahoK7m-tfoC96H0ksU9TkexQyYSwgCdTJ_bMkBCcyBMYY5dQ1AvZxgW8t8w_gu8Fi4_qU2go6wKUSEaRyc-0Vk7QXscdP5jifwJMdx-rRE94kK3CFm1KRWL3pK6wLCQXpultT7rMdiEGT-CD__cLayRAFWwWu1FT1_R5ACEybO2i_s1ZRtD_qQs1f3L20Bs3ngHMS447w")
                .retrieve()
                .bodyToMono(String.class)
                .map(retorno -> "Metodo Externo para " + retorno);
    }

}
