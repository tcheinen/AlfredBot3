package io.github.skyshayde.features

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import sx.blah.discord.api.events.EventSubscriber
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent
import sx.blah.discord.handle.obj.IMessage

class LevelupCleaner() {
    val POKECORD_ID: Long = 365975655608745985

    @EventSubscriber
    fun onChatMessage(event: MessageReceivedEvent) {
        val m: IMessage = event.message
        if(m.author.longID == POKECORD_ID && m.embeds.size > 0) {
            if(m.embeds.last().description != null && m.embeds.last().description.matches(Regex("Your (.*?) is now level (.*?)!"))) {
                launch {
                    delay(30000)
                    m.delete()
                }
            }
        }
    }
}