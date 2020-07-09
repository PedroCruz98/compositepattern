package model;

import java.util.Arrays;
import java.util.List;

public class ComplexEvaluation implements Evaluation {

    private final String _description;
    private final Float _percentage;
    private final List<Evaluation> _grades;

    public ComplexEvaluation(String description, float percentage, Evaluation... values) throws IllegalArgumentException {
        validationOnInstantiation(description, percentage, values);

        _description = description;
        _percentage = percentage;
        _grades = Arrays.asList(values);
    }

    private void validationOnInstantiation(String description, float percentage, Evaluation... values) throws IllegalArgumentException {
        if (description == null || description.isEmpty())
            throw new IllegalArgumentException("Description can't be empty nor null");

        if (values.length == 0) throw new IllegalArgumentException("ComplexValues cannot be empty.");
    }

    public void add(Evaluation evaluation) {
        _grades.add(evaluation);
    }

    public void remove(Evaluation evaluation){
        _grades.remove(evaluation);
    }

    @Override
    public Float percentage() {
        return _percentage;
    }

    @Override
    public String description() {
        return _description;
    }

    @Override
    public Float value() {
        return _percentage * (float) _grades.stream().mapToDouble(Evaluation::value).sum();
    }

    @Override
    public String toString() {

        StringBuilder buff = new StringBuilder();
        buff.append(String.format("%s: [p = %.2f]\n", description(), percentage()));
        for (Evaluation g : _grades) {
            buff.append(g.toString().replaceAll("\n", "\n\t")).append("\n");
        }
        String a = buff.toString().replaceAll("\n", "\n\t");

        return a.substring(0, a.length() - 2);
    }
}
