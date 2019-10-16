package com.codegym.servletTask.model;

import java.util.HashMap;
import java.util.Map;

public class Repository {

    private static Map<Integer, Step> steps = new HashMap<>();

    static {
        Step q1 = new Step(1);
        q1.setDescription("Ты потерял память. Принять вызов НЛО?");

        Step q2 = new Step(2);
        q2.setAnswer("Принять вызов.");
        q2.setDescription("Ты принял вызов. Поднимешся на мостик к их капитану?");

        Step q3 = new Step(3);
        q3.setAnswer("Отклонить вызов");
        q3.setDescription("Ты отклонил вызов. Смерть.");
        q3.setDead(true);

        Step q4 = new Step(4);
        q4.setAnswer("Поднятся на мостик.");
        q4.setDescription("Ты поднялся на мостик. Ты кто?");

        Step q5 = new Step(5);
        q5.setAnswer("Отказаться подниматься на мостик.");
        q5.setDescription("Ты не пошел на переговоры. Смерть.");
        q5.setDead(true);

        Step q6 = new Step(6);
        q6.setAnswer("Рассказать правду о себе.");
        q6.setDescription("Тебя отвезли домой. Победа.");
        q6.setWin(true);

        Step q7 = new Step(7);
        q7.setAnswer("Солгать о себе.");
        q7.setDescription("Твою ложь разоблачили. Смерть.");
        q7.setDead(true);

        q1.addOption(q2);
        q1.addOption(q3);

        q2.addOption(q4);
        q2.addOption(q5);

        q4.addOption(q6);
        q4.addOption(q7);

        steps.put(q1.getId(), q1);
        steps.put(q2.getId(), q2);
        steps.put(q3.getId(), q3);
        steps.put(q4.getId(), q4);
        steps.put(q5.getId(), q5);
        steps.put(q6.getId(), q6);
        steps.put(q7.getId(), q7);
    }

    public static Step getStepById(Integer id) {
        return steps.get(id);
    }
}
