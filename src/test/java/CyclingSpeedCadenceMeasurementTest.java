import com.movisens.smartgattlib.GattUtils;
import com.movisens.smartgattlib.characteristics.CyclingSpeedCadenceMeasurement;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CyclingSpeedCadenceMeasurementTest {

    @Test
    public void testCCM() {
        byte[] testValue = GattUtils.hexStringToByteArray("032D060000A3A9900A289F");
        CyclingSpeedCadenceMeasurement ccm = new CyclingSpeedCadenceMeasurement(testValue);
        assertTrue("Wheel rev should be present", ccm.isWheelRevPresent());
        assertTrue("Crank rev should be present", ccm.isCrankRevPresent());
        assertTrue("Cumulative crank revolutions should be 2704", ccm.getCumulativeCrankRevolutions() == 2704);
        assertTrue("Last crank event time should be 0", ccm.getLastCrankEventTime() == 40744);
        assertTrue("Cumulative wheel revolutions should be 1581", ccm.getCumulativeWheelRevolutions() == 1581);
        assertTrue("Last wheel even time should be 43427", ccm.getLastWheelEventTime() == 43427);
    }
}
