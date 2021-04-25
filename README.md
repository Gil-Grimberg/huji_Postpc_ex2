I pledge the highest level of ethical principles in support of academic excellence.  
I ensure that all of my work reflects my own abilities and not those of someone else.

Answer to the hypothetical question:

 If we are to add a "x" button for multiplication we need to do the following edits/changes:

#in SimpleCalculatorImpl.java:#

first we have to decide how this operator will behave (lets say we ignore a "x" 
that comes afters another operator and we allow "x-" and "x+")

1. add a function called insertMul() that adds "x" to the calculation.
2. edit the function output() to support "x" operator (add an if statement to deal with "x-" and "x+" operators)

#in SimpleCalculatorImplTest.java:#

add some tests like:
1. test "4x5="==20
2. test "4x-2="==-8
3. test "0x5="==0
4. test "9-x1="==8 (since we ignore x coming after + or -)

#in MainActivity:#

add the following lines:

1. TextView mulButton = findViewById(R.id.buttonMul);
2. mulButton.setOnClickListener(v -> {
      calculator.insertMul();
      textViewCalculatorOutput.setText(calculator.output());
    });

#in MainActivityTest:#

we can add this test:

  @Test
  public void when_userClicksButtonMul_then_activityShouldForwardCallToCalculator_and_ShowTheExpectedCalculatorOutputRightAway() {
    // setup
    String expectedText = "button MUL clicked";
    Mockito.when(mockCalculator.output()).thenReturn(expectedText);

    TextView activityMainTextView = activityUnderTest.findViewById(R.id.textViewCalculatorOutput);
    View buttonMul = activityUnderTest.findViewById(R.id.buttonMul);

    // test
    buttonMul.performClick();

    // verify
    Mockito.verify(mockCalculator).insertMul(); // make sure that the activity called this method
    assertEquals(expectedText, activityMainTextView.getText().toString()); // make sure that the activity shows text from calculator.output()
  }

#as for the AppFlow:#

1. add to setup the findByView for buttonMul.

2. we can add the following flow tests:

  @Test
  public void flowTest13(){
    // run clicks on "6x2="
    for (View button: Arrays.asList(
            button6, buttonMul, button2, buttonEquals
    )) {
      button.performClick();
    }

    assertEquals("12", textViewOutput.getText().toString());
  }

  @Test
  public void flowTest14(){
    // run clicks on "x2"
    for (View button: Arrays.asList(
            buttonMul, button2,
    )) {
      button.performClick();
    }

    assertEquals("0x2", textViewOutput.getText().toString());
  }