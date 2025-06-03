//package me.leesh.board.common.infrastructure.encryptor
//
//import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
//import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.boot.context.properties.EnableConfigurationProperties
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
//@EnableConfigurationProperties
//@Configuration
//class JasyptEncryptor {
//
//    @Value("\${jasypt.encryptor.password}")
//    lateinit var encryptorPassword: String
//
//    // Additional methods for encryption/decryption can be added here if needed
//    // For example, you could create methods that use the Jasypt library to encrypt/decrypt values
//    // using the `encryptorPassword` field.
//    // However, for now, this class serves as a configuration holder for the Jasypt encryptor password.
//    // You can also create methods to encrypt/decrypt values using Jasypt if needed.
//    @Bean
//    fun createEncryptor(): PooledPBEStringEncryptor {
//        val encryptor = PooledPBEStringEncryptor()
//        val config = SimpleStringPBEConfig()
//
//        config.apply {
//            setPassword(encryptorPassword)
//            setAlgorithm("PBEWithMD5AndDES")
//            setKeyObtentionIterations("1000")
//            setPoolSize("1")
//            setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator")
//            setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator")
//            setStringOutputType("base64")
//        }
//
//        encryptor.setConfig(config)
//        return encryptor
//    }
//
//
//}
