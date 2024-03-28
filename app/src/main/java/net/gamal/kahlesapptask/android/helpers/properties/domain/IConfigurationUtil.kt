package net.gamal.kahlesapptask.android.helpers.properties.domain

interface IConfigurationUtil {
    fun getServerBaseUrl(): String
    fun getProperty(key: ConfigurationKey): String
}