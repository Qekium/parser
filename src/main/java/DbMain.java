import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;

public class DbMain {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:mem:";
        DriverDataSource dataSource = new DriverDataSource(
                url,
                "org.h2.Driver",
                null,
                "sa",
                ""
        );
        JdbcTemplate template = new JdbcTemplate(dataSource);
        Integer result = template.queryForObject("select 1+1", Integer.class);
        System.out.println(result);
    }
}
