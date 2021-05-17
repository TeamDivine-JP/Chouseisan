package com.github.selfyy;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class BotReadyListener extends ListenerAdapter {

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        System.out.println("Bot is now ready!");
    }
}
