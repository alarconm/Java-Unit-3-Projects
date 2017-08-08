package org.launchcode.hellospring.Controllers;

import java.util.HashMap;
import java.util.Map;

public class Languages{


    private static final HashMap<String, String> myGreeting = createMap();
    public static HashMap<String, String> createMap()

    {
        HashMap<String, String> myGreeting = new HashMap<>();
        myGreeting.put("English", "English");
        myGreeting.put("Spanish", "Spanish");
        myGreeting.put("French", "French");
        myGreeting.put("German", "German");
        myGreeting.put("Arabic", "Arabic");
        return myGreeting;

    }
}
