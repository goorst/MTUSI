package ru.mtuci.project.service;

import ru.mtuci.project.models.LicenseType;
import ru.mtuci.project.requests.DataLicenseTypeRequest;

import java.util.List;
import java.util.Optional;

public interface LicenseTypeService {
    Optional<LicenseType> getLicenseTypeById(Long id);

    // save
    LicenseType save(DataLicenseTypeRequest request);

    // read
    List<LicenseType> getAll();

    // update
    LicenseType update(DataLicenseTypeRequest request);

    // delete
    void delete(Long id);
}

