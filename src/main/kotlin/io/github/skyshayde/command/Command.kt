package io.github.skyshayde.command

import com.darichey.discord.Command
import com.darichey.discord.CommandContext
import io.github.skyshayde.AlfredBot

abstract class Command(name: String) {
    abstract val help: String
    abstract val desc: String
    abstract fun execute(ctx: CommandContext)

    init {
        AlfredBot.registry.register(Command.builder().onCalled { execute(it) }.build(), name)
        AlfredBot.commands[name] = this
    }
}