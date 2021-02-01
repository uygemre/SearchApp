package com.base.data.enums

enum class ServiceType(s: String) {

    SEARCH("software"),
    TAG("tag");

    fun getServiceType(type: ServiceType): String {
        return type.name
    }
}