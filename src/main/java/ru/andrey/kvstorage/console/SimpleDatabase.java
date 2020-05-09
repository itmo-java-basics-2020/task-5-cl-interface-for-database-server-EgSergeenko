package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class SimpleDatabase implements Database {

    public SimpleDatabase() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void createTableIfNotExists(String tableName) throws DatabaseException {

    }

    @Override
    public void createTableIfNotExists(String tableName, int segmentSizeInBytes) throws DatabaseException {

    }

    @Override
    public void write(String tableName, String objectKey, String objectValue) throws DatabaseException {

    }

    @Override
    public String read(String tableName, String objectKey) throws DatabaseException {
        return null;
    }
}
