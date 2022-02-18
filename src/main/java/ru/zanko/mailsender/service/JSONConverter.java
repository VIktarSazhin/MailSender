package ru.zanko.mailsender.service;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.zanko.mailsender.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class JSONConverter {
    public static List<User> listUser = new ArrayList<>();

    public static List<User> parse() {

        JSONParser jsonParser = new JSONParser();

        JSONObject object = null;
        JSONArray jsonArray = null;
        File file = new File("output.json");

        try (FileReader fileReader = new FileReader(file)) {

//            object = (JSONObject) jsonParser.parse(JsoupParser.parsURL());

            object = (JSONObject) jsonParser.parse(fileReader);
            jsonArray = (JSONArray) object.get("Players_data");
            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                String user_name = (String) jsonObject.get("user_name");
                double spend_time = (Double) jsonObject.get("spend_time");
                String activities = (String) jsonObject.get("activities");

                User user2 = new User(user_name, String.valueOf(spend_time), activities);
                listUser.add(user2);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        Collections.sort(listUser);

        return listUser;
    }
}
