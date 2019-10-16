package com.codegym.servletTask.model;

import java.util.ArrayList;
import java.util.List;

public class Step {

    private Integer id;

    private String answer = "";

    private boolean dead = false;

    private boolean win = false;

    private String description = "";

    private List<Step> options = new ArrayList<>();

    public Step(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addOption(Step option) {
        options.add(option);
    }

    public List<Step> getOptions() {
        return options;
    }
}
