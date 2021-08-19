import org.junit.jupiter.api.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Проверка подключения к БД sakila и отправки запросов")
public class Tests {
    @BeforeEach
    public void setUp() {

        Assertions.assertNotNull(Connect.connectToDB());
    }

    @AfterEach
    public void tearDown() {
        Connect.closeConnection();

    }

        @Test
        @Order(1)
        @DisplayName("Проверка создания таблицы в БД")
        public void testCreateTable() {
            String query = "CREATE TABLE citizens ("
                    + "ID int(6) NOT NULL,"
                    + "FIRST_NAME VARCHAR(45) NOT NULL,"
                    + "LAST_NAME VARCHAR(45) NOT NULL,"
                    + "TOWN VARCHAR(45),"
                    + "PRIMARY KEY (id))";
            Connect.createTable(query);
        }
    @Test
    @Order(2)
    @DisplayName("Отправка INSERT запроса")
    public void testInsertRequest() {
        String query = "INSERT INTO citizens (ID, FIRST_NAME, LAST_NAME, TOWN) VALUES (230009, 'Vasia', 'Petrov', 'Grodno')";
        Connect.insertIntoTable(query);

        String selectQuery = "SELECT * FROM citizens";
        ResultSet rs = Connect.selectFromTable(selectQuery);
        assertAll("Should return inserted data",
                () -> assertEquals("230009", rs.getString("ID")),
                () -> assertEquals("Vasia", rs.getString("FIRST_NAME")),
                () -> assertEquals("Petrov", rs.getString("LAST_NAME")),
                () -> assertEquals("Grodno", rs.getString("TOWN")));
    }

    @Test
    @Order(3)
    public void testUpdateRequest() throws SQLException {
        String query = "UPDATE citizens SET TOWN = 'MINSK' WHERE ID='230009'";
        Connect.updateInTable(query);
        String selectQuery = "SELECT TOWN FROM citizens WHERE ID=230009";
        ResultSet rs = Connect.selectFromTable(selectQuery);
        String expectedTown = "MINSK";
        String actualTown = rs.getString("TOWN");
        assertEquals(expectedTown, actualTown, "Actual town is '" + actualTown + "'. Expected - '" + expectedTown + "'.");
    }

    @Test
    @Order(4)
    @DisplayName("Отправка DELETE запроса")
    public void testDeleteRequest() {
        String query = "DELETE FROM citizens WHERE ID=230009";
        Connect.deleteFromTable(query);
    }

    @Test
    @Order(5)
    @DisplayName("Проверка удаления таблицы из БД")
    public void test_dropTable() {
        Connect.dropTable("citizens");
    }

    @Test
    @Order(6)
    @DisplayName("Отправка простого SELECT запроса. Проверка адреса")
    public void testSelectRequest_checkAddress() throws SQLException {
        String query = "SELECT * FROM address WHERE address_id=100";
        ResultSet rs = Connect.selectFromTable(query);
        String expectedAddress = "1308 Arecibo Way";
        String actualAddress = rs.getString("address");
        assertEquals(expectedAddress, actualAddress, "Actual address is '" + actualAddress + "'. Expected - '"
                + expectedAddress + "'.");
    }

    @Test
    @Order(7)
    @DisplayName("Отправка SELECT JOIN запроса. Проверка принадлежности города стране")
    public void testSelectWithJoinRequest_CheckCityAndCountry() throws SQLException {
        String query = "SELECT ct.city, cntr.country FROM city ct LEFT JOIN country cntr ON " +
                "ct.country_id=cntr.country_id WHERE city='Moscow'";
        ResultSet rs = Connect.selectFromTable(query);
        String expectedCountry = "Russian Federation";
        String actualCountry = rs.getString("country");
        assertEquals(expectedCountry, actualCountry, "Actual country is '" + actualCountry +
                "'. Expected - '" + expectedCountry + "'.");
    }

    @Test
    @Order(8)
    @DisplayName("Отправка SELECT JOIN запроса. Проверка языка последнего в списке фильма")
    public void testSelectWithJoinRequest_CheckFilmLanguage() throws SQLException {
        String query = "SELECT f.title, l.name FROM film f LEFT JOIN language l ON f.language_id=l.language_id";
        ResultSet rs = Connect.selectFromTable(query);
        rs.last();
        String expectedLanguage = "French";
        String actualLanguage = rs.getString("name");
        assertEquals(expectedLanguage, actualLanguage, "Actual language is '" + actualLanguage +
                "'. Expected - '" + expectedLanguage + "'.");
    }
}
