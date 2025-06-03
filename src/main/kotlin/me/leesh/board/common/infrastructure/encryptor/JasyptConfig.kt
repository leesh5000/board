package me.leesh.board.common.infrastructure.encryptor

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties
import org.jasypt.encryption.StringEncryptor
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.env.Environment

@Profile("prod")
@Configuration
@EnableEncryptableProperties
class JasyptConfig(private val environment: Environment) {

    @Bean("jasyptStringEncryptor")
    fun stringEncryptor(): StringEncryptor {
        val encryptor = PooledPBEStringEncryptor()
        val config = SimpleStringPBEConfig()

        // Get encryption password from environment variable, JVM property, or use a default for development
        val password = environment.getProperty("JASYPT_ENCRYPTOR_PASSWORD")
            ?: environment.getProperty("jasypt.encryptor.password")
            ?: ""

        config.apply {
            setPassword(password)
            algorithm = "PBEWithMD5AndDES"
            setKeyObtentionIterations("1000")
            setPoolSize("1")
            setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator")
            setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator")
            stringOutputType = "base64"
        }

        encryptor.setConfig(config)
        return encryptor
    }
}
