package com.example.arabicletters;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;

public class practivepage extends AppCompatActivity implements View.OnClickListener {

    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton prevButton;
    private ImageView Image;
    private TextView questionTextView;
    private int correct = 0;
    // to keep current question track
    private int currentQuestionIndex = 0;
    private Question[] questionBank = new Question[] {
            // array of objects of class Question
            // providing questions from string
            // resource and the correct ans
            new Question(R.string.a, true),
            new Question(R.string.b, false),
            new Question(R.string.c, true),
            new Question(R.string.d, true),
            new Question(R.string.e, true),
            new Question(R.string.f, false),};
    @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_practivepage);
            falseButton = findViewById(R.id.false_button);
            trueButton = findViewById(R.id.true_button);
            nextButton = findViewById(R.id.next_button);
            prevButton = findViewById(R.id.prev_button);
//            // register our buttons to listen to
//            // click events
            questionTextView = findViewById(R.id.answer_text_view);
            Image = findViewById(R.id.myimage);
            falseButton.setOnClickListener( this);
           trueButton.setOnClickListener(this);
            nextButton.setOnClickListener(this);
           prevButton.setOnClickListener(this);
        }

        public void onClick(View v)
        {
            // checking which button is
            // clicked by user
            // in this case user choose false
            switch (v.getId()) {
                case R.id.false_button:
                    checkAnswer(false);
                    break;

                case R.id.true_button:
                    checkAnswer(true);
                    break;

                case R.id.next_button:
                    // go to next question
                    // limiting question bank range
                    if (currentQuestionIndex < 7) {
                        currentQuestionIndex
                                = currentQuestionIndex + 1;
                        // we are safe now!
                        // last question reached
                        // making buttons
                        // invisible
                        if (currentQuestionIndex == 6) {
                            questionTextView.setText(getString(
                                    R.string.correct, correct));
                            nextButton.setVisibility(
                                    View.INVISIBLE);
                            prevButton.setVisibility(
                                    View.INVISIBLE);
                            trueButton.setVisibility(
                                    View.INVISIBLE);
                            falseButton.setVisibility(
                                    View.INVISIBLE);
                            if (correct > 3)

                                questionTextView.setText(
                                        "CORRECTNESS IS " + correct
                                                + " "
                                                + "OUT OF 6");
                                // showing correctness
                            else
                                Image.setImageResource(
                                        R.drawable.first2teeth);
                            // if correctness<3 showing sad emoji
                        }
                        else {
                            updateQuestion();
                        }
                    }

                    break;
                case R.id.prev_button:
                    if (currentQuestionIndex > 0) {
                        currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.length;
                        updateQuestion();
                    }
            }
        }


        private void updateQuestion()
        {
            Log.d("Current",
                    "onClick: " + currentQuestionIndex);

            questionTextView.setText(
                    questionBank[currentQuestionIndex]
                            .getAnswerResId());
            // setting the textview with new question
            switch (currentQuestionIndex) {
                case 1:
                    // setting up image for each
                    // question
                    Image.setImageResource(R.drawable.nose);
                    break;
                case 2:
                    Image.setImageResource(R.drawable.toungup);
                    break;
                case 3:
                    Image.setImageResource(R.drawable.toungtip);
                    break;
                case 4:
                    Image.setImageResource(R.drawable.tounground);
                    break;
                case 5:
                    Image.setImageResource(R.drawable.toungbase);
                    break;
                case 6:
                    Image.setImageResource(R.drawable.btteeth);
                    break;
                case 7:
                    Image.setImageResource(R.drawable.first2teeth);
                    break;
            }
        }
        private void checkAnswer(boolean userChooseCorrect)
        {
            boolean answerIsTrue
                    = questionBank[currentQuestionIndex]
                    .isAnswerTrue();
            // getting correct ans of current question
            int toastMessageId;
            // if ans matches with the
            // button clicked

            if (userChooseCorrect == answerIsTrue) {
                toastMessageId = R.string.correct_answer;
                correct++;
            }
            else {
                // showing toast
                // message correct
                toastMessageId = R.string.wrong_answer;
            }

            Toast
                    .makeText(practivepage.this, toastMessageId,
                            Toast.LENGTH_SHORT)
                    .show();
        }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}