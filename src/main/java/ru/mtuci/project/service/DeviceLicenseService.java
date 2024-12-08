package ru.mtuci.project.service;

import ru.mtuci.project.models.DeviceLicense;
import ru.mtuci.project.requests.DataDeviceLicenseRequest;

import java.util.List;

public interface DeviceLicenseService {
    DeviceLicense saveDeviceLicense(DeviceLicense deviceLicense);

    // save
    DeviceLicense save(DataDeviceLicenseRequest request);

    // read
    List<DeviceLicense> getAll();

    // update
    DeviceLicense update(DataDeviceLicenseRequest request);

    // delete
    void delete(Long id);
}

