package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.logic.Database;
import ru.andrey.kvstorage.console.DatabaseCommandResult.SimpleDatabaseCommandResult;

public class CreateDatabaseCommand implements DatabaseCommand {
    private final ExecutionEnvironment env;
    private final String databaseName;
    private final Database database;

    public CreateDatabaseCommand(ExecutionEnvironment env, String databaseName, Database database) {
        this.env = env;
        this.databaseName = databaseName;
        this.database = database;
    }

    @Override
    public DatabaseCommandResult execute() {
        return env.getDatabase(databaseName).map(x ->
                SimpleDatabaseCommandResult.error("Database already exists")
        ).orElseGet(() -> {
            env.addDatabase(database);
            return SimpleDatabaseCommandResult.success("Database was created successfully");
        });
    }
}
