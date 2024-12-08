package MyProgram;

abstract class AbstractPhysicalCalculation implements Comparable<AbstractPhysicalCalculation>, Cloneable {
    private final double result;

    public AbstractPhysicalCalculation(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public abstract double calculate();

    @Override
    public String toString() {
        return "Результат: " + calculate();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        AbstractPhysicalCalculation currentType = (AbstractPhysicalCalculation) object;
        return Double.compare(currentType.calculate(), calculate()) == 0;
    }

    @Override
    public int compareTo(AbstractPhysicalCalculation currentType) {
        return Double.compare(this.calculate(), currentType.calculate());
    }

    @Override
    public AbstractPhysicalCalculation clone() {
        try {
            return (AbstractPhysicalCalculation) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Клонирование невозможно");
        }
    }
}