package me.choicore.springbootddd.domain.user.command;

public sealed interface UserCommand permits UserCommand.Create, UserCommand.Delete, UserCommand.Modify, UserCommand.Query {
    non-sealed interface Create extends UserCommand {
    }


    non-sealed interface Query<T> extends UserCommand {
        T userId();
    }

    non-sealed interface Modify<T> extends UserCommand {
        T userId();

    }

    non-sealed interface Delete<T> extends UserCommand {
        T userId();

    }

}