package com.gibran.marvelservice.util

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class MarvelKey {
    companion object {
        fun generateUserKey(timeStamp: String, privateKey: String, publicKey: String): String {
            return md5(timeStamp + privateKey + publicKey)
        }

        private fun md5(stringToHash: String): String {
            val MD5 = "MD5"

            try {
                val digest = MessageDigest.getInstance(MD5)
                digest.update(stringToHash.toByteArray())
                val messageDigest = digest.digest()

                val hexString = StringBuilder()
                for (aMessageDigest in messageDigest) {
                    var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                    while (h.length < 2)
                        h = "0" + h
                    hexString.append(h)
                }
                return hexString.toString()

            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }

            return ""
        }
    }
}