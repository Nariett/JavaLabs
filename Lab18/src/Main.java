import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Привет");
        while (true) {
            //String connectionString = "jdbc:sqlserver://DESKTOP-RES35B3\\SQLSERVER;databaseName=JavaBase;integratedSecurity=true;";
            //String connectionString = "jdbc:h2:~/test", "sa","");
            System.out.println("1 Создайть таблицы\n2 Заполнить таблцы\n3 Отобрзить таблицы\n4 Выйти");
                int command = scanner.nextInt();
                switch (command) {
                    case 1:
                        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","");
                             Statement statement = connection.createStatement()) {
                            createTables(statement);
                            System.out.println("Созданы таблицы");
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","");
                             Statement statement = connection.createStatement()) {
                            fillTables(statement);
                            System.out.println("Таблицы заполнены");
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","");
                             Statement statement = connection.createStatement()) {
                            displayTableData(statement, "Лекарства");
                            displayTableData(statement, "Покупатели");
                            displayTableData(statement, "Продавцы");
                            displayTableData(statement, "Рецепты");
                            displayTableData(statement, "Продажа_лекарств");
                            System.out.println("Таблицы выведены");
                            connection.close();

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        System.out.println("Неизвестная команда");
                }
        }
    }
    private static void createTables(Statement statement) throws SQLException {
        // Создание таблиц
        statement.executeUpdate("CREATE TABLE Лекарства (id INT AUTO_INCREMENT(1,1) PRIMARY KEY, название NVARCHAR(100) NOT NULL, вид NVARCHAR(50) NOT NULL, цена DECIMAL(10,2) NOT NULL);");
        statement.executeUpdate("CREATE TABLE Покупатели ( id INT AUTO_INCREMENT(1,1) PRIMARY KEY, фамилия NVARCHAR(50) NOT NULL, имя NVARCHAR(50) NOT NULL, отчество NVARCHAR(50) NOT NULL, адрес NVARCHAR(100) NOT NULL, город NVARCHAR(50) NOT NULL, телефон NVARCHAR(20) NOT NULL);");
        statement.executeUpdate("CREATE TABLE Продавцы (id INT AUTO_INCREMENT(1,1) PRIMARY KEY, фамилия NVARCHAR(50) NOT NULL, имя NVARCHAR(50) NOT NULL, отчество NVARCHAR(50) NOT NULL, дата_поступления DATE NOT NULL, дата_рождения DATE NOT NULL, образование NVARCHAR(100) NOT NULL);");
        statement.executeUpdate("CREATE TABLE Рецепты (номер_рецепта INT AUTO_INCREMENT(1,1) PRIMARY KEY, дата_выдачи DATE NOT NULL, ФИО_больного NVARCHAR(150) NOT NULL, ФИО_врача NVARCHAR(150) NOT NULL, диагноз_пациента NVARCHAR(200) NOT NULL);");
        statement.executeUpdate("CREATE TABLE Продажа_лекарств (id INT AUTO_INCREMENT(1,1) PRIMARY KEY, дата DATE NOT NULL,лекарство INT NOT NULL, кол_во INT NOT NULL, рецепт INT, продавец INT, FOREIGN KEY (лекарство) REFERENCES Лекарства(id), FOREIGN KEY (рецепт) REFERENCES Рецепты(номер_рецепта), FOREIGN KEY (продавец) REFERENCES Продавцы(id));");
    }

    private static void fillTables(Statement statement) throws SQLException {
        // Заполнение таблиц данными
        statement.executeUpdate("INSERT INTO Лекарства (название, вид, цена)" +
                "VALUES ('Аспирин', 'Таблетки', 10.99)," +
                "('Ибупрофен', 'Таблетки', 7.99)," +
                "('Левомеколь', 'Мази', 15.50)," +
                "('Валериана', 'Настойки', 5.50);");
        statement.executeUpdate("INSERT INTO Покупатели (фамилия, имя, отчество, адрес, город, телефон)" +
                "VALUES ('Иванов', 'Иван', 'Иванович', 'ул. Центральная 1', 'Москва', '1234567890')," +
                "('Петров', 'Петр', 'Петрович', 'ул. Садовая 2', 'Санкт-Петербург', '9876543210')," +
                "('Сидорова', 'Анна', 'Петровна', 'ул. Лесная 3', 'Екатеринбург', '5555555555');");

        statement.executeUpdate("INSERT INTO Продавцы (фамилия, имя, отчество, дата_поступления, дата_рождения, образование)" +
                "VALUES ('Смирнов', 'Алексей', 'Иванович', '2020-01-01', '1980-05-15', 'Высшее')," +
                "('Петрова', 'Мария', 'Петровна', '2018-03-10', '1990-11-20', 'Среднее')," +
                "('Иванова', 'Екатерина', 'Андреевна', '2019-06-20', '1985-09-05', 'Высшее');");

        statement.executeUpdate("INSERT INTO Рецепты (дата_выдачи, ФИО_больного, ФИО_врача, диагноз_пациента)" +
                "VALUES ('2022-02-15', 'Иванов Иван Иванович', 'Смирнова Елена Петровна', 'Грипп')," +
                "('2022-03-20', 'Петрова Мария Петровна', 'Иванова Анастасия Сергеевна', 'Ангина')," +
                "('2022-04-10', 'Сидорова Анна Петровна', 'Петров Алексей Иванович', 'Аллергия');");
        statement.executeUpdate("INSERT INTO Продажа_лекарств (дата, лекарство, кол_во, рецепт, продавец)" +
                "VALUES ('2022-02-20', 1, 2, NULL, 1)," +
                "('2022-03-25', 2, 1, 1, 2)," +
                "('2022-04-15', 3, 3, 2, 3);");
    }
    public static void displayTableData(Statement statement, String tableName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName);
        ResultSetMetaData metaData = resultSet.getMetaData();

        System.out.println("Содержимое таблицы " + tableName + ":");

        // Вывод заголовков столбцов
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.print(metaData.getColumnName(i) + "\t");
        }
        System.out.println();

        // Вывод данных
        while (resultSet.next()) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.print(resultSet.getString(i) + "\t");
            }
            System.out.println();
        }

        resultSet.close();
    }
    private static void displayData(Statement statement) throws SQLException {
        // Вывод информации из таблиц
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Лекарства");
        while (resultSet.next()) {
            String название = resultSet.getString("название");
            String вид = resultSet.getString("вид");
            double цена = resultSet.getDouble("цена");

            System.out.println("Название: " + название + ", Вид: " + вид + ", Цена: " + цена);
        }
    }
    private static void displayTableFields(Statement statement, String tableName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + tableName + "'");
        System.out.println("Поля таблицы " + tableName + ":");
        while (resultSet.next()) {
            String columnName = resultSet.getString(1);
            System.out.println(columnName);
        }
        System.out.println();
        resultSet.close();
    }
}

