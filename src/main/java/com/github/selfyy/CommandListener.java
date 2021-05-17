package com.github.selfyy;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CommandListener extends ListenerAdapter {

    String prefix_main = "!sch";

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if(!event.getMessage().getAuthor().isBot()){ // message author isnt bot user acc
            String msg = event.getMessage().getContentRaw();
            String str = msg.split(" ")[1];
            if(msg.startsWith(prefix_main)){
                try {
                    Main.refresh();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String file = Main.fname;
                List<String> stringList = new ArrayList<>();
                int base = 5;
                try(BufferedReader br = new BufferedReader(new FileReader(file)))
                {
                    String line;
                    while ((line = br.readLine()) != null) {
                        stringList.add(line);
                    }

                    for (int i = 6; i < stringList.size(); i++) {

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
