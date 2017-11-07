import com.movisens.smartgattlib.GattUtils;
import com.movisens.smartgattlib.attributes.HeartRateMeasurement;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeartRateMeasurementTest {
    @Test public void testHR() {
        byte[] testValue = GattUtils.hexStringToByteArray("16485401EC02");
        HeartRateMeasurement hrm = new HeartRateMeasurement(testValue);
        assertTrue("HR should be 72", hrm.getHr() == 72);
        assertTrue("Sensor is worn", hrm.getSensorWorn() == HeartRateMeasurement.SensorWorn.WORN);
        assertTrue("EE should not be available", hrm.getEe() == -1);
        assertTrue("2 RR intervals should be available", hrm.getRrIntervals().size() == 2);
        assertTrue("RR intervals should be correct", hrm.getRrIntervals().get(0) == 0.33203125 && hrm.getRrIntervals().get(1) == 0.73046875);
    }
}
