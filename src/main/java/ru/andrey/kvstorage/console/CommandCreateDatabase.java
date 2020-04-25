package ru.andrey.kvstorage.console;

public class CommandCreateDatabase implements DatabaseCommand {
    private final ExecutionEnvironment environment;
    private final String databaseName;

    public CommandCreateDatabase(ExecutionEnvironment environment,
                                 String databaseName) {
        this.environment = environment;
        this.databaseName = databaseName;
    }

    @Override
    public DatabaseCommandResult execute() {
        environment.addDatabase(null);
        return DatabaseCommandResult.success("Database created successfully");
    }
}
