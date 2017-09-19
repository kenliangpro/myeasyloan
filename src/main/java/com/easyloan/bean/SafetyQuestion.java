package com.easyloan.bean;

public class SafetyQuestion {
    private String id;

    private String question;

    private String answer;

    private String safetyEmail;

    private Integer safetyLevel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getSafetyEmail() {
        return safetyEmail;
    }

    public void setSafetyEmail(String safetyEmail) {
        this.safetyEmail = safetyEmail == null ? null : safetyEmail.trim();
    }

    public Integer getSafetyLevel() {
        return safetyLevel;
    }

    public void setSafetyLevel(Integer safetyLevel) {
        this.safetyLevel = safetyLevel;
    }
}