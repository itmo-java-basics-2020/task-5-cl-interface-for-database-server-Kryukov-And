package ru.andrey.kvstorage.console;

public class CommandUpdateKey implements DatabaseCommand {
    private final ExecutionEnvironment environment;
    private final String databaseName;
    private final String tableName;
    private final String key;
    private final String value;

    public CommandUpdateKey(ExecutionEnvironment environment,
                            String databaseName, String tableName, String key, String value) {
        this.environment = environment;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.key = key;
        this.value = value;
    }

    @Override
    public DatabaseCommandResult execute() {
        try {
            environment.getDatabase(databaseName).get().write(tableName, key, value);
            return DatabaseCommandResult.success("Key updated");
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
