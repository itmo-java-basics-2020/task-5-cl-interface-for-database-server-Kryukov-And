package ru.andrey.kvstorage.console;

public class CommandReadKey implements DatabaseCommand {
    private final ExecutionEnvironment environment;
    private final String databaseName;
    private final String tableName;
    private final String key;

    public CommandReadKey(ExecutionEnvironment environment,
                          String databaseName, String tableName, String key) {
        this.environment = environment;
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.key = key;
    }

    @Override
    public DatabaseCommandResult execute() {
        try {
            String value = environment.getDatabase(databaseName).get().read(tableName, key);

            if (value == null) {
                return DatabaseCommandResult.error("Key not found");
            }

            return DatabaseCommandResult.success("Value = " + value);
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }

}
