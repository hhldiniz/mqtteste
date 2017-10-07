package mqtt

class App : Runnable
{
    private val subscriber = Subscriber()
    override fun run() {
        while(true)
        {
            for(i in 0 until subscriber.getMessages().size)
                println(subscriber.getMessages()[i])
            subscriber.resetMessagesList()
            Thread.sleep(1000)
        }
    }

}
fun main(args: Array<String>)
{
    val app = App()
    val thread = Thread(app)
    thread.start()
}