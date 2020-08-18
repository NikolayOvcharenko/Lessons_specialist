package mockito

import mail.Client
import mail.Mailer
import mail.PersonalInfo
import mail.sendMessageToClient
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*


class TestMailer {

    @Test
    fun testMailer() {
        val mailer = mock(Mailer::class.java)
        val personalInfio = PersonalInfo("email")
        val client = Client(personalInfio)
        val message = "message"
        //`when`
        sendMessageToClient(client, message, mailer)
        verify(mailer).sendMessage("email", "message")

    }


    @Test
    fun testSendMessageNotCall() {
        val mailer = mock(Mailer::class.java)
        val personalInfio = PersonalInfo("email")
        val client = Client(personalInfio)
        val message = null
        //`when`
        sendMessageToClient(client, message, mailer)
        verifyNoMoreInteractions(mailer)

    }

}