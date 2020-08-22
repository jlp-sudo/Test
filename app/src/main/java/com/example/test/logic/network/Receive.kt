package com.example.test.logic.network

import java.net.DatagramPacket
import java.net.DatagramSocket

object Receive {
    fun receive():String {
        val ds= DatagramSocket()
        val bytes = ByteArray(1024)
        val dp=DatagramPacket(bytes,bytes.size)
        ds.receive(dp)

        val address=dp.address
        val port=dp.port
        val content=String(dp.data,0,dp.length)
        ds.close()
        return content
    }
}