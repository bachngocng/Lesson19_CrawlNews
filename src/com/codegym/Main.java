package com.codegym;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String link = "https://dantri.com.vn/";

        try {
            URL url = new URL(link);
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("&quot;", "\"");

            Pattern p = Pattern.compile("<h3 class=\"article-title\"> <a data-utm=\"\" href=.*?>(.*?)</a> </h3>");
            Matcher m = p.matcher(content);
            int count = 0;
            while (m.find()) {
                System.out.println(m.group(1));
                count++;
            }
            System.out.println("-----------------------------");
            System.out.printf("Tìm được %d bài báo\n", count);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

