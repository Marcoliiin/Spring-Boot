package Mercadinho.learning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/test")
public class DatabaseTestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/database")
    public @ResponseBody String testDatabaseConnection() {
        try {
            String result = jdbcTemplate.queryForObject("SELECT 1", String.class);
            return "Conexão com o banco de dados bem-sucedida! Resultado: " + result;
        } catch (Exception e) {
            return "Erro ao conectar ao banco de dados: " + e.getMessage();
        }
    }
}
