package model;

public class SingleValue implements Evaluation {

    private final String _description;
    private final Float _percentage;
    private final Float _value;

    public SingleValue(String description, float percentage, float value) throws IllegalArgumentException {
        validationOnInstantiation(description, percentage, value);

        _description = description;
        _percentage = percentage;
        _value = value;
    }

    private void validationOnInstantiation(String description, float percentage, float value) throws IllegalArgumentException {
        if (description == null || description.isEmpty())
            throw new IllegalArgumentException("Description can't be empty nor null");

        if (percentage < 0 || percentage > 1)
            throw new IllegalArgumentException("Percentage value should between 0 and 1.");
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
        return _percentage * _value;
    }

    @Override
    public String toString() {
        return String.format("%s:\t[p = %.2f; n = %.2f]", description(), percentage(), _value);
    }
}
