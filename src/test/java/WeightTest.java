import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.movisens.smartgattlib.attributes.Weight;
import com.movisens.smartgattlib.helper.GattByteBuffer;

/**
 * Created by robert.zetzsche on 17.05.2017.
 */
public class WeightTest {
    @Test
    public void testWeight() {
        Float weightFloat = 12.5f;
        byte[] bytes = GattByteBuffer.allocate(2).putUint16(Math.round(weightFloat * 200)).array();
        Weight weight = new Weight(weightFloat.doubleValue());
        Weight weightBytes = new Weight(bytes);
        assertEquals(weight.getWeight(), weightFloat, 0);
        assertEquals(weightBytes.getWeight(), weightFloat.doubleValue(), 0);
        assertEquals(weightBytes.getWeight(), weight.getWeight());
        assertArrayEquals(weight.getBytes(), bytes);
        assertArrayEquals(weightBytes.getBytes(), bytes);
        assertArrayEquals(weight.getBytes(), weightBytes.getBytes());
    }
}
