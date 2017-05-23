import com.movisens.smartgattlib.GattByteBuffer;
import com.movisens.smartgattlib.characteristics.Weight;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by robert.zetzsche on 17.05.2017.
 */
public class WeightTest {
    @Test
    public void testWeight() {
        Float weightFloat = 12.5f;
        byte[] bytes = GattByteBuffer.allocate(4).putUint16(Math.round(weightFloat * 200)).array();
        Weight weight = new Weight(weightFloat);
        Weight weightBytes = new Weight(bytes);
        assertTrue(weight.getValue().equals(weightFloat));
        assertTrue(weightBytes.getValue().equals(weightFloat));
        assertTrue(weightBytes.getValue().equals(weight.getValue()));
        assertTrue(Arrays.equals(weight.getBytes(), bytes));
        assertTrue(Arrays.equals(weightBytes.getBytes(), bytes));
        assertTrue(Arrays.equals(weight.getBytes(), weightBytes.getBytes()));
    }
}
