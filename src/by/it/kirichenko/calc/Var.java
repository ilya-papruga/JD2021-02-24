package by.it.kirichenko.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var save(String key, Var value) {
        vars.put(key, value);
        return value;
    }

    static Var load(String key) {

        return vars.get(key);
    }

    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException(String.format("Operation %s + %s is not possible\n", this, other));
    }

    @Override
    public Var sub(Var other)  throws CalcException{
        throw new CalcException(String.format("Operation %s - %s is not possible\n", this, other));
    }

    @Override
    public Var mul(Var other)  throws CalcException{
        throw new CalcException(String.format("Operation %s * %s is not possible\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s / %s is not possible\n", this, other));
    }

    @Override
    public String toString() {
        return "abstract Var{}";
    }
}