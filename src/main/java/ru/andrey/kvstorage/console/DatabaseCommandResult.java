package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    static DatabaseCommandResult success(String result) {
        return new DatabaseCommandResultClass(DatabaseCommandStatus.SUCCESS, result);
    }

    static DatabaseCommandResult error(String message) {
        return new DatabaseCommandResultClass(DatabaseCommandStatus.FAILED, message);
    }

    class DatabaseCommandResultClass implements DatabaseCommandResult {
        private final DatabaseCommandStatus status;
        private final String message;

        private DatabaseCommandResultClass(DatabaseCommandStatus status, String message) {
            this.status = status;
            this.message = message;
        }

        @Override
        public Optional<String> getResult() {
            if (isSuccess()) {
                return Optional.of(message);
            }

            return Optional.empty();
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return status;
        }

        @Override
        public boolean isSuccess() {
            return status == DatabaseCommandStatus.SUCCESS;
        }

        @Override
        public String getErrorMessage() {
            if (isSuccess()) {
                return null;
            }

            return message;
        }
    }
}