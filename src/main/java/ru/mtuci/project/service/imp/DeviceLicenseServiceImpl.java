package ru.mtuci.project.service.imp;

import ru.mtuci.project.exceptions.categories.DeviceLicenseNotFoundException;
import ru.mtuci.project.exceptions.categories.DeviceNotFoundException;
import ru.mtuci.project.exceptions.categories.license.LicenseNotFoundException;
import ru.mtuci.project.models.DeviceLicense;
import ru.mtuci.project.repositories.DeviceLicenseRepository;
import ru.mtuci.project.repositories.LicenseRepository;
import ru.mtuci.project.requests.DataDeviceLicenseRequest;
import ru.mtuci.project.service.DeviceLicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceLicenseServiceImpl implements DeviceLicenseService {
    private final DeviceServiceImpl deviceService;
    private final LicenseRepository licenseRepository;
    private final DeviceLicenseRepository deviceLicenseRepository;

    private DeviceLicense edit(DeviceLicense deviceLicense, DataDeviceLicenseRequest request) {
        deviceLicense.setDevice(deviceService.findDeviceById(request.getDevice_id()).orElseThrow(
                () -> new DeviceNotFoundException("Устройство не найдено")
        ));
        deviceLicense.setLicense(licenseRepository.findById(request.getLicense_id()).orElseThrow(
                () -> new LicenseNotFoundException("Лицензия не найдена")
        ));
        deviceLicense.setActivation_date(request.getActivation_date());
        return deviceLicense;
    }

    @Override
    public DeviceLicense saveDeviceLicense(DeviceLicense deviceLicense) {
        return deviceLicenseRepository.save(deviceLicense);
    }

    @Override
    public DeviceLicense save(DataDeviceLicenseRequest request) {
        return deviceLicenseRepository.save(edit(new DeviceLicense(), request));
    }

    @Override
    public List<DeviceLicense> getAll() {
        return deviceLicenseRepository.findAll();
    }

    @Override
    public DeviceLicense update(DataDeviceLicenseRequest request) {
        DeviceLicense deviceLicense = deviceLicenseRepository.findById(request.getDevice_id()).orElseThrow(
                () -> new DeviceLicenseNotFoundException("Устройство-лицензия не найдено")
        );
        return deviceLicenseRepository.save(edit(deviceLicense, request));
    }

    @Override
    public void delete(Long id) {
        deviceLicenseRepository.deleteById(id);
    }
}