package mqtt

import org.eclipse.paho.client.mqttv3.MqttClient

class App : Runnable
{
    private val subscriber = Subscriber(MqttClient("tcp://m11.cloudmqtt.com:18446","Desktop Client"))
    override fun run() {
        while(true)
        {
            for(i in 0 until subscriber.getMessages().size)
                println(subscriber.getMessages()[i])
            subscriber.resetMessagesList()
            Thread.sleep(1000)
        }
    }

    val getSubscriber = {subscriber}
}
fun main(args: Array<String>)
{
    val app = App()
    val thread = Thread(app)
    thread.start()
}