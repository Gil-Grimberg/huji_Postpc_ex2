package android.exercise.mini.calculator.app;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @VisibleForTesting
  public SimpleCalculator calculator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (calculator == null) {
      calculator = new SimpleCalculatorImpl();
    }

    /*
    TODO:
    - find all views
    - initial update main text-view based on calculator's output
    - set click listeners on all buttons to operate on the calculator and refresh main text-view
     */
    TextView equalsButton = findViewById(R.id.buttonEquals);
    TextView plusButton = findViewById(R.id.buttonPlus);
    TextView minusButton = findViewById(R.id.buttonMinus);
    TextView clearButton = findViewById(R.id.buttonClear);
    TextView Button0 = findViewById(R.id.button0);
    TextView Button1 = findViewById(R.id.button1);
    TextView Button2 = findViewById(R.id.button2);
    TextView Button3 = findViewById(R.id.button3);
    TextView Button4 = findViewById(R.id.button4);
    TextView Button5 = findViewById(R.id.button5);
    TextView Button6 = findViewById(R.id.button6);
    TextView Button7 = findViewById(R.id.button7);
    TextView Button8 = findViewById(R.id.button8);
    TextView Button9 = findViewById(R.id.button9);
    View backSpaceButton = findViewById(R.id.buttonBackSpace);
    TextView textViewCalculatorOutput = findViewById(R.id.textViewCalculatorOutput);

//    initiate text view output
    textViewCalculatorOutput.setText("~~~ ready to start ~~~");
//

    plusButton.setOnClickListener(v -> {
      calculator.insertPlus();
      textViewCalculatorOutput.setText(calculator.output());
    });

    minusButton.setOnClickListener(v -> {
      calculator.insertMinus();
      textViewCalculatorOutput.setText(calculator.output());
    });

    equalsButton.setOnClickListener(v -> {
      calculator.insertEquals();
      textViewCalculatorOutput.setText(calculator.output());
    });

    backSpaceButton.setOnClickListener(v -> {
      calculator.deleteLast();
      textViewCalculatorOutput.setText(calculator.output());
    });

    clearButton.setOnClickListener(v -> {
      calculator.clear();
      textViewCalculatorOutput.setText(calculator.output());
    });

    Button0.setOnClickListener(v -> {
      calculator.insertDigit(0);
      textViewCalculatorOutput.setText(calculator.output());
    });

    Button1.setOnClickListener(v -> {
      calculator.insertDigit(1);
      textViewCalculatorOutput.setText(calculator.output());
    });

    Button2.setOnClickListener(v -> {
      calculator.insertDigit(2);
      textViewCalculatorOutput.setText(calculator.output());
    });

    Button3.setOnClickListener(v -> {
      calculator.insertDigit(3);
      textViewCalculatorOutput.setText(calculator.output());
    });

    Button4.setOnClickListener(v -> {
      calculator.insertDigit(4);
      textViewCalculatorOutput.setText(calculator.output());
    });

    Button5.setOnClickListener(v -> {
      calculator.insertDigit(5);
      textViewCalculatorOutput.setText(calculator.output());
    });

    Button6.setOnClickListener(v -> {
      calculator.insertDigit(6);
      textViewCalculatorOutput.setText(calculator.output());
    });

    Button7.setOnClickListener(v -> {
      calculator.insertDigit(7);
      textViewCalculatorOutput.setText(calculator.output());
    });

    Button8.setOnClickListener(v -> {
      calculator.insertDigit(8);
      textViewCalculatorOutput.setText(calculator.output());
    });

    Button9.setOnClickListener(v -> {
      calculator.insertDigit(9);
      textViewCalculatorOutput.setText(calculator.output());
    });
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    // todo: save calculator state into the bundle
    outState.putSerializable("calculatorState",calculator.saveState());
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
    calculator.loadState(savedInstanceState.getSerializable("calculatorState"));
  }
}