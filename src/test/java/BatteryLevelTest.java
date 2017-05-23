import com.movisens.smartgattlib.GattUtils;
import com.movisens.smartgattlib.characteristics.BatteryLevel;
import com.movisens.smartgattlib.characteristics.HeartRateMeasurement;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BatteryLevelTest {
    @Test public void testBatteryLevel() {
        byte[] testValue = GattUtils.hexStringToByteArray("2C");
        BatteryLevel batteryLevel = new BatteryLevel(testValue);
        assertTrue("Battery level should be 44", batteryLevel.getValue() == 44);
    }
}
