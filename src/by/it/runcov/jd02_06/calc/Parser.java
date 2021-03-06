package by.it.runcov.jd02_06.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var evaluate(String expression) throws CalcException {
        Matcher brackets = Pattern.compile(Patterns.BRACKETS).matcher(expression);
        while (brackets.find()) {
            String group = brackets.group();
            String bracketsExpressionResult = String.valueOf(evaluate(group.substring(1, group.length() - 1)));
            expression = brackets.replaceFirst(bracketsExpressionResult);
            brackets.reset();
            brackets = Pattern.compile(Patterns.BRACKETS).matcher(expression);
        }
        ArrayList<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        ArrayList<String> operations = new ArrayList<>();
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) {
            int index = getIndex(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = oneOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return VarCreator.build(operands.get(0));
    }

    private Var oneOperation(String left, String operation, String right) throws CalcException {
        Var rightVar = VarCreator.build(right);
        if (operation.equals("=")) {
            return Var.save(left, rightVar);
        }
        Var leftVar = VarCreator.build(left);


        switch (operation) {
            case "+":
                return leftVar.add(rightVar);
            case "-":
                return leftVar.sub(rightVar);
            case "*":
                return leftVar.mul(rightVar);
            case "/":
                return leftVar.div(rightVar);
        }
        throw new CalcException("The something stupid ");
    }

    private static final Map<String, Integer> map = Map.of(
            "=", 0,
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2
    );

    private int getIndex(ArrayList<String> operations) {
        int index = -1;
        int best = -1;
        for (int i = 0; i < operations.size(); i++) {
            int currentMap = map.get(operations.get(i));
            if (currentMap > best) {
                index = i;
                best = currentMap;
            }
        }
        return index;
    }
}

