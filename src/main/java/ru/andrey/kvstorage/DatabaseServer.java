package ru.andrey.kvstorage;

import java.util.Arrays;


import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.DatabaseCommands;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.console.DatabaseCommandResult.SimpleDatabaseCommandResult;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {

    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        try {
            if (commandText == null) {
                throw new IllegalArgumentException();
            }
            String[] query = commandText.split(" ");
            String command = query[0];
            String[] args = Arrays.copyOfRange(query, 1, query.length);
            return DatabaseCommands.valueOf(command).getCommand(env, args).execute();
        } catch (IllegalArgumentException e) {
            return SimpleDatabaseCommandResult.error("No such command");

        } catch (DatabaseException e) {
            return SimpleDatabaseCommandResult.error(e.getMessage());
        }
    }
}
