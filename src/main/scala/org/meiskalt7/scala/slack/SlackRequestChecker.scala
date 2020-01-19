package org.meiskalt7.scala.slack

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import org.apache.commons.codec.binary.Hex

object SlackRequestChecker {
  def verifySlackRequest(signature: String, signingSecret: String,
                         timestamp: String, body: String, algorithm: String = "HmacSHA256"): Boolean =
    signature == s"v0=${generateHMAC(signingSecret,s"v0:${timestamp}:${body}", algorithm)}"

  private def generateHMAC(signingSecret: String, content: String, algorithm: String): String = {
    val mac = Mac.getInstance(algorithm)
    mac.init(new SecretKeySpec(signingSecret.getBytes, algorithm))
    Hex.encodeHexString(mac.doFinal(content.getBytes))
  }
}
