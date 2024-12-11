package ru.mtuci.project.requests;

import lombok.Data;

@Data
public class DeviceRequest {
    private String activationCode, name, macAddress;
}
