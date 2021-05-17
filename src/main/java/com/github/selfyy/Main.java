package com.github.selfyy;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    static String prefix = "https://chouseisan.com/schedule/List/createCsv?h=";
    static String h = "";
    static String fname = "data.csv";

    public static void main(String[] args) throws LoginException, IOException {
        JDABuilder builder = JDABuilder.createDefault(args[0]);
        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        builder.setBulkDeleteSplittingEnabled(false);
        builder.setActivity(Activity.playing("!sch"));
        builder.addEventListeners(new BotReadyListener());
        builder.addEventListeners(new CommandListener());
        builder.build();

        refresh();
    }

    public static void refresh() throws IOException {
        download(new URL(prefix + h));
    }

    public static void download(URL url) throws IOException {
        String path = url.getPath();
        String name = path.substring(path.lastIndexOf("/") + 1);
        int size = 0;
        try (DataInputStream in = new DataInputStream(url.openStream());
             DataOutputStream out = new DataOutputStream(new FileOutputStream(fname))) {
            byte[] buf = new byte[8192];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
                size += len;
            }
            out.flush();
        }
        System.out.println("Download: " + fname + " - " + size + " bytes");
    }
}
