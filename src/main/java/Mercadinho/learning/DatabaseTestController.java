package Mercadinho.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*Quando uma classe é anotada com @Component significa
que a mesma usará o padrão de injeção de depêndencia, e será elegível para auto-configuração
 e auto-detecção de beans anotados à partir de escaneamento de classpath que o IoC Container do Spring faz.*/

@Component
public class DatabaseTestController {
/*O Autowired (@Autowired) é a anotação mais utiliza com relação a injeção de dependências.
    Como o próprio nome diz, o Autowired, indica um ponto aonde a injeção automática deve ser aplicada. 
    Esta pode ser usada em métodos, atributos e construtores.*/
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Clients clients;

    @GetMapping("/database")
    public @ResponseBody String testDatabaseConnection() {
        try {
            String result = jdbcTemplate.queryForObject("SELECT 1", String.class);
            return "Conexão com o banco de dados bem-sucedida! Resultado: " + result;
        } catch (Exception e) {
            return "Erro ao conectar ao banco de dados: " + e.getMessage();
        }
    }

    @PostMapping("/clients")
    public String createClient(@RequestBody ClientDTO clientDTO) {
        clients.createClient(clientDTO.getName(), clientDTO.getSex(), clientDTO.getAddress());
        return "Cliente cadastrado com sucesso.";
    }
}
