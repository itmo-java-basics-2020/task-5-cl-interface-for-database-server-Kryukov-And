package ru.andrey.kvstorage.console;

public class CommandCreateTable implements DatabaseCommand {
    private final ExecutionEnvironment environment;
    private final String databaseName;
    private final String tableName;

    public CommandCreateTable(ExecutionEnvironment environment,
                              String databaseName, String tableName) {
        this.environment = environment;
        this.databaseName = databaseName;
        this.tableName = tableName;
    }

    @Override
    public DatabaseCommandResult execute() {
        try {
            environment.getDatabase(databaseName).get().createTableIfNotExists(tableName);
            return DatabaseCommandResult.success("Table created successfully");
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
