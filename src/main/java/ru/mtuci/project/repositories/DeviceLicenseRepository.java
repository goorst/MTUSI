package ru.mtuci.project.repositories;

import ru.mtuci.project.models.Device;
import ru.mtuci.project.models.DeviceLicense;
import ru.mtuci.project.models.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceLicenseRepository extends JpaRepository<DeviceLicense, Long> {
    Optional<DeviceLicense> findByDeviceAndLicense(Device device, License license);
}
