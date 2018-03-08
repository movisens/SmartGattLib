import com.movisens.smartgattlib.GattUtils;
import com.movisens.smartgattlib.attributes.CscMeasurement;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CyclingSpeedCadenceMeasurementTest {

    @Test
    public void testCCM() {
        byte[] testValue = GattUtils.hexStringToByteArray("032D060000A3A9900A289F");
        CscMeasurement ccm = new CscMeasurement(testValue);
        assertTrue("Wheel rev should be present", ccm.isWheelRevPresent());
        assertTrue("Crank rev should be present", ccm.isCrankRevPresent());
        assertTrue("Cumulative crank revolutions should be 2704", ccm.getCumulativeCrankRevolutions() == 2704);
        assertTrue("Last crank event time should be 0", ccm.getCrankEventTime() == 40744);
        assertTrue("Cumulative wheel revolutions should be 1581", ccm.getCumulativeWheelRevolutions() == 1581);
        assertTrue("Last wheel even time should be 43427", ccm.getWheelEventTime() == 43427);
    }
}
