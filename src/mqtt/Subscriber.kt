package mqtt

import org.eclipse.paho.client.mqttv3.*

class Subscriber(client : MqttClient) : MqttCallback{
    init {
        val connectionOptions = MqttConnectOptions()
        connectionOptions.userName = "yhdytvpm"
        connectionOptions.password = "2nMy0rfV-hKE".toCharArray()
        client.connect(connectionOptions)
        client.subscribe("sensor/light")
        client.subscribe("sensor/gyroscope")
        client.subscribe("sensor/accel")
        client.setCallback(this)
    }
    private val messages = ArrayList<String>()
    override fun messageArrived(p0: String?, p1: MqttMessage?) {
        println("Mensagem Recebida")
        if(p0 != null)
            messages.add(String(p1!!.payload))

    }

    override fun connectionLost(p0: Throwable?) {
        println("Conexão Perdida!")
        if(p0 != null)
            throw p0
    }

    override fun deliveryComplete(p0: IMqttDeliveryToken?) {
        println("Envio Concluído")
    }

    val getMessages = {
        messages
    }

    val resetMessagesList = {
        messages.clear()
    }
}