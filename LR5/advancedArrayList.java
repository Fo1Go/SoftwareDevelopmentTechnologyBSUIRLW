package LR5;

import java.util.ArrayList;
import static java.lang.Math.abs;

public class advancedArrayList<T> extends ArrayList<T> {
    public Double findMostCloseToNumberByModule(Double module) {
        Double closestNumber = null;
        double criterion = Double.MAX_VALUE;
        double temp;
        for (int index = 0; index < this.size(); index++) {
            temp = abs((Double)this.get(index) - module);
            if (temp < criterion) {
                criterion = temp;
                closestNumber = (Double)this.get(index);
            }
        }
        return closestNumber;
    }
}
