package lab.quizzes.model.entities;

import java.util.Objects;

public class Quiz {
  String question;
  String choises;
  String answer;

  public Quiz(String question, String choises, String answer) {
    this.question = question;
    this.choises = choises;
    this.answer = answer;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getChoises() {
    return choises;
  }

  public void setChoises(String choises) {
    this.choises = choises;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Quiz quiz = (Quiz) o;
    return Objects.equals(question, quiz.question) &&
      Objects.equals(choises, quiz.choises) &&
      Objects.equals(answer, quiz.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(question, choises, answer);
  }

  @Override
  public String toString() {
    return "Quiz{" +
      "question='" + question + '\'' +
      ", choises='" + choises + '\'' +
      ", answer='" + answer + '\'' +
      '}';
  }
}
