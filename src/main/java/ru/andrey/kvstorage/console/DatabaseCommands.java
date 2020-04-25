package ru.andrey.kvstorage.console;

public enum DatabaseCommands {
    CREATE_DATABASE {
        public DatabaseCommand getCommand(ExecutionEnvironment environment, String... args) {
            if (args.length != 1) {
                throw new IllegalArgumentException("Excepted 1 argument");
            }

            return new CommandCreateDatabase(environment, args[0]);
        }
    }, CREATE_TABLE {
        public DatabaseCommand getCommand(ExecutionEnvironment environment, String... args) {
            if (args.length != 2) {
                throw new IllegalArgumentException("Excepted 2 arguments");
            }

            return new CommandCreateTable(environment, args[0], args[1]);
        }
    }, UPDATE_KEY {
        public DatabaseCommand getCommand(ExecutionEnvironment environment, String... args) {
            if (args.length != 4) {
                throw new IllegalArgumentException("Excepted 4 arguments");
            }

            return new CommandUpdateKey(environment, args[0], args[1], args[2], args[3]);
        }
    }, READ_KEY {
        public DatabaseCommand getCommand(ExecutionEnvironment environment, String... args) {
            if (args.length != 3) {
                throw new IllegalArgumentException("Excepted 3 arguments");
            }

            return new CommandReadKey(environment, args[0], args[1], args[2]);
        }
    };

    public abstract DatabaseCommand getCommand(ExecutionEnvironment environment, String... args);
}
