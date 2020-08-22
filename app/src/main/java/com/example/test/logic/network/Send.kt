package com.example.test.logic.network

import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

object Send {

    fun send(msg: String) {
        val ds= DatagramSocket()
        val bytes: ByteArray = msg.toByteArray()
        val address=InetAddress.getByName("192.168.31.137")
        val dp=DatagramPacket(bytes,bytes.size,address,6666)
        ds.send(dp)
        ds.close()
    }

}