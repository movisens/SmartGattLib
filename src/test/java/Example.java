import java.util.UUID;

import com.movisens.smartgattlib.Characteristics;
import com.movisens.smartgattlib.Services;
import com.movisens.smartgattlib.attributes.DefaultAttribute;
import com.movisens.smartgattlib.attributes.HeartRateMeasurement;
import com.movisens.smartgattlib.attributes.Weight;
import com.movisens.smartgattlib.helper.AbstractAttribute;
import com.movisens.smartgattlib.security.CryptoManager;

public class Example {

    public static void main(String[] args) {
        // onConnected
        // TODO: iterate over available services
        UUID serviceUuid = null;// service.getUuid();
        if (Services.HEART_RATE.equals(serviceUuid)) {

            // TODO: iterate over characteristics
            UUID characteristicUuid = null;// characteristic.getUuid();
            if (Characteristics.HEART_RATE_MEASUREMENT.equals(characteristicUuid)) {
                // TODO: Enable notification e.g. for Android API 18:
                // BluetoothGattDescriptor descriptor = characteristic.getDescriptor(Descriptor.CLIENT_CHARACTERISTIC_CONFIGURATION);
                // descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                // mBluetoothGatt.writeDescriptor(descriptor);
            }
        } else {
            System.out.println("Found unused Service: " + Services.lookup(serviceUuid));
        }

        // onCharacteristicChanged
        UUID uuid = null;// characteristic.getUuid();
        byte[] data = null;// characteristic.getValue();

        CryptoManager cryptoManager = new CryptoManager();
        
        AbstractAttribute a = Characteristics.lookup(uuid).createAttribute(cryptoManager, data);
        if (a instanceof HeartRateMeasurement) {
            HeartRateMeasurement heartRateMeasurement = ((HeartRateMeasurement) a);
            heartRateMeasurement.getHr();
            heartRateMeasurement.getEe();
        } else if (a instanceof DefaultAttribute) {
            System.err.println("characteristic for " + uuid + " is unknown");
        } else {
            System.out.println("unused characteristic " + a.getCharacteristic().getName());
        }

        // write Attribute
        @SuppressWarnings("unused")
        AbstractAttribute aa = new Weight(12.3);
        // TODO: Write aa.getBytes() to aa.getCharacteristic().getUuid();
    }
}
