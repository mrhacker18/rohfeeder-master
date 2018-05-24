package shs2.rohfeedback.object;

/**
 * Created by Lenovo on 05/02/18.
 */

public class Query {
    private Integer Id;
    private String Question;

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
