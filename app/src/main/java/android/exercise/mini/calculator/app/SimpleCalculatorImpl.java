package android.exercise.mini.calculator.app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimpleCalculatorImpl implements SimpleCalculator {

    // todo: add fields as needed
    List<String> calculation = new ArrayList<>();
    int elementsCounter = -1;

    @Override
    public String output() {
        // todo: return output based on the current state
        String out = "";
        if (calculation.isEmpty()) {
            out = "0";
        } else {
            for (String element : calculation) {
                out += element;
            }
        }
        return out;
    }

    @Override
    public void insertDigit(int digit) {
        // todo: insert a digit
        if ((digit > 9) || (digit < 0)) {
            throw new IllegalArgumentException();
        }
        calculation.add(String.valueOf(digit));
        elementsCounter++;
    }

    @Override
    public void insertPlus() {
        // todo: insert a plus
        if (calculation.isEmpty()) {
            calculation.add("0");
            elementsCounter++;
        }
        if ((calculation.get(elementsCounter).equals("+")) && (calculation.get(elementsCounter).equals("-"))) {
            // ignore
        } else {
            calculation.add("+");
            elementsCounter++;
        }
    }

    @Override
    public void insertMinus() {
        // todo: insert a minus
        if (calculation.isEmpty()) {
            calculation.add("0");
            elementsCounter++;
        }
        if ((calculation.get(elementsCounter).equals("+")) && (calculation.get(elementsCounter).equals("-"))) {
            // ignore
        } else {
            calculation.add("-");
            elementsCounter++;
        }
    }

    @Override
    public void insertEquals() {
        // todo: calculate the equation. after calling `insertEquals()`, the output should be the result
        //  e.g. given input "14+3", calling `insertEquals()`, and calling `output()`, output should be "17"
        if ((calculation.get(elementsCounter).equals("+")) || (calculation.get(elementsCounter).equals("-"))) {
            calculation.remove(elementsCounter);
            elementsCounter--;
        }
        String newAction = "";
        String prevAction = "+";
        String temp = "";
        int counter = 0;
        int res = 0;
        while (counter <= elementsCounter) {
            if ((!calculation.get(elementsCounter).equals("+")) && (!calculation.get(elementsCounter).equals("-"))) {
                temp += calculation.get(counter);
                counter++;
            }
            else {
                if (prevAction.equals("+")){
                    res += Integer.parseInt(temp);
                }
                else{
                    res -= Integer.parseInt(temp);
                }
                prevAction = newAction;
                temp = "";
                counter++;
            }
        }
        if (prevAction.equals("+")){
            res += Integer.parseInt(temp);
        }
        else{
            res -= Integer.parseInt(temp);
        }
        calculation.clear();
        calculation.add(String.valueOf(res));

    }

    @Override
    public void deleteLast() {
        // todo: delete the last input (digit, plus or minus)
        //  e.g.
        //  if input was "12+3" and called `deleteLast()`, then delete the "3"
        //  if input was "12+" and called `deleteLast()`, then delete the "+"
        //  if no input was given, then there is nothing to do here
    }

    @Override
    public void clear() {
        // todo: clear everything (same as no-input was never given)
    }

    @Override
    public Serializable saveState() {
        CalculatorState state = new CalculatorState();
        // todo: insert all data to the state, so in the future we can load from this state
        return state;
    }

    @Override
    public void loadState(Serializable prevState) {
        if (!(prevState instanceof CalculatorState)) {
            return; // ignore
        }
        CalculatorState casted = (CalculatorState) prevState;
        // todo: use the CalculatorState to load
    }

    private static class CalculatorState implements Serializable {
    /*
    TODO: add fields to this class that will store the calculator state
    all fields must only be from the types:
    - primitives (e.g. int, boolean, etc)
    - String
    - ArrayList<> where the type is a primitive or a String
    - HashMap<> where the types are primitives or a String
     */
    }
}
