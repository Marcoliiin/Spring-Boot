package Mercadinho.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Clients {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void createClient(String name, String sex, String address) {
        try {
            String sql = "INSERT INTO clientes (name, sex, address) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, name, sex, address);
            System.out.println("Cliente cadastrado com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro ao cadastrar o cliente: " + e.getMessage());
        }
    }
}
