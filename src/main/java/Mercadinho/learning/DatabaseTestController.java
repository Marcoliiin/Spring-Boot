package Mercadinho.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Component
public class DatabaseTestController {

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