# quiz-classwork

# Quiz:

class Question/QuizItem
String text
List<QuestionAnswer> answers


class QuestionAnswer/QuestionOptions/QuestionChoices/QuizItemChoices
String textQuestion 
parent/question
boolean correct

class UserAnswer
Question question
QuestionAnswer answer
