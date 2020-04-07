package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.console.DatabaseCommandResult.SimpleDatabaseCommandResult;


public class CreateTable implements DatabaseCommand {
    private final ExecutionEnvironment env;
    private final String databaseName;
    private final String tableName;

    public CreateTable(ExecutionEnvironment env, String databaseName, String tableName) {
        this.env = env;
        this.databaseName = databaseName;
        this.tableName = tableName;
    }

    @Override
    public DatabaseCommandResult execute() {
        return env.getDatabase(databaseName).map(database -> {
            try {
                database.createTableIfNotExists(tableName);
                return SimpleDatabaseCommandResult.success(
                        String.format("Table '%s'/'%s' was created.", databaseName, tableName)
                );
            } catch (DatabaseException e) {
                return SimpleDatabaseCommandResult.error(e.getMessage());
            }
        }).orElseGet(() -> SimpleDatabaseCommandResult.error(
                String.format("Database '%s' doesn't exist", databaseName)
        ));
    }
}
