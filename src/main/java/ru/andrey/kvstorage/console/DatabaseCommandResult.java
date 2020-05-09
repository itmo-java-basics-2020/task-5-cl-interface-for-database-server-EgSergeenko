package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    String getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    class SimpleDatabaseCommandResult implements DatabaseCommandResult {
        private final String result;
        private final DatabaseCommandStatus status;
        private String errorMessage;

        private SimpleDatabaseCommandResult(String result, DatabaseCommandStatus status) {
            this.result = result;
            this.status = status;
        }

        private SimpleDatabaseCommandResult(String result, DatabaseCommandStatus status, String errorMessage) {
            this(result, status);
            this.errorMessage = errorMessage;
        }

        public static SimpleDatabaseCommandResult success(String result) {
            return new SimpleDatabaseCommandResult(result, DatabaseCommandStatus.SUCCESS);
        }

        public static SimpleDatabaseCommandResult error(String errorMessage) {
            return new SimpleDatabaseCommandResult(null, DatabaseCommandStatus.FAILED, errorMessage);
        }

        @Override
        public String getResult() {
            return result;
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return status;
        }

        @Override
        public boolean isSuccess() {
            return status.equals(DatabaseCommandStatus.SUCCESS);
        }

        @Override
        public String getErrorMessage() {
            return errorMessage;
        }
    }
}