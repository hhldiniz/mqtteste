package mqtt

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage

class Subscriber : MqttCallback{
    private val messages = ArrayList<String>()
    override fun messageArrived(p0: String?, p1: MqttMessage?) {
        if(p0 != null)
            messages.add(p0)
    }

    override fun connectionLost(p0: Throwable?) {
        if(p0 != null)
            throw p0
    }

    override fun deliveryComplete(p0: IMqttDeliveryToken?) {

    }

    val getMessages = {
        messages
    }

    val resetMessagesList = {
        messages.clear()
    }
}