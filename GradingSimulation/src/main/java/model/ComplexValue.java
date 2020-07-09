package model;

public class ComplexValue implements Evaluation {

    private final String _description;
    private final Float _percentage;
    private final Evaluation[] _values;

    public ComplexValue(String description, float percentage, Evaluation... values) throws IllegalArgumentException {
        validationOnInstantiation(description, percentage, values);

        _description = description;
        _percentage = percentage;
        _values = values;
    }

    private void validationOnInstantiation(String description, float percentage, Evaluation... values) throws IllegalArgumentException {
        if (description == null || description.isEmpty())
            throw new IllegalArgumentException("Description can't be empty nor null");

        if (values == null) throw new IllegalArgumentException("Null value not accepted");
        if (values.length == 0) throw new IllegalArgumentException("ComplexValues cannot be empty.");

        float acc = 0f;
        for (Evaluation sv : values) acc += sv.percentage();
        if ((1 - acc) * 1000 > 0) throw new IllegalArgumentException("Percentage accumulation should be 1.");
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
        float acc = 0f;
        for (Evaluation sv : _values) acc += sv.value();
        return _percentage * acc;
    }

    @Override
    public String toString() {

        StringBuilder buff = new StringBuilder();
        buff.append(String.format("%s: [p = %.2f]\n", description(), percentage()));
        for (Evaluation g : _values) {
            buff.append(g.toString().replaceAll("\n", "\n\t")).append("\n");
        }
        String a = buff.toString().replaceAll("\n", "\n\t");

        return a.substring(0, a.length() - 2);
    }
}
