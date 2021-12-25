package com.modules.database;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class DatabaseTest {
    @Test
    void testMain() throws SQLException {
        Database.main(new String[]{"value"});
    }
}
