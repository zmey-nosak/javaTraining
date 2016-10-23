package tableManipulation;

import lombok.SneakyThrows;
import org.h2.tools.RunScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;

/**
 * Created by Echetik on 16.10.2016.
 */

public class TableManipulation {
    String url;

    public TableManipulation(String pathToConfig) {
        initDriver(pathToConfig);
        intiDb();
    }

    @SneakyThrows
    private void initDriver(String pathToConfig) {
        Properties properties = new Properties();
        properties.load(new FileInputStream(pathToConfig));
        Class.forName(properties.getProperty("driver"));
        url = (properties.getProperty("url"));
        int poolSize = Integer.parseInt(properties.getProperty("poolSize"));
    }

    @SneakyThrows
    public void intiDb() {
        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement();
        ) {
            Path path = FileSystems.getDefault().getPath("src/test/resources/db/");
            Files.list(path).filter((Path p) -> {
                return p.toString().contains(".sql");
            }).forEachOrdered(p -> {
                try {
                    RunScript.execute(conn, new FileReader(p.toFile()));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            });

            try (ResultSet resultSet = st.executeQuery("SELECT * FROM PERSONS")) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id") + " " + resultSet.getString("F_NAME") + " " + resultSet.getString("L_NAME"));
                }
            }
            String sql = "SELECT id, F_NAME, L_NAME FROM PERSONS WHERE id=?";
            try (PreparedStatement ps = conn.prepareStatement(sql);) {
                ps.setInt(1, 2);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(rs.getString("F_NAME") + " " + rs.getString("L_NAME"));
                    }
                }
            }
        }
    }


}
