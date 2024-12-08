package ru.mtuci.project.service;

import ru.mtuci.project.models.ApplicationUser;
import ru.mtuci.project.models.Device;
import ru.mtuci.project.models.License;
import ru.mtuci.project.models.Ticket;
import ru.mtuci.project.requests.DataLicenseRequest;

import java.util.List;

public interface LicenseService {
    License createLicense(
            Long productId, Long ownerId, Long licenseTypeId,
            Integer device_count, Long duration
    );

    Ticket activateLicense(String activationCode, Device device, ApplicationUser user);
    Ticket generateTicket(License license, Device device, String description);
    List<Ticket> licenseRenewal(String activationCode, ApplicationUser user);

    boolean validateLicense(License license, Device device, ApplicationUser user);
    void createDeviceLicense(License license, Device device);
    void updateLicense(License license);

    List<License> getActiveLicensesForDevice(Device device, ApplicationUser user);

    // save
    License save(DataLicenseRequest request);

    // read
    List<License> getAll();

    // update
    License update(DataLicenseRequest request);

    // delete
    void delete(Long id);
}

